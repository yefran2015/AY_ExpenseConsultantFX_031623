package gui_v1.testers;

import gui_v1.gui_logic.GUI_ManualEntryTemporaialHolder;
import gui_v1.help_utils.GUI_Routines;

public class GUI_ManualEntryTemporarialHolder_Tester implements GUI_Routines {
    public static void main(String[] args) {
        new GUI_ManualEntryTemporarialHolder_Tester();
    }

    private GUI_ManualEntryTemporarialHolder_Tester(){
//        test1();
//        test();
        test4();
//        test2();
    }
    private void test4(){
        String[] sArr = {"A","B","C","D","E","F","G"};
        String[] sArr2 = {"    A","B     ","  C  ","     D      ","   E   ","  F","G"};
        String[] sArr3 = {"    A","Bra     ","  C  ","     Ddf%^(@$^U*     ","   E   ","  F","G"};
        String[] sArr4 = {"A","Bra ","C","Ddf%^(@$^U* "," E "," F","G"};
        o("-->"+isStrArrsIdentical(sArr4,sArr3));
        o("-->"+isStrArrsIdentical(trimAllStr(sArr4),trimAllStr(sArr3)));
        GUI_ManualEntryTemporaialHolder.getInstance().addTempUserManualEntry(sArr);

        GUI_ManualEntryTemporaialHolder.getInstance().addTempUserManualEntry(sArr);

        GUI_ManualEntryTemporaialHolder.getInstance().addTempUserManualEntry(sArr);

        GUI_ManualEntryTemporaialHolder.getInstance().addTempUserManualEntry(sArr);

        o(GUI_ManualEntryTemporaialHolder.getInstance().getManuallYEnterredAccounts().size());

        o(GUI_ManualEntryTemporaialHolder.getInstance().isThisEntryExists(sArr));
        o(GUI_ManualEntryTemporaialHolder.getInstance().isThisEntryExists(sArr2));
        o(GUI_ManualEntryTemporaialHolder.getInstance().isThisEntryExists(sArr3));
        GUI_ManualEntryTemporaialHolder.getInstance().addTempUserManualEntry(sArr2);
        o(GUI_ManualEntryTemporaialHolder.getInstance().getManuallYEnterredAccounts().size());
    }
    private void test3(){
        String s1 = "  mmmmmm  ";
        GUI_ManualEntryTemporaialHolder.getInstance().trimStr(s1);
        o(s1);
        o(GUI_ManualEntryTemporaialHolder.getInstance().trimStr(s1));
        String[] sArr = {"A","B","C","D","E","F","G"};
        o(sArr);
        GUI_ManualEntryTemporaialHolder.getInstance().addTempUserManualEntry(sArr);

        o(GUI_ManualEntryTemporaialHolder.getInstance().getManuallYEnterredAccounts().size());
        o( GUI_ManualEntryTemporaialHolder.getInstance().isThisEntryExists(sArr));
//        o(GUI_ManualEntryTemporaialHolder.getManuallYEnterredAccounts().size());
//        o(sArr);
//        GUI_ManualEntryTemporaialHolder.addTempUserManualEntry(sArr);
//        o("_______________________________________________");
//        o(GUI_ManualEntryTemporaialHolder.getManuallYEnterredAccounts().get(0));
//        o("_______________________________________________");
//        o(GUI_ManualEntryTemporaialHolder.getManuallYEnterredAccounts().get(1));

    }
    private void test2(){
        String s1 = "  mmmmmm  ";
        GUI_ManualEntryTemporaialHolder.getInstance().trimStr(s1);
        o(s1);
        o(GUI_ManualEntryTemporaialHolder.getInstance().trimStr(s1));
        String[] sArr = {" AAAA  ","        BBBBBB","CCCCCCCCCC       ","DDDDD", "       EEEEEEEEEEE    ", "FFFFFFFFFFF", "GGGG  GGGG"};
        o(sArr);
//        o(GUI_ManualEntryTemporaialHolder.trimAllStr(sArr));
//        o(GUI_ManualEntryTemporaialHolder.getManuallYEnterredAccounts().size());
        GUI_ManualEntryTemporaialHolder.getInstance().addTempUserManualEntry(sArr);

        o(GUI_ManualEntryTemporaialHolder.getInstance().getManuallYEnterredAccounts().size());
        GUI_ManualEntryTemporaialHolder.getInstance().addTempUserManualEntry( GUI_ManualEntryTemporaialHolder.getInstance().trimAllStr(sArr));
        o(GUI_ManualEntryTemporaialHolder.getInstance().getManuallYEnterredAccounts().size());
        o(sArr);


    }
    private void test1(){
        String s1 = "  mmmmmm  ";
        GUI_ManualEntryTemporaialHolder.getInstance().trimStr(s1);
        o(s1);
        o(GUI_ManualEntryTemporaialHolder.getInstance().trimStr(s1));
        String[] sArr = {" AAAA  ","        BBBBBB","CCCCCCCCCC       ","DDDDD", "       EEEEEEEEEEE    "};
        o(sArr);
        o(GUI_ManualEntryTemporaialHolder.getInstance().trimAllStr(sArr));
    }

//    private void o(Object[] ob){
//        for(Object o: ob){
//            o(o);
//        }
//    }
//
//    private void o(Object ob){
//        System.out.println("---->"+ob+"<----");
//    }

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
}
