package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    private static final WebDriverWait wait = new WebDriverWait(AppiumManager.getDriver(), Duration.ofSeconds(15));

    public static WebElement waitForElementToBeVisibleWithText(WebElement element) {
        wait.until(x -> !element.getText().isEmpty());
        return element;
    }
}

