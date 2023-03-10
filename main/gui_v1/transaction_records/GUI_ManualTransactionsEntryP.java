package gui_v1.transaction_records;

import entities.Transaction;
import gui_v1.action_processors.ManualEntryProgrammableHandler;
import gui_v1.automation.GUI_ElementCreator;
import gui_v1.guiHelp_utils.GUI_AY_Calendar;
import gui_v1.gui_logic.GUI_ManualEntryTemporaialHolder;
import gui_v1.mainWindows.GUI_ManualEntryWindow;
import gui_v1.mainWindows.GUI_RecordsWindow;
import gui_v1.settings.GUI_Settings_Variables;
import main_logic.PEC;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;

public class GUI_ManualTransactionsEntryP extends JPanel implements GUI_Settings_Variables, ActionListener, FocusListener {
    private final static String[] ERROR_IN_USER_INPUT = null;
    private static String[] manyalEntryDefaultJTextFieldText = new String[]{"Select Account",
            Transaction.returnYYYYMMDDFromCalendar(Calendar.getInstance()),
            "Enter Reference number", "Enter Transaction Name", "Enter Memo", "Enter Amount", "Select Category"};


    private JTextField jtfDate = GUI_ElementCreator.newTextField(manyalEntryDefaultJTextFieldText[1]);
    private JTextField jtfOutputDate = GUI_ElementCreator.newOutputTextField(manyalEntryDefaultJTextFieldText[1]);
    private JTextField jtfRefNum = GUI_ElementCreator.newTextField(manyalEntryDefaultJTextFieldText[2]);
    private JTextField jtfTransName = GUI_ElementCreator.newTextField(manyalEntryDefaultJTextFieldText[3]);
    private JTextField jtfMemo = GUI_ElementCreator.newTextField(manyalEntryDefaultJTextFieldText[4]);
    private JTextField jtfAmount = GUI_ElementCreator.newTextField(manyalEntryDefaultJTextFieldText[5]);

    private static JComboBox<String> jcmbAccount = GUI_ElementCreator.newJComboBox(TransactionBankAccountInitialLists.getInstance().getAccntNicksList());
    private static JComboBox<String> jcmbCategory = GUI_ElementCreator.newJComboBox(TransactionBankAccountInitialLists.getInstance().getTransCategoryist());
    private static String previousAcctSelection = manyalEntryDefaultJTextFieldText[0];

    private JButton jbtnCancel = GUI_ElementCreator.newJButton("Cancel");
    private JButton jbtnAnother = GUI_ElementCreator.newJButton("Another");
    private JButton jbtnDone = GUI_ElementCreator.newJButton("Done");

    private JButton jbtnFirst = GUI_ElementCreator.newJButton("<--First");
    private JButton jbtnPrev = GUI_ElementCreator.newJButton("<-Prev");
    private JButton jbtnNext = GUI_ElementCreator.newJButton("Next->");
    private JButton jbtnLast = GUI_ElementCreator.newJButton("Last-->");

    private JComboBox<String> jcmbYears;
    private JComboBox<String> jcmbMonths;
    private JComboBox<String> jcmbDays;


