package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SingletonChromeConnection;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GmailImportantMessagePO {
    private ChromeDriver driver = SingletonChromeConnection.getDriver();

    @FindAll(@FindBy(xpath = "//div[@role=\"checkbox\"]"))
    public List<WebElement> checkboxes;

    public GmailImportantMessagePO() {
        WebDriver webDriver = SingletonChromeConnection.getDriver();
        PageFactory.initElements(webDriver,this);
    }

    public boolean deleteFirstThreeMessages(){
        selectFirstThreeCheckButtons();
        deleteCheckedMessages();
        return true;
    }

    private void selectFirstThreeCheckButtons(){
            for (int i = 0; i < 3; i++) {
                checkboxes.get(i).click();
            }
    }

    private void deleteCheckedMessages(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\":5\"]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div/div")).click();
    }
}
