import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.ForgotPasswordPage;
import pom.MainPage;
import pom.RegisterPage;
import utils.BrowserRule;
import utils.User;

import static org.junit.Assert.assertTrue;

public class LoginPageTest {

    private final User user = new User();
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Before
    public void createUser() {
        RegisterPage registerPage = new RegisterPage(browserRule.getDriver());

        registerPage.registerUserWithCorrectPassword(user);

        assertTrue(registerPage.loginPage().isDisplayedButtonGoTo());
    }

    @Test
    public void checkLoginByButtonGoToAccountOnMainPage() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.loginByButtonGoToAccountOnMainPage(user);

        assertTrue(mainPage.isDisplayedButtonCreateOrder());
    }

    @Test
    public void checkLoginByButtonPersonalAccountOnMainPage() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.loginByButtonPersonalAccountOnMainPage(user);

        assertTrue(mainPage.isDisplayedButtonCreateOrder());
    }

    @Test
    public void checkLoginByLinkGoToOnRegisterPage() {
        RegisterPage registerPage = new RegisterPage(browserRule.getDriver());

        MainPage mainPage = new MainPage(browserRule.getDriver());

        registerPage.loginByLinkGoToOnRegisterPage(user);

        assertTrue(mainPage.isDisplayedButtonCreateOrder());
    }

    @Test
    public void checkLoginByLinkGoToOnForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(browserRule.getDriver());

        MainPage mainPage = new MainPage(browserRule.getDriver());

        forgotPasswordPage.loginByLinkGoToOnForgotPasswordPage(user);

        assertTrue(mainPage.isDisplayedButtonCreateOrder());
    }
}
