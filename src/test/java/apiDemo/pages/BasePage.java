package apiDemo.pages;

import apiDemo.elements.Element;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;

public class BasePage {

    protected AppiumDriver driver;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 0, TimeUnit.SECONDS), this);
    }

    protected Element getElement(WebElement element) {
        return new Element(element);
    }

    protected void click(WebElement element) {
        getElement(element).click();
    }

    protected void actionSwipe(int startx, int starty, int endx, int endy) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(point(startx, starty))
                .waitAction(waitOptions(ofMillis(3000))).moveTo(point(endx, endy))
                .release().perform();
    }

    protected Boolean isAndroid(AppiumDriver driver) {
        return !driver.getPlatformName().equals("iOS");
    }
}