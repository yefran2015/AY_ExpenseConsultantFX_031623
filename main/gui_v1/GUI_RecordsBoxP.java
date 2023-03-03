package gui_v1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.*;

import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;

public class GUI_RecordsBoxP extends JPanel implements GUI_Settings_Variables{

	private static final long serialVersionUID = 1L;

//	private JLabel jlblRecordsMainTitle = new JLabel(strHeadTitle_GUIRecordsWindow, JLabel.CENTER);
//	private JLabel jlblRecordsSubTitle = new JLabel("Records Sub Title", JLabel.CENTER);
	private JLabel jlblRecordsMainTitle= GUI_ElementCreator.newHead(strHeadTitle_GUIRecordsWindow);
	private JLabel jlblRecordsSubTitle =  GUI_ElementCreator.newSubHead(strDefaultSubTitleString);
	
	private static String[] columnNames = {"Date", "Ref", "Name", "Memo", "Amount", "OTHER"};
	private static String[][] testData = {{"Rec Num", "Explain", "Bank", "Acct #", "Amount", "OTHER"},
			{"Rec Num", "Explain", "Bank", "Acct #", "Amount", "OTHER"},
			{"Rec Num", "Explain", "Bank", "Acct #", "Amount", "OTHER"} ,
			{"Rec Num", "Explain", "Bank", "Acct #", "Amount", "OTHER"},
			{"Rec Num", "Explain", "Bank", "Acct #", "Amount", "OTHER"},
			{"Rec Num", "Explain", "Bank", "Acct #", "Amount", "OTHER"},
			{"Rec Num", "Explain", "Bank", "Acct #", "Amount", "OTHER"}};
//	private static final JTable jtRecordsTable = GUI_ElementCreator.newJTable(testData, columnNames);
////	private static JTable jtRecordsTable = GUI_ElementCreator.newJTable();
//	public static JTable getTableView(){
//		return jtRecordsTable;
//	}
	public GUI_RecordsBoxP() {
		
	
		
		setLayout(new BorderLayout());

		JPanel jpRecordsTitleBoxP = new JPanel();
		JPanel jpRecordsDisplayBoxP = new JPanel();
		JPanel jpRecordsActionControlsBoxP = new JPanel();
		JPanel jpRecordsDisplayAndActionBoxP = new JPanel();

		jpRecordsTitleBoxP.setLayout(new GridLayout(2,1));
		jpRecordsTitleBoxP.add(jlblRecordsMainTitle);
		jpRecordsTitleBoxP.add(jlblRecordsSubTitle);

		jpRecordsDisplayBoxP.setLayout(new BorderLayout());



		jpRecordsDisplayBoxP.add(new RecordsTable(), BorderLayout.CENTER);


		jpRecordsActionControlsBoxP.setLayout(new GridLayout(1,3));
//		jpRecordsActionControlsBoxP.setPreferredSize(new Dimension(0,300));
		jpRecordsActionControlsBoxP.add(new GUI_RecordsAvailableActionsSelectionP());
		jpRecordsActionControlsBoxP.add(new GUI_RecordsActionsInputsBoxP());

		jpRecordsActionControlsBoxP.add(new GUI_RecordsActionsControlButtonsBoxP());




		add(jpRecordsTitleBoxP, BorderLayout.NORTH);
		add(jpRecordsDisplayBoxP, BorderLayout.CENTER);
		add(jpRecordsActionControlsBoxP, BorderLayout.SOUTH);
//		add(new RecordsNavigationButtonsP(), BorderLayout.SOUTH);


	}

	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return this;
	}
}
