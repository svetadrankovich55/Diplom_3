import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import pom.MainPage;
import utils.BrowserRule;

import static org.hamcrest.Matchers.containsString;

public class MainPageTest {

    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    public void checkGoToSectionBuns() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.openMainPage()
                .goToBunsSection();

        String text = mainPage.getTextCurrentSection();
        MatcherAssert.assertThat(text, containsString("current"));
    }

    @Test
    public void checkGoToSectionSauces() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.openMainPage()
                .goToSaucesSection();

        String text = mainPage.getTextCurrentSection();
        MatcherAssert.assertThat(text, containsString("current"));
    }

    @Test
    public void checkGoToSectionFilling() {
        MainPage mainPage = new MainPage(browserRule.getDriver());

        mainPage.openMainPage()
                .goToFillingSection();

        String text = mainPage.getTextCurrentSection();
        MatcherAssert.assertThat(text, containsString("current"));
    }
}
