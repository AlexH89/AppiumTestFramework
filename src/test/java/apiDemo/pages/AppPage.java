package apiDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class AppPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Search']")
    private WebElement searchMenuButton;

    public AppPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickSearchMenuButton() {
        click(searchMenuButton);
    }
}
