package IstTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GmailTest {
    WebDriver driver = new ChromeDriver(){
        {
            manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        }
    };

    @Test
    public void gmailTest() throws Exception{
        driver.get("http://www.gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("taras.matsyshyn@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();
        driver.findElement(By.name("password")).sendKeys("*******");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span"));
        new Actions(driver).clickAndHold(element).release().perform();
        driver.findElement(By.xpath("//*[@id=\":io\"]/div/div")).click();
        driver.findElement(By.xpath("//*[@id=\":o6\"]")).sendKeys("vasterlord619@gmail.com");
        driver.findElement(By.xpath("//*[@id=\":np\"]")).sendKeys("Privetuli");
        driver.findElement(By.xpath("//*[@id=\":oq\"]")).sendKeys("Yulik darova!");
        driver.findElement(By.xpath("//*[@id=\":nf\"]")).click();
    }
}
