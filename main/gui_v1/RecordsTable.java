package gui_v1;

import entities.Transaction;
import gui_v1.automation.GUI_ElementCreator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.print.PrinterException;
import java.util.Comparator;
//import javax.swing.table.DefaultTableModel;

public class RecordsTable  extends JPanel {
    private static JTable instance;
    private static int recordCount = 0;
    private static String[] columnNames = { "Date", "Ref", "Name", "Memo", "Amount", "Category"};
    private static String[][] testData = {};
    private static DefaultTableModel m;
 
    public RecordsTable() {
        setLayout(new BorderLayout());
        createTable();
//        createTableWithCustomSorting();
    }
    /**
     *  This method is for creating table with ability to sort Amount column
     *  with String datatype and dollar sign apfront
     */
    private void createTableWithCustomSorting() {

        instance = new JTable(new DefaultTableModel(testData,columnNames));
        instance.setRowSorter(RecordsTable_CustomMethods.getCustomRowSorter(instance.getModel(), 5));

        add(instance.getTableHeader(), BorderLayout.PAGE_START);
        add(new JScrollPane(instance), BorderLayout.CENTER);
    }


    private void createTable() {
        TableModel m = new DefaultTableModel(testData, columnNames) {
            public Class getColumnClass(int column) {
                Class returnValue;
                if ((column >= 0) && (column < getColumnCount())) {
                    returnValue = getValueAt(0, column).getClass();
                } else {
                    returnValue = Object.class;
                }
                return returnValue;
            }
        };
        instance = new JTable(m);
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(m);
        instance.setRowSorter(sorter);

        add(instance.getTableHeader(), BorderLayout.PAGE_START);
        add(new JScrollPane(instance), BorderLayout.CENTER);
    }

    public static void addRowToTable(String ofxDate, String ref, String name, String memo, String amount, String cat) {
        Object[] rowItems = new Object[6];
        rowItems[0] = ofxDate + "";
        rowItems[1] = ref + "";
        rowItems[2] = name + "";
        rowItems[3] = memo + "";
        rowItems[4] = amount + "" ;
        rowItems[5] = cat + "";
        m = (DefaultTableModel) (instance.getModel());
        m.addRow(rowItems);

    }

    public static void addRowToTable(String ofxDate, String ref, String name, String memo, Double amount, String cat) {
        Object[] rowItems = new Object[6];
        rowItems[0] = ofxDate + "";
        rowItems[1] = ref + "";
        rowItems[2] = name + "";
        rowItems[3] = memo + "";
        rowItems[4] = amount ;
        rowItems[5] = cat + "";
        m = (DefaultTableModel) (instance.getModel());
        m.addRow(rowItems);

    }

    public static void printTransactionsTable(){
        try {
            instance.print();
            JOptionPane.showMessageDialog(null, "Unable to print.\nCheck your printer,\nand\ntry to print again.","Unable to Print", JOptionPane.WARNING_MESSAGE);

        } catch (PrinterException e) {
//            throw new RuntimeException(e);
            JOptionPane.showMessageDialog(null, "Unable to print.\nCheck your printer,\nand\ntry to print again.","Unable to Print", JOptionPane.WARNING_MESSAGE);

        }
    }

}