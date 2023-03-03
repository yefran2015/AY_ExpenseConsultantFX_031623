package gui_v1.action_processors;

import javax.swing.*;

public class NewAccountProgrammableHandler {
    private String strAcctNum;
    private String strAccntNick;
    private String strBank;
//    private String descr;
//    private  String memo;
//    private String amount;
//    private String customCategory;
//    public NewAccountProgrammableHandler(String _acct, String _date, String _refN, String _descr, String _memo,
//                                          String _amount, String _customCategory) {
    public NewAccountProgrammableHandler(String _strAcctNum, String _strAccntNick, String _strBank){
        strAcctNum = _strAcctNum;
        strAccntNick = _strAccntNick;
        strBank = _strBank;
//        descr = _descr;
//        memo = _memo;
//        amount = _amount;
//        customCategory = _customCategory;

        showNewManualEntryInfo();
    }
    private void showNewManualEntryInfo(){
        String regInfo = "User New Accounts :\nAccount #:"+ strAcctNum+ "\nAccount NickName: " + strAccntNick +"\nBank "+ strBank;


        JOptionPane.showMessageDialog(null, regInfo,  "New Account Data", JOptionPane.INFORMATION_MESSAGE);

    }
}
