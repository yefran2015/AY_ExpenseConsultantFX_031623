package guiFX.input_validators;

/**
 * @version 0.0.1
 * @serial 02161270
 * @author Andrey Yefremov
 *
 * This class is part of ICS499 Capston Team project.
 * SPAM Team has 3 persons: Pavel, Sam, and Andrey.
 * This class job is to evaluate user entered data.
 *
 */
public class UserInputCheckers {
    public boolean isLoginNameAcceptable(String login_to_chek){
        if(login_to_chek.length()<2){
            return false;
        }

        return true;
    }

}
