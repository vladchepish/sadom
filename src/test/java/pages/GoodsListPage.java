package pages;

import lib.obj.Good;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class GoodsListPage extends BasePage {

    private static final By catalogProductContainer = By.cssSelector("div[id='catalogProductsContainer']");
    private static final By product = By.cssSelector("li.b-products__item");
    private static final By productName = By.cssSelector("a.b-products-item__name-link");
    private static final By productPrice = By.cssSelector("div.b-products-item__price");
    private static final By productStatus = By.cssSelector("div.b-products-item__availability");
    private static final By productSeller = By.cssSelector("span.truncated-text");
    private static final By productCity = By.cssSelector("div.b-products-item__town");

    public GoodsListPage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(catalogProductContainer));
    }

    public Good openFirstGoodFromList() {
        List<WebElement> goodsList = getElements(product);
        Good good = getGood(goodsList.get(0));
        goodsList.get(0).findElement(productName).click();

        return good;
    }

    private Good getGood(WebElement good) {
        String name = good.findElement(productName).getText();
        String price = good.findElement(productPrice).getText();
        String status = good.findElement(productStatus).getText();
        String seller = good.findElement(productSeller).getText();
        String city = good.findElement(productCity).getText();

        return new Good(name, price, status, seller, city);
    }
}
