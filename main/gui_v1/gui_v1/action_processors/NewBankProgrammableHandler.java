package gui_v1.action_processors;
import gui_v1.mainWindows.newAccountWElements.GUI_NewAccountP;

import javax.swing.*;



public class NewBankProgrammableHandler {
    private String strBank;
    public NewBankProgrammableHandler( String _strBank){
        GUI_NewAccountP.addAccountNickToComboBox(_strBank );
        strBank = _strBank;
        showNewBankEntryInfo();
    }
    private void showNewBankEntryInfo(){
        String regInfo = "User New Bank Info:\nBank name --> " + strBank;
        JOptionPane.showMessageDialog(null, regInfo,  "New Bank Data", JOptionPane.INFORMATION_MESSAGE);

    }
}
