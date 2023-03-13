package gui_v1.mainWindows.mainWElements;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;

public class GUI_AccountInfoInputP  extends JPanel implements GUI_Settings_Variables{

	private static final long serialVersionUID = 1L;
//
//	private JTextField jtfBankInfoIn1 = new JTextField();
//	private JTextField jtfBankInfoIn2 = new JTextField();
//	private JTextField jtfBankInfoIn3 = new JTextField();

	private JTextField jtfBankInfoIn1 = GUI_ElementCreator.newTextField();
	private JTextField jtfBankInfoIn2 = GUI_ElementCreator.newTextField();
	private JTextField jtfBankInfoIn3 = GUI_ElementCreator.newTextField();

	public GUI_AccountInfoInputP() {
		setLayout(new GridLayout(5,1));
		JPanel box1 = new JPanel();
		box1.setLayout(new GridLayout(1,2));
		JPanel box2 = new JPanel();
		box2.setLayout(new GridLayout(1,2));
		JPanel box3 = new JPanel();
		box3.setLayout(new GridLayout(1,2));

		
		box1.add(GUI_ElementCreator.newFieldNameLabel("Name on Account (as spelled):"));
//		box1.add(new JLabel("Name on Account (as spelled):"));
		box1.add(jtfBankInfoIn1);
//		box2.add(new JLabel("Account Number:"));
		box2.add(GUI_ElementCreator.newFieldNameLabel("Account Number:"));
		box2.add(jtfBankInfoIn2);
//		box3.add(new JLabel("Current Balance:"));
		box3.add(GUI_ElementCreator.newFieldNameLabel("Current Balance:"));
		box3.add(jtfBankInfoIn3);

//		add(new JLabel("New Account Info:", JLabel.CENTER));
		add(GUI_ElementCreator.newTitle("New Account Info:"));
		
		add(box1);
		add(box2);
		add(box3);


	}

	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return this;
	}


}