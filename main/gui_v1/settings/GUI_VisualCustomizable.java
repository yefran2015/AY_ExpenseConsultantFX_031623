package gui_v1.settings;

import java.awt.Component;

public interface GUI_VisualCustomizable extends GUI_Settings_Variables{
	default void setVisualSettings(Component c) {
		c.setBackground(allGuiBoxesBackgroundCColor);
		c.setForeground(allGuiBoxesForegroundCColor);
	}

}
