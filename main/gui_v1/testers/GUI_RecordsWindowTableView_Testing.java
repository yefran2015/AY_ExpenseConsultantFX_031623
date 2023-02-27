package gui_v1.testers;

import entities.Transaction;
import entities.TransactionList;
import gui_v1.RecordsTable;
//import gui_v1.mainWindows.GUI_RecordsFrame;
import parsers.OFXParser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.util.ListIterator;

import static parsers.OFXParser.instance;

public class GUI_RecordsWindowTableView_Testing {


    /*
    public static void main(String[] args)  throws IOException {
//AY_WORKING_ARCHIVE/CreditCardSAMPLE.qfx
//        parserTester();
//        parserTester2();
//        parserTester2();
//        out(GUI_FileChooser.getFileOrDirectory(new File("/ExpenseConsultantApp_AY_02192023")));
//        new GUI_RecordsFrame();
//        File f = new File("/ExpenseConsultantApp_AY_02192023");
//        out(new File("/ExpenseConsultantApp_AY_02192023"));
//        GUI_FileChooser.getFileOrDirectory(f);

//        parserTesterFINAL();
        parserTesterFinal2();
    }
    private static void parserTesterFinal2(){
        new GUI_RecordsFrame();
    }
    public static void out(Object o){
        System.out.println(o+"");

    }

    public static void parserTesterFINAL()  throws IOException {
        new GUI_RecordsFrame();
        String[] columnNames = {"DateTest1", "RefT3", "NamTe", "Memo", "Amount", "OTHER"};
        JTable table1 = RecordsTable.getRecordsTable();
//        setTableHeads(table1,columnNames);
        DefaultTableModel m = (DefaultTableModel)table1.getModel();

        m.addRow(new String[]{"ROW","ADD", "DDED", "SuCCESS", "ORRR", "MPT????"});

         TransactionList t;
//        File file = new File("/AY_WORKING_ARCHIVE/CreditCardSAMPLE.qfx");
        instance();

        File file = new File("CreditCardSAMPLE.qfx");
        t = OFXParser.ofxParser(file);
        ListIterator<Transaction> i = t.listIterator(); // t.sort(Transaction.DESCRIPTION);
        int count  = 0;
        while (i.hasNext()) {
//            System.out.println(i.next());
            addRowToTable(i.next(),m);



        }
        RecordsTable.addRowToTable(new  String[]{"DateTest1", "RefT3", "NamTe", "Memo", "Amount", "OTHER","*********"});
        System.out.println("Beginning date: " + Transaction.returnOFXFromCalendar(OFXParser.getStartDate()));
        System.out.println("Ending date: " + Transaction.returnOFXFromCalendar(OFXParser.getEndDate()));
        System.out.println("Is this a CC? " + OFXParser.isCreditCard());
        System.out.println("Currency: " + OFXParser.getCurrency());
        System.out.println("Account number: " + OFXParser.getAcctNumber());
        System.out.println("Account type: " + OFXParser.getAcctType());
    }

    public static void addRowToTable(Transaction t, DefaultTableModel m){
        String[] rowItems = new String[6];

        rowItems[0]=Transaction.returnMMslashDDFromCalendar(t.getPostedDate())+"";
        rowItems[1]=t.getRefNumber()+"";
        rowItems[2]=t.getDescription()+"";
        rowItems[3]=t.getMemo()+"";
        rowItems[4]=t.getAmount()+"";
        rowItems[5]=t.getCategoryName()+"";

        m.addRow(rowItems);

    }


//    public static void setTableHeads(JTable table, String[] names){
//        TableColumn tc = table.getColumnModel().getColumn(0);
////        tc.setHeaderValue("HHHHHH");
//        for(int i=0; i< names.length;i++){
//            tc.setHeaderValue(names[i]);
//        }
//    }
    public static void parserTester()  throws IOException {
        new GUI_RecordsFrame();
        String[] columnNames = {"DateTest1", "RefT3", "NamTe", "Memo", "Amount", "OTHER"};
        JTable table1 = RecordsTable.getRecordsTable();
//        setTableHeads(table1,columnNames);
        DefaultTableModel m = (DefaultTableModel)table1.getModel();

        m.addRow(new String[]{"ROW","ADD", "DDED", "SuCCESS", "ORRR", "MPT????"});

//        table1.adR
//        String[] columnNames = {"Date", "Ref", "Name", "Memo", "Amount", "OTHER"};
//        JTable table = new JTable();


        File f= new File("/ExpenseConsultantApp_AY_02192023");
        TransactionList t;
//        File file = new File("/AY_WORKING_ARCHIVE/CreditCardSAMPLE.qfx");
        instance();

        File file = new File("CreditCardSAMPLE.qfx");
        t = OFXParser.ofxParser(file);
        ListIterator<Transaction> i = t.listIterator(); // t.sort(Transaction.DESCRIPTION);
        int count  = 0;
        while (i.hasNext()) {
//            System.out.println(i.next()+ " -->> COUNT:--->>   "+ (count++) +" <------");
            System.out.println(i.next());

        }
        System.out.println("Beginning date: " + Transaction.returnOFXFromCalendar(OFXParser.getStartDate()));
        System.out.println("Ending date: " + Transaction.returnOFXFromCalendar(OFXParser.getEndDate()));
        System.out.println("Is this a CC? " + OFXParser.isCreditCard());
        System.out.println("Currency: " + OFXParser.getCurrency());
        System.out.println("Account number: " + OFXParser.getAcctNumber());
        System.out.println("Account type: " + OFXParser.getAcctType());
    }
    public static void parserTester2()  throws IOException {
        new GUI_RecordsFrame();
        String[] columnNames = {"DateTest1", "RefT3", "NamTe", "Memo", "Amount", "OTHER"};
        JTable table1 = RecordsTable.getRecordsTable();
//        setTableHeads(table1,columnNames);
        DefaultTableModel m = (DefaultTableModel)table1.getModel();

        m.addRow(new String[]{"ROW","ADD", "DDED", "SuCCESS", "ORRR", "MPT????"});

//        table1.adR
//        String[] columnNames = {"Date", "Ref", "Name", "Memo", "Amount", "OTHER"};
//        JTable table = new JTable();


        File f= new File("/ExpenseConsultantApp_AY_02192023");
        TransactionList t;
//        File file = new File("/AY_WORKING_ARCHIVE/CreditCardSAMPLE.qfx");
        instance();

        File file = new File("CreditCardSAMPLE.qfx");
        t = OFXParser.ofxParser(file);
        ListIterator<Transaction> i = t.listIterator(); // t.sort(Transaction.DESCRIPTION);
        int count  = 0;
        Transaction singleTrans;
        while (i.hasNext()) {
            singleTrans = i.next();
//            System.out.println(singleTrans+ " -->> COUNT:--->>   "+ (count++) +" <------");
//            printTransaction(singleTrans, count);
//            if(count>0)
            printTransaction3(singleTrans, count++);
        }
        System.out.println("Beginning date: " + Transaction.returnOFXFromCalendar(OFXParser.getStartDate()));
        System.out.println("Ending date: " + Transaction.returnOFXFromCalendar(OFXParser.getEndDate()));
        System.out.println("Is this a CC? " + OFXParser.isCreditCard());
        System.out.println("Currency: " + OFXParser.getCurrency());
        System.out.println("Account number: " + OFXParser.getAcctNumber());
        System.out.println("Account type: " + OFXParser.getAcctType());
    }


    public static void printTransaction3(Transaction t, int c){
        out(c+"<<"+Transaction.returnMMslashDDFromCalendar(t.getPostedDate())+">>");
        out(c+"<<"+t.getRefNumber()+">>");
        out(c+"<<"+t.getDescription()+">>");
        out(c+"<<"+t.getMemo()+">>");
        out(c+"<<"+t.getAmount()+">>");
        out(c+"<<"+t.getCategoryName()+">>");

    }
    public static void printTransaction(Transaction t, int c){
       out(c+"<<"+t.getPostedDate()+">>");
        Transaction.returnMMslashDDFromCalendar(t.getPostedDate());
    }
    public static void printTransactio2n(Transaction t, int c){

        out(c+"<<"+ Transaction.returnMMslashDDFromCalendar(t.getPostedDate())+">>");
//        Transaction.returnMMslashDDFromCalendar(t.getPostedDate())
    }
    /**
     * 1st. coulumn date  Transaction.returnMMslashDDFromCalendar(t.getPostedDate())
     *
     *
     *
     *
     *
     * */

}
