package gui_v1.testers;

import gui_v1.help_utils.GUI_Routines;

public class GUI_HelpRoutines_Tester implements GUI_Routines {
    public static void main(String[] args) {
        new GUI_HelpRoutines_Tester();
    }
    GUI_HelpRoutines_Tester(){
        boolean[] arr = new boolean[10];
        oLn(arr,'-');
        setAllFalse(arr);
    }

}
