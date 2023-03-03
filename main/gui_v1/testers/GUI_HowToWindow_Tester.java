package gui_v1.testers;


import gui_v1.mainWindows.GUI_HowToWindow;

public class GUI_HowToWindow_Tester {
    GUI_HowToWindow_Tester(){
        Test1();
    }

    private void Test1() {
        GUI_HowToWindow.createRecordViewWindow();
        GUI_HowToWindow.showRecordsWindow();
    }

    public static void main(String[] args) {
        new GUI_HowToWindow_Tester();
    }
}
