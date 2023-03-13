package gui_v1.action_processors;

import gui_v1.mainWindows.recordsWElements.RecordsTable;
import gui_v1.mainWindows.GUI_RecordsWindow;
import main_logic.PEC;
import main_logic.Request;
import main_logic.Result;

import javax.swing.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class ManualEntryProgrammableHandler{
    /**
     * This List of String[] arrays has all manually added transactions from GUI_ManualEntryWindow.
     */
    private LinkedList<String[]> manualEntriesList = new LinkedList<String[]>();

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

        // we also need to save all Categories!!
    }
    public ManualEntryProgrammableHandler(LinkedList<String[]> manualEnteredAccountsList) {

        manualEntriesList = manualEnteredAccountsList;
        showNewManualEntryInfo(manualEntriesList);
        transactionManualEntryProcessing();
    }

    /**
     *  This method is for put code to process User Transactions Manually Entered.
     *  manualEntriesList -- holding all transactions entered at TransactionManualEntryWindow
     */
    private void transactionManualEntryProcessing(){
        Request request = Request.instance();
        Result result = new Result();
        for(String[] singleUserTransManuallyEntered: manualEntriesList){
            request.reset();
            request.setAccountNick(singleUserTransManuallyEntered[0]);
            request.setTDate(singleUserTransManuallyEntered[1]);
            request.setTRef(singleUserTransManuallyEntered[2]);
            request.setTDesc(singleUserTransManuallyEntered[3]);
            request.setTMemo(singleUserTransManuallyEntered[4]);
            try {
                request.setTAmount(Double.parseDouble(singleUserTransManuallyEntered[5]));
            } catch (Exception e) {
                request.setTAmount(0.0);
            }
            request.setTCat(singleUserTransManuallyEntered[6]);
            PEC.instance().processSingleManualEntry(request);
        }
        ListIterator<Result> it = PEC.instance().returnRListIterator();
        RecordsTable.clearTable();
        while(it.hasNext()){
            result = it.next();
            RecordsTable.addRowToTable(result.getTDate(),
                    result.getTRef(), result.getTDesc(),
                    result.getTMemo(), result.getTAmount(), result.getTCat());
        }
        GUI_RecordsWindow.getInstance().showRecordsWindow();
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
