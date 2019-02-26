package apiDemo.elements;

import org.awaitility.core.ConditionTimeoutException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

public class Element {

    private WebElement element;

    public Element(WebElement element) {
        this.element = element;
    }

    public void click() {
        while (true) {
            try {
                element.click();
                return;
            } catch (NoSuchElementException | ElementNotVisibleException e) {
                waitUntilPresent("Element not found or not visible");
            }
        }
    }

    public void sendKeys(String text) {
        while (true) {
            try {
                element.sendKeys(text);
                return;
            } catch (NoSuchElementException | ElementNotVisibleException e) {
                waitUntilPresent("Element not found or not visible");
            }
        }
    }

    public Boolean exists() {
        try {
            element.isEnabled();
            return true;
        } catch (NotFoundException e) {
            return false;
        }
    }

    public void waitUntilPresent(String message) {
        try {
            await().atMost(30, SECONDS).until(() -> exists());
        } catch (ConditionTimeoutException e) {
            throw new TimeoutException(message, e);
        }
    }
}
