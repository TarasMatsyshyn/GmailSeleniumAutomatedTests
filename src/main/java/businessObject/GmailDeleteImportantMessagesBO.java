package businessObject;

import pageObjects.GmailImportantMessagePO;

public class GmailDeleteImportantMessagesBO {
    public void deleteImportantMessages(){
        GmailImportantMessagePO gmailImportantMessagePO = new GmailImportantMessagePO();
        gmailImportantMessagePO.selectFirstThreeCheckButtons();
        gmailImportantMessagePO.deleteCheckedMessages();
    }
}
