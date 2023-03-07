package gui_v1.action_processors;

import javax.swing.*;
import java.util.LinkedList;

public class ManualEntryProgrammableHandler {
    /**
     * This List of String[] arrays has all manually added transactions from GUI_ManualEntryWindow.
     */
    private LinkedList<String[]> manualEntriesList;

    private String acct;
    private String date;
    private String refN;
    private String descr;
    private String memo;
    private String amount;
    private String customCategory;

    public ManualEntryProgrammableHandler(String _acct, String _date, String _refN, String _descr, String _memo,
                                          String _amount, String _customCategory) {
        acct = _acct;
        date = _date;
        refN = _refN;
        descr = _descr;
        memo = _memo;
        amount = _amount;
        customCategory = _customCategory;

        showNewManualEntryInfo();
    }
    public ManualEntryProgrammableHandler(LinkedList<String[]> manualEnteredAccountsList) {
        manualEntriesList = manualEnteredAccountsList;
        showNewManualEntryInfo(manualEntriesList);
    }

    /**
     *  This method is for put code to process User Transactions Manually Entered.
     *  manualEntriesList -- holding all transactions entered at TransactionManualEntryWindow
     */
    private void transactionManualEntryProrcessing(){
        for(String[] singleUserTransManuallyEntered: manualEntriesList){
        }
    }


    private void showNewManualEntryInfo(LinkedList<String[]> manualEnteredAccountsList) {
        String[] singleManualEntry;

        String regInfo = "Users Manual Entry Data.";
        regInfo +="\nUser Enter " + manualEnteredAccountsList.size() + " transaction records:";

        for(int i = 0; i< manualEnteredAccountsList.size(); i++){
            singleManualEntry = manualEnteredAccountsList.get(i);
            regInfo +="\nRecord N." + (i+1) + " info:";
            regInfo +="\nAccount-->"+ singleManualEntry[0]+ "\ndate --> " + singleManualEntry[1] +"\nrefN --> "+ singleManualEntry[2]
                    +"\ndescr --> "+ singleManualEntry[3] +"\nmemo --> "+ singleManualEntry[4] +"\namount --> "+ singleManualEntry[5]
                    +"\ncustomCategory --> "+ singleManualEntry[6];
        }
        JOptionPane.showMessageDialog(null, regInfo,  "Manual Entry Data", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showNewManualEntryInfo(){
        String regInfo = "Users Manual Entry Data :\nAccount-->"+ acct+ "\ndate --> " + date +"\nrefN --> "+ refN
                +"\ndescr --> "+ descr +"\nmemo --> "+ memo +"\namount --> "+ amount
                +"\ncustomCategory --> "+ customCategory;
        JOptionPane.showMessageDialog(null, regInfo,  "Manual Entry Data", JOptionPane.INFORMATION_MESSAGE);

    }



}
