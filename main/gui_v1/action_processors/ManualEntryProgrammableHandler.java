package gui_v1.action_processors;

import javax.swing.*;

public class ManualEntryProgrammableHandler {
    private String date;
    private String refN;
    private String descr;
    private  String memo;
    private String amount;
    private String category;
    private String customCategory;
    public ManualEntryProgrammableHandler(String _date, String _refN, String _descr, String _memo,
                                          String _amount, String _category, String _customCategory) {
        date = _date;
        refN = _refN;
        descr = _descr;
        memo = _memo;
        amount = _amount;
        category = _category;
        customCategory = _customCategory;

        showNewManualEntryInfo();
    }
    private void showNewManualEntryInfo(){
        String regInfo = "Users Manual Entry Data :\n" + "date --> " + date +"\nrefN --> "+ refN
                +"\ndescr --> "+ descr +"\nmemo --> "+ memo +"\namount --> "+ amount
                +"\ncategory --> "+ category +"\ncustomCategory --> "+ customCategory;
        JOptionPane.showMessageDialog(null, regInfo,  "Manual Entry Data", JOptionPane.INFORMATION_MESSAGE);

    }
}
