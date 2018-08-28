package tests;

import lib.BaseClass.BaseTestClass;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;

public class CheckingMainPageTest extends BaseTestClass {

    @Test
    public void testFirst(){
        assertTrue("Logo don't displayed", isLogoDisplayed());
    }

    private boolean isLogoDisplayed() {
        try {
            webDriver.findElement(By.cssSelector("img.b-top-bar__logo-img"));
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
