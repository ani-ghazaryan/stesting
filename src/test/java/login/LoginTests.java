
package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUsername("ani.ghaz.t");
        loginPage.clickLoginButton(false);
        loginPage.setPassword("Ghazaryan1!");
        InboxPage inboxPage = loginPage.clickLoginButton(true);
        String composeLetterButtonText = inboxPage.getComposeLetterButtonText();
        assertTrue(composeLetterButtonText.contains("Написать"),"User is not logged in");
    }
}
