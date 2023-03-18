package gui_v1.testers;

import gui_v1.data_loaders.GUI_ElementsDataLoader;
import gui_v1.mainWindows.GUI_ManualEntryWindow;
import gui_v1.mainWindows.GUI_RecordsWindow;

import java.sql.SQLException;

public class GUI_ManualEntryWindow_Tester {
    GUI_ManualEntryWindow_Tester(){
        try {
            GUI_ElementsDataLoader.loadDataInitializeGUI();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        GUI_RecordsWindow.getInstance().hideRecordsWindoww();
        GUI_ManualEntryWindow.getInstance().showManualEntryWindow();
//        GUI_ManualEntryWindow.showManualEntryWindow("", -1, "");
//        GUI_RecordsWindow.getInstance().hideRecordsWindoww();
    }

    public static void main(String[] args) {
        new GUI_ManualEntryWindow_Tester();
    }
}
