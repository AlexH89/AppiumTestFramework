package apiDemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiDemo.pages.ButtonsPage;
import apiDemo.pages.HomePage;
import apiDemo.pages.ViewsPage;

public class ButtonTests extends BaseTest {

    @Test
    public void toggleButtonToOn() {
        HomePage homePage = new HomePage(driver);
        homePage.clickButton("Views");

        ViewsPage viewsPage = new ViewsPage(driver);
        viewsPage.clickButtonsButton();

        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.clickToggleButton();
        Assert.assertTrue(buttonsPage.toggleButtonIsOn(), "Toggle button is not switched on");
    }
}
