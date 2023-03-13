package gui_v1.testers;
import gui_v1.mainWindows.GUI_NewAccountWindow;

public class GUI_NewAccountWindow_Tester {
    GUI_NewAccountWindow_Tester(){
        GUI_NewAccountWindow.getInstance().showNewAccntWindow();
    }

    public static void main(String[] args) {
        new GUI_NewAccountWindow_Tester();
    }
}
