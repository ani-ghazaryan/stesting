package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InboxPage {

    private WebDriver webDriver;
    private By composeEmailButton = By.cssSelector("[data-key=\"view=main-action-buttons\"]");

    public InboxPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getComposeLetterButtonText(){
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(composeEmailButton));
        return webDriver.findElement(composeEmailButton).getText();
    }

}
