package apiDemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiDemo.pages.CodePreferencePage;
import apiDemo.pages.HomePage;
import apiDemo.pages.PreferencePage;

public class DataPersistenceTests extends BaseTest {

    @Test
    public void tickCheckBoxAndAssertChangeIsPersisted() {
        HomePage homePage = new HomePage(driver);
        homePage.clickButton("Preference");

        PreferencePage preferencePage = new PreferencePage(driver);
        preferencePage.clickCodePreferenceMenuButton();

        CodePreferencePage codePreferencePage = new CodePreferencePage(driver);
        codePreferencePage.toggleCheckBox();

        driver.navigate().back();
        preferencePage.clickCodePreferenceMenuButton();

        Assert.assertTrue(codePreferencePage.checkBoxIsChecked(), "Checkbox state not persisted");
    }
}
