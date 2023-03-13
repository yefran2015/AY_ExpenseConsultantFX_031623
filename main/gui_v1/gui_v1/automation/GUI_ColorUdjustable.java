package gui_v1.automation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

public interface GUI_ColorUdjustable {

	public default void setFontColor(Component c, Color color) {
		if(((Container)c).getComponentCount()>0){
			for(Component children: ((Container) c).getComponents()) {
				setFontColor(children, color);
			}
		}
		if(c.getClass().getSimpleName().compareToIgnoreCase("element")==0) {
			c.setForeground(color);
		}
	}
	public default void setBackgroundColor(Component c, Color color) {
		if(((Container)c).getComponentCount()>0){
			for(Component children: ((Container) c).getComponents()) {
				setBackgroundColor(children, color);
			}
		}
		if(c.getClass().getSimpleName().compareToIgnoreCase("element")==0) {
			c.setBackground(color);
		}
	}
}

