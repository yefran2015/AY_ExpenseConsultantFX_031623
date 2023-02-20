module guiFX.mainWindows.SPAM {
//    requires javafx.controls;
//    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.controls;
    requires javafx.fxml;


    opens guiFX.mainWindows to javafx.fxml;
    exports guiFX.mainWindows;
}