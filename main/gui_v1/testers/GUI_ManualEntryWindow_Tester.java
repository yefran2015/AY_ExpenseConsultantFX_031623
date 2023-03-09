package gui_v1.testers;

import gui_v1.mainWindows.GUI_ManualEntryWindow;

public class GUI_ManualEntryWindow_Tester {
    GUI_ManualEntryWindow_Tester(){
        GUI_ManualEntryWindow.getInstance().showManualEntryWindow();
//        GUI_ManualEntryWindow.showManualEntryWindow("", -1, "");
    }

    public static void main(String[] args) {
        new GUI_ManualEntryWindow_Tester();
    }
}
