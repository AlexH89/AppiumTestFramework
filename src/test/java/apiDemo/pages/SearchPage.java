package apiDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Invoke Search']")
    private WebElement invokeSearchMenuButton;

    public SearchPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickInvokeSearchMenuButton() {
        click(invokeSearchMenuButton);
    }
}
