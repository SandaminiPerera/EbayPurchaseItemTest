import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.HomePage;
import pages.ItemPage;
import utils.Configurations;

public class CartPageTest {
    WebDriver driver;
    Configurations configurations = new Configurations();

    SoftAssert softAssert = new SoftAssert();
    static String itemName  ;
    static String itemPrice;
    @BeforeClass
    @Parameters({"url","browser"})
    public void setUp(String url,String browser){
        configurations.openBrowser(browser);
        configurations.navigateToURL(url);
        driver= Configurations.getDriver();
    }
    @Test(priority = 1)
    public void printShipping(){
        HomePage homePage = new HomePage(driver);
        ItemPage itemPage = new ItemPage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.clickDropDown().clickCellPhonesAndAccessoriesLink()
                .typeOnSearchBar("Mobile phone").clickSearchButton().clickAppleCheckBox().clickItemLink();
        configurations.handleNewTab();
        itemPage.selectModel().selectCarrier().selectStorage().selectColor().selectCosmetic();
         itemPrice = itemPage.getItemPrice();
        itemName = itemPage.getItemName();
        itemPage.clickAddToCartBttn();

        System.out.println("Shipping : "+cartPage.getShipping());
    }

    @Test(priority = 2)
    public void validateItemName(){
        CartPage cartPage = new CartPage(driver);

        softAssert.assertEquals(cartPage.getItemName(),itemName,"Error : Item name is not matching");

    }

    @Test(priority = 3)
    public void validatePrice(){
        CartPage cartPage = new CartPage(driver);
        softAssert.assertEquals(cartPage.getItemPrice(),itemPrice,"Error : Item price is incorrect");

    }

    @Test(priority = 4)
    public void validateSubTotal(){
        CartPage cartPage = new CartPage(driver);
        softAssert.assertEquals(cartPage.getSubTotal(),itemPrice,"Error : Item subtotal is not equal to item price");

    }

    @Test(priority = 5)
    public void validateQuantity(){
        CartPage cartPage = new CartPage(driver);
        softAssert.assertNotNull(cartPage.getItemQuantityDropDown());

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
