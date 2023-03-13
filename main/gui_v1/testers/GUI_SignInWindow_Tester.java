package gui_v1.testers;

import gui_v1.mainWindows.GUI_SignUPWindow;

public class GUI_SignInWindow_Tester {
     GUI_SignInWindow_Tester(){
        GUI_SignUPWindow.getInstance().showSignUpWindow();
    }

    public static void main(String[] args) {
        new GUI_SignInWindow_Tester();
    }
}
