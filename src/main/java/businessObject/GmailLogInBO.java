package businessObject;

import model.UserModel;
import pageObjects.GmailLoginPO;

public class GmailLogInBO {

    public void logIn(UserModel user){
        GmailLoginPO gmailLoginPO = new GmailLoginPO();
        gmailLoginPO.logIn(user.getLogin(),user.getPassword());
    }

}
