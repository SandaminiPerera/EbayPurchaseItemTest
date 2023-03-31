package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Configurations;

public class CartPage {
    Configurations configurations = new Configurations();
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    By itemName = By.xpath("//span[@class=\"BOLD\"]/label");
    By itemPrice = By.xpath("//div[@class=\"item-price font-title-3\"]/span/span/span");
    By itemQuantity = By.xpath("//div[@class=\"quantity\"]//span/select");
    By subTotal = By.xpath("//div[@class=\"val-col total-row\"]/span/span/span");
    By shipping = By.xpath("//div[@class=\"val-col\"]/span/span/span");

    public String getItemName(){
        return driver.findElement(itemName).getText().trim();
    }
    public String getItemPrice(){
        return driver.findElement(itemPrice).getText().trim();
    }
    public String getSubTotal(){
        return driver.findElement(subTotal).getText().trim();
    }
    public String getShipping(){
        try{
            return   driver.findElements(shipping).get(1).getText().trim();
        }catch (NoSuchElementException e){
            return "NO Shipping details";
        }    }

    public String getItemQuantityDropDown(){
        Select select = new Select(driver.findElements(itemQuantity).get(0));
        return select.getFirstSelectedOption().getText();
    }
}
