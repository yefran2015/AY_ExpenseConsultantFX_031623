package gui_v1.data_loaders;
import main_logic.PEC;
import java.util.Collections;
import java.util.LinkedList;

/**
 *  This class to handle all Categories Lists of GUI RUN TIme.
 */
public class GUI_ElementsOptionLists {

    private LinkedList<String> bankList;
    private LinkedList<String> acctNicksList;
    private LinkedList<String> transactionCategoriesList;

    private static GUI_ElementsOptionLists instance = null;

    private void initiate(){
        bankList = new LinkedList<>(Collections.singletonList(PEC.NEW_BANK));
        acctNicksList = new LinkedList<>(Collections.singletonList(PEC.NEW_ACCOUNT));
        transactionCategoriesList = new LinkedList<>(Collections.singletonList(PEC.OTHER));
    }

    private GUI_ElementsOptionLists(){
        initiate();
        loadTestingData();
        addBanksToList(GUI_ElementsDataLoader.getBanks().availableBanks());
        addAccntNicksToList(GUI_ElementsDataLoader.getAcctNicks().availableNicks());
        addTransactionCategoriessToList(GUI_ElementsDataLoader.getTranCategory().availableCategories());;
    }
    public static GUI_ElementsOptionLists getInstance(){
        if(instance == null){
            instance = new GUI_ElementsOptionLists();
        }
        return instance;
    }

    private void loadTestingData(){

    }
    public boolean isBankInList(String bank) {
        for(String existBank: bankList){
            if(bank.compareToIgnoreCase(existBank)==0){
                return true;
            }
        }

        return false;
    }
    public void addTransactionCategoriessToList(String[] transactionCategoriesArr) {
        if(transactionCategoriesArr==null || transactionCategoriesArr.length<0){
            return;
        }
        String last = transactionCategoriesList.removeLast();
//        transactionCategoriesList.addAll(Arrays.stream(transactionCategoriesArr).toList());
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
//        acctNicksList.addAll(Arrays.stream(accountNicks).toList());
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

    private String[] getAsStringArr(LinkedList<String> ll){
        String[] out = new String[ll.size()];
        for(int i=0; i< ll.size(); i++){
            out[i] = ll.get(i)+"";
        }
        return out;
    }


}
