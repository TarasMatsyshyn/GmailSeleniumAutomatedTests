package businessObject;

import pageObjects.GmailImportantMessagePO;

public class GmailDeleteImportantMessagesBO {
    public boolean deleteImportantMessages(){
        GmailImportantMessagePO gmailImportantMessagePO = new GmailImportantMessagePO();
        return gmailImportantMessagePO.deleteFirstThreeMessages();
    }
}
