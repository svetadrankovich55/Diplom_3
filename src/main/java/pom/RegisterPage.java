package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.User;

import java.time.Duration;

public class RegisterPage {

    private final String urlRegisterPage = "https://stellarburgers.nomoreparties.site/register";

    //Заголовок главной страницы
    private final By headOfRegisterPage = By.cssSelector(".Auth_login__3hAey > h2");

    //Поле "Имя"
    private final By inputName = By.xpath(".//label[text()='Имя']/../input");

    //Поле "Email"
    private final By inputEmail = By.xpath(".//label[text()='Email']/../input");

    //Поле "Пароль"
    private final By inputPassword = By.xpath(".//label[text()='Пароль']/../input");

    //Кнопка "Зарегистрироваться"
    private final By buttonRegister = By.xpath(".//button[text()='Зарегистрироваться']");

    //Сообщение о некорректном пароле
    private final By messageAboutIncorrectPassword = By.cssSelector(".input__error");

    private final By linkGoTo = By.linkText("Войти");

    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPage openRegisterPage() {
        driver.get(urlRegisterPage);
        return this;
    }

    public RegisterPage inputName(String text) {
        driver.findElement(inputName).sendKeys(text);
        return this;
    }

    public RegisterPage inputEmail(String text) {
        driver.findElement(inputEmail).sendKeys(text);
        return this;
    }

    public RegisterPage inputPassword(String text) {
        driver.findElement(inputPassword).sendKeys(text);
        return this;
    }

    public void waitForLoadElement(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(drv -> (drv.findElement(by).getText() != null && !drv.findElement(by).getText().isEmpty()));
    }

    public RegisterPage waitForLoadHeadOfRegisterPage() {
        waitForLoadElement(headOfRegisterPage);
        return this;
    }

    public RegisterPage clickButtonRegister() {
        driver.findElement(buttonRegister).click();
        return this;
    }

    public RegisterPage clickLinkGoTo() {
        driver.findElement(linkGoTo).click();
        return this;
    }

    public RegisterPage fillRegistrationFormWithCorrectPassword(User user) {
        inputName(user.getName())
                .inputEmail(user.getEmail())
                .inputPassword(user.getPasswordCorrect())
                .clickButtonRegister();
        return this;
    }

    public RegisterPage fillRegistrationFormWithIncorrectPassword(User user) {
        inputName(user.getName())
                .inputEmail(user.getEmail())
                .inputPassword(user.getPasswordIncorrect())
                .clickButtonRegister();
        return this;
    }

    public RegisterPage registerUserWithCorrectPassword(User user) {
        openRegisterPage()
                .waitForLoadHeadOfRegisterPage()
                .fillRegistrationFormWithCorrectPassword(user);
        return this;
    }

    public RegisterPage registerUserWithIncorrectPassword(User user) {
        openRegisterPage()
                .waitForLoadHeadOfRegisterPage()
                .fillRegistrationFormWithIncorrectPassword(user);
        return this;
    }

    public RegisterPage loginByLinkGoToOnRegisterPage(User user) {
        openRegisterPage()
                .waitForLoadHeadOfRegisterPage()
                .clickLinkGoTo()
                .loginPage()
                .waitForLoadHeadOfLoginPage()
                .fillLoginFormWithIncorrectPassword(user);
        return this;
    }

    public LoginPage loginPage() {
        return new LoginPage(driver);
    }

    public String getMessageAboutIncorrectPassword() {
        return driver.findElement(messageAboutIncorrectPassword).getText();
    }

}
