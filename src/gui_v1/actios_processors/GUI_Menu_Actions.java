package gui_v1.actios_processors;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import gui_v1.mainWindows.GUI_RecordsFrame;
import gui_v1.settings.GUI_Settings_Variables;

public class GUI_Menu_Actions implements ActionListener, GUI_Settings_Variables{
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().compareToIgnoreCase("Exit")==0) {
			System.exit(0);
		}else if (e.getActionCommand().compareToIgnoreCase("About")==0) {

			JOptionPane.showMessageDialog(null, ""+strAboutApp,"About", JOptionPane.INFORMATION_MESSAGE);

		}else if (e.getActionCommand().compareToIgnoreCase("Show Records Window")==0) {
			new GUI_RecordsFrame();
		}else if (e.getActionCommand().compareToIgnoreCase("Increse GUI Text Size (+)")==0) {
			increaseAllElementsFont();


		}else if (e.getActionCommand().compareToIgnoreCase("Decrese GUI Text Size (-)")==0) {
			decreaseAllElementsFont();
		}

	}

	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return mainGUIComponent;
	}
	private Component mainGUIComponent;
	public void setMainGUIComponent(Component c) {
		mainGUIComponent=c;
	}

}
