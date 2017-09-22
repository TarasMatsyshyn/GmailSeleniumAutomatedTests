package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import utils.SingletonChromeConnection;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GmailInputMessagesPO extends PageObject {

    @FindAll({@FindBy(className = "pG")})
    private List<WebElement> importantMessageIcons;

    public void markMessages(){
        for (int i = 0; i < 3; i++) {
            importantMessageIcons.get(i).click();
        }
    }

    public void goToImportant(){
        ChromeDriver chromeDriver = SingletonChromeConnection.getDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        chromeDriver.findElement(By.xpath("//div[@class=\"TN GLujEb aHS-bns\"]//a")).click();
    }
}
