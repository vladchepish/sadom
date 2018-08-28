package lib.BaseClass;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BaseTestClass {

    public static WebDriver webDriver;
    protected static Properties properties;
    public static String baseUrl;

    @BeforeClass
    public static void openUrl(){
        setProperties();
        webDriver = startNewDriver();
    }

    private static WebDriver startNewDriver() {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());

        // Проброс - который определяет, задаёт параметры хрому в зависимости от того, в какой операционной системе выполняются тесты
        if(isWindows()){
            ChromeDriverManager.getInstance().setup();
            return new ChromeDriver(capability);
        }

        capability.setCapability("screenResolution", "1920x1080x24");
        capability.setCapability("enableVNC", true);
        capability.setCapability("timeZone", "Europe/Moscow");

        return new RemoteWebDriver();
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

    private static void setProperties() {
        properties = new Properties();
        try {
            properties.load(new InputStreamReader(BaseTestClass.class.getClassLoader().getResourceAsStream("config.properties"), "UTF-8"));
        } catch (IOException e) {
            System.out.println("Can't load 'config.properties'");
        }
        baseUrl = properties.getProperty("url");
    }

    public static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        // windows
        return (os.indexOf("win") >= 0);
    }
}
