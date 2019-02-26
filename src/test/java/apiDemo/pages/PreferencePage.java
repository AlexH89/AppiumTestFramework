package apiDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class PreferencePage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='5. Preferences from code']")
    private WebElement codePreferenceMenuButton;

    public PreferencePage(AppiumDriver driver) {
        super(driver);
    }

    public void clickCodePreferenceMenuButton() {
        click(codePreferenceMenuButton);
    }
}
