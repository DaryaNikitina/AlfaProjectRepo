package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.AppiumManager;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppiumManager.getDriver()), this);
    }
}