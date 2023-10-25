package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utils.AppiumManager;

public abstract class BaseTest {

    @BeforeAll
    public static void startService() {
        AppiumManager.startAppiumService();
    }

    @BeforeEach
    public void startTheApp() {
        AppiumManager.getDriver();
    }

    @AfterEach
    public void closeTheApp() {
        AppiumManager.quit();
    }

    @AfterAll
    public static void stopService() {
        AppiumManager.stopAppiumService();
    }
}
