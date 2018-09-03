package tests.autorization;

import lib.BaseClass.BaseTestClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.MainPage;
import pages.AutorizationPage;

public class AutorizationPageElementValidation extends BaseTestClass {

    private static MainPage mainPage;
    private static AutorizationPage autorizationPage;

    @BeforeClass
    public static void beforeClassMethod(){
        mainPage = new MainPage(webDriver);
    }

    @Test
    public void testRegistrationPageElementsValidation(){
        autorizationPage = mainPage.goToAutorizationPage();
        autorizationPage.validateElementsOnPage();
    }

}
