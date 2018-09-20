import Core.WebDriverFactory;
import Pages.DatePickers;
import Pages.ListPage;
import Pages.MainPage;
import Pages.InputForms;
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
    protected InputForms inputForms;
    protected DatePickers dataPickers;

    @BeforeMethod
    @Parameters(("browser"))
    public void setUp(@Optional("chrome") String browser) {
        webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver(browser);

        mainPage = new MainPage(driver);
        listPage = new ListPage(driver);
        inputForms = new InputForms(driver);
        dataPickers = new DatePickers(driver);
    }

    @AfterMethod
    public void cleanUp() {
        driver.close(); }
}