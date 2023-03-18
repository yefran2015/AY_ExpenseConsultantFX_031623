package gui_v1.data_loaders;
import gui_v1.help_utils.GUI_Routines;

import java.util.LinkedList;
import java.util.MissingResourceException;

/**
 *  This class to handle all Categories Lists of GUI RUN TIme.
 */
public class GUI_ElementsOptionLists implements GUI_Routines {

    private LinkedList<String> bankList;
    private LinkedList<String> acctNicksList;
    private LinkedList<String> transactionCategoriesList;

    private static GUI_ElementsOptionLists instance = null;

    private GUI_ElementsOptionLists(String bankActionOption, String acctActionOption, String tranActionOption){
        bankList = new LinkedList<>();
        bankList.add(bankActionOption);
        acctNicksList = new LinkedList<>();
        acctNicksList.add(acctActionOption);
        transactionCategoriesList = new LinkedList<>();
        transactionCategoriesList.add(tranActionOption);
    }
    public static void setGuiRequiredData(String bankActionOption, String acctActionOption, String tranActionOption){
        if(instance == null){
            instance = new GUI_ElementsOptionLists(bankActionOption, acctActionOption, tranActionOption);
        }

    }
    public static GUI_ElementsOptionLists getInstance(){
        if(instance == null)
            throw new MissingResourceException("","","");
        return instance;
    }
    public boolean isBankExist(String bank) {
        return  isTextInList(bank, bankList);
    }


    public void addTransactionCategoriessToList(String[] transactionCategoriesArr) {
        if(transactionCategoriesArr==null || transactionCategoriesArr.length<0){
            return;
        }
        String last = transactionCategoriesList.removeLast();
        for(int i=0; i< transactionCategoriesArr.length; i++){
            transactionCategoriesList.add(transactionCategoriesArr[i]);
        }
        transactionCategoriesList.addLast(last);
    }
    public void addTransactionCategoryToList(String transactionCategory) {
        transactionCategoriesList.add(bankList.size()-1, transactionCategory);
    }
    public  void addBanksToList(String[] banks){
        if(banks==null || banks.length<0){
            return;
        }
        String last = bankList.removeLast();
        for(int i=0; i< banks.length; i++){
            bankList.add(banks[i]);
        }
        bankList.addLast(last);
    }
    public  void addBankToList(String bank){
        bankList.add(bankList.size()-1, bank);
    }
    public  void addAccntNicksToList(String[] accountNicks){
        if(accountNicks==null || accountNicks.length<0){
            return;
        }
        String last = acctNicksList.removeLast();
        for(int i=0; i< accountNicks.length; i++){
            acctNicksList.add(accountNicks[i]);
        }
        acctNicksList.addLast(last);
    }
    public void addAccntNickToList(String accountNick){
        acctNicksList.add(acctNicksList.size()-1, accountNick);
    }

    public  String[]  getTransCategoryist(){
        return getAsStringArr(transactionCategoriesList);
    }
    public   String[]  getBanksList(){
        return getAsStringArr(bankList);
    }
    public   String[]  getAccountNicksList(){
        return getAsStringArr(acctNicksList);
    }



}
