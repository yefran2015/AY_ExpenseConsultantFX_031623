package gui_v1;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;

public class GUI_AddAcctControlButtonsP extends JPanel implements GUI_Settings_Variables {

	private static final long serialVersionUID = 1L;

//	private JButton jbtAddAccount = new JButton("Add");

	private JButton jbtAddAccount = GUI_ElementCreator.newJButton("Add");
	public GUI_AddAcctControlButtonsP() {
		setLayout(new GridLayout(5,1));
//		add(new JLabel("Check Bank and Account"));
//		add(new JLabel("Information"));
//		add(new JLabel("if All Correct"));
//		add(new JLabel("Click Add Button"));

		add(GUI_ElementCreator.newTitle("Confirm Adding"));
		add(GUI_ElementCreator.newTextLabel("Check Bank and Account"));
		add(GUI_ElementCreator.newTextLabel("Information if All Correct"));
		add(GUI_ElementCreator.newTextLabel("Click Add Button"));
		add(jbtAddAccount);
	}
	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return this;
	}
}
