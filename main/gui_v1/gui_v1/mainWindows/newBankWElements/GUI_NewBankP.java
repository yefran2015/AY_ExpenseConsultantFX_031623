package gui_v1.mainWindows.newBankWElements;
import gui_v1.action_processors.NewBankProgrammableHandler;
import gui_v1.automation.GUI_ElementCreator;
import gui_v1.data_loaders.GUI_ElementsDataLoader;
import gui_v1.data_loaders.GUI_ElementsOptionLists;
import gui_v1.mainWindows.GUI_NewAccountWindow;
import gui_v1.mainWindows.GUI_NewBankWindow;
import gui_v1.settings.GUI_Settings_Variables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI_NewBankP extends JPanel implements GUI_Settings_Variables, ActionListener {
    private JTextField jtfBankName;
    private JButton jbtnAdd;
    private void init(){
        jtfBankName= GUI_ElementCreator.newTextFieldWithHelp(GUI_ElementsDataLoader.getNBHelpMsgs().newBankNameInputHelpMsg());
        jbtnAdd = GUI_ElementCreator.newJButton("Add This Bank");

        jbtnAdd.addActionListener(this);
    }

    public GUI_NewBankP(){

        init();
        setLayout(new BorderLayout());
        add(GUI_ElementCreator.newTitle("Enter New Bank Info"), BorderLayout.NORTH);

        JPanel pBox = new JPanel(new GridLayout(3,2));
        pBox.add(new JLabel());
        pBox.add(new JLabel());
        pBox.requestFocusInWindow();
        pBox.setRequestFocusEnabled(true);
        pBox.setFocusable(true);
        JLabel jlblInputTitles = GUI_ElementCreator.newTextLabel("New Bank Name:");
        jlblInputTitles.setFocusTraversalPolicyProvider(true);
        pBox.add(jlblInputTitles);
        pBox.add(jtfBankName);
        pBox.add(new JLabel());
        pBox.add(new JLabel());
        add(pBox, BorderLayout.CENTER);
        add(jbtnAdd, BorderLayout.SOUTH);

        jbtnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                jbtnAdd.requestFocusInWindow();
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jbtnAdd){
            processAddBankBtnClick();
        }
    }

    private boolean getConfirmationFromUserAboutBankNameEmpty(){
        int answr = JOptionPane.showOptionDialog(null, "Bank Name Not Entered, Do you want close this window, and return to Adding Accounts?, ", "Bank name is not Entered.",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, JOptionPane.NO_OPTION);
        return answr == JOptionPane.YES_OPTION;
    }
    private void processAddBankBtnClick() {
        String bankName = jtfBankName.getText().trim() ;
        if(bankName.compareToIgnoreCase("")==0 ||
                bankName.compareToIgnoreCase(GUI_ElementsDataLoader.getNBHelpMsgs().newBankNameInputHelpMsg())==0){
                if(getConfirmationFromUserAboutBankNameEmpty()){
                    GUI_NewBankWindow.getInstance().disposeNewBankWindow();
                    GUI_NewAccountWindow.getInstance().showNewAccntWindow();
                }
        }else{
            if(GUI_ElementsOptionLists.getInstance().isBankInList(bankName)){
                showBannkExistMessage();
            }else{
//              GUI_NewAccountP.addAccountNickToComboBox( jtfBankName.getText().trim() );
                GUI_NewBankWindow.getInstance().disposeNewBankWindow();
                GUI_NewAccountWindow.getInstance().showNewAccntWindow();
                new NewBankProgrammableHandler(bankName);
            }
        }
    }

    private void showBannkExistMessage() {
        JOptionPane.showMessageDialog(null, "This bank is already in your record", "Bank Exists", JOptionPane.INFORMATION_MESSAGE);
    }


    @Override
    public Component getComponent() {
        return null;
    }

}