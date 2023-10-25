package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utils.Attributes;
import utils.Waiter;

public class LoginPage extends BasePage {
    @AndroidFindBy(id = "tvTitle")
    private WebElement title;
    @AndroidFindBy(id = "etUsername")
    private WebElement loginInput;
    @AndroidFindBy(id = "etPassword")
    private WebElement passwordInput;
    @AndroidFindBy(id = "btnConfirm")
    private WebElement loginButton;
    @AndroidFindBy(id = "tvError")
    private WebElement errorMessage;

    public String getTitle() {
        return title.getText();
    }

    @Step("")
    public LoginPage enterUsername(String login) {
        loginInput.clear();
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public String getEnteredLogin() {
        return loginInput.getAttribute(Attributes.TEXT);
    }

    public String getErrorMessage() {
        return Waiter.waitForElementToBeVisibleWithText(errorMessage).getText();
    }
}
