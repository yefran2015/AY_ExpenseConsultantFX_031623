package gui_v1;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;

public class GUI_AvailableActionsSelectionP extends JPanel implements GUI_Settings_Variables{

	private static final long serialVersionUID = 1L;

//		private JRadioButton jrbtInsertData = new JRadioButton("Insert Data");
//		private JRadioButton jrbtSearchData = new JRadioButton("Search Data");
//		private JRadioButton jrbtGetAdvice = new JRadioButton("Get Advice");
//		private JRadioButton jrbtHowToUse = new JRadioButton("Learn How to Use");
//		private JRadioButton jrbtSaveData = new JRadioButton("Save Data");
//		private JRadioButton jrbtLoadData = new JRadioButton("Load Data");
//		private JRadioButton jrbtObtainDataReport = new JRadioButton("Obtain Data Report");
	private JRadioButton jrbtInsertData = GUI_ElementCreator.newRadioButton("Insert Data");
	private JRadioButton jrbtSearchData = GUI_ElementCreator.newRadioButton("Search Data");
	private JRadioButton jrbtGetAdvice = GUI_ElementCreator.newRadioButton("Get Advice");
	private JRadioButton jrbtHowToUse = GUI_ElementCreator.newRadioButton("Learn How to Use");
	private JRadioButton jrbtSaveData = GUI_ElementCreator.newRadioButton("Save Data");
	private JRadioButton jrbtLoadData = GUI_ElementCreator.newRadioButton("Load Data");
	private JRadioButton jrbtObtainDataReport = GUI_ElementCreator.newRadioButton("Obtain Data Report");

	public GUI_AvailableActionsSelectionP() {

		this.setBorder(new LineBorder(clr_Action_Option, lineSize));
		setBackground(clrB_Action_Selectors);
		setForeground(clrF_Action_Selectors);
		
		setLayout(new GridLayout(9,1));
		ButtonGroup actionRBTNsGroup = new ButtonGroup();
		actionRBTNsGroup.add(jrbtInsertData);
		actionRBTNsGroup.add(jrbtSearchData);
		actionRBTNsGroup.add(jrbtGetAdvice);
		actionRBTNsGroup.add(jrbtHowToUse);
		actionRBTNsGroup.add(jrbtSaveData);
		actionRBTNsGroup.add(jrbtLoadData);
		actionRBTNsGroup.add(jrbtObtainDataReport);

//		add(new JLabel("Available Actions:"));

		add(GUI_ElementCreator.newTitle("Available Actions:"));
		add(jrbtInsertData);
		add(jrbtSearchData);
		add(jrbtGetAdvice);
		add(jrbtHowToUse);
		add(jrbtSaveData);
		add(jrbtLoadData);
		add(jrbtObtainDataReport);

	}

	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return this;
	}
}
