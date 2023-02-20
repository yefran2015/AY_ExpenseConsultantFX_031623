package gui_v1.login;

import gui_v1.settings.GUI_LoginSignUpWiindows_Settings;

import javax.swing.*;
import java.awt.*;


public class LogInWindow extends JFrame  implements GUI_LoginSignUpWiindows_Settings {

    public LogInWindow() {

        setTitle(strLogInWindowTitle);
        setSize(logInFFrameSize);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(new  GUI_LogInP(this), BorderLayout.CENTER);
        add(new JLabel(strCopyRigts, JLabel.CENTER), BorderLayout.SOUTH);
        setVisible(true);
    }
}
