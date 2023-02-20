package gui_v1.login;

import gui_v1.automation.GUI_ElementCreator;
import gui_v1.mainWindows.MainGUIWindow;
import gui_v1.settings.GUI_LoginSignUpWiindows_Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_SignUpP extends JPanel implements GUI_LoginSignUpWiindows_Settings, ActionListener {
    private JFrame signUpFrame;
    private JTextField jtfName;
    private JTextField jtfLName;
    private JTextField jtfNewLogInName;
    private JTextField jtfEmail;
    private JTextField jtfEmail2;
    private JPasswordField jtfNewPass;
    private  JPasswordField jtfNewPass2;

    public GUI_SignUpP(JFrame frame) {
        this.signUpFrame = frame;
        setLayout(new BorderLayout());
        add(GUI_ElementCreator.newTitle(StrSignUpHeadTilte), BorderLayout.NORTH);



        JPanel inputBoxP = new JPanel();
        inputBoxP.setLayout(new GridLayout(8,2));

        jtfName =  new JTextField();
        jtfName.setText("Name: ");
        jtfName.selectAll();
        inputBoxP.add(new JLabel("Name: "));
        inputBoxP.add(jtfName);

        jtfLName =  new JTextField();
        jtfLName.setText("last Name: ");
        jtfLName.selectAll();
        inputBoxP.add(new JLabel("Last Name: "));
        inputBoxP.add(jtfLName);

        jtfNewLogInName =  new JTextField();
        jtfNewLogInName.setText("New LogIn Name: ");
        jtfNewLogInName.selectAll();
        inputBoxP.add(new JLabel("Choose Login Name: "));
        inputBoxP.add(jtfNewLogInName);


        jtfEmail =  new JTextField();
        jtfEmail.setText("Your Email");
        jtfEmail.selectAll();
        inputBoxP.add(new JLabel("Email:"));
        inputBoxP.add(jtfEmail);
        jtfEmail2 =  new JTextField();
        jtfEmail2.setText("Confirm Email");
        jtfEmail2.selectAll();
        inputBoxP.add(new JLabel("Confirm your Email:"));
        inputBoxP.add(jtfEmail2);



        jtfNewPass =  new JPasswordField();
        inputBoxP.add(new JLabel("Choose log in password: "));
        inputBoxP.add(jtfNewPass);
        jtfNewPass2 =  new JPasswordField();
        inputBoxP.add(new JLabel("Confirm chosen password: "));
        inputBoxP.add(jtfNewPass2);
        add(inputBoxP, BorderLayout.CENTER);


        JButton jbtOk = new JButton("OK");
        jbtOk.addActionListener(this);
        add(jbtOk, BorderLayout.SOUTH);


    }

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getActionCommand().compareToIgnoreCase("OK")==0) {
            String  userInfo = "\nUser Name: "+ jtfName.getText() + "\nLast Name: " + jtfLName.getText() ;
            userInfo+=  "\nEmail: "+ jtfEmail.getText()+"\nEmail confirm: "+ jtfEmail2.getText();
            userInfo += "\nUser Login: "+ jtfNewLogInName.getText() + "\nPasword: " + jtfNewPass.getPassword()  + "\nPassword2: "+ jtfNewPass2.getPassword();

            JOptionPane.showMessageDialog(null, userInfo,"Confirm", JOptionPane.INFORMATION_MESSAGE);
            signUpFrame.setVisible(false);
            //new MainGUIWindow();

        }
    }
}
