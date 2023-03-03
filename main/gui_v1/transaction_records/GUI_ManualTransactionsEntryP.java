package gui_v1.transaction_records;

import gui_v1.action_processors.ManualEntryProgrammableHandler;
import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_ManualTransactionsEntryP extends JPanel implements GUI_Settings_Variables, ActionListener {


    private static JComboBox jcmbAccount = GUI_ElementCreator.newJComboBox(new String[]{"Nick","Nick2","Nick3", "NEW"});

    private JTextField jtfDate = GUI_ElementCreator.newTextField("02/15/2025");
    private JTextField jtfRefNum= GUI_ElementCreator.newTextField("Enter Reference Number");
    private JTextField jtfTransName = GUI_ElementCreator.newTextField("Enter Transaction Name");
    private JTextField jtfMemo= GUI_ElementCreator.newTextField("Enter Memo");
    private JTextField jtfAmount= GUI_ElementCreator.newTextField("Enter Amount");

//    private JTextField jtfCategory= GUI_ElementCreator.newTextField("Enter new Category");
    private JComboBox jcmbCategory = GUI_ElementCreator.newJComboBox(new String[]{"Fun","Games","Other"});

    private JButton jbtnCancel = GUI_ElementCreator.newJButton("Cancel");
    private JButton jbtnAnother = GUI_ElementCreator.newJButton("Another");
    private JButton jbtnDone = GUI_ElementCreator.newJButton("Done");

    private JButton jbtnFirst = GUI_ElementCreator.newJButton("<--First");
    private JButton jbtnPrev = GUI_ElementCreator.newJButton("<-Prev");
    private JButton jbtnNext = GUI_ElementCreator.newJButton("Next->");
    private JButton jbtnLast = GUI_ElementCreator.newJButton("Last-->");




    public GUI_ManualTransactionsEntryP(){
            setLayout(new BorderLayout());
            String  headingTitle  = "Transaction Manual Entry";
            add(GUI_ElementCreator.newSubHead(headingTitle), BorderLayout.NORTH);

            JPanel mainBoxP = new JPanel(new BorderLayout());
            String  manualEntryTitleMessage  = "Enter Transaction Information";
            mainBoxP.add(GUI_ElementCreator.newTitle(manualEntryTitleMessage), BorderLayout.NORTH);

            JPanel userInputElementsBox = new JPanel(new GridLayout(7,2));
            userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Account:"));
            jcmbAccount.addActionListener(this);
            userInputElementsBox.add(jcmbAccount);

            userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Date:"));
            userInputElementsBox.add(jtfDate);


            userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Reference #"));
            userInputElementsBox.add(jtfRefNum);
            userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Transaction Name:"));
            userInputElementsBox.add(jtfTransName);
            userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Memo:"));
            userInputElementsBox.add(jtfMemo);
            userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Amount:"));
            userInputElementsBox.add(jtfAmount);
            userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Category:"));
            userInputElementsBox.add(jcmbCategory);

            mainBoxP.add(userInputElementsBox, BorderLayout.CENTER);
            add(mainBoxP, BorderLayout.CENTER);
            jbtnDone.addActionListener(this);
            JPanel buttonsBox = new JPanel(new GridLayout(2,4));
            buttonsBox.add(jbtnFirst);
            buttonsBox.add(jbtnPrev);
            buttonsBox.add(jbtnNext);
            buttonsBox.add(jbtnLast);
            buttonsBox.add(jbtnCancel);
            buttonsBox.add(jbtnAnother);
            buttonsBox.add(jbtnDone);
            add(buttonsBox, BorderLayout.SOUTH);
        }
        public static void addAccountNickToComboBox(String acctNick){
            jcmbAccount.addItem(acctNick);
        }
        @Override
        public Component getComponent() {
            return null;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == jbtnDone){
                String accoutn = jcmbAccount.getSelectedItem().toString().trim();
                String date= jtfDate.getText().trim();
                String refN = jtfRefNum.getText().trim();
                String descr = jtfTransName.getText().trim();
                String memo = jtfMemo.getText().trim();
                String amount = jtfAmount.getText().trim();
                String custom_category= jcmbCategory.getSelectedItem().toString().trim();

                new ManualEntryProgrammableHandler(accoutn, date, refN,descr, memo, amount,custom_category);

            }else  if(e.getSource() == jcmbAccount){
                if(jcmbAccount.getSelectedItem().toString().trim().compareToIgnoreCase("NEW")==0){
                    new NewAccountWindow();
                }

            }
        }
}
