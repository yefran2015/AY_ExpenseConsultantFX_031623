package gui_v1;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;

public class GUI_RecordsAvailableActionsSelectionP extends JPanel implements GUI_Settings_Variables{

	private static final long serialVersionUID = 1L;

		private JRadioButton jrbtInsertRecord = GUI_ElementCreator.newRadioButton("Insert Record");
		private JRadioButton jrbtSearchRecord = GUI_ElementCreator.newRadioButton("Search Record");

	public GUI_RecordsAvailableActionsSelectionP() {
		setLayout(new GridLayout(3,1));
		ButtonGroup actionRBTNsGroup = new ButtonGroup();
		actionRBTNsGroup.add(jrbtInsertRecord);
		actionRBTNsGroup.add(jrbtSearchRecord);

		add(GUI_ElementCreator.newTitle("Available Actions:"));
		add(jrbtInsertRecord);
		add(jrbtSearchRecord);

	}

	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return this;
	}
}