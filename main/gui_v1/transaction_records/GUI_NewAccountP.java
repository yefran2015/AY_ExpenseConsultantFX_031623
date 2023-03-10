package gui_v1.transaction_records;

import gui_v1.action_processors.NewAccountProgrammableHandler;
import gui_v1.automation.GUI_ElementCreator;
import main_logic.PEC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_NewAccountP extends JPanel implements ActionListener {
//    private static final String NEW_BANK = "<NEW BANK>";
//
//    // WILL BE LOADED FROM THE DATABASE
//    private static String[] bankList = new String[] { "Wells Fargo", "US Bank", "Bank Of America" };
//    private static DropDownItems bankNames = new DropDownItems(bankList, "<--no bank-->", NEW_BANK);

//    private static String[] bankList  = TransactionBankAccountInitialLists.getInstance().getBanksList();

    private final JComboBox<String>  jcmbBank = GUI_ElementCreator.newJComboBox(TransactionBankAccountInitialLists.getInstance().getBanksList());
    private final JTextField jtfAcctNum= GUI_ElementCreator.newTextField("Account Number");
    private final JTextField jtfAcctNick= GUI_ElementCreator.newTextField("Account Nick");
    private final JButton jbtnAdd = GUI_ElementCreator.newJButton("Add This Account");
    private final JFrame frame;

    public GUI_NewAccountP(JFrame f){
        setLayout(new BorderLayout());
        add(GUI_ElementCreator.newTitle("Enter New Account Info"), BorderLayout.NORTH);
        JPanel pBox = new JPanel(new GridLayout(3,2));
        pBox.add(GUI_ElementCreator.newTextLabel("Account #:"));
        pBox.add(jtfAcctNum);
        pBox.add(GUI_ElementCreator.newTextLabel("Account Nick:"));
        pBox.add(jtfAcctNick);
        pBox.add(GUI_ElementCreator.newTextLabel("Bank:"));
        jcmbBank.addActionListener(this);
        pBox.add(jcmbBank);
        add(pBox, BorderLayout.CENTER);
        jbtnAdd.addActionListener(this);
        add(jbtnAdd, BorderLayout.SOUTH);

        frame = f;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== jbtnAdd){
            String msg = "Do you really want to save this account:";
            msg+="\n";
            msg+="Account #: "+ jtfAcctNum.getText().trim();
            msg+="\n";
            msg+="Account Nick:"+ jtfAcctNick.getText().trim();
            msg+="\n";
            msg+="Bank of Account:"+ (jcmbBank.getSelectedItem()+"").trim();
            msg+="\n";
            msg+="After Clicking Yes button this account will be added to your accounts";
            int answr = JOptionPane.showOptionDialog(null, msg, "Adding and Storing Account!",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, JOptionPane.NO_OPTION);
            if(answr == JOptionPane.YES_OPTION){
                frame.dispose();
                new NewAccountProgrammableHandler(jtfAcctNum.getText().trim(), jtfAcctNick.getText().trim(),
                        (jcmbBank.getSelectedItem()+"").trim());
            } else {
                GUI_ManualTransactionsEntryP.setAcctSelection(GUI_ManualTransactionsEntryP.getPreviousAcctSelection());
            }

        }else  if(e.getSource() == jcmbBank){
//            if(jcmbBank.getSelectedItem().toString().trim().compareToIgnoreCase(bankList[bankList.length-1])==0){
            if((jcmbBank.getSelectedItem()+"").trim().compareToIgnoreCase(PEC.NEW_BANK)==0){
                JOptionPane.showOptionDialog(null, "New Bank Window will be created soon", "New Bank",
                        JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, JOptionPane.YES_OPTION);
            }

        }
    }
}
