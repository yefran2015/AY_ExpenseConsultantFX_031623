package gui_v1.gui_logic;
import gui_v1.help_utils.GUI_Routines;
import java.util.*;

public class GUI_ManualEntryTemporaialHolder implements GUI_Routines {
    private static GUI_ManualEntryTemporaialHolder instance = null;
    public enum ENTRY_PREVIW {NO_CYCLES};
    private static LinkedList<String[]> accounts;
    private static int currEntryIndex;
    private GUI_ManualEntryTemporaialHolder(){
        initiate();
    }
    private static void initiate(){
        accounts= new LinkedList<String[]>();
        currEntryIndex = 0;
    }

    public static GUI_ManualEntryTemporaialHolder getInstance() {
        if (instance == null) {
           instance = new GUI_ManualEntryTemporaialHolder();
        }
        return instance;
    }
    public int getNumOfItems(){
        return accounts.size();
    }
    public void addTempUserManualEntry(String[] currEntry){
        if(currEntry == null){
            return;
        }
        if(isThisEntryExists(currEntry)){
            return;
        }
        accounts.addLast(trimAllStr(new String[]{currEntry[0], currEntry[1], currEntry[2],
                currEntry[3], currEntry[4], currEntry[5], currEntry[6]}));
        currEntryIndex = accounts.size()-1;
//        setCurrentByIndex(currEntryIndex);
    }

    public void addTempUserManualEntry(String account, String date, String refN,String descr, String memo,
                                       String amount, String category){
        addTempUserManualEntry(crateStrArr(account,  date,  refN, descr,  memo, amount,  category));
    }

