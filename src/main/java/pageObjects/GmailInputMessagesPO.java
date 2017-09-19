package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GmailInputMessagesPO extends PageObject {

    @FindAll({@FindBy(className = "pG")})
    public List<WebElement> importantMessageIcons;

    public void markMessages(){
        for (int i = 0; i < 3; i++) {
            importantMessageIcons.get(i).click();
        }
    }
}
