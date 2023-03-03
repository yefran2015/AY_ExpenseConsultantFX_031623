package gui_v1.mainWindows;

import gui_v1.menu.GUI_Menu;
import gui_v1.menu.GUI_Menu_Technical;
import gui_v1.settings.GUI_Settings_Variables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class GUI_HowToWindow  extends JFrame implements GUI_Settings_Variables {
    private static final long serialVersionUID = 1L;
    private static GUI_HowToWindow instance = null;
    public GUI_HowToWindow() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setSize(howToWindowFrameSize);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        addMenu();
        ImageIcon howToImage = new ImageIcon("HowToPoster.jpg");


        add(new JScrollPane(new JLabel("",howToImage, JLabel.CENTER)));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                instance.dispose();
//                GUI_RecordsWindow.showRecordsWindow();
            }
        });
    }
    private void addMenu(){
        if(gui_v1.settings.GUI_Static_Settings.workStage==1){
            setJMenuBar(new GUI_Menu());
        }else{
            setJMenuBar(new GUI_Menu_Technical());
        }
    }

    public static GUI_HowToWindow createRecordViewWindow(){
        if(instance==null){
            instance = new GUI_HowToWindow();
        }
        return instance;
    }
    public static void showRecordsWindow(){
        createRecordViewWindow();
        instance.setVisible(true);
    }
    public static void hideRecordsWindoww(){
        createRecordViewWindow();
        instance.setVisible(false);
    }
    @Override
    public Component getComponent() {
        return null;
    }
}
