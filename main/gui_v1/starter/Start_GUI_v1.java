package gui_v1.starter;

import gui_v1.mainWindows.GUI_SignUPWindow;
import gui_v1.mainWindows.GUI_RecordsWindow;

public class Start_GUI_v1 {
    public static void main(String[] args) {
        new Start_GUI_v1();
    }
    public Start_GUI_v1(){
//        GUI_MainWindow.createMainGUIWindow();
//        GUI_RecordsWindow.getInstance().createRecordViewWindow();
//        new LogInWindow();
//        GUI_MainWindow.showMainWindow();
        GUI_RecordsWindow.getInstance().showRecordsWindow();
//        GUI_SignUPWindow.getInstance().showSignUpWindow();
    }
}