    public GUI_ManualTransactionsEntryP() {

        setLayout(new BorderLayout());
        String headingTitle = "Transaction Manual Entry";
        add(GUI_ElementCreator.newSubHead(headingTitle), BorderLayout.NORTH);

        JPanel mainBoxP = new JPanel(new BorderLayout());
        String manualEntryTitleMessage = "Enter Transaction Information";
        mainBoxP.add(GUI_ElementCreator.newTitle(manualEntryTitleMessage), BorderLayout.NORTH);

        JPanel userInputElementsBox = new JPanel(new GridLayout(7, 2));
        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Account:"));
        jcmbAccount.addActionListener(this);
        jcmbAccount.removeItem(manyalEntryDefaultJTextFieldText[0]);
        jcmbAccount.insertItemAt(manyalEntryDefaultJTextFieldText[0], 0);
        jcmbAccount.setSelectedIndex(0);

        userInputElementsBox.add(jcmbAccount);

        JPanel dateBoxP = new JPanel(new BorderLayout());
        dateBoxP.add(GUI_ElementCreator.newTextLabel("Date:"), BorderLayout.WEST);

        jtfOutputDate.setEditable(false);
        jtfOutputDate.setBackground(null);
        JPanel datOutBoxP = new JPanel();
        jtfOutputDate.setPreferredSize(new Dimension(120, txtSize_JTextField + 4));
        datOutBoxP.add(GUI_ElementCreator.newOutputTextFieldLabel("Selected Date:"));
        datOutBoxP.add(jtfOutputDate);
        datOutBoxP.add(GUI_ElementCreator.newFieldNameLabel(" "));
        dateBoxP.add(datOutBoxP, BorderLayout.EAST);
        userInputElementsBox.add(dateBoxP);
        userInputElementsBox.add(new DateSelectionsP());


        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Reference #"));
        userInputElementsBox.add(jtfRefNum);
        jtfRefNum.addFocusListener(this);
        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Transaction Name:"));
        userInputElementsBox.add(jtfTransName);
        jtfTransName.addFocusListener(this);
        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Memo:"));
        userInputElementsBox.add(jtfMemo);
        jtfMemo.addFocusListener(this);
        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Amount:"));
        userInputElementsBox.add(jtfAmount);
        jtfAmount.addFocusListener(this);

        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Category:"));
        jcmbCategory.removeItem(manyalEntryDefaultJTextFieldText[manyalEntryDefaultJTextFieldText.length - 1]);
        jcmbCategory.insertItemAt(manyalEntryDefaultJTextFieldText[manyalEntryDefaultJTextFieldText.length - 1], 0);
        jcmbCategory.setSelectedItem(PEC.instance().OTHER);
        userInputElementsBox.add(jcmbCategory);

        mainBoxP.add(userInputElementsBox, BorderLayout.CENTER);
        add(mainBoxP, BorderLayout.CENTER);


        jbtnFirst.addActionListener(this);
        jbtnPrev.addActionListener(this);
        jbtnNext.addActionListener(this);
        jbtnLast.addActionListener(this);


        jbtnDone.addActionListener(this);
        jbtnCancel.addActionListener(this);
        jbtnAnother.addActionListener(this);

        JPanel buttonsBox = new JPanel(new GridLayout(2, 4));
        buttonsBox.add(jbtnFirst);
        buttonsBox.add(jbtnPrev);
        buttonsBox.add(jbtnNext);
        buttonsBox.add(jbtnLast);
        buttonsBox.add(jbtnCancel);
        buttonsBox.add(jbtnAnother);
        buttonsBox.add(jbtnDone);
        add(buttonsBox, BorderLayout.SOUTH);
    }


    public static String getPreviousAcctSelection() {
        return previousAcctSelection;
    }

    public static void setAcctSelection(String selection) {
        jcmbAccount.setSelectedItem(selection);
    }

    private void setDateOutputTextFieldWithDateFromComboBoxes() {
        jtfOutputDate.setText(jcmbMonths.getSelectedItem() + "/" + jcmbDays.getSelectedItem() + "/" + jcmbYears.getSelectedItem());
    }


    private void o(Object o) {
        System.out.println(o + "");
    }

    private void replaceItemsAtJCMBoWith(JComboBox<String> jcb, String[] items) {
        jcb.removeAllItems();
        for (String i : items) {
            jcb.addItem(i);
        }
    }

    public static void addAccountNickToComboBox(String acctNick) {
        jcmbAccount.insertItemAt(acctNick, jcmbAccount.getItemCount() - 1);
        jcmbAccount.setSelectedItem(acctNick);
    }

    public void setALLDefault_UserHelpTexts() {
        setALLCustom_UserHelpTexts(manyalEntryDefaultJTextFieldText[0], manyalEntryDefaultJTextFieldText[1],
                manyalEntryDefaultJTextFieldText[2], manyalEntryDefaultJTextFieldText[3], manyalEntryDefaultJTextFieldText[4],
                manyalEntryDefaultJTextFieldText[5], manyalEntryDefaultJTextFieldText[6]);

    }

    public void setALLCustom_UserHelpTexts(String accountCombo_helpText, String date_helpText, String refnum_helpText, String transName_helpText,
                                           String memo_helpText, String amount_helpText, String categoryCombo_helpText) {
        setJTFCustom_Texts(date_helpText, refnum_helpText, transName_helpText, memo_helpText, amount_helpText);
        setJCMBs_Custom_UserHelpTexts(accountCombo_helpText, categoryCombo_helpText);
    }

