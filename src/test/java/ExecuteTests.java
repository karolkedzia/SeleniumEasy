import Core.Random;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExecuteTests extends BaseTest {

    @DataProvider
    public Object[][] enterRandomValues() {
        int randomInt1 = Random.randomInt();
        int randomInt2 = Random.randomInt();
        String randomString1 = Random.randomString();
        String randomString2 = Random.randomString();

        return new Object[][]{
                {String.valueOf(randomInt1), String.valueOf(randomInt2), String.valueOf(randomInt1 + randomInt2)},
                {randomString1, randomString2, "NaN"},
        };
    }

    @Test(description = "Exercise 1 - Single Input Field")
    public void singleInputField() {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnSimpleFormDemo()
                .getWorkSpacePage()
                .singleInputFieldsendMessage()
                .clickOnMessageButtonButton()
                .assertThatMessageIsEqualWithTheExpected();
    }

    @Test(description = "Exercise 2 - Single Input Field. positive and negative test. Correct (Integers) and incorrect (Strings) characters in inputs", dataProvider = "enterRandomValues")
    public void twoInputFieldsWithIncorrectStrings(String randomString1, String randomString2, String expectedValue) {
        mainPage
                .goToSeleniumMainPage()
                .getListPage()
                .clickOnInputForms()
                .clickOnSimpleFormDemo()
                .getWorkSpacePage()
                .fillInInputA(randomString1)
                .fillInInputB(randomString2)
                .clickOnGetTotalButton()
                .assertThatCorrectCharactersInInputs(expectedValue);
    }
}
