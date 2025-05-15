package SiteTest;

import SiteTest.Pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Test {
    ChromeDriver driver;
    HomePage homePage;

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
    public void testSiteTitle() {
        String expectedSiteTitle = "Your Store";
        String actualSiteTitle = homePage.getSiteTitle();
        Assert.assertEquals(expectedSiteTitle, actualSiteTitle);
    }

    @org.junit.Test
    public void testShouldHaveTwoMainSliderWrappers() {
        int expectedNumberElements = 2;
        int actualNumberElements = homePage.getMainSliderWrappers().size();
        Assert.assertEquals(expectedNumberElements, actualNumberElements);
    }
}
