package gui_v1.data_loaders;

import gui_v1.help_utils.GUI_Routines;
import main_logic.PEC;
import main_logic.Result;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GUI_ElementsDataLoader implements GUI_Routines {
    private static GUI_ElementsDataLoader instance = null;
    private GUI_ElementsDataLoader() throws SQLException {
        loadData();
    }
    public static GUI_ElementsDataLoader loadDataInitializeGUI() throws SQLException {
        if(instance == null){
            instance = new GUI_ElementsDataLoader();
        }
        return instance;
    }



    /**
     *  This array is holder of Short help tips for input elements located at
     *  Manual Entry, New Account, and New Bank Panels.
     *
     *  Positions in array are for -->
     *  [0] -- ComboBox Selection List for Account Nicks Selection
     *  [1] -- TextField for Date Input
     *  [2] -- TextField for Reference Number of Transaction Input
     *  [2] -- TextField for Transaction Name Input
     *  [2] -- TextField for Memo about Transaction Input
     *  [2] -- TextField for Currency Amount of Transaction Input
     *  [7] -- ComboBox Selection List for Transaction Categories Selection
     */
    public static String[] manualEntryElements_HelpMessages = new String[]{"Select Account","Enter Date",
            "Enter Reference number", "Enter Transaction Name", "Enter Memo", "Enter Amount", "Select Category"};
    /**
     * Same as Help Messages with adding at end Date string.
     * Positions in array are for -->
     * [8] -- Test String for Date Output Text Fields.
     *
     * */
    public static String[] manualEntryElements_TestingMessages = new String[]{"Select Account","Enter Date",
            "Enter Reference number", "Enter Transaction Name", "Enter Memo", "Enter Amount", "Select Category",
            "03/12/2023"};

    public static String[] newBankElements_HelpMessages = new String[]{"Enter New Bank Name",""};
    public static String[] newAccountElements_HelpMessages = new String[]{"Enter Account Number","Enter Account Nickname",
            "Select Bank"};
    private static String bSelectActionOption;
    private static  String[]  availableBanks;
    private static String anSelectActionOption;
    private static  String[]  availableNicks;
    private static String cSelectActionOption;
    private static  String[]  availableCategories;
    private void loadData() throws SQLException {

        bSelectActionOption = PEC.NEW_BANK;
        anSelectActionOption = PEC.NEW_ACCOUNT;
        cSelectActionOption = PEC.OTHER;
        Result res = PEC.instance().downloadDropDownMenuEntries();
        availableBanks= res.getBankList();
        availableNicks= res.getAcctList();
        availableCategories= res.getCategoryList();
        GUI_ElementsOptionLists.setGuiRequiredData(bSelectActionOption,anSelectActionOption, cSelectActionOption);
        GUI_ElementsOptionLists.getInstance().addBanksToList(availableBanks);
        GUI_ElementsOptionLists.getInstance().addAccntNicksToList(availableNicks);
        GUI_ElementsOptionLists.getInstance().addTransactionCategoriessToList(availableCategories);
    }

    private String[] sanitizeStrArr( String[] from){
        String[] newArr = new String[from.length];
        for(int i=0; i< newArr.length; i++){
            newArr[i] = from[i].trim();
        }
        return newArr;
    }
    public static  ManualEntryDataLoader getMEntHelpMsgs(){
      return ManualEntryDataLoader.getInst();
    }
    public static NewAccountsNickDataLoader getNAHelpMsgs(){
        return  NewAccountsNickDataLoader.getInst();
    }
    public static NewBankDataLoader getNBHelpMsgs(){
        return NewBankDataLoader.getInst();
    }

    public static AvailableBanksLoader getBanks(){
        return AvailableBanksLoader.getInst();
    }
    public static AvailableAccountNicksLoader getAcctNicks(){
        return AvailableAccountNicksLoader.getInst();
    }
    public static  AvailableTransactionCategoriesLoader getTranCategory(){
        return AvailableTransactionCategoriesLoader.getInst();
    }

    public static class ManualEntryDataLoader{
        private static final int NUMBER_ENABLED_INPUT_ELEMENTS_ON_THIS_VIEW = 7;
        private static ManualEntryDataLoader inst = null;
        private  ManualEntryDataLoader(){}
        public static ManualEntryDataLoader getInst(){
            if(inst == null){
                inst = new ManualEntryDataLoader();
            }
            return inst;
        }
        public int numOfInputElementsManualEntryHas(){
            return NUMBER_ENABLED_INPUT_ELEMENTS_ON_THIS_VIEW;
        }
        public String acctNicksSelectionHelpMsg(){
            return manualEntryElements_HelpMessages[0];
        }
        public String dateInputHelpMsg(){
            return manualEntryElements_HelpMessages[1];
        }
        public String referenceInputHelpMsg(){
            return manualEntryElements_HelpMessages[2];
        }
        public String transNameInputHelpMsg(){
            return manualEntryElements_HelpMessages[3];
        }
        public String transMemoInputHelpMsg(){
            return manualEntryElements_HelpMessages[4];
        }
        public String transAmountInputHelpMsg(){
            return manualEntryElements_HelpMessages[5];
        }
        public String categoryOfAccntSelectionHelpMsg(){
            return manualEntryElements_HelpMessages[6];
        }

        public String dateOutputHelpMsg(){
            return manualEntryElements_TestingMessages[7];
        }

    }
    public static class NewAccountsNickDataLoader{
        private static final int NUMBER_ENABLED_INPUT_ELEMENTS_ON_THIS_VIEW = 3;
        private static NewAccountsNickDataLoader inst = null;
        private  NewAccountsNickDataLoader(){}
        public static NewAccountsNickDataLoader getInst(){
            if(inst == null){
                inst = new NewAccountsNickDataLoader();
            }
            return inst;
        }
        public String accontInputHelpMsg(){
            return newAccountElements_HelpMessages[0];
        }
        public String nicknameInputHelpMsg(){
            return newAccountElements_HelpMessages[1];
        }
        public String bankSelectionHelpMsg(){
            return newAccountElements_HelpMessages[2];
        }

        public int numOfInputElementsNewAccountHas(){
            return NUMBER_ENABLED_INPUT_ELEMENTS_ON_THIS_VIEW;
        }
    }
    public static class NewBankDataLoader{
        private static final int NUMBER_ENABLED_INPUT_ELEMENTS_ON_THIS_VIEW = 1;
        private static NewBankDataLoader inst = null;
        private  NewBankDataLoader(){}
        public static NewBankDataLoader getInst(){
            if(inst == null){
                inst = new NewBankDataLoader();
            }
            return inst;
        }

        public String newBankNameInputHelpMsg(){
            return newBankElements_HelpMessages[0];
        }
    }

    public static class AvailableBanksLoader{
        private static AvailableBanksLoader inst = null;
        private  AvailableBanksLoader(){}
        public static AvailableBanksLoader getInst(){
            if(inst == null){
                inst = new AvailableBanksLoader();
            }
            return inst;
        }

        public String[] availableBanks(){
            return availableBanks;
        }
        public int numOfAvailableBanks(){
            return availableBanks().length;
        }
    }
    public static class AvailableAccountNicksLoader {
        private static AvailableAccountNicksLoader inst = null;
        private AvailableAccountNicksLoader(){}
        public static AvailableAccountNicksLoader getInst(){
            if(inst == null){
                inst = new AvailableAccountNicksLoader();
            }
            return inst;
        }

        public String[] availableNicks(){
            return availableNicks;
        }
        public int numOfAvailableNicks(){
            return availableNicks.length;
        }
    }
    public static class AvailableTransactionCategoriesLoader {
        private static AvailableTransactionCategoriesLoader inst = null;
        private AvailableTransactionCategoriesLoader(){}
        public static AvailableTransactionCategoriesLoader getInst(){
            if(inst == null){
                inst = new AvailableTransactionCategoriesLoader();
            }
            return inst;
        }

        public String[] availableCategories(){
            return availableCategories;
        }
        public int numOfAvailableCategories(){
            return availableCategories.length;
        }
    }

}
