package gui_v1.action_processors;

import javax.swing.*;
import java.io.File;

/**
 *  THis is class for static method file chooser,
 *  to allow user ot choose OFX file for parsing
 */
public class GUI_FileChooser {
   static  public File getFileOrDirectory(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        //if user clicked Cancel button
        if(result == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No File Was Selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
        File file = fileChooser.getSelectedFile();

        if((file ==null)||(file.getName().equals(""))){
            JOptionPane.showMessageDialog(null, "Invalid Name", "Invalid Name", JOptionPane.ERROR_MESSAGE);
        }
        return file;
    }
    static  public File getFileOrDirectory(File dir){
        JFileChooser fileChooser = new JFileChooser(dir);
        fileChooser.setCurrentDirectory(dir);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        //if user clicked Cancel button
        if(result == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No File Was Selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
        File file = fileChooser.getSelectedFile();

        if((file ==null)||(file.getName().equals(""))){
            JOptionPane.showMessageDialog(null, "Invalid Name", "Invalid Name", JOptionPane.ERROR_MESSAGE);
        }
        return file;
    }

}
