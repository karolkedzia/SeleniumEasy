package Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class WorkSpacePage extends BasePage {

    @FindBy(id = "user-message")
    private WebElement enterMessageTextfield;

    @FindBy(xpath = "//*[@id=\"get-input\"]/button")
    private WebElement showMessageButton;

    @FindBy(id = "display")
    private WebElement yourMessage;

    @FindBy(id = "sum1")
    private WebElement labelA;

    @FindBy(id = "sum2")
    private WebElement labelB;

    @FindBy(xpath = "//*[@id=\"gettotal\"]/button")
    private WebElement getTotalButton;

    @FindBy(id = "displayvalue")
    private WebElement additionResult;
    private int result;
    private String sentMessage;


    public WorkSpacePage(WebDriver driver) {
        super(driver);
    }

    //Exercise 1 - Single Input Field
    public WorkSpacePage singleInputFieldsendMessage() {
        String message = RandomStringUtils.randomAlphanumeric(100);
        sentMessage = message;
        enterMessageTextfield.sendKeys(message);
        return this;
    }

    public WorkSpacePage clickOnMessageButtonButton() {
        showMessageButton.click();
        return this;
    }
    //Exercise 2 - Two Input Fields.

    public WorkSpacePage fillInInputA(String randomString1) {
        labelA.sendKeys(randomString1);
        return this;
    }

    public WorkSpacePage fillInInputB(String randomString2) {
        labelB.sendKeys(randomString2);
        return this;
    }

    public WorkSpacePage clickOnGetTotalButton() {
        getTotalButton.click();
        return this;
    }


    //Assertion

    //Exercise 1 - Single Input Field. Positive test
    public void assertThatMessageIsEqualWithTheExpected() {
        Reporter.log("I check if the received message is the same as the one declared");
        Assert.assertTrue(yourMessage.getText().equals(sentMessage));
    }

    //Exercise 2 - Two Input Fields. Positive and negative test. Correct (Integers) and incorrect (Strings) characters in inputs
    public void assertThatCorrectCharactersInInputs(String expectedValue) {
        Reporter.log("I check if after entering random inscriptions (String, number) on the inputs, we get the expected result");
        Assert.assertEquals(additionResult.getText(), expectedValue);
    }
}
