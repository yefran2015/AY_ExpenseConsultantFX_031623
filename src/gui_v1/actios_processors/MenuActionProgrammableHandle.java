package gui_v1.actios_processors;



import main_logic.PEC;
import main_logic.Request;
import main_logic.Result;

import javax.swing.*;
import java.io.File;
import java.util.ListIterator;

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
        File chosenFile= GUI_FileChooser.getFileOrDirectory();

        if(chosenFile == null ){
            JOptionPane.showMessageDialog(null, "File not Selected","Info", JOptionPane.ERROR_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(null, "OFX Chosen File for pParse is" + chosenFile.getName() ,"About", JOptionPane.INFORMATION_MESSAGE);
            Request request = Request.instance();
            ListIterator<Result> it;
            request.setFileWithPath(chosenFile.getAbsolutePath());
            it = PEC.instance().parseOFX(request);
            // ???
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
