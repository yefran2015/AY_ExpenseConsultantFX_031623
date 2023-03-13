package gui_v1.action_processors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordsNavigation_Actions implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent a) {
        if (a.getActionCommand().compareToIgnoreCase("First")==0) {
            System.out.println("LLLLLLLLL");
        }else if (a.getActionCommand().compareToIgnoreCase("Previous")==0) {

        }else if (a.getActionCommand().compareToIgnoreCase("Next")==0) {

        }else if (a.getActionCommand().compareToIgnoreCase("Last")==0) {

        }else if (a.getActionCommand().compareToIgnoreCase("Back")==0) {

        }
    }

}
