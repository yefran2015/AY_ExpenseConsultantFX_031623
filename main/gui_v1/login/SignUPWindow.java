package gui_v1.login;

import gui_v1.mainWindows.GUI_ManualEntryWindow;
import gui_v1.settings.GUI_LoginSignUpWiindows_Settings;

import javax.swing.*;
import java.awt.*;

public class SignUPWindow  extends JFrame implements GUI_LoginSignUpWiindows_Settings {
    private static SignUPWindow instance=null;

    private SignUPWindow(){
        setTitle(strSignUpWindowTitle);
        setSize(signUpWindowSize);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
//        add(new  GUI_SignUpP(), BorderLayout.CENTER);
        add(new  GUI_SignUpP_v2(), BorderLayout.CENTER);
        add(new JLabel(strCopyRigts, JLabel.CENTER), BorderLayout.SOUTH);
    }
    public static SignUPWindow getInstance(){
        if(instance==null){
            instance = new SignUPWindow();
        }
        return instance;
    }
    public void showSignUpWindow(){
        instance.setVisible(true);
    }
    public void hideSignUpWindow(){
        instance.setVisible(false);
    }
    public void disposeSignUpWindow(){
        instance.dispose();
        instance = null;
    }
}
