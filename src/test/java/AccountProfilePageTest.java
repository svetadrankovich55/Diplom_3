import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import pom.AccountProfilePage;
import pom.MainPage;
import pom.RegisterPage;
import utils.BrowserRule;
import utils.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountProfilePageTest {

    private final User user = new User();
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Before
    public void createAndLoginUser() {
        RegisterPage registerPage = new RegisterPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());

        registerPage.registerUserWithCorrectPassword(user);
        mainPage.loginByButtonPersonalAccountOnMainPage(user);

        assertTrue(mainPage.isDisplayedButtonCreateOrder());
    }

    @Test
    public void checkGoToPersonalAccount() {
        MainPage mainPage = new MainPage(browserRule.getDriver());
        AccountProfilePage accountProfilePage = new AccountProfilePage(browserRule.getDriver());

        mainPage.goToPersonalAccount();

        String expectedText = "Профиль";
        String actualText = accountProfilePage.getTextSectionProfile();

        assertEquals(expectedText, actualText);
    }

    @Test
    public void checkGoToConstructor() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.goToPersonalAccount()
                .accountProfilePage()
                .goToConstructor();

        String expectedMessage = "Булки";
        String actualMessage = mainPage.getTextBunsSection();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void checkGoToLogoStellarBurgers() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.goToPersonalAccount()
                .accountProfilePage()
                .goToLogoStellarBurgers();

        String expectedMessage = "Соберите бургер";
        String actualMessage = mainPage.getTextHeadOfMainPage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void checkLogoutAccountProfile() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        boolean isDisplayedButtonGoTo = mainPage.goToPersonalAccount()
                .accountProfilePage()
                .clickButtonExit()
                .loginPage()
                .waitForLoadHeadOfLoginPage()
                .isDisplayedButtonGoTo();

        assertTrue(isDisplayedButtonGoTo);
    }

}
