package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.User;

import java.time.Duration;

public class MainPage {

    // URL главной страницы
    private final String urlMainPage = "https://stellarburgers.nomoreparties.site/";

    //Заголовок главной страницы
    private final By headOfMainPage = By.cssSelector(".text_type_main-large");

    //Кнопка "Личный кабинет"
    private final By buttonPersonalAccount = By.xpath("//p[text() = 'Личный Кабинет']");

    //Кнопка "Войти в аккаунт"
    private final By buttonGoToAccount = By.xpath("//button[text() = 'Войти в аккаунт']");

    //Кнопка "Оформить заказ"
    private final By buttonCreateOrder = By.xpath("//button[text() = 'Оформить заказ']");

    //Меню выбора разделов "Булки", "Соусы", "Начинки"
    private final By menuSection = By.xpath("//div[@style]/div[1]");

    //Раздел "Булки"
    private final By bunsSection = By.xpath("//h2[text() = 'Булки']");

    //первая булка
    private final By firstBun = By.xpath("//ul/a[1]");
    //вторая булка

    //Раздел "Соусы"
    private final By saucesSection = By.xpath("//h2[text() = 'Соусы']");

    //Раздел "Начинки"
    private final By fillingSection = By.xpath("//h2[text() = 'Начинки']");
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        driver.get(urlMainPage);
        return this;
    }

    public void waitForLoadElement(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(drv -> (drv.findElement(by).getText() != null && !drv.findElement(by).getText().isEmpty()));
    }

    public MainPage waitForLoadHeadOfMainPage() {
        waitForLoadElement(headOfMainPage);
        return this;
    }

    public MainPage waitForFirstBun() {
        waitForLoadElement(firstBun);
        return this;
    }

    public MainPage clickButtonPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
        return this;
    }

    public MainPage clickButtonGoToAccount() {
        driver.findElement(buttonGoToAccount).click();
        return this;
    }

    public MainPage clickBunsSection() {
        driver.findElement(bunsSection).click();
        return this;
    }

    public MainPage clickSaucesSection() {
        driver.findElement(bunsSection).click();
        return this;
    }

    public MainPage clickFillingSection() {
        driver.findElement(bunsSection).click();
        return this;
    }

    public LoginPage loginPage() {
        return new LoginPage(driver);
    }

    public AccountProfilePage accountProfilePage() {
        return new AccountProfilePage(driver);
    }

    public MainPage loginByButtonGoToAccountOnMainPage(User user) {
        openMainPage()
                .waitForLoadHeadOfMainPage()
                .clickButtonGoToAccount()
                .loginPage()
                .waitForLoadHeadOfLoginPage()
                .fillLoginFormWithIncorrectPassword(user);
        return this;

    }

    public MainPage loginByButtonPersonalAccountOnMainPage(User user) {
        openMainPage()
                .waitForLoadHeadOfMainPage()
                .clickButtonPersonalAccount()
                .loginPage()
                .waitForLoadHeadOfLoginPage()
                .fillLoginFormWithIncorrectPassword(user);
        return this;
    }

    public boolean isDisplayedButtonCreateOrder() {
        return driver.findElement(buttonCreateOrder).isDisplayed();

    }

    public MainPage goToPersonalAccount() {
        clickButtonPersonalAccount()
                .accountProfilePage()
                .waitForAccountProfilePage();
        return this;
    }

    public MainPage goToBunsSection() {
        waitForLoadHeadOfMainPage()
                .clickBunsSection();
        return this;
    }

    public MainPage goToSaucesSection() {
        waitForLoadHeadOfMainPage()
                .clickSaucesSection();
        return this;
    }

    public MainPage goToFillingSection() {
        waitForLoadHeadOfMainPage()
                .clickFillingSection();
        return this;
    }

    public String getTextBunsSection() {
        return driver.findElement(bunsSection).getText();
    }

    public String getTextCurrentSection() {
        return driver.findElement(menuSection).getAttribute("class");
    }

    public String getTextHeadOfMainPage() {
        return driver.findElement(headOfMainPage).getText();
    }

}
