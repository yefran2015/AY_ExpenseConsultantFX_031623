package testers;

import javafx.application.Application;

public class TestingGUIFX {
    public static void main(String[] args) {
        new TestingGUIFX(3);
//        new TestingGUIFX(2);

    }
    TestingGUIFX(int i){
        switch(i){
            case 1:
                test1();
                break;
            case 2:
                test2();
                break;
            case 3:
                tes3();
                break;
        }
    }

    private void test1(){
        new guiFX.mainWindows.MainGUIWindow();
    }
    private void test2(){
        guiFX.mainWindows.MainGUIWindow.launch();
    }
    private void tes3(){
        Application app = new guiFX.mainWindows.MainGUIWindow();
//        app.launch();
    }

}
