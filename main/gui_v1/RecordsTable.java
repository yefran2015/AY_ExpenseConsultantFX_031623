package gui_v1;

import entities.Transaction;
import gui_v1.automation.GUI_ElementCreator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
//import javax.swing.table.DefaultTableModel;

public class RecordsTable  extends JPanel{
    private static JTable instance;

    private static String[] columnNames = {"Date", "Ref", "Name", "Memo", "Amount", "OTHER"};
    private static String[][] testData = {{"Rec Num", "Explain", "Bank", "Acct #", "Amount", "7777"},
            {"Rec Num", "Explain", "Bank", "Acct #", "Amount", "O777THER"},
            {"Rec Num", "Explain", "Bank", "Acct #", "Amount", "OT777HER"} ,
            {"Rec Num", "Explain", "Bank", "Acct #", "Amount", "OT77HER"},
            {"Rec Num", "Explain", "Bank", "Acct #", "Amount", "777"},
            {"Rec Num", "Explain", "Bank", "Acct #", "Amount", "OT77HER"},
            {"Rec Num", "Explain", "Bank", "Acct #", "Amount", "OT777HER"}};

//    private static final JTable jtRecordsTable = GUI_ElementCreator.newJTable(testData, columnNames);
    public static JTable createTableView(String[][] testData, String[] columnNames){
       if(instance==null){
           instance = new JTable(new DefaultTableModel(testData, columnNames));
       }
        return instance;
    }

   public static  JTable getRecordsTable(){
        if(instance==null){
            instance = new JTable(new DefaultTableModel());
        }
        return instance;
   }
   public RecordsTable(){
        setLayout(new BorderLayout());
        createTableView(testData,columnNames);
        add(RecordsTable.getRecordsTable().getTableHeader(), BorderLayout.PAGE_START);
        add(new JScrollPane(RecordsTable.getRecordsTable()), BorderLayout.CENTER);
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
    public static void addRowToTable(Transaction t){
        String[] rowItems = new String[6];

        rowItems[0]=Transaction.returnMMslashDDFromCalendar(t.getPostedDate())+"";
        rowItems[1]=t.getRefNumber()+"";
        rowItems[2]=t.getDescription()+"";
        rowItems[3]=t.getMemo()+"";
        rowItems[4]=t.getAmount()+"";
        rowItems[5]=t.getCategoryName()+"";
        DefaultTableModel m = (DefaultTableModel) (instance.getModel());
        m.addRow(rowItems);
//        System.out.println("_______________"+t);

    }
    public static void addRowToTable(String[] dateRow){
        DefaultTableModel m = (DefaultTableModel) (instance.getModel());
        m.addRow(dateRow);
    }
    public static void addRowToTable(Object[] dateRow){
        String[] rowItems = new String[dateRow.length];
        int rowSize = rowItems.length;
        for(int c = 0; c<rowItems.length; c++){
            rowItems[c]=testData[c]+"";
            if(c==rowSize) break;
        }
        DefaultTableModel m = (DefaultTableModel) (instance.getModel());
        m.addRow(rowItems);

    }

//    public static void setTableHeads(JTable table, String[] names){
//        TableColumn tc = table.getColumnModel().getColumn(0);
//        for (String name : names) {
//            tc.setHeaderValue(name);
//        }
//    }

}
//	RecordsTable.createTableView(testData,columnNames);
//            jpRecordsDisplayBoxP.add(RecordsTable.getRecordsTable().getTableHeader(), BorderLayout.PAGE_START);
//
//            jpRecordsDisplayBoxP.add(RecordsTable.getRecordsTable(), BorderLayout.CENTER);


////    private DefaultTableModel model;
//
//    public DefaultTableModel setTableColumnNames( String[] col_names){
//        DefaultTableModel model = new DefaultTableModel() {
////            String[] employee = {"emp 1", "emp 2", "EM 3"};
//
//            @Override
//            public int getColumnCount() {
//                return col_names.length;
//            }
//
//            @Override
//            public String getColumnName(int index) {
//                return col_names[index];
//            }
//        };
//        return model;
//    }
//    public RecordsTable(String[] col_names){
//      // super(setTableColumnNames(col_names));
////        m.addRow(new String[]{"",""});
//    }
//
//}
