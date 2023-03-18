package gui_v1.testers;

import gui_v1.mainWindows.GUI_SignUPWindow;

public class GUI_SignUpWindow_Tester {
     GUI_SignUpWindow_Tester(){
        GUI_SignUPWindow.getInstance().showSignUpWindow();
    }

    public static void main(String[] args) {
        new GUI_SignUpWindow_Tester();
    }
}
