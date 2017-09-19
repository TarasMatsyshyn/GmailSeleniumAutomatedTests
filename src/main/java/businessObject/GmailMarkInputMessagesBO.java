package businessObject;

import pageObjects.GmailInputMessagesPO;

public class GmailMarkInputMessagesBO {
    public void markMessagesAsImportant(){
        GmailInputMessagesPO gmailInputMessagesPO = new GmailInputMessagesPO();
        gmailInputMessagesPO.markMessages();
    }
}
