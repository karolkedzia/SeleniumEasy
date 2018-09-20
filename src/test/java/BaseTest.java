import Core.WebDriverFactory;
import Pages.ListPage;
import Pages.MainPage;
import Pages.WorkSpacePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    private WebDriver driver;
    private WebDriverFactory webDriverFactory;
    protected MainPage mainPage;
    protected ListPage listPage;
    protected WorkSpacePage workSpacePage;

    @BeforeMethod
    @Parameters(("browser"))
    public void setUp(@Optional("chrome") String browser) {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(browser);

        mainPage = new MainPage(driver);
        listPage = new ListPage(driver);
        workSpacePage = new WorkSpacePage(driver);
    }

    @AfterMethod
    public void cleanUp() {
        driver.close(); }
}