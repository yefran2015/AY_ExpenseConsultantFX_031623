package gui_v1;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.print.PrinterException;
import java.text.DecimalFormat;

/**
 * @author Andrey Y
 * @author  Pavel
 * @author Sam
 * @version 0.0.1
 * @serial 030220231659
 *
 * This class is for crating and handling Table of Transaction records shown in GUI_v1.
 */
public class RecordsTable  extends JPanel{
    private static JTable instance;
    private static int recordCount = 0;
    private static String[] columnNames = { "Date", "Ref", "Name", "Memo", "Amount", "Category"};
    private static String[][] testData = {};
    private static DefaultTableModel m;

    public RecordsTable() {
        setLayout(new BorderLayout());
        createTableWithCustomSorting();
        setVisible(true);;
    }
    /**
     *  This method is for creating table with ability to sort Amount column
     *  with String datatype and dollar sign apfront
     */
    private void createTableWithCustomSorting() {

        instance = new JTable(new DefaultTableModel(testData,columnNames));
        instance.setRowSorter(RecordsTable_CustomMethods.getInstance().getCustomRowSorterByDate(instance.getModel(), 0));
        instance.setRowSorter(RecordsTable_CustomMethods.getInstance().getCustomRowSorter(instance.getModel(), 4));

        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.RIGHT);
        instance.getColumnModel().getColumn(4).setCellRenderer(r);

        add(instance.getTableHeader(), BorderLayout.PAGE_START);
        add(new JScrollPane(instance), BorderLayout.CENTER);
        add(new RecordsNavigationButtonsP(), BorderLayout.SOUTH);
    }


    /**
     * @param ofxDate  -- Transaction date
     * @param ref -- Transaction Refference num
     * @param name -- Transaction Nick name
     * @param memo -- Transaction memo
     * @param amount -- Transaction amount
     * @param cat -- transaction Category
     *
     *  This method is for adding single transaction record as one row into Records Table View.
     *  Method accept all Transaction fields as strings.
     *  If adding transactions through this method,
     *  sorting of table rows based on amount column is performed by string sorting,
     *  and sorting result is not correct sorting of numbers.
     */
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
    private static DecimalFormat df = new DecimalFormat("$#,###,###,##0.00");

    /**
     * @param ofxDate  -- Transaction date
     * @param ref -- Transaction Refference num
     * @param name -- Transaction Nick name
     * @param memo -- Transaction memo
     * @param amount -- Transaction amount as double
     * @param cat -- Transaction Category
     *
     *  This method is for adding single transaction record as one row into Records Table View.
     *  Method accept most Transaction fields as strings
     *  with amount as Double.
     *  If adding transactions through this method,
     *  sorting of table rows based on amount column is performed by numeric sorting,
     *  and sorting result is not correct sorting of numbers.
     */
    public static void addRowToTable(String ofxDate, String ref, String name, String memo, Double amount, String cat) {
        Object[] rowItems = new Object[6];
//        String[] date = ofxDate.split("/");
//        System.out.println("-1->>>"+"L "+date.length+" 0 "+date[0]+"  1 "+ date[1] +" 2 "+date[2]);

//        if(date[0].length()==4){
//            rowItems[0] = ofxDate + "";
//        }else{
//            rowItems[0] = date[2]+"/"+date[0]+"/"+date[1];
//        }
//System.out.println("-2->>>"+rowItems[0]+"  "+ ofxDate);
        rowItems[0] = ofxDate + "";
        rowItems[1] = ref + "";
        rowItems[2] = name + "";
        rowItems[3] = memo + "";
        rowItems[4] = df.format(amount);
        rowItems[5] = cat + "";
        m = (DefaultTableModel) (instance.getModel());
        m.addRow(rowItems);

    }
    /**
     *  This method is for remove all data rows from Table.
     */
    public static void clearTable() {
        m = (DefaultTableModel) (instance.getModel());
        int recN = m.getRowCount();
        for(int i= recN-1; i>=0 ; i--){
            m.removeRow(i);
        }
    }
    /**
     * @param ofxDate  -- Transaction date
     * @param ref -- Transaction Refference num
     * @param name -- Transaction Nick name
     * @param memo -- Transaction memo
     * @param amount -- Transaction amount as double
     * @param cat -- Transaction Category
     *
     *  This method is for adding single transaction record as one row into Records Table View.
     *  Method accept most Transaction fields as strings
     *  with amount as Double.
     *  If adding transactions through this method,
     *  sorting of table rows based on amount column is performed by numeric sorting,
     *  and sorting result is not correct sorting of numbers.
     */
    public static void addRowToTable2(String ofxDate, String ref, String name, String memo, Double amount, String cat) {
        Object[] rowItems = new Object[6];
        rowItems[0] = ofxDate + "";
        rowItems[1] = ref + "";
        rowItems[2] = name + "";
        rowItems[3] = memo + "";
        rowItems[4] = df.format(amount);
        rowItems[5] = cat + "";
        m = (DefaultTableModel) (instance.getModel());
        m.addRow(rowItems);

    }
    /**
     *  This method is for printing Transactions table.
     *  Printing can be to the printer connected to local PC,
     *  or  into the pdf file.
     *
     */
    public static void printTransactionsTable(){
        try {
            instance.print();
         } catch (PrinterException e) {
            JOptionPane.showMessageDialog(null, "Unable to print.\nCheck your printer,\nand\ntry to print again.","Unable to Print", JOptionPane.WARNING_MESSAGE);

        }
    }

}