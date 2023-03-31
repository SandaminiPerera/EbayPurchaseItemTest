package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Configurations {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }
   public void openBrowser(String browser){
       switch (browser){
           case "chrome":
               String exePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
               System.setProperty("webdriver.chrome.driver", exePath);
               driver = new ChromeDriver();
               break;

           case "edge":
               String exePath1 = System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe";
               System.setProperty("webdriver.edge.driver", exePath1);
               driver = new EdgeDriver();
               break;

           case "firefox":
               String exePath2 = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
               System.setProperty("webdriver.gecko.driver", exePath2);
               driver = new FirefoxDriver();
               break;

           default:
               System.out.println("Browser not support");
               System.exit(0);
       }

       driver.manage().window().maximize();

   }

   public void navigateToURL(String url){
        driver.get(url);
   }

   public void handleNewTab(){
       String currentTab = driver.getWindowHandle();
       for (String tab : driver.getWindowHandles()) {
           if (!tab.equals(currentTab)) {
               driver.switchTo().window(tab);
           }
       }
   }

   public void waitForElements(By element1){

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(element1));
   }
}
