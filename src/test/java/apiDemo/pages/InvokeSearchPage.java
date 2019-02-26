package apiDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class InvokeSearchPage extends BasePage {

    @FindBy(xpath = "//android.widget.Button[@text='ONSEARCHREQUESTED()']")
    private WebElement searchButton;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='android:id/search_src_text']")
    private WebElement searchInputField;

    public InvokeSearchPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickSearchButton() {
        click(searchButton);
    }

    public void insertTextAndPressEnter(String text) {
        getElement(searchInputField).sendKeys(text + "\n");
    }
}
