package pageObjects;

import controls.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPO extends PageObject {

    @FindBy(xpath = "//*[@id=\"identifierId\"]")
    private WebElement loginInput;

    @FindBy(xpath = "//*[@id=\"identifierNext\"]/content")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div[2]")
    private WebElement passwordButton;

    public void logIn(String email, String password){
        loginInput.sendKeys(email);
        loginButton.click();

        passwordInput.sendKeys(password);
//        passwordButton.click();
    }
}
