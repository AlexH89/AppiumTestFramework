package apiDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='io.appium.android.apis:id/txt_query']")
    private WebElement queryField;

    public SearchResultPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean searchQueryEqualsDisplayedQuery(String searchQuery) {
        getElement(queryField).waitUntilPresent("Could not find query field");
        return queryField.getAttribute("text").equals(searchQuery);
    }
}
