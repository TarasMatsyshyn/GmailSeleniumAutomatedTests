package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SingletonChromeConnection {
    private static ChromeDriver driver = null;

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private SingletonChromeConnection(){
    }

//    public static ChromeDriver getDriver(){
//        if (driver == null){
////            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//            driver = new ChromeDriver(){
//                {
//                    manage().window().maximize();
//                    manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
//                }
//            };
//        }
//        return driver;
//    }

    public static ChromeDriver getDriver(){
        if(webDriverThreadLocal.get()!= null){
            return (ChromeDriver)webDriverThreadLocal.get();
        }
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver instance = new ChromeDriver(){
            {
                manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
            }
        };
        webDriverThreadLocal.set(instance);
        return (ChromeDriver)webDriverThreadLocal.get();
    }

}
