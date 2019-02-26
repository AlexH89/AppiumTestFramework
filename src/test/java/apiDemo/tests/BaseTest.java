package apiDemo.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    private AppiumDriverLocalService appiumService;
    protected AppiumDriver driver;

    @BeforeClass
    public void beforeClass() {
        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();

        if (appiumService == null || !appiumService.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started!");
        }
    }

    private static DesiredCapabilities createCapabilities(String platformProperty,
                                                          Map<String, String> attributes) throws FileNotFoundException {
        FileReader file = new FileReader("src/test/java/apiDemo/config/platforms.yml");
        Map<String, Object> platforms = (Map<String, Object>) new Yaml().load(file);
        Map<String, Object> platform = (Map<String, Object>) platforms.get(platformProperty);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        for (String key : platform.keySet()) {
            String customValue = null;
            for (String attribute : attributes.keySet()) {
                if (attribute.equals(key) && attributes.get(attribute) != null) {
                    customValue = attributes.get(attribute);
                }
            }
            capabilities.setCapability(key, customValue == null ? platform.get(key) : customValue);
        }

        capabilities.setCapability("avd", capabilities.getCapability("deviceName"));
        capabilities.setCapability("noReset", true);

        return capabilities;
    }

    @BeforeMethod
    public void setup(Method method) throws MalformedURLException, FileNotFoundException {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("platformName", System.getProperty("platform.name"));
        attributes.put("platformVersion", System.getProperty("platform.version"));
        attributes.put("deviceName", System.getProperty("device.name"));

        String platformProperty = System.getProperty("platform");
        String platform = (platformProperty != null) ? platformProperty : "androidAppLocal";

        DesiredCapabilities capabilities = createCapabilities(platform, attributes);
        driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String status = result.isSuccess() ? "Test passed" : "Test failed";
        System.out.println(status);
        driver.quit();
    }

    @AfterSuite
    public void stopAppiumServer() {
        if (appiumService != null) {
            appiumService.stop();
        }
    }
}
