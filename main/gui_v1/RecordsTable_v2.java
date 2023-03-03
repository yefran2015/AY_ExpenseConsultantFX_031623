package gui_v1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
//import javax.swing.table.DefaultTableModel;

public class RecordsTable_v2 extends JPanel {
    private static JTable instance;
    private static int recordCount = 0;
    private static String[] columnNames = { "Date", "Ref", "Name", "Memo", "Amount", "Category"};
    private static String[][] testData = {};
    private static DefaultTableModel m;

    public RecordsTable_v2() {
        setLayout(new BorderLayout());
        createTable();
    }

//    private void createTable() {
//        TableModel m = new DefaultTableModel(testData, columnNames) {
//            public Class getColumnClass(int column) {
//                Class returnValue;
//                if ((column >= 0) && (column < getColumnCount())) {
//                    returnValue = getValueAt(0, column).getClass();
//                } else {
//                    returnValue = Object.class;
//                }
//                return returnValue;
//            }
//        };
//        instance = new JTable(m);
//        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(m);
//        instance.setRowSorter(sorter);
//
//
//
//
//
////        m = new DefaultTableModel(testData, columnNames);
////        instance = new JTable(m);
//
//        add(instance.getTableHeader(), BorderLayout.PAGE_START);
//        add(new JScrollPane(instance), BorderLayout.CENTER);
//    }
    private void createTable() {
//        TableModel m = new DefaultTableModel(testData, columnNames) {
//            public Class getColumnClass(int column) {
//                Class returnValue;
//                if ((column >= 0) && (column < getColumnCount())) {
//                    returnValue = getValueAt(0, column).getClass();
//                } else {
//                    returnValue = Object.class;
//                }
//                return returnValue;
//            }
//        };
        instance = new JTable(testData,columnNames);
//        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(m);
//        instance.setRowSorter(sorter);
        instance.setAutoCreateRowSorter(true);




    //        m = new DefaultTableModel(testData, columnNames);
    //        instance = new JTable(m);

        add(instance.getTableHeader(), BorderLayout.PAGE_START);
        add(new JScrollPane(instance), BorderLayout.CENTER);
    }
    public static void addRowToTable(String ofxDate, String ref, String name, String memo, String amount, String cat) {
        String[] rowItems = new String[6];
        rowItems[0] = ofxDate + "";
        rowItems[1] = ref + "";
        rowItems[2] = name + "";
        rowItems[3] = memo + "";
        rowItems[4] = amount + "";
        rowItems[5] = cat + "";
        m = (DefaultTableModel) (instance.getModel());
        m.addRow(rowItems);
    }

}