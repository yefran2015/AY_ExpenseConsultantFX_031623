package gui_v1.testers;
import gui_v1.transaction_records.NewAccountWindow;

public class GUI_NewAccountWindow_Tester {
    GUI_NewAccountWindow_Tester(){
        NewAccountWindow.getInstance().showNewAccntWindow();
    }

    public static void main(String[] args) {
        new GUI_NewAccountWindow_Tester();
    }
}
