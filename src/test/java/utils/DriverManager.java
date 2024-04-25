package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.*;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import static runners.RunnerTest.Platform;

public class DriverManager {

    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    TestUtilities utils = new TestUtilities();

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void initializeDriver() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        URL url;
        AppiumDriver driver = null;
        if (driver == null) {
            switch (Platform){
                case "Android":
                    capabilities.setCapability("platformName", "Android");
                    capabilities.setCapability("automationName", "uiautomator2");
                    capabilities.setCapability("newCommandTimeout", "300000");
                    capabilities.setCapability("autoGrantPermission", true);
                    capabilities.setCapability("noReset", false);
                    capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
                    capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
                    String androidAppPath = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                            "main" + File.separator + "java" + File.separator + "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
                    capabilities.setCapability("app", androidAppPath);
                    url = new URL("http://127.0.0.1:4723/");
                    driver = new AndroidDriver(url, capabilities);
                    utils.log().info("Capabilities set successfully");
                    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(utils.waitImplicit));
                    break;
                case "iOS":
                    capabilities.setCapability("platformName", "iOS");
                    capabilities.setCapability("automationName", "XCUITest");
                    capabilities.setCapability("udid", "");
                    capabilities.setCapability("autoDismissAlerts", true);
                    capabilities.setCapability("bundleId", "com.swaglabsmobileapp");
                    String iOSAppPath = System.getProperty("user.dir") + File.separator + "src" + File.separator +
                            "main" + File.separator + "java" + File.separator + " ";
                    capabilities.setCapability("app", iOSAppPath);
                    url = new URL("http://0.0.0.0:4723");
                    driver = new IOSDriver(url, capabilities);
                    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(utils.waitImplicit));
                    break;
            }
            if (driver == null) {
                throw new Exception("Please set the driver");
            }
//            utils.log().info("Driver initialized");
            DriverManager.driver.set(driver);
        }
    }
}
