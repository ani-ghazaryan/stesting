package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;

public class HomePage {

    private WebDriver webDriver;
    private By loginToMailButton = By.cssSelector(".desk-notif-card__login-new-items a[href*=\"mail\"]");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage clickLoginButton() {
        webDriver.findElement(loginToMailButton).click();
        ArrayList<String> wid = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(wid.get(1));

        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.className("AuthLoginInputToggle-input")));
        return new LoginPage(webDriver);
    }

}
