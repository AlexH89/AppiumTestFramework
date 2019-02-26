package apiDemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import apiDemo.pages.AppPage;
import apiDemo.pages.HomePage;
import apiDemo.pages.InvokeSearchPage;
import apiDemo.pages.SearchPage;
import apiDemo.pages.SearchResultPage;

public class SearchQueryTests extends BaseTest {

    @Test
    public void insertTextAndAssertValueAfterwards() {
        HomePage homePage = new HomePage(driver);
        homePage.clickButton("App");

        AppPage appPage = new AppPage(driver);
        appPage.clickSearchMenuButton();

        SearchPage buttonsPage = new SearchPage(driver);
        buttonsPage.clickInvokeSearchMenuButton();

        String searchQuery = "Test123";
        InvokeSearchPage invokeSearchPage = new InvokeSearchPage(driver);
        invokeSearchPage.clickSearchButton();
        invokeSearchPage.insertTextAndPressEnter(searchQuery);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assert.assertTrue(searchResultPage.searchQueryEqualsDisplayedQuery(searchQuery),
                "Displayed query not the same as entered query");
    }
}
