package gui_v1.action_processors;

import javax.swing.*;

public class ManualEntryProgrammableHandler {
    private String acct;
    private String date;
    private String refN;
    private String descr;
    private  String memo;
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
    private void showNewManualEntryInfo(){
        String regInfo = "Users Manual Entry Data :\nAccount-->"+ acct+ "\ndate --> " + date +"\nrefN --> "+ refN
                +"\ndescr --> "+ descr +"\nmemo --> "+ memo +"\namount --> "+ amount
                +"\ncustomCategory --> "+ customCategory;
        JOptionPane.showMessageDialog(null, regInfo,  "Manual Entry Data", JOptionPane.INFORMATION_MESSAGE);

    }


}
