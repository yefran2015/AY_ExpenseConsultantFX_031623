package gui_v1.login;
import gui_v1.automation.GUI_ElementCreator;
import gui_v1.mainWindows.MainGUIWindow;
import gui_v1.settings.GUI_LoginSignUpWiindows_Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_LogInP extends JPanel implements GUI_LoginSignUpWiindows_Settings, ActionListener {
    private JFrame loginFrame;
    private JTextField jtfLogInName;
    private JPasswordField jtfPass;
    private  JPasswordField jtfPass2;


    public GUI_LogInP(JFrame loginFrame){
        this.loginFrame=loginFrame;
        setLayout(new BorderLayout());
//        add(new Label(strLogInHeadTitle), BorderLayout.NORTH);
        add(GUI_ElementCreator.newTitle(strLogInHeadTitle), BorderLayout.NORTH);

        JPanel inputBoxP = new JPanel();
        inputBoxP.setLayout(new GridLayout(3,2));
        jtfLogInName =  new JTextField();
        jtfLogInName.setText("Enter Log in Name");
        jtfLogInName.selectAll();
        jtfPass =  new JPasswordField();
        jtfPass.setText("Password");
        jtfPass2 =  new JPasswordField();
        jtfPass2.setText("Rpeat Password");

        JButton jbtOk = new JButton("OK");
//        jbtOk.addActionListener(new LogIN_Actons());


        jbtOk.addActionListener(this);
        inputBoxP.add(new JLabel("LogIn Name:"));

        inputBoxP.add(jtfLogInName);
        inputBoxP.add(new JLabel("Password"));
        inputBoxP.add(jtfPass);
        inputBoxP.add(new JLabel("Repeat Password:"));
        inputBoxP.add(jtfPass2);

        add(inputBoxP, BorderLayout.CENTER);
        add(jbtOk, BorderLayout.SOUTH);

    }


    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getActionCommand().compareToIgnoreCase("OK")==0) {
            String userInfo = "User Login: "+ jtfLogInName.getName() + "\nPasword: " + jtfPass.getPassword()  + "\nPassword2: "+ jtfPass2.getPassword();

            JOptionPane.showMessageDialog(null, userInfo,"Confirm", JOptionPane.INFORMATION_MESSAGE);
            loginFrame.setVisible(false);
            //new MainGUIWindow();

        }
    }
}
