package guiFX.automation;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import guiFX.settings.GUI_Settings_Variables;
//import src.ay.gui.old_ver.gui.settings.GUI_Settings_Variables;
//
//import static src.gui.settings.GUI_Settings_Variables.txtSize_RadioButton;


public final class GUI_ElementCreator implements GUI_Settings_Variables {



	public static Font newFont(Font f, int fSize) {
		return new Font(f.getName(),  fSize);
	}

	public static RadioButton newRadioButton(String  msg) {
		RadioButton  rbtn = new RadioButton(msg);
		rbtn.setFont(newFont(rbtn.getFont(), GUI_Settings_Variables.txtSize_RadioButton));
		rbtn.setTextFill(GUI_Settings_Variables.clrF_RadioButton);
		rbtn.setBackground(Background.fill(GUI_Settings_Variables.clrB_RadioButton));
		return rbtn;
	}
	public static TextField newTextField() {
		TextField jtf = new TextField();
		jtf.setFont(newFont(jtf.getFont(), GUI_Settings_Variables.txtSize_TextField+1));
		jtf.setStyle("-fx-text-fill: "+String.valueOf(GUI_Settings_Variables.clrF_TextField));
		jtf.setBackground(Background.fill(GUI_Settings_Variables.clrB_TextField));
		return jtf;
	}
	public static TextArea newTextArea() {
		TextArea  jta = new TextArea();
		jta.setFont(newFont(jta.getFont(), GUI_Settings_Variables.txtSize_TextArea));
		jta.setStyle("-fx-text-fill: "+String.valueOf(GUI_Settings_Variables.clrF_TextArea));
		jta.setBackground(Background.fill(GUI_Settings_Variables.clrB_TextArea));
		return jta;
	}


	private static String checkTitleMsg(String msg) {
		if(msg!=null) {
			return msg;
		}else {
			return GUI_Settings_Variables.strDefaultString;
		}
	}

	public static Label newHead(String  msg) {
		Label  lbl = new Label(checkTitleMsg(msg));
		lbl.setContentDisplay(ContentDisplay.CENTER);
		lbl.setFont(newFont(lbl.getFont(), GUI_Settings_Variables.txtSize_Heading));
		lbl.setTextFill(GUI_Settings_Variables.clrF_HeadTitle);
		lbl.setBackground(Background.fill(GUI_Settings_Variables.clrB_HeadTitle));
		return lbl;
	}
	public static Label newSubHead(String  msg) {
		Label  lbl = new Label(checkTitleMsg(msg));
		lbl.setContentDisplay(ContentDisplay.CENTER);
		lbl.setFont(newFont(lbl.getFont(), GUI_Settings_Variables.txtSize_subHead));
		lbl.setTextFill(GUI_Settings_Variables.clrF_SubTitle);
		lbl.setBackground(Background.fill(GUI_Settings_Variables.clrB_SubTitle));
		return lbl;
	}
	public static Label newTitle(String  msg) {
		Label  lbl = new Label(checkTitleMsg(msg));
		lbl.setContentDisplay(ContentDisplay.CENTER);
		lbl.setFont(newFont(lbl.getFont(), GUI_Settings_Variables.txtSize_Title));
		lbl.setTextFill(GUI_Settings_Variables.clrF_Title);
		lbl.setBackground(Background.fill(GUI_Settings_Variables.clrB_Title));
		return lbl;
	}
	public static Button newButton(String  msg) {
		Button  jbtn = new Button(checkTitleMsg(msg));
		jbtn.setFont(newFont(jbtn.getFont(), GUI_Settings_Variables.txtSize_Button));
		jbtn.setTextFill(GUI_Settings_Variables.clrF_Btn_Add);
		jbtn.setBackground(Background.fill(GUI_Settings_Variables.clrB_Btn_Add));
		return jbtn;
	}
	public static Menu newMenu(String  msg) {
		Menu  jmenu = new Menu(checkTitleMsg(msg));
		jmenu.setText(msg);
////		jmenu.(clrF_Menu);
//		jmenu.setOnAction(Background.fill(clrB_Menu));
		return jmenu;
	}
	public static MenuItem newMenuItem(String  msg) {
		MenuItem  jmenu = new MenuItem(checkTitleMsg(msg));
//		jmenu.setStyle("-fx-text-fill: "+String.valueOf(clrF_TextField));
//		jmenu.getStyle().si txtSize_MenuItem));
//		jmenu.setStyle("-fx-text-fill: "+String.valueOf(clrF_MenuItem));
		System.out.println("Hello: "+ GUI_Settings_Variables.clrF_MenuItem);
		jmenu.setStyle("-fx-text-fill: green");
//		jmenu.setBackground(clrB_MenuItem);
		return jmenu;
	}
	public static Label newFieldNameLabel(String  msg) {
		Label  lbl = new Label(checkTitleMsg(msg));
		lbl.setContentDisplay(ContentDisplay.CENTER);
		lbl.setFont(newFont(lbl.getFont(), GUI_Settings_Variables.txtSize_NamesOfFields));
		lbl.setTextFill(GUI_Settings_Variables.clr_NamesOfField);
//		lbl.setBackground(clrB_Title);
		return lbl;
	}
	public static Label newTextLabel(String  msg) {
		Label  lbl = new Label(checkTitleMsg(msg));
		lbl.setContentDisplay(ContentDisplay.CENTER);
		lbl.setFont(newFont(lbl.getFont(), GUI_Settings_Variables.txtSize_Regular));
		lbl.setTextFill(GUI_Settings_Variables.clrF_InfoMsgs);
//		lbl.setBackground(clrB_Title);
		return lbl;
	}
//	@Override
//	public Component getComponent() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public static TableView newTableView(FXCollections.observableArrayList testData, String[] columnNames) {
	public static TableView newTableView(ObservableList<String> testData, String[] columnNames) {
		TableView jtbl = new TableView();

		jtbl.setItems(testData);
//		jtbl.getPlaceholder().setBackground(clrB_TableCellHead);
////		jtbl.getPlaceholder().setTextFill(clrF_TableCellHead);
//		jtbl.getPlaceholder().setFont(newFont(jtbl.getPlaceholder().getFont(), txtSize_TableHeader));
//		jtbl.setFont(newFont(jtbl.getFont(), txtSize_TableCell));
//		jtbl.setRowHeight(jtbl.getFont().getSize()+2);
		return jtbl;
	}
	public static TableView newTableView() {
		TableView jtbl = new TableView();
//		jtbl.getTableHeader().setBackground(clrB_TableCellHead);
//		jtbl.getTableHeader().setTextFill(clrF_TableCellHead);
//		jtbl.getTableHeader().setFont(newFont(jtbl.getTableHeader().getFont(), txtSize_TableHeader));
//		jtbl.setFont(newFont(jtbl.getFont(), txtSize_TableCell));
//		jtbl.setRowHeight(jtbl.getFont().getSize()+2);
		return jtbl;
	}
}

