package gui_v1.starter;

import gui_v1.login.LogInWindow;
import gui_v1.login.SignUPWindow;
import gui_v1.mainWindows.GUI_MainWindow;
import gui_v1.mainWindows.GUI_RecordsWindow;

public class Start_GUI_v1 {
    public static void main(String[] args) {
        new Start_GUI_v1();
    }
    public Start_GUI_v1(){
//        GUI_MainWindow.createMainGUIWindow();
        GUI_RecordsWindow.createRecordViewWindow();
//        new LogInWindow();
//        GUI_MainWindow.showMainWindow();
        GUI_RecordsWindow.showRecordsWindow();
        new SignUPWindow();
    }
}
