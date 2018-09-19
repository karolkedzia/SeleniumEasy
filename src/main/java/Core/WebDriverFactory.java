package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    public WebDriver getWebDriver(String browser) {
        WebDriver driver;
        browser = browser.toLowerCase();

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", Properties.chromeDriver);
            driver = new ChromeDriver();
        } else {
            if (browser.equals("firefox")) {
                System.setProperty("webdriver.chrome.driver", Properties.firefoxDriver);
            } else {
                System.out.println("Error. There is no Webdriver for " + browser);
            }
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
