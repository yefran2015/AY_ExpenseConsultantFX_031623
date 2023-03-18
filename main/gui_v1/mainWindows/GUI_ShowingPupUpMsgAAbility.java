package gui_v1.mainWindows;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface GUI_ShowingPupUpMsgAAbility {


    JButton b = new JButton();
    default void showErrMessageAndAskWhaatToDo(String msg, String title, ActionListener a){
        int answr = JOptionPane.showOptionDialog(null, msg, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, JOptionPane.YES_OPTION);
        if(answr == JOptionPane.YES_OPTION){
            doAction(a);
        }
    }
    default void showConfirmationMessge(String msg, ActionListener a){
        JOptionPane.showMessageDialog(null, msg);
        doAction(a);
    }

    default void doAction(ActionListener a){
        b.addActionListener(a);
        b.doClick();
    }

}
