package gui_v1.mainWindows.mainWElements;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;

public class GUI_MainBoxP extends JPanel implements GUI_Settings_Variables{

	private static final long serialVersionUID = 1L;

	private JPanel jpMainHeadingBoxP = new JPanel();
	private JPanel jpMainActionBoxP = new JPanel();
	private JPanel jpMainMessagesBoxP = new JPanel();

	private JPanel jpSelectionActionBoxP = new JPanel();
	private JPanel jpSelectActionBox1P = new JPanel();
	private JPanel jpSelectActionBox2P = new JPanel();
	private JPanel jpSelectActionBox3P = new JPanel();
	private JPanel jpActionInputBoxP = new JPanel();
	private JPanel jpActionUserInputBoxP = new JPanel();

	private JPanel jpUserInputBox1P = new JPanel();

	private JPanel jpUserInputBox2P = new JPanel();

	private JPanel jpUserInputBox3P = new JPanel();


//	private JLabel jlblHeadTitle = new JLabel(strHeadTitle_GUIMainWindow, JLabel.CENTER);
//	private JLabel jlblSubTitle = new JLabel("Sub Title", JLabel.CENTER);
//	private JLabel jlblUserInputTitle = new JLabel("Action Input Title", JLabel.CENTER);
	
	private JLabel jlblHeadTitle = GUI_ElementCreator.newHead(strHeadTitle_GUIMainWindow);
	private JLabel jlblSubTitle = GUI_ElementCreator.newSubHead(strDefaultString);
	private JLabel jlblUserInputTitle =GUI_ElementCreator.newTitle(strDefaultActionString);


	private void for_testing() {
		jpMainHeadingBoxP.setBorder(new TitledBorder("jpMainHeadingBoxP"));
		jpMainActionBoxP.setBorder(new TitledBorder("jpMainActionBoxP"));
		jpMainMessagesBoxP.setBorder(new TitledBorder("jpMainMessagesBoxP"));
		jpSelectionActionBoxP.setBorder(new TitledBorder("jpSelectionActionBoxP"));
		jpActionInputBoxP.setBorder(new TitledBorder("jpActionInputBoxP"));
		jpSelectActionBox1P.setBorder(new TitledBorder("jpSelectActionBox1P"));
		jpSelectActionBox2P.setBorder(new TitledBorder("jpSelectActionBox2P"));
		jpSelectActionBox3P.setBorder(new TitledBorder("jpSelectActionBox3P"));
		jpActionUserInputBoxP.setBorder(new TitledBorder("jpActionUserInputBoxP"));
		jpUserInputBox1P.setBorder(new TitledBorder("jpUserInputBox1P"));
		jpUserInputBox2P.setBorder(new TitledBorder("jpUserInputBox2P"));
		jpUserInputBox3P.setBorder(new TitledBorder("jpUserInputBox3P"));
	}

	private void setVisualSettings() {
		this.setBackground(allGuiBoxesBackgroundCColor);
		this.setForeground(allGuiBoxesForegroundCColor);
//		jlblHeadTitle.setFont(GUI_ElementCreator.newFont(jlblHeadTitle.getFont(), txtSize_Heading));
	}

	public GUI_MainBoxP() {
		for_testing();



		setVisualSettings();

		setLayout(new BorderLayout());
		jpMainActionBoxP.setLayout(new GridLayout(2,1));

		jpMainHeadingBoxP.setLayout(new GridLayout(2,1));
		jpMainHeadingBoxP.add(jlblHeadTitle);
		jpMainHeadingBoxP.add(jlblSubTitle);
		add(jpMainHeadingBoxP, BorderLayout.NORTH);

		jpSelectionActionBoxP.setLayout(new GridLayout(1,3));
		jpSelectActionBox1P.setLayout(new BorderLayout());
		jpSelectActionBox1P.add(new GUI_AvailableActionsSelectionP(), BorderLayout.CENTER);
		jpSelectionActionBoxP.add(jpSelectActionBox1P);
		jpSelectActionBox2P.setLayout(new BorderLayout());
		jpSelectActionBox2P.add(new GUI_InsertDataP(), BorderLayout.CENTER);
		jpSelectionActionBoxP.add(jpSelectActionBox2P);
		jpSelectActionBox3P.setLayout(new BorderLayout());
		jpSelectActionBox3P.add(new GUI_AddAccountP(), BorderLayout.CENTER);
		jpSelectionActionBoxP.add(jpSelectActionBox3P);
		jpMainActionBoxP.add(jpSelectionActionBoxP);

		jpActionInputBoxP.setLayout(new BorderLayout());
		jpActionInputBoxP.add(jlblUserInputTitle, BorderLayout.NORTH);

		jpActionUserInputBoxP.setLayout(new GridLayout(1,3));
		jpUserInputBox1P.setLayout(new BorderLayout());
		jpUserInputBox1P.add(new GUI_BankInfoInputP(), BorderLayout.CENTER);
		jpActionUserInputBoxP.add(jpUserInputBox1P);
		jpUserInputBox2P.setLayout(new BorderLayout());
		jpUserInputBox2P.add(new GUI_AccountInfoInputP(), BorderLayout.CENTER);
		jpActionUserInputBoxP.add(jpUserInputBox2P);

		jpUserInputBox3P.setLayout(new BorderLayout());
		jpUserInputBox3P.add(new GUI_AddAcctControlButtonsP(), BorderLayout.CENTER);
		jpActionUserInputBoxP.add(jpUserInputBox3P);

		jpActionInputBoxP.add(jpActionUserInputBoxP, BorderLayout.CENTER);


		jpMainActionBoxP.add(jpActionInputBoxP);
		add(jpMainActionBoxP, BorderLayout.CENTER);


		jpMainMessagesBoxP.setLayout(new BorderLayout());
		jpMainMessagesBoxP.add(new GUI_MessagesDislplayBoxP(), BorderLayout.CENTER);
		add(jpMainMessagesBoxP, BorderLayout.SOUTH);


	}

	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return this;
	}

}
