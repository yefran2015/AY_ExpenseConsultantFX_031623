package guiFX.menu;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import guiFX.automation.GUI_ElementCreator;

public class FXMenu extends MenuBar {
//    menuItemAdd.setAccelerator(
//            KeyCombination.keyCombination("Ctrl+A"));


    public FXMenu(){
        Menu jmFile = GUI_ElementCreator.newMenu("File");

        MenuItem jmiSave = GUI_ElementCreator.newMenuItem("Save");
        jmFile.getItems().addAll(jmiSave);
        MenuItem jmiLoad = GUI_ElementCreator.newMenuItem("Load");
        jmFile.getItems().addAll(jmiLoad);
//        jmFile.getItems().addAll((Collection<? extends MenuItem>) new Separator());
        MenuItem jmiExit = GUI_ElementCreator.newMenuItem("Exit");
        jmFile.getItems().addAll(jmiExit);
        getMenus().addAll(jmFile);




        Menu jmAction = GUI_ElementCreator.newMenu("Actions" );
        MenuItem jmiAddData = GUI_ElementCreator.newMenuItem("Insert Data");
        jmAction.getItems().addAll(jmiAddData);
        MenuItem jmiSearchData = GUI_ElementCreator.newMenuItem("Search Data");
        jmAction.getItems().addAll(jmiSearchData);
        MenuItem jmiAdvising = GUI_ElementCreator.newMenuItem("Advising");
        jmAction.getItems().addAll(jmiAdvising);
        MenuItem jmiEditData = GUI_ElementCreator.newMenuItem("Edit Data");
        jmAction.getItems().addAll(jmiEditData);

        getMenus().addAll(jmAction);


        Menu jmView = GUI_ElementCreator.newMenu("View");
        Menu jmWindow = GUI_ElementCreator.newMenu("GUI Windows Views");
        MenuItem jmiShowRecordsWindow = GUI_ElementCreator.newMenuItem("Show Records Window");
//        jmWindow.getItems().addAll((Collection<? extends MenuItem>) new Separator());
        jmWindow.getItems().addAll(jmiShowRecordsWindow);
        jmView.getItems().addAll(jmWindow);
        getMenus().addAll(jmView);

        Menu jmSettings = GUI_ElementCreator.newMenu("Settings");
        Menu jmFontSize = GUI_ElementCreator.newMenu("Adjust Text Size");


        MenuItem jmiIncreaseFontSize = GUI_ElementCreator.newMenuItem("Increse GUI Text Size (+)");
        MenuItem jmiDecreaseFontSize = GUI_ElementCreator.newMenuItem("Decrese GUI Text Size (-)");
        jmFontSize.getItems().addAll(jmiIncreaseFontSize);
        jmFontSize.getItems().addAll(jmiDecreaseFontSize);
        jmSettings.getItems().addAll(jmFontSize);
        getMenus().addAll(jmSettings);


        Menu jmHelp = GUI_ElementCreator.newMenu("Help" );
        MenuItem jmiUse = GUI_ElementCreator.newMenuItem("App Use");
        jmHelp.getItems().addAll(jmiUse);
//        jmHelp.getItems().addAll((Collection<? extends MenuItem>) new Separator());
        MenuItem jmiAbout = GUI_ElementCreator.newMenuItem("About");
        jmHelp.getItems().addAll(jmiAbout);
        getMenus().addAll(jmHelp);
    }
}
