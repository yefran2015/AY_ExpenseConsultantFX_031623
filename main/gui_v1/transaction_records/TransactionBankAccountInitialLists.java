package gui_v1.transaction_records;

import main_logic.Result;
import main_logic.PEC;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 *  This class to handle all Categories Lists of GUI RUN TIme.
 */
public class TransactionBankAccountInitialLists {

    private LinkedList<String> bankList;
    private LinkedList<String> acctNicksList;
    private LinkedList<String> transactionCategoriesList;

    private static TransactionBankAccountInitialLists instance = null;
    private TransactionBankAccountInitialLists(){
        initiate();
        loadTestingData();
    }
    public static TransactionBankAccountInitialLists getInstance(){
        if(instance == null){
            instance = new TransactionBankAccountInitialLists();
        }
        return instance;
    }
    private void initiate(){
        bankList = new LinkedList<>(Collections.singletonList(PEC.NEW_BANK));
        acctNicksList = new LinkedList<>(Collections.singletonList(PEC.NEW_ACCOUNT));
        transactionCategoriesList = new LinkedList<>(Collections.singletonList(PEC.OTHER));
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

    public void addTransactionCategoriessToList(String[] transactionCategoriesArr) {
        String last = transactionCategoriesList.removeLast();
        transactionCategoriesList.addAll(Arrays.stream(transactionCategoriesArr).toList());
        transactionCategoriesList.addLast(last);
    }
    public void addTransactionCategoryToList(String transactionCategory) {
        transactionCategoriesList.add(bankList.size()-1, transactionCategory);
    }
    public  void addBanksToList(String[] banks){
        String last = bankList.removeLast();
        bankList.addAll(Arrays.stream(banks).toList());
        bankList.addLast(last);
    }
    public  void addBankToList(String bank){
        bankList.add(bankList.size()-1, bank);
    }
    public  void addAccntNicksToList(String[] accountNicks){
        System.out.println("??????????? "+accountNicks.length);
        String last = acctNicksList.removeLast();
        acctNicksList.addAll(Arrays.stream(accountNicks).toList());
        acctNicksList.addLast(last);
    }
    public void addAccntNickToList(String accountNick){
        acctNicksList.add(acctNicksList.size()-1, accountNick);
    }

    public  String[]  getTransCategoryist(){

        return getAsStringArr(transactionCategoriesList);
//        String[] out = new String[transactionCategoriesList.size()];
//        for(int i=0; i< transactionCategoriesList.size(); i++){
//            out[i] = new String(transactionCategoriesList.get(i));
//        }
//        return out;
    }
    public   String[]  getBanksList(){
        return getAsStringArr(bankList);
//        String[] out = new String[bankList.size()];
//        for(int i=0; i< bankList.size(); i++){
//            out[i] = new String(bankList.get(i));
//        }
//        return out;
    }
    public   String[]  getAccntNicksList(){
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
            out[i] = ll.get(i)+"";
        }
        return out;
    }
}
