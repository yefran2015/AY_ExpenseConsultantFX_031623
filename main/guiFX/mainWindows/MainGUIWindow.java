package guiFX.mainWindows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import guiFX.menu.FXMenu;
import guiFX.settings.GUI_Settings_Variables;

import java.io.IOException;

public class MainGUIWindow extends Application implements GUI_Settings_Variables {
    private Stage mainGuiStage;
    //This is the BorderPane of RootLayout
    private BorderPane mainBox;

      public static void main(String[] args) {

        Application.launch();
//        URL location = getClass().getResource("example.fxml");
//        ResourceBundle resources = ResourceBundle.getBundle("com.foo.example");
//        FXMLLoader fxmlLoader = new FXMLLoader(location, resources);
//
//        Pane root = (Pane)fxmlLoader.load();
//        MyController controller = (MyController)fxmlLoader.getController();
    }
    @Override
    public void start(Stage stage) throws IOException {
     //  runGUIFX(stage);
       runOldGUI();

    }

    private void runGUIFX(Stage stage){
        this.mainGuiStage = stage;
        stage.setTitle(GUI_Settings_Variables.strDefaultString);

        FXMLLoader fxmlLoader = new FXMLLoader(MainGUIWindow.class.getResource("guiFX.fxml"));
        // mainBox = (BorderPane) fxmlLoader.load();
        mainBox = new BorderPane();
        Pane menuP = new Pane();


        menuP.getChildren().add(new FXMenu());

        Scene mainWindowScene = new Scene(menuP, 500, 500);
        Scene minorWindowScene = new Scene(mainBox, 300,300);
        Stage minorStage = new Stage();
        minorStage.setTitle("Stabe Minor");
        minorStage.setScene(minorWindowScene);

        minorStage.show();
        mainGuiStage.setScene(mainWindowScene);
        mainGuiStage.show();
        minorStage.show();

    }

    private void runOldGUI(){
        new gui_v1.mainWindows.MainGUIWindow();
    }
}
