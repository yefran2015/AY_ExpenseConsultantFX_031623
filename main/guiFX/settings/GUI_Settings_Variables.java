package guiFX.settings;



import javafx.scene.paint.Color;


/**
 * @author owners SPAM Team, ICS499, Personal Expenses Manager App.
 * @author owner Andrey Y
 * @author owner Pavel
 * @author owner Sam
 * @
 *
 */
//public interface GUI_Settings_Variables extends GUI_FontSizeAdjustable {
public interface GUI_Settings_Variables{
	
	/**
	 * This is Main Settings Interface Class for this App.
	 * GUI Elements visual appearance: sizes, colors, locations,
	 * are here. Global Headings, Titles, Subtitles, Messages, with
	 * all other static Text Strings are here.
	 *
	 * *************************************************************8
	 * Technical Information Section of this info
	 * *************************
	 *
	 * ***********
	 * 1. All Color variables naming -->
	 * *****
	 * A.  All BackgroundColor variables have prefix --> clrB_
	 * B.  All ForegroundColor variables have prefix --> clrF_
	 *
	 * ***********
	 * 1. All Fonts Sizing are related to -->
	 * *****
	 * A. Basic Font Size
	 * B. Head Font Size
	 * C. SubHead Font Size
	 * D, Title Font Size
	 * E. Important Font Size --> Basic Font Size + fontSizeFactor
	 * F. Smaller Font Size --> Basic Font Size - fontSizeFactor
	 *
	 *
	 * */
//	String strDefaultString  = "This is Default NO-ANY Message is Set Sttring";
	String strDefaultString  = "SPAM Team \nSam, Pavel, Andrey, and not Musab";
	String strDefaultActionString  = "Action Title NOT SET";

	String strDefaultSubTitleString  = "This Sub Title NOT-SET";


	String strAppOfficialName = "Personal Expense Consultant by SPAM Team";
	String strCopyRigts = "Copyright \u00a9 SPAM Team 2023";
	String strAboutApp = "This App is Capstone project of SPAM Team";

	String strHeadTitle_GUIMainWindow = "Welcome to Personal Expenses Manager ";
	String strHeadTitle_GUIRecordsWindow = "Records Handler Personal Expenses Manager ";


	int gui_width = 900;
	int gui_height = 1000;
//	Dimension mainGUIFrameSize = new Dimension(gui_width, gui_height);
//	Dimension recordsGUIWindowFrameSize = new Dimension(gui_width, gui_height);



	String mainGUIFrameWindowTitle = strAppOfficialName;
	String recordsGUIWindowTitle = strAppOfficialName;
	
	/////////////////////////////////////////
	//    main colors
	/////////////////////////////////////////
	Color clr_Input = Color.BLUE;
	Color clr_Action_Option = Color.RED;
	Color clr_Selection = Color.RED;
	
	/////////////////////////////////////////
	
	int lineSize = 1;

	int txtSizeFactor = 3;
	int txtSize_Regular = 18;
	int txtSize_Important = txtSize_Regular + txtSizeFactor;
	int txtSize_Smaller = txtSize_Regular - txtSizeFactor;

	int txtSize_Heading = txtSize_Regular + 4 * txtSizeFactor;
	int txtSize_subHead = txtSize_Regular +  4 * txtSizeFactor;
	int txtSize_Title  = txtSize_Regular +  2 * txtSizeFactor;
	

	int txtSize_NamesOfFields = txtSize_Regular;
	Color clr_NamesOfField =clr_Input;
	
	
	
	////////////////////////////////////////
	/// Java Elements Font size settings here
	int txtSize_MenuBar = txtSize_Regular + 5 *txtSizeFactor;
	int txtSize_Menu = txtSize_Regular +  5 * txtSizeFactor;
	int txtSize_MenuItem = txtSize_Regular + 4 * txtSizeFactor;
	int txtSize_Label = txtSize_Regular +  txtSizeFactor;

	int txtSize_TextArea = txtSize_Regular;
	int txtSize_TextField = txtSize_Regular;
	int txtSize_CheckBox = txtSize_Smaller;
	int txtSize_RadioButton = txtSize_Smaller;
	int txtSize_Button = txtSize_Regular;
	int txtSize_Table = txtSize_Regular;
	int txtSize_TableHeader = txtSize_Regular;
	int txtSize_TableCell = txtSize_Regular;


		
    /////////////////////////////////////////

	Color guiFramesBackgroundColor = Color.CYAN;
	Color guiFramesForegroundColor = Color.BLACK;

	Color allGuiBoxesBackgroundCColor = Color.BLUE;
	Color allGuiBoxesForegroundCColor = Color.BLACK;

//	Color allSelectionHoldersPanelsBackgroundColor = Color.ORANGE;
//	Color allSelectionHoldersPanelsForegroundColor = Color.BLUE;

	Color availableActionsPanelBackgroundColor = Color.RED;
	Color availableActionsPanelForegroundColor = Color.GREEN;


