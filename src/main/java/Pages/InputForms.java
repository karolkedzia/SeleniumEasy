package Pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class InputForms extends BasePage {

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

    @FindBy(id = "isAgeSelected")
    private WebElement singleChecbkox;

    @FindBy(id = "txtAge")
    private WebElement singleCheckBoxMessage;

    @FindBy(css = "div#easycont div:nth-child(3) > label > input")
    private WebElement checkboxOption1;

    @FindBy(css = "div#easycont div:nth-child(4) > label > input")
    private WebElement checkboxOption2;

    @FindBy(css = "div#easycont div:nth-child(5) > label > input")
    private WebElement checkboxOption3;

    @FindBy(css = "div#easycont div:nth-child(6) > label > input")
    private WebElement checkboxOption4;

    @FindBy(id = "check1")
    private WebElement checkButton;

    private String sentMessage;

    public InputForms(WebDriver driver) {
        super(driver);
    }

    //Exercise 1 - Simple Form Demo / Single Input Field
    public InputForms singleInputFieldsendMessage() {
        String message = RandomStringUtils.randomAlphanumeric(100);
        sentMessage = message;
        enterMessageTextfield.sendKeys(message);
        return this;
    }

    public InputForms singleInputFieldCheckPlaceholder() {
        enterMessageTextfield.getAttribute("placeholder");
        return this;
    }

    public InputForms clickOnMessageButtonButton() {
        showMessageButton.click();
        return this;
    }
    //Exercise 2 - Simple Form Demo / Two Input Fields

    public InputForms fillInInputA(String randomString1) {
        labelA.sendKeys(randomString1);
        return this;
    }

    public InputForms AInputPlaceholder() {
        labelA.getAttribute("placeholder");
        return this;
    }

    public InputForms fillInInputB(String randomString2) {
        labelB.sendKeys(randomString2);
        return this;
    }

    public InputForms BinputPlaceholder() {
        labelA.getAttribute("placeholder");
        return this;
    }

    public InputForms clickOnGetTotalButton() {
        getTotalButton.click();
        return this;
    }

    //Exercise 3 - Checkbox Demo / Single Checkbox Demo

    public InputForms clickOnCheckbox() {
        singleChecbkox.click();
        return this;
    }

    //Exercise 4 - Checkbox Demo / Multiple Checkbox Demo

    public InputForms clickCheckboxOption1() {
        checkboxOption1.click();
        return this;
    }

    public InputForms clickCheckboxOption2() {
        checkboxOption2.click();
        return this;
    }

    public InputForms clickCheckboxOption3() {
        checkboxOption3.click();
        return this;
    }

    public InputForms clickCheckboxOption4() {
        checkboxOption4.click();
        return this;
    }

    public InputForms clickButtonCheckAll() {
        checkButton.click();
        return this;
    }

    //Assertions

    //Exercise 1 - Simple Form Demo / Single Input Field. Positive test
    public void assertThatMessageIsEqualWithTheExpected() {
        Reporter.log("I check if the received message is the same as the one declared");
        Assert.assertTrue(yourMessage.getText().equals(sentMessage));
    }

    //Exercise 1 - Simple Form Demo / Single Input Field. Positive test. Placeholder
    public void assertThatPlaceholderIsEqualWithTheExpected(String placeholder) {
        Reporter.log("I check if the placeholder is compatible with the expected one");
        Assert.assertEquals(enterMessageTextfield.getAttribute("placeholder"), placeholder);
    }

    //Exercise 2 - Simple Form Demo / Two Input Fields. Positive and negative test. Correct (Integers) and incorrect (Strings) characters in inputs
    public void assertThatCorrectCharactersInInputs(String expectedValue) {
        Reporter.log("I check if after entering random inscriptions (String, number) on the inputs, we get the expected result");
        Assert.assertEquals(additionResult.getText(), expectedValue);
    }

    //Exercise 2 - Simple Form Demo / Two Input Fields. Positive test. Placeholder
    public void assertThatPlaceholdersAreEqualsWithTheExpected(String placeholder) {
        Reporter.log("I check if the placeholder is compatible with the expected one");
        Assert.assertEquals(labelA.getAttribute("placeholder"), placeholder);
        Assert.assertEquals(labelB.getAttribute("placeholder"), placeholder);
    }

    //Exercise 3 - Checkbox Demo / Single Checkbox Demo. Checkbox On
    public void assertThatCheckboxOn(String staticMessage) {
        Reporter.log("I check if the checkbox is checked");
        Assert.assertTrue(singleChecbkox.isSelected());
        Assert.assertEquals(singleCheckBoxMessage.getText(), staticMessage);
    }

    //Exercise 3 - Checkbox Demo / Single Checkbox Demo. Checkbox Off
    public void assertThatCheckboxOff(String atribute) {
        Reporter.log("I check if the checkbox is not checked");
        Assert.assertEquals(singleCheckBoxMessage.getAttribute("style"), atribute);
    }

    //Exercise 4 - Checkbox Demo / Multiple Checkbox Demo. All checkboxes are selected
    public void assertThatAllCheckboxesOn() {
        Reporter.log("I check if all checkboxes are marked correctly");
        Assert.assertTrue(checkboxOption1.isSelected());
        Assert.assertTrue(checkboxOption2.isSelected());
        Assert.assertTrue(checkboxOption3.isSelected());
        Assert.assertTrue(checkboxOption4.isSelected());
    }

    //Exercise 4 - Checkbox Demo / Multiple Checkbox Demo. Checks whether the button is correct depending on the configuration
    public void assertThatChecksIfTheButtonIsCorrect(String value) {
        Reporter.log("I check if the button is correct depending on the configuration");
        Assert.assertEquals(checkButton.getAttribute("value"), value);
    }

    //Exercise 4 - Checkbox Demo / Multiple Checkbox Demo. Checks whether clicking "Check All" ticks all checkboxes
    public void assertThatAllCheckboxesAreChecked() {
        Reporter.log("I check if all checkboxes are checked");
        Assert.assertTrue(checkboxOption1.isSelected());
        Assert.assertTrue(checkboxOption2.isSelected());
        Assert.assertTrue(checkboxOption3.isSelected());
        Assert.assertTrue(checkboxOption4.isSelected());
    }

    //Exercise 4 - Checkbox Demo / Multiple Checkbox Demo. Checks if all checkboxes are unchecked after using the "Uncheck All" button
    public void assertThatAllCheckboxesAreUnchecked() {
        Reporter.log("I check if all checkboxes are unchecked");
        Assert.assertFalse(checkboxOption1.isSelected());
        Assert.assertFalse(checkboxOption2.isSelected());
        Assert.assertFalse(checkboxOption3.isSelected());
        Assert.assertFalse(checkboxOption4.isSelected());
    }

}
