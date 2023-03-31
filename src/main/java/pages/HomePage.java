package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;
    By dropDown= By.id("gh-shop-ei");
    By cellPhonesAndAccessoriesLink = By.xpath("//a[text()=\"Cell phones & accessories\"]");


    public HomePage clickDropDown(){

        driver.findElement(dropDown).click();
        return this;
    }

    public CellPhonesAndAccessoriesPage clickCellPhonesAndAccessoriesLink(){
        driver.findElement(cellPhonesAndAccessoriesLink).click();
        return new CellPhonesAndAccessoriesPage(driver);
    }

}
