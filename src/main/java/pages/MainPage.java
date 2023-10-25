package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    @AndroidFindBy(xpath = "//*[contains(@text, 'Вход в Alfa-Test выполнен')]")
    private WebElement successMessage;

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}