    private void setJCMBs_Custom_UserHelpTexts(String accountComboHelpText, String categoryComboHelpText) {
        jcmbAccount.setSelectedItem(accountComboHelpText);
        jcmbCategory.setSelectedItem(categoryComboHelpText);
    }

    public void setJTFCustom_Texts(String date_helpText, String refnum_helpText, String TransName_helpText,
                                   String memo_helpText, String amount_helpText) {
        jtfDate.setText(date_helpText);
        jtfRefNum.setText(refnum_helpText);
        jtfTransName.setText(TransName_helpText);
        jtfMemo.setText(memo_helpText);
        jtfAmount.setText(amount_helpText);
    }

    public void setManualEntriesValues(String[] tmpManualEntries) {
        String acctNick = tmpManualEntries[0];
        String date = tmpManualEntries[1];
        String refNum = tmpManualEntries[2];
        String transName = tmpManualEntries[3];
        String memo = tmpManualEntries[4];
        String amount = tmpManualEntries[5];
        String category = tmpManualEntries[6];
        setALLCustom_UserHelpTexts(acctNick, date, refNum, transName, memo, amount, category);
        setManualEntriesCalendarValues(date.split("/"));
    }

    public void setManualEntriesCalendarValues(String[] calArrYMD) {
        jcmbYears.setSelectedItem(calArrYMD[2]);
        jcmbMonths.setSelectedItem(calArrYMD[0]);
        jcmbDays.setSelectedItem(calArrYMD[1]);
    }


    private String[] getAllInputs() {
        String account = (jcmbAccount.getSelectedItem() + "").trim();
        String custom_category = (jcmbCategory.getSelectedItem() + "").trim();
        boolean err = false;
        if (account.compareToIgnoreCase(manyalEntryDefaultJTextFieldText[0]) == 0) {
            jcmbAccount.setBorder(new LineBorder(Color.RED, 1));
            err = true;

        }
        if (custom_category.compareToIgnoreCase(manyalEntryDefaultJTextFieldText[manyalEntryDefaultJTextFieldText.length - 1]) == 0) {
            jcmbCategory.setBorder(new LineBorder(Color.RED, 1));
            err = true;
        }
        if (err) {
            return ERROR_IN_USER_INPUT;
        }
//        String date= jtfOutputDate.getText().trim();
        String[] dateArr = jtfOutputDate.getText().split("/");
        if (dateArr[0].length() == 1) {
            dateArr[0] = "0" + dateArr[0];
        }
        if (dateArr[1].length() == 1) {
            dateArr[1] = "0" + dateArr[1];
        }

        // String date= dateArr[2]+"/"+dateArr[0]+"/"+dateArr[1];
        String date = dateArr[0] + "/" + dateArr[1] + "/" + dateArr[2];

        String refN = jtfRefNum.getText().trim();
        String descr = jtfTransName.getText().trim();
        String memo = jtfMemo.getText().trim();
        String amount = jtfAmount.getText().trim();
//        GUI_ManualEntryTemporaialHolder.addTempUserManualEntry(account, date, refN,descr, memo, amount,custom_category);

        return new String[]{account, date, refN, descr, memo, amount, custom_category};
    }

    private void clearErrorBorders() {
        jcmbAccount.setBorder(new LineBorder(null, 0));
        jcmbCategory.setBorder(new LineBorder(null, 0));
    }

