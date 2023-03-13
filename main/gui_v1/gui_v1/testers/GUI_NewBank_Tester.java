package gui_v1.testers;

import gui_v1.mainWindows.GUI_NewBankWindow;

public class GUI_NewBank_Tester {
    public static void main(String[] args) {
        new GUI_NewBank_Tester();
    }
   private  GUI_NewBank_Tester(){
        test1();
        test2();
   }

    private void test2() {
        GUI_NewBankWindow.getInstance().showNewBankWindow();
    }

    private void test1() {
    }
}