    public void clearTemporalManualEntryList(){
        initiate();
    }
    public boolean isThisEntryExists(String[] itemToCheck){
        if(accounts.size()==0){
            return false;
        }
        itemToCheck = trimAllStr(itemToCheck);
        boolean check = true;
        for(String[] singleItm: accounts){
            if(singleItm[0].compareToIgnoreCase(itemToCheck[0])==0){
                check = true;
                for(int i=0; i< singleItm.length; i++){
                    //System.out.println(singleItm[i]+" ? "+itemToCheck[i]+" --> "+ ( singleItm[i].compareToIgnoreCase(itemToCheck[i])==0));
                    if(singleItm[i].compareToIgnoreCase(itemToCheck[i])!=0){
                        check = false;
                    }
                }
                if(check){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isStrArrsIdentical(String[] sArr1, String[] sAr2){
        if(sArr1.length != sAr2.length){
            return false;
        }
        for(int i=0; i< sArr1.length; i++){
            System.out.println(sArr1[i] + " ==  "+sAr2[i]);
            if(!(sArr1[i].compareTo(sAr2[i])==0)){
                return false;
            }
        }
        return true;
    }

    public boolean isThisEntryExists(String account, String date, String refN,String descr, String memo,
                                     String amount, String category){
        return isThisEntryExists(crateStrArr(account,  date,  refN, descr,  memo, amount,  category));
    }

    private String[] crateStrArr(String account, String date, String refN, String descr, String memo,
                                 String amount, String category){
//        return new String[]{ account.trim(),  date.trim(),  refN.trim(), descr.trim(),  memo.trim(), amount.trim(),  category.trim()};

        return trimAllStr(new String[]{ account,  date,  refN, descr,  memo, amount,  category});
    }
//    private void setCurrentByIndex(int currEntryIndex){
//        setCurrent(accounts.get(currEntryIndex));
//    }

//    private  void setCurrent(String[] currEntry){
//        currEntry = trimAllStr(currEntry);
//        currItem =  new String[]{currEntry[0]+"", currEntry[1]+"", currEntry[2]+"",
//                currEntry[3]+"", currEntry[4]+"",currEntry[5]+"", currEntry[6]+""};
//    }

    public String[] getFirst() {
        if(accounts!=null && accounts.size()>0){
            currEntryIndex = 0;
//            setCurrentByIndex(currEntryIndex);
            return accounts.get(currEntryIndex);
        }
        return null;
    }
    public String[] getPrevNoCycles() {
        return getPrev(ENTRY_PREVIW.NO_CYCLES);
    }
    public String[] getNextNoCycles() {
        return getNext(ENTRY_PREVIW.NO_CYCLES);
    }
    public String[] getPrev(ENTRY_PREVIW cyclic) {
        if(accounts==null || accounts.size() == 0 ||(  cyclic==ENTRY_PREVIW.NO_CYCLES && currEntryIndex==0 )) {
            return null;
        }else{
            if(currEntryIndex==0){
                currEntryIndex = accounts.size()-1;
            }else{
                currEntryIndex--;
            }
//            setCurrentByIndex(currEntryIndex);
            return accounts.get(currEntryIndex);
        }
    }


    public String[] getNext(ENTRY_PREVIW cyclic) {
        if((accounts==null || accounts.size() == 0) || ((cyclic==ENTRY_PREVIW.NO_CYCLES) && (currEntryIndex == accounts.size() -1))) {
            return null;
        }else{
            if (currEntryIndex == (accounts.size() - 1)) {
                currEntryIndex = 0;
            } else {
                currEntryIndex++;
            }

//            setCurrentByIndex(currEntryIndex);
            return accounts.get(currEntryIndex);
        }
    }
    public String[] getLast() {
        if(accounts!=null && accounts.size()>0){
            currEntryIndex = accounts.size()-1;
//            setCurrentByIndex(currEntryIndex);
            return accounts.get(currEntryIndex);
        }
        return null;
    }

    public LinkedList<String[]> getManuallYEnterredAccounts() {
        return accounts;
    }
}

//    public String[] getPrev() {
//        createManualEntryProcessor();
//        if(accounts.size()>0){
//            if(currEntryIndex==0){
//                currEntryIndex = accounts.size()-1;
//            }else{
//                currEntryIndex--;
//            }
//
//            setCurrentByIndex(currEntryIndex);
//            return accounts.get(currEntryIndex);
//        }
//        return manualEntryDefaultJTextFieldTex;
//
//    }
//    public String[] getNext() {
//        createManualEntryProcessor();
//        if(accounts.size()>0){
//            if(currEntryIndex == (accounts.size()-1)){
//                currEntryIndex=0;
//            }else{
//                currEntryIndex++;
//            }
//
//            setCurrentByIndex(currEntryIndex);
//            return accounts.get(currEntryIndex);
//        }
//        return manualEntryDefaultJTextFieldTex;
//    }




//package gui_v1.gui_logic;
//import java.util.*;
//
//public class GUI_ManualEntryTemporaialHolder {
//    private static GUI_ManualEntryTemporaialHolder instance = null;
//
//    public static enum ENTRY_PREVIW {NO_CYCLES};
//    private static LinkedList<String[]> accounts;
//    private static String[] currentTransactionOfManualEnetry;
//    private static int currEntryIndex;
//
//    private GUI_ManualEntryTemporaialHolder(){
//        initiate();
//    }
//    private static void initiate(){
//        currentTransactionOfManualEnetry = new String[7];
//        accounts= new LinkedList<String[]>();
//        currEntryIndex = 0;
//    }
//    public static GUI_ManualEntryTemporaialHolder getInstance(){
//        if(instance == null){
//            instance = new GUI_ManualEntryTemporaialHolder();
//        }
//        return  instance;
//    }
//
//    public void addTempUserManualEntry(String[] currEntry){
//        if(currEntry == null){
//            return;
//        }
//        if(isThisEntryExists(currEntry)){
//            return;
//        }
//        accounts.addLast(trimAllStr(new String[]{currEntry[0], currEntry[1], currEntry[2],
//                currEntry[3], currEntry[4], currEntry[5], currEntry[6]}));
//        currEntryIndex = accounts.size()-1;
//        setCurrentByIndex(currEntryIndex);
//    }
//
//    public void addTempUserManualEntry(String account, String date, String refN,String descr, String memo,
//                                       String amount, String category){
//        addTempUserManualEntry(crateStrArr(account,  date,  refN, descr,  memo, amount,  category));
//    }
//
//    public void clearTemporalManualEntrylist(){
//        initiate();
//    }
//
//    public boolean isThisEntryExists(String[] itemToCheck){
//        if(accounts.size()==0){
//            return false;
//        }
//        itemToCheck = trimAllStr(itemToCheck);
//        boolean check = true;
//        for(String[] singleItm: accounts){
//            if(singleItm[0].compareToIgnoreCase(itemToCheck[0])==0){
//                check = true;
//                for(int i=0; i< singleItm.length; i++){
//                    //System.out.println(singleItm[i]+" ? "+itemToCheck[i]+" --> "+ ( singleItm[i].compareToIgnoreCase(itemToCheck[i])==0));
//                    if(singleItm[i].compareToIgnoreCase(itemToCheck[i])!=0){
//                        check = false;
//                    }
//                }
//                if(!check){return true;};
//            }
//        }
//        return false;
//    }
//
//    public boolean isThisEntryExists(String account, String date, String refN,String descr, String memo,
//                                     String amount, String category){
//        return isThisEntryExists(crateStrArr(account,  date,  refN, descr,  memo, amount,  category));
//    }
//
//    private String[] crateStrArr(String account, String date, String refN, String descr, String memo,
//                                 String amount, String category){
//        return trimAllStr(new String[]{ account,  date,  refN, descr,  memo, amount,  category});
//    }
//    public String  trimStr(String s){
//        return s.trim();
//
//    }
//    public String[] trimAllStr(String[] sArr){
//        if(sArr == null){
//            return null;
//        }
//        String[]  clearArr = new String[sArr.length];
//        for(int i=0; i< sArr.length; i++ ){
//            clearArr[i]= trimStr(sArr[i])+"";
//        }
//        return  clearArr;
//    }
//    private void setCurrentByIndex(int currEntryIndex){
//        setCurrent(accounts.get(currEntryIndex));
//    }
//    private  void setCurrent(String[] currEntry){
//        currEntry = trimAllStr(currEntry);
//        currentTransactionOfManualEnetry =  new String[]{currEntry[0]+"", currEntry[1]+"", currEntry[2]+"",
//                currEntry[3]+"", currEntry[4]+"",currEntry[5]+"", currEntry[6]+""};
//    }
//    public String[] getCurrent() {
//        return accounts.get(currEntryIndex);
//    }
//    public String[]  getFirst() {
//        if(accounts.size()>0){
//            currEntryIndex = 0;
//            setCurrentByIndex(currEntryIndex);
//            return accounts.get(currEntryIndex);
//        }
//        return null;
//    }
//    public String[] getPrevNoCycles() {
//        if(accounts.size()>0 && currEntryIndex>0){
//            currEntryIndex--;
//            setCurrentByIndex(currEntryIndex);
//            return accounts.get(currEntryIndex);
//        }
//        return null;
//    }
//    public String[] getPrev(ENTRY_PREVIW cycled) {
//
//        if(cycled  == ENTRY_PREVIW.NO_CYCLES){
//            if(currEntryIndex>0){
//                currEntryIndex--;
//            }
//        }else{
//            if(currEntryIndex==0){
//                currEntryIndex = accounts.size()-1;
//            }else{
//                currEntryIndex--;
//            }
//        }
//        if(accounts.size()==0){
//            return null;
//        }
//        setCurrentByIndex(currEntryIndex);
//        return accounts.get(currEntryIndex);
//    }
//    public String[] getNextNoCycles() {
//        if(accounts.size()>0 && currEntryIndex < accounts.size()-1){
//            currEntryIndex++;
//            setCurrentByIndex(currEntryIndex);
//            return accounts.get(currEntryIndex);
//        }
//        return  null;
//    }
//
//    public String[] getNext(ENTRY_PREVIW cycled) {
//
//        if(cycled  == ENTRY_PREVIW.NO_CYCLES){
//            if( currEntryIndex < accounts.size()-1){
//                currEntryIndex++;
//            }
//        }else{
//            if(currEntryIndex == (accounts.size()-1)){
//                currEntryIndex=0;
//            }else{
//                currEntryIndex++;
//            }
//        }
//        if(accounts.size()==0){
//            return null;
//        }
//        setCurrentByIndex(currEntryIndex);
//        return accounts.get(currEntryIndex);
//    }
//
//    public String[] getLast() {
//        if(accounts.size()>0){
//            currEntryIndex = accounts.size()-1;
//
//            setCurrentByIndex(currEntryIndex);
//            return accounts.get(currEntryIndex);
//        }
//        return  null;
//    }
//
//    public boolean isIdenticalWithCurrent(String[] dataToCheck) {
//        if(accounts.size()<=0 || currEntryIndex>0){
//            return false;
//        }
//        return isStrArrsIdentical(getCurrent(), dataToCheck);
//    }
//    public boolean isStrArrsIdentical(String[] sArr1, String[] sAr2){
//        if(sArr1.length != sAr2.length){
//            return false;
//        }
//        for(int i=0; i< sArr1.length; i++){
//            System.out.println(sArr1[i] + " ==  "+sAr2[i]);
//            if(!(sArr1[i].compareTo(sAr2[i])==0)){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public LinkedList<String[]> getManuallYEnterredAccounts() {
//        return accounts;
//    }
//
//}
//
////    public String[] getNext() {
//////        createManualEntryProcessor();
////        if(accounts.size()>0){
////            if(currEntryIndex == (accounts.size()-1)){
////                currEntryIndex=0;
////            }else{
////                currEntryIndex++;
////            }
////
////            setCurrentByIndex(currEntryIndex);
////            return accounts.get(currEntryIndex);
////        }
//////        return manualEntryDefaultJTextFieldText;
////        return  null;
////    }
//
////    public String[] getPrev() {
//////        createManualEntryProcessor();
////        if(accounts.size()>0){
////            if(currEntryIndex==0){
////                currEntryIndex = accounts.size()-1;
////            }else{
////                currEntryIndex--;
////            }
////
////            setCurrentByIndex(currEntryIndex);
////            return accounts.get(currEntryIndex);
////        }
//////        return manualEntryDefaultJTextFieldText;
////        return  null;
////
////    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////package gui_v1.gui_logic;
////import entities.Transaction;
////
////import java.util.*;
////
////public class GUI_ManualEntryTemporaialHolder {
////    private static GUI_ManualEntryTemporaialHolder instance = null;
////
//////    private static String[] manyalEntryDefaultJTextFieldText = new String[]{"Select Account",
//////            Transaction.returnYYYYMMDDFromCalendar(Calendar.getInstance()),
//////            "Enter Reference number", "Enter Transaction Name", "Enter Memo", "Enter Amount", "Select Category"};
////    private static LinkedList<String[]> accounts;
////    private static String[] currentTransactionOfManualEnetry;
////    private static int currEntryIndex;
////
////    private GUI_ManualEntryTemporaialHolder(){
////        initiate();
////    }
////    private static void initiate(){
////        currentTransactionOfManualEnetry = new String[7];
////        accounts= new LinkedList<String[]>();
////        currEntryIndex = 0;
////    }
////
////    private static void createManualEntryProcessor(){
////        if(instance == null){
////            instance = new GUI_ManualEntryTemporaialHolder();
////        }
////    }
////    public static GUI_ManualEntryTemporaialHolder getInstance(){
////        if(instance == null){
////            createManualEntryProcessor();
////        }
////        return  instance;
////    }
////
////    public void addTempUserManualEntry(String[] currEntry){
//////        if(instance==null){
//////            createManualEntryProcessor();
//////        }
////        if(currEntry == null){
////            return;
////        }
////        if(isThisEntryExists(currEntry)){
////            return;
////        }
////        accounts.addLast(trimAllStr(new String[]{currEntry[0], currEntry[1], currEntry[2],
////                currEntry[3], currEntry[4], currEntry[5], currEntry[6]}));
////        currEntryIndex = accounts.size()-1;
////        setCurrentByIndex(currEntryIndex);
////    }
////
////    public void addTempUserManualEntry(String account, String date, String refN,String descr, String memo,
////                                         String amount, String category){
////        addTempUserManualEntry(crateStrArr(account,  date,  refN, descr,  memo, amount,  category));
////    }
////
////    public void clearTemporalManualEntrylist(){
////        initiate();
////    }
////
////    public boolean isThisEntryExists(String[] itemToCheck){
////        itemToCheck = trimAllStr(itemToCheck);
////        for(String[] singleItm: accounts){
////            if(singleItm[0].compareToIgnoreCase(itemToCheck[0])==0){
////                for(int i=0; i< singleItm.length; i++){
////                    if(singleItm[i].compareToIgnoreCase(itemToCheck[0])!=0){
////                        return true;
////                    }
////                }
////            }
////        }
////        return false;
////    }
////
////    public boolean isThisEntryExists(String account, String date, String refN,String descr, String memo,
////                                             String amount, String category){
////        return isThisEntryExists(crateStrArr(account,  date,  refN, descr,  memo, amount,  category));
////    }
////
////    private String[] crateStrArr(String account, String date, String refN, String descr, String memo,
////                                        String amount, String category){
//////        return new String[]{ account.trim(),  date.trim(),  refN.trim(), descr.trim(),  memo.trim(), amount.trim(),  category.trim()};
////
////        return trimAllStr(new String[]{ account,  date,  refN, descr,  memo, amount,  category});
////    }
////
////    public String  trimStr(String s){
////        return s.trim();
////
////    }
////    public String[] trimAllStr(String[] sArr){
////        if(sArr == null){
////            return null;
////        }
////        String[]  clearArr = new String[sArr.length];
////        for(int i=0; i< sArr.length; i++ ){
////            clearArr[i]= trimStr(sArr[i])+"";
////        }
////
////        return  clearArr;
////    }
////
////    private void setCurrentByIndex(int currEntryIndex){
////        setCurrent(accounts.get(currEntryIndex));
////    }
////
////    private  void setCurrent(String[] currEntry){
////        currEntry = trimAllStr(currEntry);
////        currentTransactionOfManualEnetry =  new String[]{currEntry[0]+"", currEntry[1]+"", currEntry[2]+"",
////                currEntry[3]+"", currEntry[4]+"",currEntry[5]+"", currEntry[6]+""};
////    }
////
////    public String[]  getFirst() {
////        createManualEntryProcessor();
////        if(accounts.size()>0){
////            currEntryIndex = 0;
////            setCurrentByIndex(currEntryIndex);
////            return accounts.get(currEntryIndex);
////        }
////        return manyalEntryDefaultJTextFieldText;
////    }
////
////    public String[] getPrev() {
////        createManualEntryProcessor();
////        if(accounts.size()>0){
////            if(currEntryIndex==0){
////                currEntryIndex = accounts.size()-1;
////            }else{
////                currEntryIndex--;
////            }
////
////            setCurrentByIndex(currEntryIndex);
////            return accounts.get(currEntryIndex);
////        }
////        return manyalEntryDefaultJTextFieldText;
////
////    }
////
////    public String[] getNext() {
////        createManualEntryProcessor();
////        if(accounts.size()>0){
////            if(currEntryIndex == (accounts.size()-1)){
////                currEntryIndex=0;
////            }else{
////                currEntryIndex++;
////            }
////
////            setCurrentByIndex(currEntryIndex);
////            return accounts.get(currEntryIndex);
////        }
////        return manyalEntryDefaultJTextFieldText;
////    }
////
////    public String[] getLast() {
////        createManualEntryProcessor();
////        if(accounts.size()>0){
////            currEntryIndex = accounts.size()-1;
////
////            setCurrentByIndex(currEntryIndex);
////            return accounts.get(currEntryIndex);
////        }
////        return manyalEntryDefaultJTextFieldText;
////    }
////
////    public LinkedList<String[]> getManuallYEnterredAccounts() {
////        return accounts;
////    }
////
////}
