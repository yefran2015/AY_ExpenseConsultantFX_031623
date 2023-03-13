package gui_v1.testers;

import gui_v1.mainWindows.GUI_ManualEntryWindow;
import gui_v1.help_utils.GUI_AY_Calendar;

import java.util.Calendar;

public class GUI_Calendar_Tester {
    public GUI_Calendar_Tester(){
        GUI_AY_Calendar.getYearsDescendingArr();
        o("DAAte--> "+Calendar.getInstance().get(Calendar.YEAR));
        GUI_ManualEntryWindow.getInstance().showManualEntryWindow();
    }

    public static void main(String[] args) {
        new GUI_Calendar_Tester();
    }
    private void o(Object ob){
        System.out.println(ob+"");
    }
}
