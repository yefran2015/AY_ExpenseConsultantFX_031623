package gui_v1.menu;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import gui_v1.action_processors.GUI_Menu_Actions;
import gui_v1.automation.GUI_ElementCreator;
import gui_v1.settings.GUI_Settings_Variables;

import java.io.Serial;

public class GUI_Menu extends JMenuBar implements GUI_Settings_Variables{
	@Serial
	private static final long serialVersionUID = 1L;


	public GUI_Menu(){
		if(gui_v1.settings.GUI_Static_Settings.workStage==0){
			setBackground(clrB_JMenuBar);
		}else{
			setForeground(clrF_JMenuBar);
		}
		final GUI_Menu_Actions a;

		setFont(GUI_ElementCreator.newFont(this.getFont(), txtSize_JMenuBar));
		a = new GUI_Menu_Actions();

		JMenu jmFile = GUI_ElementCreator.newJMenu("File");
		jmFile.setMnemonic('F');
		JMenuItem jmiSave = GUI_ElementCreator.newJMenuItem("Save");
		jmiSave.setMnemonic('v');
		jmFile.add(jmiSave);
		JMenuItem jmiLoad = GUI_ElementCreator.newJMenuItem("Load");
		jmiLoad.setMnemonic('L');
		jmFile.add(jmiLoad);
		jmFile.add(new JSeparator());
		JMenuItem jmiExit = GUI_ElementCreator.newJMenuItem("Exit");
		jmiExit.setMnemonic('E');
		jmFile.add(jmiExit);
		add(jmFile);
		jmiExit.addActionListener(a);


		
		
		JMenu jmAction = GUI_ElementCreator.newJMenu("Transactions" );
		jmAction.setMnemonic('T');
		jmAction.addActionListener(a);


		JMenu jmVMenu = GUI_ElementCreator.newJMenu("Menu");
		jmVMenu.setMnemonic('M');

		JMenuItem jmiHowStart = GUI_ElementCreator.newJMenuItem("How To Start");
		jmiHowStart.setMnemonic('S');
		jmiHowStart.addActionListener(a);
		jmVMenu.add(jmiHowStart);

		JMenuItem jmiParseOFX = GUI_ElementCreator.newJMenuItem("Parse OFX File");
		jmiParseOFX.setMnemonic('P');
		jmiParseOFX.addActionListener(a);
		jmVMenu.add(jmiParseOFX);

		JMenuItem jmiAddDataManually = GUI_ElementCreator.newJMenuItem("Manual Entry");
		jmiAddDataManually.setMnemonic('M');
		jmiAddDataManually.addActionListener(a);
		jmVMenu.add(jmiAddDataManually);

		JMenuItem jmiSummery = GUI_ElementCreator.newJMenuItem("Generate Summary");
		jmiSummery.setMnemonic('S');
		jmiSummery.addActionListener(a);
		jmVMenu.add(jmiSummery);

		JMenuItem jmiAdvising = GUI_ElementCreator.newJMenuItem("Get Advise");
		jmiAdvising.setMnemonic('G');
		jmiAdvising.addActionListener(a);
		jmVMenu.add(jmiAdvising);

		JMenuItem jmiSettings = GUI_ElementCreator.newJMenuItem("Settings");
		jmiSettings.setMnemonic('S');
		jmiSettings.addActionListener(a);
		jmVMenu.add(jmiSettings);

		JMenuItem jmiLogOuut = GUI_ElementCreator.newJMenuItem("LogOut" );
		jmiLogOuut.addActionListener(a);
		jmiLogOuut.setMnemonic('O');
		jmVMenu.add(jmiLogOuut);

		add(jmVMenu);

		JMenu jmHelp = GUI_ElementCreator.newJMenu("Help" );
		jmHelp.setMnemonic('H');

		JMenuItem jmiAbout = GUI_ElementCreator.newJMenuItem("About");
		jmiAbout.setMnemonic('A');
		jmiAbout.addActionListener(a);
		jmHelp.add(jmiAbout);
		add(jmHelp);
	}
}
