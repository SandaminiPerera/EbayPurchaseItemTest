import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.Configurations;

public class HomePageTest {
    WebDriver driver;
    Configurations configurations = new Configurations();
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    @Parameters({"browser","url"})
    public void setUp(String browser,String url){
        configurations.openBrowser(browser);
        configurations.navigateToURL(url);
        driver= Configurations.getDriver();
    }

    @Test
    public void verifyingURL() {
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.ebay.com/", "Error -Incorrect URL");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
