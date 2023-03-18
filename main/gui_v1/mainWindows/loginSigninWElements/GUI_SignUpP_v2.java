package gui_v1.mainWindows.loginSigninWElements;

import gui_v1.action_processors.SignupNewUserProgrammableHandler;
import gui_v1.automation.GUI_ElementCreator;
import gui_v1.mainWindows.GUI_MainWindow;
import gui_v1.settings.GUI_LoginSignUpWiindows_Settings;
import main_logic.PEC;
import main_logic.Request;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class GUI_SignUpP_v2 extends JPanel implements GUI_LoginSignUpWiindows_Settings, ActionListener {
    private JFrame signUpFrame;
    private JTextField jtfSeqAnswer1;
    private JTextField jtfSeqAnswer2;
    private JTextField jtfNewLogInName;
    private JTextField jtfEmail;
    private JPasswordField jtfNewPass;
    private JPasswordField jtfNewPass2;
    private JComboBox jcmbQuestion1;
    private JComboBox jcmbQuestion2;

    public GUI_SignUpP_v2() {
//        this.signUpFrame = frame;
        setLayout(new BorderLayout());
        add(GUI_ElementCreator.newTitle(StrSignUpHeadTilte), BorderLayout.NORTH);


        JPanel inputBoxP = new JPanel();
        inputBoxP.setLayout(new GridLayout(10, 2));

        jtfEmail = GUI_ElementCreator.newTextField("Your Email");
//        jtfEmail.setText("Your Email");
        jtfEmail.selectAll();
        inputBoxP.add(GUI_ElementCreator.newTextLabel("Email:"));
        inputBoxP.add(jtfEmail);

        jtfNewPass = new JPasswordField();
        inputBoxP.add(GUI_ElementCreator.newTextLabel("Choose login password: "));
        inputBoxP.add(jtfNewPass);
        jtfNewPass2 = new JPasswordField();
        inputBoxP.add(GUI_ElementCreator.newTextLabel("Confirm chosen password: "));
        inputBoxP.add(jtfNewPass2);
        add(inputBoxP, BorderLayout.CENTER);

        jcmbQuestion1 = GUI_ElementCreator.newJComboBox(new String[]{"What's your pet's name?", "Which city were you born in?", "What's your favorite car?"});
        inputBoxP.add(GUI_ElementCreator.newTextLabel("Select Security Question 1"));
        inputBoxP.add(jcmbQuestion1);
        jtfSeqAnswer1 = GUI_ElementCreator.newTextField("Enter Answer to  Question 1");
        jtfSeqAnswer1.selectAll();
        inputBoxP.add(GUI_ElementCreator.newTextLabel("Select Answer to Security Question 1"));
        inputBoxP.add(jtfSeqAnswer1);

        jcmbQuestion2 = GUI_ElementCreator.newJComboBox(new String[]{"What's your pet's name?", "Which city were you born in?", "What's your favorite car?"});
        inputBoxP.add(GUI_ElementCreator.newTextLabel("Select Security Question 2"));
        inputBoxP.add(jcmbQuestion2);
        jtfSeqAnswer2 = GUI_ElementCreator.newTextField("Enter Answer to  Question 2");
        jtfSeqAnswer2.selectAll();
        inputBoxP.add(GUI_ElementCreator.newTextLabel("Select Answer to Security Question 2"));
        inputBoxP.add(jtfSeqAnswer2);


        JButton jbtOk = GUI_ElementCreator.newJButton("OK");
        jbtOk.addActionListener(this);
        add(jbtOk, BorderLayout.SOUTH);


    }

    @Override
    public void actionPerformed(ActionEvent a) {


        if (a.getActionCommand().compareToIgnoreCase("OK") == 0) {
            int code = 0;
            Request r = Request.instance();
            r.setEmail(jtfEmail.getText().trim());
            //System.out.println(jtfNewPass.getText());
            r.setPass1(String.valueOf(jtfNewPass.getText()));
            r.setPass2(String.valueOf(jtfNewPass2.getText()));
            r.setQuestion1(jcmbQuestion1.getSelectedItem().toString().trim());
            r.setQuestion2(jcmbQuestion2.getSelectedItem().toString().trim());
            r.setAnswer1(jtfSeqAnswer1.getText().trim());
            r.setAnswer2(jtfSeqAnswer2.getText().trim());
            try {
                code = PEC.instance().signup(r);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (code==5) {
                GUI_MainWindow.getInstance().showMainWindow();
            } else {
                JOptionPane.showMessageDialog(null, "Error!");
            }
        }
    }
}


