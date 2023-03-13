package gui_v1.mainWindows.mainWElements;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;

public class GUI_MessagesDislplayBoxP extends JPanel implements GUI_Settings_Variables{

	private static final long serialVersionUID = 1L;
	private JLabel lblTitle =  GUI_ElementCreator.newSubHead("This is Informative Dislpay");
	private JTextArea jtaMessagesDisplayOutput = GUI_ElementCreator.newJTextArea();
	private void TestData() {
//		setPreferredSize(new Dimension(300,0));
		setPreferredSize(mainWindowMessageAreaSize);
		String strTestData="System Overview\n"
				+ "The Consultant will be both an immediate and an ongoing analyst and advisor in your personal monetary matters. It will help you determine whether you’re doing fine in your financial life, or you need a little guidance. It will help you plan for and achieve financial health.\n"
				+ "Attributes\n"
				+ "    • super-fast – you see results in moments\n"
				+ "    • security – no info will go beyond your computer/device\n"
				+ "    • encryption – all data stored locally in an encrypted file\n"
				+ "    • convenience – your choice of either one-way connection with your bank accounts or manual entry\n"
				+ "    • searchability – everything displayed in sortable columns, which make it super easy to look anything up\n"
				+ "    • simplicity – simple UI\n"
				+ "Key Features\n"
				+ "    • secure login\n"
				+ "    • automatic updates\n"
				+ "    • manual entry option\n"
				+ "    • encryption of data\n"
				+ "    • transactions displayed in sortable columns\n"
				+ "    • quick overview and summary\n"
				+ "    • advising engine (predictions and suggestions built in)\n"
				+ "    • simple, well-readable GUI\n"
				+ "Capabilities\n"
				+ "    • automatic updates: one way transaction updates (bank->app) at a press of a button or at the start of the application\n"
				+ "    • manual entry option: while it takes a little bit longer done manually, if desired, there’s no connection to the bank necessary–all data can be input by hand\n"
				+ "    • encryption: all data is encrypted before storing and encrypted just before use\n"
				+ "    • sortable columns: transactions can be sorted by any piece of information that’s part of the transaction, and then easily found in the list\n"
				+ "    • summary: your overview and account summary take just moments to complete to reveal your financial health on the fly\n"
				+ "    • advising: financial projection and suggestions tailored for you available on a whim\n"
				+ "\n"
				+ " ";
		jtaMessagesDisplayOutput.setText(strTestData);
	}
	public GUI_MessagesDislplayBoxP() {
//		setBackground(allGuiBoxesBackgroundCColor);
//		setForeground(allGuiBoxesForegroundCColor);

		setLayout(new BorderLayout());

		add(lblTitle, BorderLayout.NORTH);
		add(new JScrollPane(jtaMessagesDisplayOutput), BorderLayout.CENTER);
		TestData();
	}
	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return this;
	}

}
