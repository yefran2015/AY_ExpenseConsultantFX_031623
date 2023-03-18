package gui_v1.starter;

import gui_v1.data_loaders.GUI_ElementsDataLoader;
import gui_v1.mainWindows.GUI_RecordsWindow;

import java.sql.SQLException;

public class Start_GUI_v1 {
    public static void main(String[] args) {
        new Start_GUI_v1();
    }


    public Start_GUI_v1(){
        try {
            GUI_ElementsDataLoader.loadDataInitializeGUI();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


//        GUI_MainWindow.createMainGUIWindow();
//        GUI_RecordsWindow.getInstance().createRecordViewWindow();
//        new LogInWindow();
//        GUI_MainWindow.showMainWindow();
        GUI_RecordsWindow.getInstance().showRecordsWindow();
//        GUI_SignUPWindow.getInstance().showSignUpWindow();
    }
}
