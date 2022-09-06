package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver webDriver;
    private By usernameField = By.cssSelector(".passp-auth-content [data-t=\"field:input-login\"]");
    private By passwordField = By.cssSelector(".passp-auth-content [data-t=\"field:input-passwd\"]");

    private By loginButton = By.cssSelector(".passp-auth-content [data-t=\"button:action:passp:sign-in\"]");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setUsername(String username) {
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        webDriver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public InboxPage clickLoginButton(boolean navigatesToNewPage) {

        webDriver.findElement(loginButton).click();
        if (navigatesToNewPage) {
            new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(loginButton));
            return new InboxPage(webDriver);
        }

        return null;
    }

}
