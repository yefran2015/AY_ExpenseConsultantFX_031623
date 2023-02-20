package gui_v1.actios_processors;



import javax.swing.*;
import java.io.File;

public class MenuActionProgrammableHandle {


    void doHowToStartProcessing(){

    }

    /**
     *  this method is
     *  getting file of user choose and
     *  stronger it in File named chosenFile
     *  for future processing..
     *  Code in method is just example of use, how to get file from user, and
     *  can be used anywhere.
     */
    void doParsOFXFileProcessing(){
        File choosenFile= GUI_FileChooser.getFileOrDirectory();
        if(choosenFile == null ){
            JOptionPane.showMessageDialog(null, "File not Selected","Info", JOptionPane.ERROR_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "OFX Choosen File for pParse is" + choosenFile.getName() ,"About", JOptionPane.INFORMATION_MESSAGE);
        }


    }


    void doAdvisingProcessing(){

    }
    void doManualEntryProcessing(){

    }
    void doGenerateSummaryProcessing(){

    }
    void doSettingsProcessing(){

    }
    void dologOutProcessing(){

    }


}
