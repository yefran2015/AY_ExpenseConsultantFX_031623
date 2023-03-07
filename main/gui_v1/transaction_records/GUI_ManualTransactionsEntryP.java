package gui_v1.transaction_records;

import entities.Transaction;
import gui_v1.action_processors.ManualEntryProgrammableHandler;
import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;
import main_logic.Request;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static gui_v1.mainWindows.GUI_ManualEntryWindow.hideManualEntryWindow;
import static gui_v1.mainWindows.GUI_ManualEntryWindow.showManualEntryWindow;

public class GUI_ManualTransactionsEntryP extends JPanel implements GUI_Settings_Variables, ActionListener {

    private static Request[] tempArray = new Request[5];
    static Request form = Request.instance();

    private static final String NEW_ACCT = "<NEW ACCOUNT>";
    private static final String NO_ACCT = "<--no account-->";
    private static final String NEW_CAT = "<NEW CATEGORY>";

    private JComboBox jcmbAccount;
    private JTextField jtfDate = GUI_ElementCreator.newTextField("");
    private JTextField jtfRefNum= GUI_ElementCreator.newTextField("");
    private JTextField jtfTransName = GUI_ElementCreator.newTextField("");
    private JTextField jtfMemo= GUI_ElementCreator.newTextField("");
    private JTextField jtfAmount= GUI_ElementCreator.newTextField("");
    private JComboBox jcmbCategory;

    // LOADED FROM THE DATABASE
    private static String[] nickList = new String[] { "Main Checking", "Savings", "My VISA" };
    private static DropDownItems acctNicks = new DropDownItems(nickList, NO_ACCT, NEW_ACCT);
    private static DropDownItems tranCat;

    private static int currentTran = 0; // which Transaction is being shown

    private JButton jbtnCancel = GUI_ElementCreator.newJButton("Cancel");
    private JButton jbtnAnother = GUI_ElementCreator.newJButton("Another");
    private JButton jbtnDone = GUI_ElementCreator.newJButton("Done");

    private JButton jbtnFirst = GUI_ElementCreator.newJButton("<--First");
    private JButton jbtnPrev = GUI_ElementCreator.newJButton("<-Prev");
    private JButton jbtnNext = GUI_ElementCreator.newJButton("Next->");
    private JButton jbtnLast = GUI_ElementCreator.newJButton("Last-->");

    private JPanel mainBoxP;

    public GUI_ManualTransactionsEntryP(String whichNick, int position, String whichCat){
        setLayout(new BorderLayout());
        if (tempArray.length==0 || position==-1) {
            form.reset();
            form.setTDate("");
            form.setTRef("");
            form.setTDesc("");
            form.setTMemo("");
            form.setTAmount(0.00);
            setFields(form);
        }
        String headingTitle  = "Transaction Manual Entry";
        add(GUI_ElementCreator.newSubHead(headingTitle), BorderLayout.NORTH);
        mainBoxP = new JPanel(new BorderLayout());
        String  manualEntryTitleMessage  = "Enter Transaction Information";
        mainBoxP.add(GUI_ElementCreator.newTitle(manualEntryTitleMessage), BorderLayout.NORTH);
        tranCat = new DropDownItems(Transaction.CAT_NAMES, NEW_CAT);
        jcmbAccount= GUI_ElementCreator.newJComboBox(acctNicks.getList());
        jcmbCategory= GUI_ElementCreator.newJComboBox(tranCat.getList());

        if (whichNick.length()>0) jcmbAccount.setSelectedItem(whichNick);
        if (whichCat.length()>0) jcmbCategory.setSelectedItem(whichCat);

        JPanel userInputElementsBox = new JPanel(new GridLayout(7,2));
        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Account Nickname:"));
        jcmbAccount.addActionListener(this);
        userInputElementsBox.add(jcmbAccount);

        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Date (YYYY/MM/DD):"));
        userInputElementsBox.add(jtfDate);


        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Reference #:"));
        userInputElementsBox.add(jtfRefNum);
        userInputElementsBox.add(GUI_ElementCreator.newTextLabel("Transaction Name/ Description:"));
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
        acctNicks.addItem(acctNick);
        hideManualEntryWindow();
        showManualEntryWindow(acctNick,-1, Transaction.CAT_NAMES[currentTran]);
    }

    @Override
    public Component getComponent() {
        return null;
    }

    private void setFields(Request request) {
        jtfDate = GUI_ElementCreator.newTextField(request.getTDate());
        jtfRefNum = GUI_ElementCreator.newTextField(request.getTRef());
        jtfTransName = GUI_ElementCreator.newTextField(request.getTDesc());
        jtfMemo = GUI_ElementCreator.newTextField(request.getTMemo());
        if (request.getTAmount()==0.00) jtfAmount = GUI_ElementCreator.newTextField("");
        else jtfAmount = GUI_ElementCreator.newTextField(Double.toString(request.getTAmount()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jbtnDone){
            String account = jcmbAccount.getSelectedItem().toString().trim();
            if (account.equalsIgnoreCase(NO_ACCT)) account = "";
            String date= jtfDate.getText().trim();
            String refN = jtfRefNum.getText().trim();
            String descr = jtfTransName.getText().trim();
            String memo = jtfMemo.getText().trim();
            String amount = jtfAmount.getText().trim();
            String custom_category= jcmbCategory.getSelectedItem().toString().trim();

            new ManualEntryProgrammableHandler(account, date, refN,descr, memo, amount, custom_category);

        }else  if(e.getSource() == jcmbAccount){
            if(jcmbAccount.getSelectedItem().toString().trim().compareToIgnoreCase(NEW_ACCT)==0){
                new NewAccountWindow();
            }

        }
    }
}
