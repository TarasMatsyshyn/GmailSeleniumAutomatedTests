package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import utils.SingletonChromeConnection;

public class PageObject  {

    public PageObject(WebDriver driver) {
    WebDriver instance = SingletonChromeConnection.getDriver();
    PageFactory.initElements(new DefaultElementLocatorFactory(instance), this);
}

    public PageObject() {
        this(SingletonChromeConnection.getDriver());
    }
}
