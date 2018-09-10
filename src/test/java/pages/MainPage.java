package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(logoImg));
    }

    public AutorizationPage goToAutorizationPage(){
        click(enterLink);

        return new AutorizationPage(driver);
    }

    public GoodsListPage goodsListPage(){
        return new GoodsListPage(driver);
    }

    public void searchingGoodByName(String text) {
        findElementAndTypeText(searchInput, text);
        click(searchSubmitBtn);
    }
}
