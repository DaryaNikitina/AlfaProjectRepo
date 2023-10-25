package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.util.concurrent.TimeUnit;

public class AppiumManager {
    private static AppiumDriver appiumDriver;
    private static AppiumDriverLocalService appiumService;

    private AppiumManager() {
    }

    private static AppiumDriver createDriver() {
        appiumDriver = new AppiumDriver(appiumService, CapabilityManager.getCapabilities());
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return appiumDriver;
    }

    public static AppiumDriver getDriver() {
        if (appiumDriver == null) {
            appiumDriver = createDriver();
        }
        return appiumDriver;
    }

    public static void quit() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }

    public static void startAppiumService() {
        if (appiumService == null || !appiumService.isRunning()) {
            AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
            serviceBuilder.withIPAddress("0.0.0.0");
            serviceBuilder.usingPort(4723);
            serviceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "info");
            appiumService = AppiumDriverLocalService.buildService(serviceBuilder);
            appiumService.start();
        }
    }

    public static void stopAppiumService() {
        if (appiumService != null && appiumService.isRunning()) {
            appiumService.stop();
        }
    }
}
