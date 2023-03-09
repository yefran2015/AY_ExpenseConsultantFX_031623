package gui_v1.login;

import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_LoginSignUpWiindows_Settings;
import javax.swing.*;
import java.awt.*;


public class LogInWindow extends JFrame  implements GUI_LoginSignUpWiindows_Settings {
    private static LogInWindow instance = null;
    private  LogInWindow() {

        setTitle(strLogInWindowTitle);
        setSize(logInFFrameSize);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(new  GUI_LogInP(), BorderLayout.CENTER);
        add(GUI_ElementCreator.newCopyRightsLabel(strCopyRigts), BorderLayout.SOUTH);
        setVisible(true);
    }
    public static LogInWindow getInstance(){
        if(instance==null){
            instance = new LogInWindow();
        }
        return instance;
    }
    public void showLogInWindow(){
        instance.setVisible(true);
    }
    public void hideLogInWindow(){
        instance.setVisible(false);
    }
    public void disposeLogInWindow(){
        instance.dispose();
        instance = null;
    }

}
