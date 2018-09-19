package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "/html/body/footer")
    private WebElement mavenTutorial;


    public MainPage(WebDriver driver) {
        super(driver);
    }

        public MainPage goToSeleniumMainPage() {
        driver.get("http://www.seleniumeasy.com/test/");
        return this;
    }

//    public void clickInputForms() {
//        moveViewToElementAccordingCoordinates(driver.findElement(By.cssSelector("#treemenu > li > ul > li:nth-child(7) > a")));
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

}