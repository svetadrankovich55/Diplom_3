package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.User;

import java.time.Duration;

public class LoginPage {
    private final String urlLoginPage = "https://stellarburgers.nomoreparties.site/login";

    //Заголовок главной страницы
    private final By headOfLoginPage = By.cssSelector(".Auth_login__3hAey > h2");

    //Поле "Email"
    private final By inputEmail = By.xpath(".//label[text()='Email']/../input");

    //Поле "Пароль"
    private final By inputPassword = By.xpath(".//label[text()='Пароль']/../input");

    //Кнопка "Войти"
    private final By buttonGoTo = By.xpath(".//button[text()='Войти']");

    //Ссылка "Зарегистрироваться"
    private final By linkRegister = By.linkText("Зарегистрироваться");

    //Ссылка "Восстановить пароль"
    private final By linkForgotPassword = By.linkText("Восстановить пароль");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage openLoginPage() {
        driver.get(urlLoginPage);
        return this;
    }

    public LoginPage inputEmail(String text) {
        driver.findElement(inputEmail).sendKeys(text);
        return this;
    }

    public LoginPage inputPassword(String text) {
        driver.findElement(inputPassword).sendKeys(text);
        return this;
    }

    public void waitForLoadElement(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(drv -> (drv.findElement(by).getText() != null && !drv.findElement(by).getText().isEmpty()));
    }

    public LoginPage waitForLoadHeadOfLoginPage() {
        waitForLoadElement(headOfLoginPage);
        return this;
    }

    public LoginPage clickButtonGoTo() {
        driver.findElement(buttonGoTo).click();
        return this;
    }

    public boolean isDisplayedButtonGoTo() {
        return driver.findElement(buttonGoTo).isDisplayed();

    }

    public LoginPage clickRegister() {
        driver.findElement(linkRegister).click();
        return this;
    }

    public LoginPage clickForgotPassword() {
        driver.findElement(linkForgotPassword).click();
        return this;
    }

    public LoginPage fillLoginFormWithIncorrectPassword(User user) {
        inputEmail(user.getEmail())
                .inputPassword(user.getPasswordCorrect())
                .clickButtonGoTo();
        return this;
    }

}
