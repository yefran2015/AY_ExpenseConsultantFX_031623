package gui_v1.gui_logic;
import java.util.*;

public class GUI_ManualEntryTemporaialHolder {

    private static String[] manyalEntryDefaultJTextFieldText =new String[]{"Select Nick","Enter Date in Format: 02/22/2023","Enter Reference number",
            "Enter Transaction Name","Enter Memo","Enter Amount", "Select Category"};
    private static LinkedList<String[]> accounts = new LinkedList<String[]>();
    private static String[] currentTransactionOfManualEnetry;
    private static GUI_ManualEntryTemporaialHolder instance = null;
    private static int currEntryIndex;

    private GUI_ManualEntryTemporaialHolder(){
        currEntryIndex = -1;
        currentTransactionOfManualEnetry = new String[7];
    }
    private static void clearAll(){
        currentTransactionOfManualEnetry = new String[7];
        accounts.clear();
        currEntryIndex = -1;
    }

    public static GUI_ManualEntryTemporaialHolder createManualEntryProcessor(){
        if(instance == null){
            instance = new GUI_ManualEntryTemporaialHolder();
        }
        return instance;
    }

    public static void addTempUserManualEntry(String account, String date, String refN,String descr, String memo,
                                         String amount, String category){
        if(instance==null){
            createManualEntryProcessor();
        }
        String[] anotherManualEntry = new String[]{new String(account), new String(date), new String(refN),
                new String(descr), new String(memo), new String(amount), new String(category)};

        accounts.addLast(anotherManualEntry);
        currEntryIndex = accounts.size()-1;
        setCurrentByIndex(currEntryIndex);


    }
    private static void setCurrentByIndex(int currEntryIndex){
        setCurrent(accounts.get(currEntryIndex));
    }

    private static void setCurrent(String[] currEntry){
        currentTransactionOfManualEnetry =  new String[]{new String(currEntry[0]), new String(currEntry[1]), new String(currEntry[2]),
                new String(currEntry[3]), new String(currEntry[4]), new String(currEntry[5]), new String(currEntry[6])};
    }

    public static String[]  getFirst() {
        createManualEntryProcessor();
        if(accounts.size()>0){
            currEntryIndex = 0;
            setCurrentByIndex(currEntryIndex);
            return accounts.get(currEntryIndex);
        }
        return manyalEntryDefaultJTextFieldText;
    }

    public static String[] getPrev() {
        createManualEntryProcessor();
        if(accounts.size()>0){
            if(currEntryIndex==0){
                currEntryIndex = accounts.size()-1;
            }else{
                currEntryIndex--;
            }

            setCurrentByIndex(currEntryIndex);
            return accounts.get(currEntryIndex);
        }
        return manyalEntryDefaultJTextFieldText;

    }

    public static String[] getNext() {
        createManualEntryProcessor();
        if(accounts.size()>0){
            if(currEntryIndex == (accounts.size()-1)){
                currEntryIndex=0;
            }else{
                currEntryIndex++;
            }

            setCurrentByIndex(currEntryIndex);
            return accounts.get(currEntryIndex);
        }
        return manyalEntryDefaultJTextFieldText;
    }

    public static String[] getLast() {
        createManualEntryProcessor();
        if(accounts.size()>0){
            currEntryIndex = accounts.size()-1;

            setCurrentByIndex(currEntryIndex);
            return accounts.get(currEntryIndex);
        }
        return manyalEntryDefaultJTextFieldText;
    }

    public static LinkedList<String[]> getManuallYEnterredAccounts() {
        return accounts;
    }
    public static void clearTmporalManulEntrylist(){
        clearAll();
    }
}
