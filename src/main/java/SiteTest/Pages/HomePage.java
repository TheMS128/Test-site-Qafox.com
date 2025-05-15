package SiteTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    protected void findElementWithInput(String searchRequest) {
        WebElement input = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
        input.sendKeys(searchRequest, Keys.ENTER);
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getSiteTitle() {
        return driver.findElement(By.xpath("//h1/a")).getText();
    }

    public List<WebElement> getMenuElements() {
        return driver.findElements(By.xpath("//ul[@class=\"nav navbar-nav\"]/li/a"));
    }

    public String getCartText() {
        return driver.findElement(By.xpath("//div[@class=\"col-sm-3\"]//span[@id=\"cart-total\"]"))
                .getText();
    }

    public List<WebElement> getSearchPanel() {
        return driver.findElements(By.xpath("//div[@class=\"col-sm-5\"]"));
    }

    public List<WebElement> getElementsFromSearchPage(String searchRequest) {
        findElementWithInput(searchRequest);
        List<WebElement> elements = List.of();
        try {
            elements = driver.findElements(By
                    .xpath("//div[@class=\"row\"][3]//div[@class=\"product-thumb\"]"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return elements;
    }
}
