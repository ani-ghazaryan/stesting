
package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.LoginPage;
import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {

        String username = "ani.ghaz.t";
        String password = "Yantest1!";

        LoginPage loginPage = homePage.clickLoginButton();
        loginPage.setUsername(username);
        loginPage.clickLoginButton(false);
        loginPage.setPassword(password);
        InboxPage inboxPage = loginPage.clickLoginButton(true);
        String composeLetterButtonText = inboxPage.getComposeLetterButtonText();
        assertTrue(composeLetterButtonText.contains("Написать"),"User is not logged in");
    }
}
