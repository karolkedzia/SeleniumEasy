package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListPage extends BasePage {

    @FindBy(css = "ul#treemenu li > ul > li:nth-child(1) > a")
    private WebElement inputForms;

    @FindBy(css = "ul#treemenu ul > li:nth-child(1) > ul > li:nth-child(1) > a")
    private WebElement simpleFormDemo;

    @FindBy(css = "ul#treemenu ul > li:nth-child(1) > ul > li:nth-child(2) > a")
    private WebElement checkboxDemo;

    @FindBy(css = "ul#treemenu ul > li:nth-child(1) > ul > li:nth-child(3) > a")
    private WebElement radioButtonsDemo;

    @FindBy(css = "li.tree-branch > ul > li:nth-of-type(1) > ul > li:nth-of-type(4) > a")
    private WebElement selectDropdownList;

    public ListPage(WebDriver driver) {
        super(driver);
    }

    public ListPage clickOnInputForms() {
        inputForms.click();
        return this;
    }

    public ListPage clickOnSimpleFormDemo() {
        simpleFormDemo.click();
        return this;
    }

    public ListPage clickOnCheckboxDemo() {
        checkboxDemo.click();
        waiter.wait(2000);
        return this;
    }

    public ListPage clickOnRadioButtonsDemo() {
        radioButtonsDemo.click();
        waiter.wait(2000);
        return this;
    }

    public ListPage clickOnselectDropdownList() {
        selectDropdownList.click();
        return this;
    }

    public InputForms getInputForms() {
        return new InputForms(driver);
    }

    public DatePickers getDatePickers() {
        return new DatePickers(driver);
    }

}
