package gui_v1.login;

import gui_v1.settings.GUI_LoginSignUpWiindows_Settings;

import javax.swing.*;
import java.awt.*;

public class SignUPWindow  extends JFrame implements GUI_LoginSignUpWiindows_Settings {

    public SignUPWindow(){
        setTitle(strSignUpWindowTitle);
        setSize(signUpWindowSize);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
//        add(new  GUI_SignUpP(), BorderLayout.CENTER);
        add(new  GUI_SignUpP_v2(), BorderLayout.CENTER);
        add(new JLabel(strCopyRigts, JLabel.CENTER), BorderLayout.SOUTH);
        setVisible(true);
    }

}
