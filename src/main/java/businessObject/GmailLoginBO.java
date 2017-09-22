package businessObject;

import model.UserModel;
import pageObjects.GmailLoginPO;

public class GmailLoginBO {
    private  GmailLoginPO gmailLoginPO = new GmailLoginPO();

    public boolean login(String login, String password){
        try {
            gmailLoginPO.typeLogin(login);
            gmailLoginPO.typePassword(password);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
