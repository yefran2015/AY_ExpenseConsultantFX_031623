package gui_v1.testers;

import gui_v1.login.LogInWindow;

public class GUI_LogInWindow_Tester {
    GUI_LogInWindow_Tester(){
        Test1();
    }

    private void Test1() {
        LogInWindow.getInstance().showLogInWindow();
    }

    public static void main(String[] args) {
        new GUI_LogInWindow_Tester();
    }
}
