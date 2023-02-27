package gui_v1.mainWindows;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gui_v1.GUI_MainBoxP;
import gui_v1.menu.GUI_Menu;
import gui_v1.menu.GUI_Menu_Technical;
import gui_v1.settings.GUI_Settings_Variables;
public class GUI_MainWindow extends JFrame implements GUI_Settings_Variables  {
	private static final long serialVersionUID = 1L;
	private static GUI_MainWindow instance=null;
	public static GUI_MainWindow createMainGUIWindow(){
		if(instance==null){
			instance = new GUI_MainWindow();
		}
		return instance;
	}
	 private GUI_MainWindow() {
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

	}
	public static void showMainWindow(){
		createMainGUIWindow();
		instance.setVisible(true);
	}
	public static void hideMainWindow(){
		createMainGUIWindow();
		instance.setVisible(false);
	}
	@Override
	public Component getComponent() {
		// TODO Auto-generated method stub
		return this;
	}


}

