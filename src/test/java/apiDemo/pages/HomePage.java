package apiDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class HomePage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Views']")
    private WebElement viewMenuButton;

    @FindBy(xpath = "//android.widget.TextView[@text='App']")
    private WebElement appMenuButton;

    @FindBy(xpath = "//android.widget.TextView[@text='Preference']")
    private WebElement preferenceMenuButton;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    public void clickButton(String text) {
        WebElement elementToClick;
        switch (text) {
            case "App":
                elementToClick = appMenuButton;
                break;
            case "Views":
                elementToClick = viewMenuButton;
                break;
            case "Preference":
                elementToClick = preferenceMenuButton;
                break;
            default:
                elementToClick = viewMenuButton;
        }
        click(elementToClick);
    }
}
