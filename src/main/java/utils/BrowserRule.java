package utils;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserRule extends ExternalResource {
    private WebDriver driver;

    private String yandexDriver = "C:\\WebDriverbinYandex\\bin\\yandexdriver.exe";

    private String chromeDriver = "C:\\WebDriverbin\\bin\\chromedriver.exe";

    private String yandexBrowser = "C:\\Users\\Kotka\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() {

        String browser = System.getenv("browser");
        ChromeOptions options = new ChromeOptions();
        if ("ya".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", yandexDriver);

            options.setBinary(yandexBrowser);
            driver = new ChromeDriver(options);
        } else {
            System.setProperty("webdriver.chrome.driver", chromeDriver);
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Override
    protected void after() {
        driver.quit();
    }

}
