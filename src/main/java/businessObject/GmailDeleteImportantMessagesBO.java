package businessObject;

import pageObjects.GmailImportantMessagePO;

public class GmailDeleteImportantMessagesBO {
    public void deleteImportantMessages(){
        GmailImportantMessagePO gmailImportantMessagePO = new GmailImportantMessagePO();
        gmailImportantMessagePO.goToImportant();
        gmailImportantMessagePO.selectFirstThreeCheckButtons();
        gmailImportantMessagePO.deleteCheckedMessages();
    }
}
