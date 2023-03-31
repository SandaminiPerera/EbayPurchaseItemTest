package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.Configurations;


public class ItemPage {

    WebDriver driver;

    Configurations configurations = new Configurations();
    By modelDropDown = By.id("x-msku__select-box-1000");
    By carrierDropDown = By.id("x-msku__select-box-1001");
    By storageDropDown = By.id("x-msku__select-box-1002");
    By colorDropDown = By.id("x-msku__select-box-1003");
    By cosmeticDropDown = By.id("x-msku__select-box-1004");

    By itemName = By.xpath("//h1[@class=\"x-item-title__mainTitle\"]/span");
    By itemPrice = By.xpath("//span[@itemprop=\"price\"]/span");
    By itemCondition = By.xpath("//div[@class=\"x-item-condition-text\"]//span/span/span");
    By itemQuantity = By.id("qtyTextBox");
    By addToCartButton = By.xpath("//a[@class=\"ux-call-to-action fake-btn fake-btn--fluid fake-btn--primary\"]");

    public ItemPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getItemName()  {
        configurations.waitForElements(itemName);
        return  driver.findElement(itemName).getText();
    }

    public String getItemCondition(){
        configurations.waitForElements(itemCondition);

        return driver.findElement(itemCondition).getText();
    }
    public String getItemPrice(){
        configurations.waitForElements(itemPrice);

        return driver.findElement(itemPrice).getText();
    }
    public String getItemQuantity(){
        configurations.waitForElements(itemQuantity);

        return driver.findElement(itemQuantity).getAttribute("value");
    }

    public CartPage clickAddToCartBttn(){

        driver.findElements(addToCartButton).get(2).click();
        return new CartPage(driver);
    }

    public ItemPage selectModel(){
        try {
            Select select1 = new Select(driver.findElement(modelDropDown));
            select1.selectByIndex(1);
        } catch (NoSuchElementException e) {
            System.out.println("Model drop down element is not available");
        }
        return this;
    }
    public ItemPage selectCarrier(){
        try {
            Select select2 = new Select(driver.findElement(carrierDropDown));
            select2.selectByIndex(1);
        } catch (NoSuchElementException e) {
            System.out.println("Carrier drop down element is not available");
        }
        return this;
    }
    public ItemPage selectStorage(){
        try {
            Select select3 = new Select(driver.findElement(storageDropDown));
            select3.selectByIndex(1);
        } catch (NoSuchElementException e) {
            System.out.println("Storage drop down element is not available");
        }
        return this;
    }
    public ItemPage selectColor(){
        try {
            Select select4 = new Select(driver.findElement(colorDropDown));
            select4.selectByIndex(1);
        } catch (NoSuchElementException e) {
            System.out.println("Color drop down element is not available");
        }
        return this;
    }
    public ItemPage selectCosmetic(){
        try {
            Select select5 = new Select(driver.findElement(cosmeticDropDown));
            select5.selectByIndex(1);
        } catch (NoSuchElementException e) {
            System.out.println("Cosmetic drop down element is not available");
        }
        return this;
    }

}
