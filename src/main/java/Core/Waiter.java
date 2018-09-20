package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Waiter {
    private static int timeout = 10;
    private WebDriver driver;

    public Waiter(WebDriver driver) {
        this.driver = driver;
    }

    private FluentWait<WebDriver> getWait() {
        return new FluentWait<>(this.driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(NoSuchElementException.class);
    }

    public void waitForWebElementVisibilityBy(By by) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated((by)));
    }

    public void waitForWebElementVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForWebElementInvisibility(WebElement element) {
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForWebElementTextVisibility(WebElement element, String text) {
        getWait().until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForWebElementToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void wait(int miliseconds) {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