	Color InsertDataPBackgroundColor = Color.ORANGE;
	Color InsertDataPForegroundColor = Color.RED;
	
	
	

	Color clrF_HeadTitle = Color.BLUE;
	Color clrB_HeadTitle = Color.TRANSPARENT;


	Color clrF_SubTitle = Color.BLUE;
	Color clrB_SubTitle = Color.TRANSPARENT;


	Color clrF_Title = Color.BLUE;
	Color clrB_Title = Color.TRANSPARENT;


	Color clrF_InfoMsgs = Color.BLUE;
	Color clrB_InfoMsgs = Color.TRANSPARENT;

	Color clrF_PurposeMsgs = Color.BLUE;
	Color clrB_PurposeMsgs = Color.TRANSPARENT;


	Color clrF_SelectionMsgs = Color.BLUE;
	Color clrB_SelectionMsgs = Color.TRANSPARENT;

	Color clrF_ErrorMsgs = Color.BLUE;
	Color clrB_ErrorMsg = Color.TRANSPARENT;

	Color clrF_WarningMsgs = Color.BLUE;
	Color clrB_WarningMsg = Color.TRANSPARENT;

	Color clrF_Action_Selectors= Color.RED;
	Color clrB_Action_Selectors = Color.YELLOW;


	Color clrF_Type_Selections = Color.BLUE;
	Color clrB_Type_Selections = Color.TRANSPARENT;


	Color clrF_DataInput = Color.BLUE;
	Color clrB_DataInput = Color.TRANSPARENT;

	Color clrF_DataOutput = Color.BLUE;
	Color clrB_DataOutput = Color.TRANSPARENT;


	Color clrF_Btn_Insert = Color.BLUE;
	Color clrB_Btn_Insert = Color.TRANSPARENT;
	Color clrF_Btn_Agree = Color.BLUE;
	Color clrB_Btn_Agree = Color.TRANSPARENT;
	Color clrF_Btn_Deny = Color.BLUE;	
	Color clrB_Btn_Deny = Color.TRANSPARENT;
	Color clrF_Btn_Show = Color.BLUE;
	Color clrB_Btn_Show = Color.TRANSPARENT;
	Color clrF_Btn_Delete = Color.BLUE;
	Color clrB_Btn_Delete = Color.TRANSPARENT;
	Color clrF_Btn_Close = Color.BLUE;
	Color clrB_Btn_Close = Color.TRANSPARENT;
	Color clrF_Btn_Confirm = Color.BLUE;
	Color clrB_Btn_Confirm = Color.TRANSPARENT;
	Color clrF_Btn_Add = Color.BLUE;
	Color clrB_Btn_Add = Color.rgb(255, 209, 229);
	Color clrF_Btn_Search = Color.BLUE;
	Color clrB_Btn_Search = Color.TRANSPARENT;
	Color clrF_Btn_Help = Color.BLUE;
	Color clrB_Btn_Help = Color.TRANSPARENT;



	// Same Types of GUI Elements settings


	Color clrF_Frame = Color.BLUE;
	Color clrB_Frame = Color.TRANSPARENT;

	Color clrF_Panel = Color.BLUE;
	Color clrB_Panel = Color.TRANSPARENT;

	Color clrF_Label = Color.BLUE;
	Color clrB_Label = Color.TRANSPARENT;

	Color clrF_Button = Color.BLUE;
	Color clrB_Button = Color.TRANSPARENT;

	Color clrF_TextField = Color.BLUE;
	Color clrB_TextField = Color.rgb(74, 205, 242);

	Color clrF_TextArea = Color.BLUE;
	Color clrB_TextArea = Color.TRANSPARENT;

	Color clrF_RadioButton = Color.BLUE;
	Color clrB_RadioButton= Color.TRANSPARENT;

	
	Color clrF_CheckBox = Color.BLUE;
	Color clrB_CheckBox = Color.TRANSPARENT;

	Color clrF_Table = Color.BLUE;
	Color clrB_Table = Color.TRANSPARENT;

	Color clrF_TableCellHead = Color.BLUE;
	Color clrB_TableCellHead = Color.GREEN;
	Color clrF_Table_cell = Color.BLUE;
	Color clrB_Table_cell = Color.TRANSPARENT;



	Color clrF_MenuBar = Color.BLUE;
	Color clrB_MenuBar = Color.rgb(74, 205, 242);
	Color clrF_Menu = Color.BLUE;
	Color clrB_Menu = Color.TRANSPARENT;
	Color clrF_MenuItem = Color.BLUE;
	Color clrB_MenuItem = Color.rgb(74, 205, 242);;

	/// end of ava GUI  elements settings



	////////////////////////////////////////////
	////// FONTS Settings area
	
	
	
	
///////////////////////////////////////////////////////////
	
	
	
	/////////////////////////////////////////////////////////

}



















