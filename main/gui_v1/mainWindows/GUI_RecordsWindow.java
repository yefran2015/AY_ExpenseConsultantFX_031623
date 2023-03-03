package gui_v1.mainWindows;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import gui_v1.GUI_RecordsBoxP;
import gui_v1.menu.GUI_Menu;
import gui_v1.menu.GUI_Menu_Technical;
import gui_v1.settings.GUI_Settings_Variables;

public class GUI_RecordsWindow extends JFrame implements GUI_Settings_Variables{

	private static final long serialVersionUID = 1L;
	private static GUI_RecordsWindow instance = null;
	private GUI_RecordsWindow() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


//		setBackground(guiFramesBackgroundColor);
//		setForeground(guiFramesForegroundColor);

//		setJMenuBar(new GUI_Menu(this));
		setTitle(recordsGUIWindowTitle);
		if(gui_v1.settings.GUI_Static_Settings.workStage==1){
			setJMenuBar(new GUI_Menu());
		}else{
			setJMenuBar(new GUI_Menu_Technical());
		}
		setSize(recordsGUIWindowFrameSize);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());


		add(new GUI_RecordsBoxP(), BorderLayout.CENTER);

		add(new JLabel(strCopyRigts, JLabel.CENTER), BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int answr = JOptionPane.showOptionDialog(null, "Do you want to terminate run of Consultant", "Cation System termination",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, JOptionPane.NO_OPTION);
				if(answr == JOptionPane.YES_OPTION){
					System.exit(JFrame.EXIT_ON_CLOSE);
				}else{

				}
			}
		});
//		setVisible(true);
	}
	@Override
	public Component getComponent() {
		return this;
	}
	public static GUI_RecordsWindow createRecordViewWindow(){
		if(instance==null){
			instance = new GUI_RecordsWindow();
		}
		return instance;
	}
	public static void showRecordsWindow(){
		createRecordViewWindow();
		instance.setVisible(true);
	}
	public static void hideRecordsWindoww(){
		createRecordViewWindow();
		instance.setVisible(false);
	}
}
