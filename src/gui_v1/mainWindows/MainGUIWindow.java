package gui_v1.mainWindows;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gui_v1.GUI_MainBoxP;
import gui_v1.menu.GUI_Menu;
import gui_v1.menu.GUI_Menu_Technical;
import gui_v1.settings.GUI_Settings_Variables;
public class MainGUIWindow extends JFrame implements GUI_Settings_Variables  {
	private static final long serialVersionUID = 1L;
	public MainGUIWindow() {
//		setBackground(guiFramesBackgroundColor);
//		setForeground(guiFramesForegroundColor);
//		setJMenuBar(new GUI_Menu_Technical(this));
//		setJMenuBar(new GUI_Menu(this));
		if(gui_v1.settings.GUI_Static_Settings.workStage==1){
			setJMenuBar(new GUI_Menu());
		}else{
			setJMenuBar(new GUI_Menu_Technical());
		}
		setTitle(strAppOfficialName);
		setSize(mainGUIFrameSize);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());



		add(new GUI_MainBoxP(), BorderLayout.CENTER);

		add(new JLabel(strCopyRigts, JLabel.CENTER), BorderLayout.SOUTH);
		setVisible(true);
	}
	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return this;
	}


}

