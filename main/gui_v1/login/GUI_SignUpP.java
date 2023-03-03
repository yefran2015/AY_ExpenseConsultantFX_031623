package gui_v1.login;

import gui_v1.action_processors.SignupNewUserProgrammableHandler;
import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_LoginSignUpWiindows_Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_SignUpP extends JPanel implements GUI_LoginSignUpWiindows_Settings, ActionListener {
    private JFrame signUpFrame;
    private JTextField jtfSeqAnswer1;
    private JTextField jtfSeqAnswer2;
    private JTextField jtfNewLogInName;
    private JTextField jtfEmail;
    private JPasswordField jtfNewPass;
    private JPasswordField jtfNewPass2;
    private JComboBox jcmbQuestion1;
    private JComboBox jcmbQuestion2;

    public GUI_SignUpP() {
//        this.signUpFrame = frame;
        setLayout(new BorderLayout());
        add(GUI_ElementCreator.newTitle(StrSignUpHeadTilte), BorderLayout.NORTH);



        JPanel inputBoxP = new JPanel();
        inputBoxP.setLayout(new GridLayout(10,2));

        jtfEmail =  new JTextField();
        jtfEmail.setText("Your Email");
        jtfEmail.selectAll();
        inputBoxP.add(new JLabel("Email:"));
        inputBoxP.add(jtfEmail);

        jtfNewPass =  new JPasswordField();
        inputBoxP.add(new JLabel("Choose log in password: "));
        inputBoxP.add(jtfNewPass);
        jtfNewPass2 =  new JPasswordField();
        inputBoxP.add(new JLabel("Confirm chosen password: "));
        inputBoxP.add(jtfNewPass2);
        add(inputBoxP, BorderLayout.CENTER);

        jcmbQuestion1 = new JComboBox(new String[]{"Q1","Q2","Q3"});
        inputBoxP.add(new JLabel("Select Security Question 1"));
        inputBoxP.add(jcmbQuestion1);
        jtfSeqAnswer1 =  new JTextField();
        jtfSeqAnswer1.setText("Enter Answer to  Question 1");
        jtfSeqAnswer1.selectAll();
        inputBoxP.add(new JLabel("Select Answer to Security Question 1"));
        inputBoxP.add(jtfSeqAnswer1);

        jcmbQuestion2 = new JComboBox(new String[]{"Q3","Q4","Q5"});
        inputBoxP.add(new JLabel("Select Security Question 2"));
        inputBoxP.add(jcmbQuestion2);
        jtfSeqAnswer2 =  new JTextField();
        jtfSeqAnswer2.setText("Enter Answer to  Question 2");
        jtfSeqAnswer2.selectAll();
        inputBoxP.add(new JLabel("Select Answer to Security Question 2"));
        inputBoxP.add(jtfSeqAnswer2);


        JButton jbtOk = new JButton("OK");
        jbtOk.addActionListener(this);
        add(jbtOk, BorderLayout.SOUTH);


    }

    @Override
    public void actionPerformed(ActionEvent a) {

        if (a.getActionCommand().compareToIgnoreCase("OK")==0) {
             String email= jtfEmail.getText().trim();
             String pass1 = jtfNewPass.getPassword().toString().trim();
             String pass2 = jtfNewPass2.getPassword().toString().trim();;
             String question1 = jcmbQuestion1.getSelectedItem().toString().trim();
             String question2= jcmbQuestion2.getSelectedItem().toString().trim();;
             String answer1 = jtfSeqAnswer1.getText().trim();
             String answer2 = jtfSeqAnswer2.getText().trim();

            new SignupNewUserProgrammableHandler(email, pass1,pass2, question1, question2,answer1,answer2);
        }
    }
}
