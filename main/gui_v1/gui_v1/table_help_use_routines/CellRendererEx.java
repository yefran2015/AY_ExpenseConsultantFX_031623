package gui_v1.table_help_use_routines;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 *  This class is for make border around JTable Cells at the click on them.
 */
public class CellRendererEx extends JPanel implements TableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(hasFocus) {
            setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
        }else{
            setBorder(null);
        }
        return this;
    }
}
