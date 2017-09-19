package IstTask;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;


public class TestGoogleTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void googleTest() throws Exception {
        driver.get("http://www.google.com");
        WebElement googleSearch = driver.findElement(By.name("q"));
        googleSearch.sendKeys("Svieta Chaplinska instagram");
        googleSearch.submit();

        List<WebElement> tagsList = new ArrayList<>();
        tagsList = driver.findElements(By.tagName("a"));
        tagsList.forEach(webElement -> System.out.println(webElement.getText()));

        List<WebElement> titlesList = new ArrayList<>();
        titlesList = driver.findElements(By.tagName("h3"));
        titlesList.forEach(webElement -> System.out.println(webElement.getText()));

        WebElement secondPage = driver.findElement(By.cssSelector("#nav > tbody > tr > td:nth-child(3) > a"));
        secondPage.click();
    }
}