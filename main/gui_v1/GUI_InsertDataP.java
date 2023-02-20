package gui_v1;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;

public class GUI_InsertDataP extends JPanel implements GUI_Settings_Variables{

	private static final long serialVersionUID = 1L;

//	private JRadioButton jrbtNewBank = new JRadioButton("New Bank");
//	private JRadioButton jrbtAccount = new JRadioButton("Account");
//	private JRadioButton jrbtRecord = new JRadioButton("Transaction Record");
//	private JRadioButton jrbtRecurrentExpense = new JRadioButton("Recurrent Expense");
//	private JRadioButton jrbtRecurrentProfit = new JRadioButton("Recurrent Profit");


	private JRadioButton jrbtNewBank =GUI_ElementCreator.newRadioButton("New Bank");
	private JRadioButton jrbtAccount = GUI_ElementCreator.newRadioButton("Account");
	private JRadioButton jrbtRecord = GUI_ElementCreator.newRadioButton("Transaction Record");
	private JRadioButton jrbtRecurrentExpense = GUI_ElementCreator.newRadioButton("Recurrent Expense");
	private JRadioButton jrbtRecurrentProfit = GUI_ElementCreator.newRadioButton("Recurrent Profit");
	
	
	
	public GUI_InsertDataP() {
		this.setBorder(new LineBorder(clr_Input, lineSize));
		setBackground(clrB_DataInput);
		setForeground(clrF_DataInput);

		setLayout(new GridLayout(6,1));
		ButtonGroup actionRBTNsGroup = new ButtonGroup();
		actionRBTNsGroup.add(jrbtNewBank);
		actionRBTNsGroup.add(jrbtAccount);
		actionRBTNsGroup.add(jrbtRecord);
		actionRBTNsGroup.add(jrbtRecurrentExpense);
		actionRBTNsGroup.add(jrbtRecurrentProfit);

//		add(new JLabel("Select What you Want to Insert"));
		add( GUI_ElementCreator.newTitle("Select What you Want to Insert"));
		add(jrbtNewBank);
		add(jrbtAccount);
		add(jrbtRecord);
		add(jrbtRecurrentExpense);
		add(jrbtRecurrentProfit);
	}

	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return this;
	}
}
