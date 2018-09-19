import org.testng.annotations.Test;

public class ExecuteTests extends BaseTest {

    @Test(description = "Test1 - otwarcie przeglądarki")
    public void test1() {
        mainPage
                .goToSeleniumMainPage()
                .clickInputForms();
    }
}
