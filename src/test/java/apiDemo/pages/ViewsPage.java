package apiDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class ViewsPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Buttons']")
    private WebElement buttonsMenuButton;

    public ViewsPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickButtonsButton() {
        click(buttonsMenuButton);
    }
}
