package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManager {

    private WebDriver webDriver;
    private WebDriver.Navigation navigation;

    public WindowManager(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.navigation = webDriver.navigate();
    }

    public void goBack() {
        navigation.back();
    }

    public void goForward() {
        navigation.forward();
    }

    public void refreshPage() {
        navigation.refresh();
    }

    public void goTo(String url) {
        navigation.to(url);
    }

    public void switchToTabByTitle(String tabTitle) {
        Set<String> windowHandles = webDriver.getWindowHandles();

        for(String window : windowHandles) {
            if (tabTitle.equals(webDriver.getTitle())) {
                webDriver.switchTo().window(window);
            }
        }
    }

    public void switchToTabByIndex(int index) {
        Set<String> windowHandles = webDriver.getWindowHandles();
        int i = 0;
        for(String window : windowHandles) {
            if (i == index) {
                webDriver.switchTo().window(window);
            }
            i++;
        }
    }
}
