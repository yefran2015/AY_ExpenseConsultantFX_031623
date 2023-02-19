package gui_v1;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;

public class GUI_RecordsActionsControlButtonsBoxP  extends JPanel implements GUI_Settings_Variables {

	private static final long serialVersionUID = 1L;

	private JButton jbtSearchRecords = GUI_ElementCreator.newJButton("Search");
	public GUI_RecordsActionsControlButtonsBoxP() {
		setLayout(new GridLayout(2,1));
		add(GUI_ElementCreator.newTitle("Click Search Button to Perform Search"));
		add(jbtSearchRecords);
	}
	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return this;
	}
}
