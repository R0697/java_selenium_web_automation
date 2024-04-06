package baseTest;

import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.time.Duration;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {

    public static WebDriver driver;
    public static Properties property;

    public BaseTest() {
        property = new Properties();
        try {
            InputStream configFilePath = new FileInputStream("/Users/rahilranpura/Desktop/Automation_Practical/src/main/java/config/config.properties");
            property.load(configFilePath);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeClass
    public void activateBrowser() {

        String browser = property.getProperty("browser");
        try {
            if (browser.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
            driver.get(property.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
            driver.manage().deleteAllCookies();
        } catch(NoSuchWindowException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void closeBrowser()
    {
        driver.quit();
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String browserVersion() {
        String browser = property.getProperty("browser");
        String version = null;
        if(browser.equalsIgnoreCase("chrome")) {
            Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
            version = cap.getBrowserVersion();
        } else if(browser.equalsIgnoreCase("firefox")) {
            Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
            version = cap.getBrowserVersion();
        } else if(browser.equalsIgnoreCase("edge")) {
            Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
            version = cap.getBrowserVersion();
        }
        return version;
    }
}
