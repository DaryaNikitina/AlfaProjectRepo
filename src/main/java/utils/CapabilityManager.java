package utils;

import constants.CapabilitiesConstants;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilityManager {

    public CapabilityManager() {
    }

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, CapabilitiesConstants.DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, CapabilitiesConstants.PLATFORM);
        capabilities.setCapability(MobileCapabilityType.APP, CapabilitiesConstants.APP);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, CapabilitiesConstants.AUTOMATION_NAME);
        capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, CapabilitiesConstants.APP_WAIT_ACTIVITY);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_DURATION, "10000");

        return capabilities;
    }
}
