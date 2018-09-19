package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListPage extends BasePage {

    @FindBy(css = "ul#treemenu li > ul > li:nth-child(1) > a")
    private WebElement inputForms;

    @FindBy(css = "ul#treemenu ul > li:nth-child(1) > ul > li:nth-child(1) > a")
    private WebElement simpleFormDemo;

    public ListPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnInputForms() {
        inputForms.click();
    }

    public void clickOnSimpleFormDemo() {
        simpleFormDemo.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}