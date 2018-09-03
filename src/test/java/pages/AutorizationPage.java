package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AutorizationPage extends BasePage {

    /**blocks*/
    private static final By autorizationBlock = By.cssSelector("div.autorization__login");
    private static final By autorizationSocialBlock = By.cssSelector("div.autorization__social");
    private static final By registrationBlockInvite = By.cssSelector("div.autorization__reg-invite");
    /** Autorization Block */
    private static final By emailInput = By.cssSelector("input[id='login_']");
    private static final By passwordInput = By.cssSelector("input[id='pass_field']");
    private static final By autorizationSubmitBtn = By.cssSelector("input[id='submit-login']");
    private static final By saveMe = By.cssSelector("label[for='saveme']");
    private static final By restorePasswordLink = By.cssSelector("div.extpp_row_saveme a");
    /** Autorization Social Block */
    private static final By socialsBtn = By.cssSelector("a[data-category='button']");
    /** Registration Invite Block */
    private static final By registrationBtn = By.cssSelector("span.reg-btn a");

    public AutorizationPage(WebDriver driver) {
        super(driver);
        shortWait.until(ExpectedConditions.visibilityOfElementLocated(autorizationBlock));
    }

    public void validateElementsOnPage(){
        assertTrue("Форма авторизовации не отображается", isElementDisplayed(autorizationBlock));
        assertTrue("Форма авторизации через соц. сети не отображается", isElementDisplayed(autorizationSocialBlock));
        assertTrue("Форма предложения регистрации не отображается", isElementDisplayed(registrationBlockInvite));

        assertEquals("Заголовок страницы не соответствует", "Авторизация на сайте", getElement(pageTitle).getText());

        /** Autorization Block */
        assertTrue("Поле для ввода e-mail не отображается", isElementDisplayed(emailInput));
        assertTrue("Поле для ввода пароля не отображается", isElementDisplayed(passwordInput));
        assertTrue("Кнопка авторизации не отображается", isElementDisplayed(autorizationSubmitBtn));
        assertTrue("Чекбокс 'Запомнить' не отображается", isElementDisplayed(saveMe));
        assertTrue("Ссылка на восстановление пароля не отображается", isElementDisplayed(restorePasswordLink));

        /** Autorization Social Block */
        assertEquals("Количество кнопок соцсетей отличается от ожидаемого", 6, getElements(socialsBtn).size());

        /** Registration Invite Block */
        assertTrue("Кнопка регистрации не отображается", isElementDisplayed(registrationBtn));

    }


}
