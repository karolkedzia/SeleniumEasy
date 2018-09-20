package Pages;

import Core.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;
    protected Waiter waiter;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void moveViewToElementAccordingCoordinates(WebElement element) {
        Coordinates cor = ((Locatable) element).getCoordinates();
        cor.inViewPort();
    }
}
