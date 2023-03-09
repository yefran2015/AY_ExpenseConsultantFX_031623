package gui_v1.transaction_records;

import main_logic.Result;
import main_logic.PEC;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *  This class to handle all Categories Lists of GUI RUN TIme.
 */
public class TransactionBankAccountInitialLists {

    private static LinkedList<String> bankList = new LinkedList<>(Arrays.asList(PEC.NEW_BANK));
    private static LinkedList<String> acctNicksList = new LinkedList<>(Arrays.asList(PEC.NEW_ACCOUNT));
    private static LinkedList<String> transactionCategoriesList = new LinkedList<>(Arrays.asList(PEC.OTHER));

    private static TransactionBankAccountInitialLists instance = null;
    private TransactionBankAccountInitialLists(){
        instance = this;
        loadTestingData();
    }
    public static TransactionBankAccountInitialLists getInstance(){
        if(instance == null){
            instance = new TransactionBankAccountInitialLists();
        }
        return instance;
    }

    private void loadTestingData(){
        Result res = new Result();
        res = PEC.instance().downloadDropDownMenuEntries();
        String[] bankTestingArr = res.getBankList();
        addBanksToList(bankTestingArr);
        String[] accntNicksTestingArr = res.getNickList();
        addAccntNicksToList(accntNicksTestingArr);
        String[] trnsCategoriesTestingArr = res.getCategoryList();
        addTransactionCategoriessToList(trnsCategoriesTestingArr);

    }

    protected void addTransactionCategoriessToList(String[] transactionCategoriesArr) {
        String last = transactionCategoriesList.removeLast();
        transactionCategoriesList.addAll(Arrays.stream(transactionCategoriesArr).toList());
        transactionCategoriesList.addLast(last);
    }
    protected void addTransactionCategoryToList(String transactionCategory) {
        transactionCategoriesList.add(bankList.size()-1, transactionCategory);
    }
    protected static void addBanksToList(String[] banks){
        String last = bankList.removeLast();
        bankList.addAll(Arrays.stream(banks).toList());
        bankList.addLast(last);
    }
    protected static void addBankToList(String bank){
        bankList.add(bankList.size()-1, bank);
    }
    protected static void addAccntNicksToList(String[] accountNicks){
        String last = acctNicksList.removeLast();
        acctNicksList.addAll(Arrays.stream(accountNicks).toList());
        acctNicksList.addLast(last);
    }
    protected static void addAccntNickToList(String accountNick){
        acctNicksList.add(acctNicksList.size()-1, accountNick);
    }

    protected  String[]  getTransCategoryist(){

        return getAsStringArr(transactionCategoriesList);
//        String[] out = new String[transactionCategoriesList.size()];
//        for(int i=0; i< transactionCategoriesList.size(); i++){
//            out[i] = new String(transactionCategoriesList.get(i));
//        }
//        return out;
    }
    protected  String[]  getBanksList(){
        return getAsStringArr(bankList);
//        String[] out = new String[bankList.size()];
//        for(int i=0; i< bankList.size(); i++){
//            out[i] = new String(bankList.get(i));
//        }
//        return out;
    }
    protected  String[]  getAccntNicksList(){
//        String[] out = new String[acctNicksList.size()];
//        for(int i=0; i< acctNicksList.size(); i++){
//            out[i] = new String(acctNicksList.get(i));
//        }
//        return out;
        return getAsStringArr(acctNicksList);
    }

    private String[] getAsStringArr(LinkedList<String> ll){
        String[] out = new String[ll.size()];
        for(int i=0; i< ll.size(); i++){
            out[i] = new String(ll.get(i));
        }
        return out;
    }
}
