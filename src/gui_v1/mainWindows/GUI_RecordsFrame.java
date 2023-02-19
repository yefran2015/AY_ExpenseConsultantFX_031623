package gui_v1.mainWindows;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;
import gui_v1.GUI_RecordsBoxP;
import gui_v1.menu.GUI_Menu;
import gui_v1.settings.GUI_Settings_Variables;

public class GUI_RecordsFrame extends JFrame implements GUI_Settings_Variables{

	private static final long serialVersionUID = 1L;
	public GUI_RecordsFrame() {

		setBackground(guiFramesBackgroundColor);
		setForeground(guiFramesForegroundColor);

		setJMenuBar(new GUI_Menu(this));
		setTitle(recordsGUIWindowTitle);
		setSize(recordsGUIWindowFrameSize);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());


		add(new GUI_RecordsBoxP(), BorderLayout.CENTER);

		add(new JLabel(strCopyRigts, JLabel.CENTER), BorderLayout.SOUTH);
		setVisible(true);
	}
	@Override
	public Component getComponent() {
		return this;
	}
}
