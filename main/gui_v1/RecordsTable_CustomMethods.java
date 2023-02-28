package gui_v1;

import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.Comparator;

public class RecordsTable_CustomMethods {
    /**
     * @param m   table model of table to set custom row sorting
     * @return -- custom row sorting for specified column of tables
     * @column -- column to which apply this sorting
     *  To set custom sorting of rows by some column tablee need this satment
     *   table.setRowSorter(getCustomRowSorter(table.getModel()), culumnNum);
     *
     */
    public static TableRowSorter getCustomRowSorter(TableModel m, int column){
        var sorter = new TableRowSorter<TableModel>(m);
        sorter.setComparator(column, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                System.out.println(o1+" "+o2);
                if (Double.parseDouble(o1.substring(1)) <= Double.parseDouble(o2.substring(1))) {
                    return -1;
                } else if (Double.parseDouble(o1.substring(1)) > Double.parseDouble(o2.substring(1))) {
                    return 1;
                }
                return 0;
            }
        });
        return sorter;
    }

}
