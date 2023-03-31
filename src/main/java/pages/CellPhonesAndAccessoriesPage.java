package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CellPhonesAndAccessoriesPage {

    WebDriver driver;
    By searchBar = By.id("gh-ac");
    By searchButton = By.id("gh-btn");
    By appleCheckBox = By.xpath("//input[@aria-label=\"Apple\"]");
    By itemLink = By.xpath("//a[@class=\"s-item__link\"]");
    public CellPhonesAndAccessoriesPage(WebDriver driver) {
        this.driver = driver;
    }

    public CellPhonesAndAccessoriesPage typeOnSearchBar(String input){
        driver.findElement(searchBar).sendKeys(input);
        return this;
    }

    public CellPhonesAndAccessoriesPage clickSearchButton(){
        driver.findElement(searchButton).click();
        return this;
    }

    public CellPhonesAndAccessoriesPage clickAppleCheckBox(){
        driver.findElement(appleCheckBox).click();
        return this;
    }

    public ItemPage clickItemLink(){
        driver.findElements(itemLink).get(1).click();
        return new ItemPage(driver);

    }
}
