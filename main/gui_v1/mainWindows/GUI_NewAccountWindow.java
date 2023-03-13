package gui_v1.mainWindows;
import gui_v1.settings.GUI_Settings_Variables;
import gui_v1.mainWindows.newAccountWElements.GUI_NewAccountP;


import javax.swing.*;
import java.awt.*;

public class GUI_NewAccountWindow extends JFrame  implements GUI_MainWidowsSharedBehaviors, GUI_Settings_Variables {
    private static GUI_NewAccountWindow instance=null;

    public static GUI_NewAccountWindow getInstance(){
        if(instance == null){
            instance = new GUI_NewAccountWindow();
        }
        return instance;
    }
    public void showNewAccntWindow(){

        instance.setVisible(true);
    }
    public void hideNewAccntWindow(){
        instance.setVisible(false);
    }
    public void disposeNewAccntWindow(){
       instance.dispose();
    }
    private GUI_NewAccountWindow() {
        int width = 500;
        int height = 200;
        setTitle("New Account");
        setSize(new Dimension(width, height));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        add(new JLabel(strCopyRigts, JLabel.CENTER), BorderLayout.SOUTH);
        add(new GUI_NewAccountP(), BorderLayout.CENTER);
        addWindowListener(w);


//        setVisible(true);
    }


    @Override
    public Component getComponent() {
        return null;
    }
}
