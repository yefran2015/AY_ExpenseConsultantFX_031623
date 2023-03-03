package gui_v1.transaction_records;

import gui_v1.action_processors.NewAccountProgrammableHandler;
import gui_v1.automation.GUI_ElementCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_NewAccountP extends JPanel implements ActionListener {
    private JComboBox  jcmbBank = GUI_ElementCreator.newJComboBox(new String[]{"Bank","Bank2","Bank3"});
    private JTextField jtfAcctNum= GUI_ElementCreator.newTextField("Account Number");
    private JTextField jtfAcctNick= GUI_ElementCreator.newTextField("Account Nick");
    private JButton jbtnAdd = GUI_ElementCreator.newJButton("Add This Account");
    private JFrame frame;

    public GUI_NewAccountP(JFrame f){
        setLayout(new BorderLayout());
        add(GUI_ElementCreator.newTitle("Enter New Account Info"), BorderLayout.NORTH);
        JPanel pBox = new JPanel(new GridLayout(3,2));
        pBox.add(GUI_ElementCreator.newTextLabel("Account #:"));
        pBox.add(jtfAcctNum);
        pBox.add(GUI_ElementCreator.newTextLabel("Account Nick:"));
        pBox.add(jtfAcctNick);
        pBox.add(GUI_ElementCreator.newTextLabel("Bank:"));
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
            msg+="Bank of Account:"+ jcmbBank.getSelectedItem().toString().trim();
            msg+="\n";
            msg+="After Clicking Yes button this account will be added to your accounts";
            int answr = JOptionPane.showOptionDialog(null, msg, "Adding and Storing Account!",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, JOptionPane.NO_OPTION);
            if(answr == JOptionPane.YES_OPTION){
                frame.dispose();
                new NewAccountProgrammableHandler(jtfAcctNum.getText().trim(), jtfAcctNick.getText().trim(),
                        jcmbBank.getSelectedItem().toString().trim());
            }else{

            }

            
        }
    }
}
