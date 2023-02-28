package gui_v1;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;

public class GUI_RecordsActionsControlButtonsBoxP  extends JPanel implements GUI_Settings_Variables {

	private static final long serialVersionUID = 1L;

	private JButton jbtSearchRecords = GUI_ElementCreator.newJButton("Print Table");
	public GUI_RecordsActionsControlButtonsBoxP() {
		setLayout(new GridLayout(2,1));
		add(GUI_ElementCreator.newTitle("Click Search Button to Perform Search"));
		jbtSearchRecords.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {

				RecordsTable.printTransactionsTable();
			}
		});
		add(jbtSearchRecords);
	}
	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return this;
	}
}
