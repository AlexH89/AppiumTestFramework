package apiDemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import io.appium.java_client.AppiumDriver;

public class CodePreferencePage extends BasePage {

    @FindBy(xpath = "//android.widget.CheckBox[@index='0']")
    private WebElement checkBox;

    public CodePreferencePage(AppiumDriver driver) {
        super(driver);
    }

    public void toggleCheckBox() {
        checkBox = swipeToSelectLastCheckbox();
        click(checkBox);
    }

    public boolean checkBoxIsChecked() {
        checkBox = swipeToSelectLastCheckbox();
        return checkBox.getAttribute("checked").equals("true");
    }

    private WebElement swipeToSelectLastCheckbox() {
        getElement(checkBox).waitUntilPresent("Could not find first checkBox");
        actionSwipe(954, 1656, 954, 360);
        return driver.findElement(By.xpath("//android.widget.CheckBox[@index='0']"));
    }
}
