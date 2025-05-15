package SiteTest;

import SiteTest.Pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test {
    ChromeDriver driver;
    HomePage homePage;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");

        homePage = new HomePage(driver);
    }

    @After
    public void driverQuit() {
        driver.quit();
    }

    @org.junit.Test
    public void testPageTitle() {
        String expectedPageTitle = "Your Store";
        String actualPageTitle = homePage.getPageTitle();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    @org.junit.Test
    public void testSiteTitle() {
        String expectedSiteTitle = "Qafox.com";
        String actualSiteTitle = homePage.getSiteTitle();
        Assert.assertEquals(expectedSiteTitle, actualSiteTitle);
    }

    @org.junit.Test
    public void testHaveCartText() {
        String expectedString = "0 item(s) - $0.00";
        String actualString = homePage.getCartText();
        Assert.assertEquals(expectedString, actualString);
    }

    @org.junit.Test
    public void testHave8ElementsInMenu() {
        int expectedNumberElements = 8;
        int actualNumberElements = homePage.getMenuElements().size();
        Assert.assertEquals(expectedNumberElements, actualNumberElements);
    }

    @org.junit.Test
    public void testHaveSearchPanel() {
        int expectedSearchElements = 1;
        int actualSearchElements = homePage.getSearchPanel().size();
        Assert.assertEquals(expectedSearchElements, actualSearchElements);
    }

    @org.junit.Test
    public void testSearchPanelWithMacbookValue() {
        int expectedProductElements = 3;
        String searchRequest = "Macbook";
        int actualProductElements = homePage.getElementsFromSearchPage(searchRequest).size();
        Assert.assertEquals(expectedProductElements, actualProductElements);
    }

    @org.junit.Test
    public void testSearchPanelWithIphoneValue() {
        int expectedProductElements = 1;
        String searchRequest = "iPhone";
        int actualProductElements = homePage.getElementsFromSearchPage(searchRequest).size();
        Assert.assertEquals(expectedProductElements, actualProductElements);
    }

    @org.junit.Test
    public void testSearchPanelWithAppleCinema30Value() {
        int expectedProductElements = 1;
        String searchRequest = "Apple Cinema 30\"";
        int actualProductElements = homePage.getElementsFromSearchPage(searchRequest).size();
        Assert.assertEquals(expectedProductElements, actualProductElements);
    }

    @org.junit.Test
    public void testSearchPanelWithCanonEos5DValue() {
        int expectedProductElements = 1;
        String searchRequest = "Canon EOS 5D";
        int actualProductElements = homePage.getElementsFromSearchPage(searchRequest).size();
        Assert.assertEquals(expectedProductElements, actualProductElements);
    }

    @org.junit.Test
    public void testSearchPanelWithOneSpaceValue() {
        int expectedProductElements = 19;
        String searchRequest = " ";
        int actualProductElements = homePage.getElementsFromSearchPage(searchRequest).size();
        Assert.assertEquals(expectedProductElements, actualProductElements);
    }

    @org.junit.Test
    public void testSearchPanelWithEmptyValue() {
        int expectedProductElements = 0;
        String searchRequest = "";
        int actualProductElements = homePage.getElementsFromSearchPage(searchRequest).size();
        Assert.assertEquals(expectedProductElements, actualProductElements);
    }
}
