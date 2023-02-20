package gui_v1.testers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;


public class GUI_Testing_Ideas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static  void decreaseFont(Component c, String element) {

		System.out.println("TestingIdeas_decrisej\n"+c.getClass().getSimpleName()+"\n----------------\n");
	if(((Container)c).getComponentCount()>0){
		for(Component children: ((Container) c).getComponents()) {
			decreaseFont(children, element);
		}
	}
	if(c.getClass().getSimpleName().compareToIgnoreCase(element)==0) {
		c.setFont(new java.awt.Font(c.getFont().getFontName(), c.getFont().getStyle(), c.getFont().getSize()-1));

	}
}
public static  void increaseFont(Component c, String element) {
	System.out.println("TestingIdeas_incrisej\n"+c.getClass().getSimpleName()+"\n----------------\n");

	if(((Container)c).getComponentCount()>0){
		for(Component children: ((Container) c).getComponents()) {
			increaseFont(children, element);
		}
	}
	if(c.getClass().getSimpleName().compareToIgnoreCase(element)==0) {
		c.setFont(new java.awt.Font(c.getFont().getFontName(), c.getFont().getStyle(), c.getFont().getSize()+1));

	}
}
	public static  void setFontColor(Component c, Color color) {
		if(((Container)c).getComponentCount()>0){
			for(Component children: ((Container) c).getComponents()) {
				setFontColor(children, color);
			}
		}
		if(c.getClass().getSimpleName().compareToIgnoreCase("element")==0) {
			c.setForeground(color);
		}
	}
	public static  void setBackgroundColor(Component c, Color color) {
		if(((Container)c).getComponentCount()>0){
			for(Component children: ((Container) c).getComponents()) {
				setBackgroundColor(children, color);
			}
		}
		if(c.getClass().getSimpleName().compareToIgnoreCase("element")==0) {
			c.setBackground(color);
		}
	}
//	public static void defaultBackgroundColor(Component c, String elementSimpleName) {
//	switch(c.getClass().getSimpleName()){
//	case "gui_element":
//		setBackgroundColor(getComponent(), colorJTextAreaBackground, "JTextArea");
//		break;
//	case "JTextField":
//		setBackgroundColor(getComponent(), colorForJTFBackground, "JTextField");
//		break;
//	case "JLabel":
//		setBackgroundColor(getComponent(), colorForLabelsBackground, "JLabel");
//
//		break;
//	case "JComboBox":
//		setBackgroundColor(getComponent(), coloForComoboxesBackground, "JComboBox");
//		break;
//	case "JButton":
//		setBackgroundColor(getComponent(), colorForBtnsBackground, "JButton");
//		break;
//	case "JPanel":
//		getComponent().setBackground(colorForPanelsBackgroud);
//		break;
//	case "1":
////		chooseFontColorFor(getComponent(), "JTextArea", colorJTextAreaFont);
//		break;
//	case "2":
//		break;
//	}

}
//}

//public default void setFontColor(Component c, Color color, String element) {
//	if(((Container)c).getComponentCount()>0){
//		for(Component children: ((Container) c).getComponents()) {
//			setFontColor(children, color, element);
//		}
//	}
//	if(c.getClass().getSimpleName().compareToIgnoreCase(element)==0) {
//		c.setForeground(color);
//	}
//}
//public default void setBackgroundColor(Component c, Color color, String element) {
//	if(((Container)c).getComponentCount()>0){
//		for(Component children: ((Container) c).getComponents()) {
//			setBackgroundColor(children, color, element);
//		}
//	}
//	if(c.getClass().getSimpleName().compareToIgnoreCase(element)==0) {
//		c.setBackground(color);
//	}
//}
//}
