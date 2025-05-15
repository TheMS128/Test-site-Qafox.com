package SiteTest.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSiteTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getMainSliderWrappers() {
        return driver.findElements(By.xpath("//div[@class=\"swiper-wrapper\"]"));
    }
}
