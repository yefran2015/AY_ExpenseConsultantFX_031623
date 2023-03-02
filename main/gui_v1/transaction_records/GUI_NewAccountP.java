package gui_v1.transaction_records;

import gui_v1.automation.GUI_ElementCreator;

import javax.swing.*;
import java.awt.*;

public class GUI_NewAccountP extends JPanel{
    private JComboBox  jcmbBank = GUI_ElementCreator.newJComboBox(new String[]{"Bank","Bank2","Bank3"});
    private JTextField jtfAcctNum= GUI_ElementCreator.newTextField("Account Number");
    private JTextField jtfAcctNick= GUI_ElementCreator.newTextField("Account Nick");

    public GUI_NewAccountP(){
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

    }
}
