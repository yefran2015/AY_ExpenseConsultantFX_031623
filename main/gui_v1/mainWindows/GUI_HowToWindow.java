package gui_v1.mainWindows;

import gui_v1.menu.GUI_Menu;
import gui_v1.menu.GUI_Menu_Technical;
import gui_v1.settings.GUI_Settings_Variables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI_HowToWindow  extends JFrame implements GUI_Settings_Variables, ActionListener {
    private static final long serialVersionUID = 1L;
    private static GUI_HowToWindow instance = null;
    private String resizeButtonText = "Auto-resize text";
    private Image img;
    private JButton jbtResize;
    private JScrollPane jSP;
    public GUI_HowToWindow() {
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setSize(howToWindowFrameSize);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        ImageIcon howToImage = new ImageIcon("HowToPoster.jpg");
        img = howToImage.getImage();
        Image imgScale = img.getScaledInstance(gui_width-20, (int) ((gui_width-20)/0.777), Image.SCALE_SMOOTH);
        ImageIcon scaledHowToImage = new ImageIcon(imgScale);
        jbtResize = new JButton(resizeButtonText);
        jbtResize.addActionListener(this);
        jSP = new JScrollPane(new JLabel("",scaledHowToImage, JLabel.CENTER));
        add(jSP);
        add(jbtResize, BorderLayout.SOUTH);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                instance.dispose();
//               GUI_RecordsWindow.showRecordsWindow();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        Dimension dim = new Dimension(getWidth(), getHeight());
        if (a.getActionCommand().compareToIgnoreCase(resizeButtonText) == 0) {
            Image imgScale = img.getScaledInstance((int) (dim.getWidth()-20),
                    (int) ((dim.getWidth()-20)/0.777), Image.SCALE_SMOOTH);
            ImageIcon scaledHowToImage = new ImageIcon(imgScale);
            hideRecordsWindow();
            remove(jSP);
            remove(jbtResize);
            setSize(dim);
            jSP = new JScrollPane(new JLabel("",scaledHowToImage, JLabel.CENTER));
            add(jSP);
            add(jbtResize, BorderLayout.SOUTH);
            showRecordsWindow();
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
    public static void hideRecordsWindow(){
        createRecordViewWindow();
        instance.setVisible(false);
    }
    @Override
    public Component getComponent() {
        return null;
    }
}
