package pages;

import junit.framework.TestCase;
import lib.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BasePage extends TestCase{

    protected WebDriver driver;
    protected WebDriverWait loadingWait;
    protected WebDriverWait shortWait;
    protected WebDriverWait actionWait;
    protected WebDriverWait betWait;
    protected WebDriverWait defaultWait;
    /** Upper menu */
    protected static final By logoImg = By.cssSelector("img[itemprop='logo']");
    protected static final By searchInput = By.cssSelector("input.search_input");
    protected static final By searchSubmitBtn = By.cssSelector("button.b-search__submit");
    protected static final By wishListLink = By.cssSelector("a.js-go-to-whishlist");
    protected static final By cart = By.cssSelector("a.b-cart");
    protected static final By enterLink = By.cssSelector("a.b-top-bar__sign-in");
    protected static final By registrationLink = By.cssSelector("a.b-top-bar__sign-up");
    /** Pages */
    protected static final By pageTitle = By.cssSelector("h1.b-page__title");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.shortWait = new WebDriverWait(driver, Timeout.shortTimeout);
        this.defaultWait = new WebDriverWait(driver, Timeout.defaultTimeout);
        this.actionWait = new WebDriverWait(driver, Timeout.action);
        this.loadingWait = new WebDriverWait(driver, Timeout.loading);
        this.betWait = new WebDriverWait(driver, Timeout.betTimeout);
    }

    public WebElement getElement(By by){
        return driver.findElement(by);
    }

    public List<WebElement> getElements(By by){
        try {
            return driver.findElements(by);
        } catch (InvalidSelectorException e) {
            return new ArrayList<WebElement>(); //empty list
        }
    }

    public void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e){
            //
        }
    }

    public void click(By by){
        driver.findElement(by).click();
    }

    protected boolean isElementDisplayed(By by) {
        try {
            getElement(by).isDisplayed();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    protected void findElementAndTypeText(By by, String text){
        getElement(by).click();
        getElement(by).clear();
        getElement(by).sendKeys(text);
    }
}
