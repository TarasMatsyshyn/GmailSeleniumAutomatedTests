package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.SingletonChromeConnection;

import java.util.concurrent.TimeUnit;

public class GmailImportantMessagePO {
    private ChromeDriver driver = SingletonChromeConnection.getDriver();

    public boolean deleteFirstThreeMessages(){
        goToImportantMessages();
        selectFirstThreeCheckButtons();
        deleteCheckedMessages();
        return true;
    }

    private void goToImportantMessages(){
       SingletonChromeConnection.getDriver().findElement(By.xpath("//*[@id=\":iy\"]/div/div[2]")).click();
    }

    private void selectFirstThreeCheckButtons(){
       driver.findElement(By.cssSelector("#\\3a l7 > div")).click();
       driver.findElement(By.cssSelector("#\\3a li > div")).click();
       driver.findElement(By.cssSelector("#\\3a lt > div")).click();
    }

    private void deleteCheckedMessages(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\":5\"]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div/div")).click();
    }
}