    private void processAnotherClick() {
        String[] userInputs = getAllInputs();
        if (userInputs == ERROR_IN_USER_INPUT) {
            return;
        }
        GUI_ManualEntryTemporaialHolder.getInstance().addTempUserManualEntry(userInputs[0], userInputs[1], userInputs[2],
                userInputs[3], userInputs[4], userInputs[5], userInputs[6]);
        setALLDefault_UserHelpTexts();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbtnDone) {
//          new ManualEntryProgrammableHandler(accoutn, date, refN,descr, memo, amount,custom_category);
//          processAnotherClick();
            GUI_ManualEntryTemporaialHolder.getInstance().addTempUserManualEntry(getAllInputs());
            new ManualEntryProgrammableHandler(GUI_ManualEntryTemporaialHolder.getInstance().getManuallYEnterredAccounts());
            GUI_ManualEntryTemporaialHolder.getInstance().clearTemporalManualEntrylist();
            GUI_ManualEntryWindow.getInstance().disposeManualEntryWindow();
            GUI_RecordsWindow.getInstance().showRecordsWindow();
        } else if (e.getSource() == jcmbAccount) {
            if ((jcmbAccount.getSelectedItem() + "").trim().compareToIgnoreCase(PEC.NEW_ACCOUNT) == 0) {
                NewAccountWindow.getInstance().showNewAccntWindow();
            } else {
                previousAcctSelection = (String) jcmbAccount.getSelectedItem();
            }
        } else if (e.getSource() == jbtnAnother) {
            processAnotherClick();


        } else if (e.getSource() == jcmbCategory) {
        } else if (e.getSource() == jbtnFirst) {
            String[] firstManualEntryArr = GUI_ManualEntryTemporaialHolder.getInstance().getFirst();
            setManualEntriesValues(firstManualEntryArr);
        } else if (e.getSource() == jbtnPrev) {
            String[] previousManualEntryArr = GUI_ManualEntryTemporaialHolder.getInstance().getPrev();
            setManualEntriesValues(previousManualEntryArr);
        } else if (e.getSource() == jbtnNext) {
            String[] nextManualEntryArr = GUI_ManualEntryTemporaialHolder.getInstance().getNext();
            setManualEntriesValues(nextManualEntryArr);
        } else if (e.getSource() == jbtnLast) {
            String[] lastManualEntryArr = GUI_ManualEntryTemporaialHolder.getInstance().getLast();
            setManualEntriesValues(lastManualEntryArr);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        ((JTextField) e.getSource()).selectAll();
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

    @Override
    public Component getComponent() {
        return null;
    }

    private class DateSelectionsP extends JPanel {
        DateSelectionsP() {
            setLayout(new GridLayout(1, 6));

            jcmbYears = GUI_ElementCreator.newJComboBox(GUI_AY_Calendar.getYearsDesendingArr());
            jcmbYears.setActionCommand("YEAR");
            jcmbYears.setSelectedItem(Calendar.getInstance().get(Calendar.YEAR));
            jcmbYears.addActionListener(actionListenerForDatesJCMboxes());

            jcmbMonths = GUI_ElementCreator.newJComboBox(GUI_AY_Calendar.monthsArr);
            jcmbMonths.setSelectedItem((Calendar.getInstance().get(Calendar.MONTH) + 1) + "");
            jcmbMonths.addActionListener(actionListenerForDatesJCMboxes());
            jcmbMonths.setActionCommand("MONTH");

            jcmbDays = GUI_ElementCreator.newJComboBox(GUI_AY_Calendar.getDaysAsStrArrForMountOFYear(Integer.parseInt(jcmbMonths.getSelectedItem() + ""),
                    Integer.parseInt(jcmbYears.getSelectedItem() + "")));
            jcmbDays.setSelectedItem(Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "");
            jcmbDays.addActionListener(actionListenerForDatesJCMboxes());
            jcmbDays.setActionCommand("DAY");

            add(GUI_ElementCreator.newTextLabel("Year"));
            add(jcmbYears);
            add(GUI_ElementCreator.newFieldNameLabel("Month"));
            add(jcmbMonths);
            add(GUI_ElementCreator.newFieldNameLabel("Day"));
            add(jcmbDays);

            setDateOutputTextFieldWithDateFromComboBoxes();
        }

        private ActionListener actionListenerForDatesJCMboxes() {
            ActionListener a = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getActionCommand().compareToIgnoreCase("YEAR") == 0) {
                        jcmbMonths.setSelectedIndex(0);
                    } else if (e.getActionCommand().compareToIgnoreCase("MONTH") == 0) {
                        replaceItemsAtJCMBoWith(jcmbDays, GUI_AY_Calendar.getDaysAsStrArrForMountOFYear(Integer.parseInt(jcmbMonths.getSelectedItem() + ""),
                                Integer.parseInt(jcmbYears.getSelectedItem() + "")));
                    } else if (e.getActionCommand().compareToIgnoreCase("DAY") == 0) {
                    }
                    setDateOutputTextFieldWithDateFromComboBoxes();
                }
            };
            return a;
        }
    }

}