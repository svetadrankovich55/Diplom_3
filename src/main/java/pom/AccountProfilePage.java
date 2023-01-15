package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountProfilePage {

    private final String urlAccountProfilePage = "https://stellarburgers.nomoreparties.site/account/profile";

    //Раздел профиль
    private final By sectionProfile = By.linkText("Профиль");
    //Раздел история заказов
    private final By sectionLogOfOrders = By.linkText("История заказов");
    //Кнопка "Выход"
    private final By buttonExit = By.xpath("//button[text() = 'Выход']");

    //Кнопка "Конструктор"
    private final By buttonConstructor = By.xpath("//p[text() = 'Конструктор']");

    //Кнопка "Лента Заказов"
    private final By buttonOrderFeed = By.xpath("//p[text() = 'Лента Заказов']");

    //Логотип "Stellar Burgers"
    private final By logoStellarBurgers = By.cssSelector(".AppHeader_header__logo__2D0X2 svg");
    private final WebDriver driver;

    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public AccountProfilePage openAccountProfilePage() {
        driver.get(urlAccountProfilePage);
        return this;
    }

    public void waitForLoadElement(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(drv -> (drv.findElement(by).getText() != null && !drv.findElement(by).getText().isEmpty()));
    }

    public AccountProfilePage waitForAccountProfilePage() {
        waitForLoadElement(sectionProfile);
        return this;
    }

    public String getTextSectionProfile() {
        return driver.findElement(sectionProfile).getText();
    }

    public AccountProfilePage clickButtonConstructor() {
        driver.findElement(buttonConstructor).click();
        return this;
    }

    public AccountProfilePage clickLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
        return this;
    }

    public AccountProfilePage clickButtonExit() {
        driver.findElement(buttonExit).click();
        return this;
    }

    public AccountProfilePage goToConstructor() {
        clickButtonConstructor()
                .mainPage()
                .waitForLoadHeadOfMainPage()
                .waitForFirstBun();
        return this;
    }

    public AccountProfilePage goToLogoStellarBurgers() {
        clickLogoStellarBurgers()
                .mainPage()
                .waitForLoadHeadOfMainPage();
        return this;
    }

    public MainPage mainPage() {
        return new MainPage(driver);
    }

    public LoginPage loginPage() {
        return new LoginPage(driver);
    }

}
