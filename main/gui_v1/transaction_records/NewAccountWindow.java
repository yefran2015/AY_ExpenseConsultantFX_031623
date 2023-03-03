package gui_v1.transaction_records;
import gui_v1.settings.GUI_Settings_Variables;


import javax.swing.*;
import java.awt.*;

public class NewAccountWindow  extends JFrame  implements GUI_Settings_Variables {

    public NewAccountWindow() {
        int width = 300;
        int height = 200;
        setTitle("New Account");
        setSize(new Dimension(width, height));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        add(new JLabel(strCopyRigts, JLabel.CENTER), BorderLayout.SOUTH);
        add(new GUI_NewAccountP(this), BorderLayout.CENTER);
        setVisible(true);
    }


    @Override
    public Component getComponent() {
        return null;
    }
}
