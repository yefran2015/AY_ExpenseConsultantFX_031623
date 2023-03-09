package gui_v1.mainWindows;

import gui_v1.settings.GUI_Settings_Variables;
import gui_v1.transaction_records.GUI_ManualTransactionsEntryP;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serial;

public class GUI_ManualEntryWindow extends JFrame implements GUI_Settings_Variables {

    @Serial
    private static final long serialVersionUID = 1L;
    private static GUI_ManualEntryWindow instance = null;
    private GUI_ManualEntryWindow() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        GUI_RecordsWindow.getInstance().hideRecordsWindoww();
//        setBackground(guiFramesBackgroundColor);
//        setForeground(guiFramesForegroundColor);

        setSize(manualEntryGUIWindowFrameSize);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(new GUI_ManualTransactionsEntryP(), BorderLayout.CENTER);

        add(new JLabel(strCopyRigts, JLabel.CENTER), BorderLayout.SOUTH);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int answr = JOptionPane.showOptionDialog(null, "Do you want to close this window, and return to main?", "This window will be close.",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, JOptionPane.NO_OPTION);
                if(answr == JOptionPane.YES_OPTION){
                   instance.dispose();
                   GUI_RecordsWindow.getInstance().showRecordsWindow();
                }
            }
        });
    }
    @Override
    public Component getComponent() {
        return this;
    }
    public static GUI_ManualEntryWindow getInstance(){
        if(instance==null){
            instance = new GUI_ManualEntryWindow();
        }
        return instance;
    }
    public void showManualEntryWindow(){
//        createManualEntryWindow();
        instance.setVisible(true);
    }
    public void hideManualEntryWindow(){
//        createManualEntryWindow();
        instance.setVisible(false);
    }
    public void disposeManualEntryWindow(){
        instance.dispose();
        instance = null;
    }

}
