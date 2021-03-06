import Core.Random;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class InputFormsExecuteTests extends BaseTest {

    @DataProvider
    public Object[][] enterRandomValues() {
        int randomInt1 = Random.randomInt();
        int randomInt2 = Random.randomInt();
        double randomDouble1 = Random.randomDouble();
        double randomDouble2 = Random.randomDouble();
        String randomString1 = Random.randomString();
        String randomString2 = Random.randomString();

        return new Object[][]{
                {String.valueOf(randomInt1), String.valueOf(randomInt2), String.valueOf(randomInt1 + randomInt2)},
                {randomString1, randomString2, "NaN"},
                {String.valueOf(randomDouble1), String.valueOf(randomDouble2), String.valueOf(randomDouble1 + randomDouble2)},
        };
    }

    @DataProvider
    public Object[][] enterCombinationOfValues() {
        return new Object[][]{
                {"Male", "0to5", "Sex : Male\n" +
                        "Age group: 0 - 5"},

                {"Male", "5to15", "Sex : Male\n" +
                        "Age group: 5 - 15"},

                {"Male", "15to50", "Sex : Male\n" +
                        "Age group: 15 - 50"},

                {"Female", "0to5", "Sex : Female\n" +
                        "Age group: 0 - 5"},

                {"Female", "5to15", "Sex : Female\n" +
                        "Age group: 5 - 15"},
                
                {"Female", "15to50", "Sex : Female\n" +
                        "Age group: 15 - 50"},
        };
    }

    @DataProvider
    public Object[][] enterTheDay() {
        return new Object[][]{
                {"Sunday", "Day selected :- Sunday"},
                {"Monday", "Day selected :- Monday"},
                {"Tuesday", "Day selected :- Tuesday"},
                {"Wednesday", "Day selected :- Wednesday"},
                {"Thursday", "Day selected :- Thursday"},
                {"Friday", "Day selected :- Friday"},
                {"Saturday", "Day selected :- Saturday"},
                {"Please select", ""},
        };
    }

    @Test(description = "Exercise 1 - Simple Form Demo/ Single Input Field")
    public void singleInputFieldCorrectData() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnSimpleFormDemo()
                .getInputForms()
                .singleInputFieldsendMessage()
                .clickOnMessageButtonButton()
                .assertThatMessageIsEqualWithTheExpected();
    }

    @Test(description = "Exercise 1 - Simple Form Demo / Single Input Field. I check the correctness of the placeholder")
    public void singleInputFieldCheckPlaceholders() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnSimpleFormDemo()
                .getInputForms()
                .singleInputFieldCheckPlaceholder()
                .assertThatPlaceholderIsEqualWithTheExpected("Please enter your Message");

    }

    @Test(description = "Exercise 2 - Simple Form Demo / Two Input Fields. Positive and negative tests. Correct (Integers) and incorrect (Strings) characters in inputs", dataProvider = "enterRandomValues")
    public void twoInputFieldsVariousData(String randomString1, String randomString2, String expectedValue) {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnSimpleFormDemo()
                .getInputForms()
                .fillInInputA(randomString1)
                .fillInInputB(randomString2)
                .clickOnGetTotalButton()
                .assertThatCorrectCharactersInInputs(expectedValue);
    }

    @Test(description = "Exercise 2 - Simple Form Demo / Two Input Fields. Checks if the placeholders in inputs A and B are correct")
    public void twoInputFieldsCheckPlaceholders() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnSimpleFormDemo()
                .getInputForms()
                .AInputPlaceholder()
                .BinputPlaceholder()
                .assertThatPlaceholdersAreEqualsWithTheExpected("Enter value");
    }

    @Test(description = "Exercise 3 - Checkbox Demo / Single Checkbox Demo. Checks whether the checkbox is selected correctly")
    public void singleCheckboxDemoClickOnTheCheckbox() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnCheckboxDemo()
                .getInputForms()
                .clickOnCheckbox()
                .assertThatCheckboxOn("Success - Check box is checked");
    }

    @Test(description = "Exercise 3 - Checkbox Demo / Single Checkbox Demo. Checks if the checkbox is unchecked, an incorrect message is displayed")
    public void singleCheckboxDemoCheckboxIsNotChecked() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnCheckboxDemo()
                .getInputForms()
                .assertThatCheckboxOff("display: none;");
    }

    @Test(description = "Exercise 4 - Checkbox Demo / Multiple Checkbox Demo. Checks if all checkboxes are correctly marked")
    public void multipleCheckboxDemoAllCheckboxAreSelected() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnCheckboxDemo()
                .getInputForms()
                .clickCheckboxOption1()
                .clickCheckboxOption2()
                .clickCheckboxOption3()
                .clickCheckboxOption4()
                .assertThatAllCheckboxesOn();
    }

    @Test(description = "Exercise 4 - Checkbox Demo / Multiple Checkbox Demo. Checks whether the button \"Select All\" is correct after selecting all checkboxes")
    public void multipleCheckboxDemoAllCheckboxAreSelectedAndTheButtonHasChanged() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnCheckboxDemo()
                .getInputForms()
                .clickCheckboxOption1()
                .clickCheckboxOption2()
                .clickCheckboxOption3()
                .clickCheckboxOption4()
                .assertThatChecksIfTheButtonIsCorrect("Uncheck All");

    }

    @Test(description = "Exercise 4 - Checkbox Demo / Multiple Checkbox Demo. Select checkbox 1 and check if the button has remained \"Check All\"")
    public void multipleCheckboxDemoSelectedCheckboxOption1ButtonCheckAll() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnCheckboxDemo()
                .getInputForms()
                .clickCheckboxOption1()
                .assertThatChecksIfTheButtonIsCorrect("Check All");
    }

    @Test(description = "Exercise 4 - Checkbox Demo / Multiple Checkbox Demo. Select checkbox 2 and check if the button has remained \"Check All\"")
    public void multipleCheckboxDemoSelectedCheckboxOption2ButtonCheckAll() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnCheckboxDemo()
                .getInputForms()
                .clickCheckboxOption2()
                .assertThatChecksIfTheButtonIsCorrect("Check All");
    }

    @Test(description = "Exercise 4 - Checkbox Demo / Multiple Checkbox Demo. Select checkbox 3 and check if the button has remained \"Check All\"")
    public void multipleCheckboxDemoSelectedCheckboxOption3ButtonCheckAll() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnCheckboxDemo()
                .getInputForms()
                .clickCheckboxOption3()
                .assertThatChecksIfTheButtonIsCorrect("Check All");
    }

    @Test(description = "Exercise 4 - Checkbox Demo / Multiple Checkbox Demo. Select checkbox 4 and check if the button has remained \"Check All\"")
    public void multipleCheckboxDemoSelectedCheckboxOption4ButtonCheckAll() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnCheckboxDemo()
                .getInputForms()
                .clickCheckboxOption4()
                .assertThatChecksIfTheButtonIsCorrect("Check All");
    }

    @Test(description = "Exercise 4 - Checkbox Demo / Multiple Checkbox Demo. Checks whether clicking \"Check All\" ticks all checkboxes")
    public void multipleCheckboxDemoClickCheckAllTicksAllCheckboxes() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnCheckboxDemo()
                .getInputForms()
                .clickButtonCheckAll()
                .assertThatAllCheckboxesAreChecked();
    }

    @Test(description = "Exercise 4 - Checkbox Demo / Multiple Checkbox Demo. Checks if all checkboxes are unchecked after using the \"Uncheck All\" button")
    public void multipleCheckboxDemoClickUncheckAllUncheckedAllCheckboxes() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnCheckboxDemo()
                .getInputForms()
                .clickButtonCheckAll()
                .clickButtonCheckAll()
                .assertThatAllCheckboxesAreUnchecked();
    }

    @Test(description = "Exercise 4 - Checkbox Demo / Multiple Checkbox Demo. Selects all check boxes, deselects Option 1 and validates the button")
    public void multipleCheckboxDemoSelectAllCheckboxesUncheckOneAndCheckTheButton() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnCheckboxDemo()
                .getInputForms()
                .clickCheckboxOption1()
                .clickCheckboxOption2()
                .clickCheckboxOption3()
                .clickCheckboxOption4()
                .clickCheckboxOption2()
                .assertThatChecksIfTheButtonIsCorrect("Check All");
    }

    @Test(description = "Exercise 5 - Radio Buttons Demo / Radio Button Demo. Checks if RadioButton returns the right message for Male RadioButton")
    public void radioButtonDemoChecksRightMessageForMale() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnRadioButtonsDemo()
                .getInputForms()
                .clickRadioButtonMale()
                .clickRadioButtoGet()
                .assertThatMessageIsEqualWithTheDeclared("Radio button 'Male' is checked");

    }

    @Test(description = "Exercise 5 - Radio Buttons Demo / Radio Button Demo. Checks if RadioButton returns the right message for Female RadioButton")
    public void radioButtonDemoChecksRightMessageForFemale() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnRadioButtonsDemo()
                .getInputForms()
                .clickRadioButtonFemale()
                .clickRadioButtoGet()
                .assertThatMessageIsEqualWithTheDeclared("Radio button 'Female' is checked");

    }

    @Test(description = "Exercise 6 - Radio Buttons Demo / Group Radio Buttons Demo. Checks all combinations of sex and age radiobuttons", dataProvider = "enterCombinationOfValues")
    public void radioButtonDemoChecksRightMessageForMultiRadioButtons(String sex, String age, String expectedMessage) {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnRadioButtonsDemo()
                .getInputForms()
                .choseCombinationSex(sex)
                .choseCombinationAgess(age)
                .clickGetValueButton()
                .assertThatMessageFromGetValuesButtonIsEqualWithTheDeclared(expectedMessage);

    }

    @Test(description = "Exercise 7 - Select Dropdown List / Select List Demo. Checks all available values from the list", dataProvider = "enterTheDay")
    public void selectDropdownListChecksAllAvailableValuesFromTheList(String day, String expectedMessage) {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnselectDropdownList()
                .getInputForms()
                .clickOnSelectList()
                .choseValue(day)
                .assertThatChecksAllAvailableValuesFromTheList(expectedMessage);
    }
}
