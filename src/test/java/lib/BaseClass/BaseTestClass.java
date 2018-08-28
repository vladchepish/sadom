package lib.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTestClass {

    public static WebDriver webDriver;
    private static String browser;
    public static String baseUrl;
    protected static Properties properties;

    @BeforeClass
    public static void openUrl() {
        setProperties();
        browser = System.getProperty("browser", "chrome");
        webDriver = startNewDriver();
        webDriver.manage().timeouts().implicitlyWait(200, TimeUnit.MILLISECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        webDriver.get(baseUrl);
    }

    @AfterClass
    public static void afterClass() {
        webDriver.quit();
    }


    private static synchronized void setProperties() {
        properties = new Properties();
        try {
            properties.load(new InputStreamReader(BaseTestClass.class.getClassLoader().getResourceAsStream("config.properties"), "UTF-8"));
        } catch (IOException e) {
            System.out.println("Can't load 'config.properties'");
        }
        baseUrl = properties.getProperty("url");
    }

    private static WebDriver startNewDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if(isWindows()){
            switch (browser){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                case "opera":
                    WebDriverManager.operadriver().setup();
                    return new OperaDriver();
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver(getChromeOptions());
            }
        }
        capabilities.setBrowserName(browser);
        capabilities.setJavascriptEnabled(true);
        capabilities.setCapability(ChromeOptions.CAPABILITY,getChromeOptions());
        capabilities.setCapability("screenResolution", "1920x1080x24");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("timeZone", "Europe/Moscow");

        return new RemoteWebDriver(capabilities);
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    private static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.indexOf("win") >= 0);
    }
}
