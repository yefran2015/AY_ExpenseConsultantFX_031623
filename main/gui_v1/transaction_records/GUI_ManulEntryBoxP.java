package gui_v1.transaction_records;

import gui_v1.action_processors.ManualEntryProgrammableHandler;
import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_ManulEntryBoxP extends JPanel  implements GUI_Settings_Variables, ActionListener {
    private JTextField jtfDate = GUI_ElementCreator.newTextField("Enter Date");
    private JTextField jtfRefNum= GUI_ElementCreator.newTextField("Enter Reference Number");;
    private JTextField jtfDescription= GUI_ElementCreator.newTextField("Enter Description");;
    private JTextField jtfMemo= GUI_ElementCreator.newTextField("Enter Memo");;
    private JTextField jtfAmount= GUI_ElementCreator.newTextField("Enter Amount");;
    private JTextField jtfCategory= GUI_ElementCreator.newTextField("Enter new Category");;
    private JComboBox jcmbCategory = GUI_ElementCreator.newJComboBox(new String[]{"Fun","Games","Other"});
    private JButton jbtnAdd = GUI_ElementCreator.newJButton("Add Transaction to the Record");

    public GUI_ManulEntryBoxP(){
        setLayout(new BorderLayout());
        String  headingTitle  = "Add New Transaction To transaction Records";
        add(GUI_ElementCreator.newSubHead(headingTitle), BorderLayout.NORTH);

        JPanel mainBoxP = new JPanel(new BorderLayout());
        String  manualEntryTitleMessage  = "Please Enter Transaction Information";
        mainBoxP.add(GUI_ElementCreator.newTitle(manualEntryTitleMessage), BorderLayout.NORTH);

        JPanel userInputElementsBox = new JPanel(new GridLayout(7,2));
        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Date:"));
        userInputElementsBox.add(jtfDate);
        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("ref Num:"));
        userInputElementsBox.add(jtfRefNum);
        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Description:"));
        userInputElementsBox.add(jtfDescription);
        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Memo:"));
        userInputElementsBox.add(jtfMemo);
        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Amount:"));
        userInputElementsBox.add(jtfAmount);
        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Select Category:"));
        JPanel box = new JPanel(new GridLayout(1,3));
        box.add(jcmbCategory);
        box.add(GUI_ElementCreator.newTextLabel(" or Enter Custom: "));
        box.add(jtfCategory);
        userInputElementsBox.add(box);
        mainBoxP.add(userInputElementsBox, BorderLayout.CENTER);

        add(mainBoxP, BorderLayout.CENTER);
        jbtnAdd.addActionListener(this);
        add(jbtnAdd, BorderLayout.SOUTH);
    }

    @Override
    public Component getComponent() {
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbtnAdd){
            String date= jtfDate.getText().trim();
            String refN = jtfRefNum.getText().trim();
            String descr = jtfDescription.getText().trim();
            String memo = jtfMemo.getText().trim();
            String amount = jtfAmount.getText().trim();
            String category = jtfCategory.getText().trim();

            String custom_category= jcmbCategory.getSelectedItem().toString().trim();

            new ManualEntryProgrammableHandler(date, refN,descr, memo, amount,category,custom_category);

        }
    }
}
