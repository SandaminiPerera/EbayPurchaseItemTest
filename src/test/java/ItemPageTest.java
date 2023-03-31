import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.ItemPage;
import utils.Configurations;

public class ItemPageTest {
     WebDriver driver;
    Configurations configurations = new Configurations();
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    @Parameters({"url","browser"})
    public void setUp(String url,String browser){
        configurations.openBrowser(browser);
        configurations.navigateToURL(url);
        driver= Configurations.getDriver();
    }

    @Test(priority = 1)
     public void printItemDetails() throws InterruptedException {
     HomePage homePage = new HomePage(driver);
     ItemPage itemPage = new ItemPage(driver);
     homePage.clickDropDown().clickCellPhonesAndAccessoriesLink()
             .typeOnSearchBar("Mobile phone").clickSearchButton().clickAppleCheckBox().clickItemLink();
     configurations.handleNewTab();
        Thread.sleep(1000);

        itemPage.selectModel().selectCarrier().selectStorage().selectColor().selectCosmetic();

     String itemName = itemPage.getItemName();
     String itemPrice = itemPage.getItemPrice();
     String itemCondition = itemPage.getItemCondition();
     String itemQuantity = itemPage.getItemQuantity();
     System.out.println("Item Name : "+itemName);
     System.out.println("Item Price : "+itemPrice);
     System.out.println("Item Condition : "+itemCondition);
     System.out.println("Item Quantity : "+itemQuantity);

     }

    @Test(priority = 2)
     public void validateAddToCartButton()  {
        ItemPage itemPage = new ItemPage(driver);
        itemPage.clickAddToCartBttn();

        softAssert.assertEquals("https://cart.payments.ebay.com/", driver.getCurrentUrl(),"Error : Incorrect Page");
    }


    @AfterClass
    public void tearDown()  {

        driver.quit();
     }
}
