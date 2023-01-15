import org.junit.Rule;
import org.junit.Test;
import pom.RegisterPage;
import utils.BrowserRule;
import utils.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegisterPageTest {

    private final User user = new User();
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void checkSuccessfulRegistration() {

        RegisterPage registerPage = new RegisterPage(browserRule.getDriver());

        registerPage.registerUserWithCorrectPassword(user);

        assertTrue(registerPage.loginPage().isDisplayedButtonGoTo());
    }

    @Test
    public void checkFailedRegistration() {

        RegisterPage registerPage = new RegisterPage(browserRule.getDriver());

        registerPage.registerUserWithIncorrectPassword(user);

        String expectedMessage = "Некорректный пароль";
        String actualMessage = registerPage.getMessageAboutIncorrectPassword();

        assertEquals(actualMessage, expectedMessage);
    }

}
