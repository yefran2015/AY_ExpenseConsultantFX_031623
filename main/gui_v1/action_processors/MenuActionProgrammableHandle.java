package gui_v1.action_processors;



import entities.Transaction;
import entities.TransactionList;
import gui_v1.RecordsTable;
import main_logic.PEC;
import main_logic.Request;
import main_logic.Result;
import parsers.OFXParser;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ListIterator;

import static parsers.OFXParser.instance;

public class MenuActionProgrammableHandle {


    void doHowToStartProcessing(){

    }

    /**
     *  this method is
     *  getting file of user choose and
     *  stronger it in File named chosenFile
     *  for future processing..
     *  Code in method is just example of use, how to get file from user, and
     *  can be used anywhere.
     */
    public  void doParsOFXFileProcessing2(){
          File f = new File("/home/");
//         GUI_FileChooser.getFileOrDirectory(f);
        File chosenFile= GUI_FileChooser.getFileOrDirectory(f);
        if(chosenFile == null ){
            JOptionPane.showMessageDialog(null, "File not Selected","Info", JOptionPane.ERROR_MESSAGE);
        } else{
            out( "OFX Chosen File for pParse is" + chosenFile.getName() );
            Request request = Request.instance();
            ListIterator<Result> it;
            request.setFileWithPath(chosenFile.getAbsolutePath());
            it = PEC.instance().parseOFX(request);
            while(it.hasNext()){
                Transaction transactionRecdord = (Transaction) it;
                System.out.println(transactionRecdord);
                RecordsTable.addRowToTable(transactionRecdord);
            }
        }
    }
    void doParsOFXFileProcessing() {
        File f = new File("/home/");
//         GUI_FileChooser.getFileOrDirectory(f);
        File chosenFile= GUI_FileChooser.getFileOrDirectory(f);
        if(chosenFile == null ){
            JOptionPane.showMessageDialog(null, "File not Selected","Info", JOptionPane.ERROR_MESSAGE);
            return;
        }
        TransactionList t;
        instance();

//        File file = new File("CreditCardSAMPLE.qfx");
        try {
            t = OFXParser.ofxParser(chosenFile);

            ListIterator<Transaction> i = t.listIterator(); // t.sort(Transaction.DESCRIPTION);
            int count  = 0;
            while (i.hasNext()) {
    //            System.out.println(i.next());
                RecordsTable.addRowToTable(i.next());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void out(Object o){
        System.out.println(o+"");

    }

    void doAdvisingProcessing(){

    }
    void doManualEntryProcessing(){

    }
    void doGenerateSummaryProcessing(){

    }
    void doSettingsProcessing(){

    }
    void dologOutProcessing(){

    }


}



//
//    void doParsOFXFileProcessing(){
//        File chosenFile= GUI_FileChooser.getFileOrDirectory();
//
//        if(chosenFile == null ){
//            JOptionPane.showMessageDialog(null, "File not Selected","Info", JOptionPane.ERROR_MESSAGE);
//        } else{
//
//            out( "OFX Chosen File for pParse is" + chosenFile.getName() );
//
//            Request request = Request.instance();
//            ListIterator<Transaction> it;
//            request.setFileWithPath(chosenFile.getAbsolutePath());
//            it = PEC.instance().parseOFX(request);
////            ListIterator<Transaction> i = t.listIterator();
//            while (it.hasNext()) {
//                RecordsTable.addRowToTable((Transaction)(it.next()));
//            }
//        }
//    }
//
//    TransactionList t;
//    //        File file = new File("/home/");
//    instance();
//
//    File file = new File("CreditCardSAMPLE.qfx");
//    t = OFXParser.ofxParser(file);
//            ListIterator<Transaction> i = t.listIterator(); // t.sort(Transaction.DESCRIPTION);
//        int count  = 0;
//        while (i.hasNext()) {
////            System.out.println(i.next());
//        addRowToTable(i.next(),m);