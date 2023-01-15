package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.User;

import java.time.Duration;

public class ForgotPasswordPage {
    private final String urlForgotPassword = "https://stellarburgers.nomoreparties.site/forgot-password";

    //Заголовок главной страницы
    private final By headOfForgotPassword = By.xpath(".//div[@class='Auth_login__3hAey']/h2");

    //Поле "Email"
    private final By inputEmail = By.xpath(".//label[text()='Email']/../input");

    //Кнопка "Восстановить"
    private final By buttonRestore = By.xpath(".//button[text()='Восстановить']");

    //Ссылка "Войти"
    private final By linkGoTo = By.linkText("Войти");

    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public ForgotPasswordPage openForgotPasswordPage() {
        driver.get(urlForgotPassword);
        return this;
    }

    public ForgotPasswordPage inputEmail(String text) {
        driver.findElement(inputEmail).sendKeys(text);
        return this;
    }

    public void waitForLoadElement(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(drv -> (drv.findElement(by).getText() != null && !drv.findElement(by).getText().isEmpty()));
    }

    public ForgotPasswordPage waitForLoadHeadOfForgotPasswordPage() {
        waitForLoadElement(headOfForgotPassword);
        return this;
    }

    public ForgotPasswordPage clickButtonRestore() {
        driver.findElement(buttonRestore).click();
        return this;
    }

    public ForgotPasswordPage clickLinkGoTo() {
        driver.findElement(linkGoTo).click();
        return this;
    }

    public LoginPage loginPage() {
        return new LoginPage(driver);
    }

    public ForgotPasswordPage loginByLinkGoToOnForgotPasswordPage(User user) {
        openForgotPasswordPage()
                .waitForLoadHeadOfForgotPasswordPage()
                .clickLinkGoTo()
                .loginPage()
                .waitForLoadHeadOfLoginPage()
                .fillLoginFormWithIncorrectPassword(user);
        return this;
    }

}
