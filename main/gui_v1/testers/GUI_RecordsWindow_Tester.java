package gui_v1.testers;

import gui_v1.mainWindows.GUI_RecordsWindow;

public class GUI_RecordsWindow_Tester {
    private GUI_RecordsWindow_Tester(){
        GUI_RecordsWindow.getInstance().showRecordsWindow();
    }

    public static void main(String[] args) {
        new GUI_RecordsWindow_Tester();
    }
}
