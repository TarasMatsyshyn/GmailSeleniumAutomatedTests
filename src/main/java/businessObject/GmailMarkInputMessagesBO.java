package businessObject;

import pageObjects.GmailInputMessagesPO;

public class GmailMarkInputMessagesBO {
    GmailInputMessagesPO gmailInputMessagesPO = new GmailInputMessagesPO();

    public boolean markMessagesAsImportant(){
       try {
           gmailInputMessagesPO.markMessages();
           gmailInputMessagesPO.goToImportant();
       }catch (Exception e){
           return false;
       }
       return true;
    }
}
