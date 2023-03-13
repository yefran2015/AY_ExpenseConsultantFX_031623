package gui_v1.testers;

import gui_v1.data_loaders.GUI_ElementsDataLoader;
import gui_v1.data_loaders.GUI_ElementsOptionLists;
import gui_v1.mainWindows.GUI_ManualEntryWindow;
import gui_v1.mainWindows.GUI_RecordsWindow;

public class GUI_ManualEntryWindow_Tester {
    GUI_ManualEntryWindow_Tester(){
         GUI_ElementsDataLoader.getInstance();

        GUI_RecordsWindow.getInstance().hideRecordsWindoww();
        GUI_ManualEntryWindow.getInstance().showManualEntryWindow();
//        GUI_ManualEntryWindow.showManualEntryWindow("", -1, "");
//        GUI_RecordsWindow.getInstance().hideRecordsWindoww();
    }

    public static void main(String[] args) {
        new GUI_ManualEntryWindow_Tester();
    }
}
