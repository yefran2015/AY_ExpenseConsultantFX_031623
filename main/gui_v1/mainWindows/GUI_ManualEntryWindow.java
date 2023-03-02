package gui_v1.mainWindows;

import gui_v1.menu.GUI_Menu;
import gui_v1.menu.GUI_Menu_Technical;
import gui_v1.settings.GUI_Settings_Variables;
import gui_v1.transaction_records.GUI_ManulEntryBoxP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI_ManualEntryWindow extends JFrame implements GUI_Settings_Variables {

    private static final long serialVersionUID = 1L;
    private static GUI_ManualEntryWindow instance = null;
    private GUI_ManualEntryWindow() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        setBackground(guiFramesBackgroundColor);
        setForeground(guiFramesForegroundColor);


        setTitle(manulEntryWindowWindowTitle);
        if(gui_v1.settings.GUI_Static_Settings.workStage==1){
            setJMenuBar(new GUI_Menu());
        }else{
            setJMenuBar(new GUI_Menu_Technical());
        }
        setSize(manualEntryGUIWindowFrameSize);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        add(new GUI_ManulEntryBoxP(), BorderLayout.CENTER);

        add(new JLabel(strCopyRigts, JLabel.CENTER), BorderLayout.SOUTH);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int answr = JOptionPane.showOptionDialog(null, "Do you want to close this window, and return to main?", "This window will be close.",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, JOptionPane.NO_OPTION);
                if(answr == JOptionPane.YES_OPTION){
                   instance.dispose();
                   GUI_RecordsWindow.showRecordsWindow();

                }else{

                }
            }
        });
//		setVisible(true);
    }
    @Override
    public Component getComponent() {
        return this;
    }
    public static GUI_ManualEntryWindow createManualEntryWindow(){
        if(instance==null){
            instance = new GUI_ManualEntryWindow();
        }
        return instance;
    }
    public static void showManualEntryWindow(){
        createManualEntryWindow();
        instance.setVisible(true);
    }
    public static void hideManualEntryWindow(){
        createManualEntryWindow();
        instance.setVisible(false);
    }
}
