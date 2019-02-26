package apiDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class ButtonsPage extends BasePage {

    @FindBy(className = "android.widget.ToggleButton")
    private WebElement toggleButton;

    public ButtonsPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickToggleButton() {
        click(toggleButton);
    }

    public boolean toggleButtonIsOn() {
        return toggleButton.getAttribute("text").equals("ON");
    }
}
