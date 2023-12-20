import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;

public class ActionClass {


    WebDriver driver;


    @BeforeTest

    public void Setup() {

        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        driver = new OperaDriver();

        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
    }

    @Test
    public void Test1(){

        //Action methods

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("user-name"));
        actions.moveToElement(element)
                .click(element).sendKeys(element, "standard_user")
                .doubleClick(element)
                .contextClick(element)
                .build()
                .perform();
    }

    @Test
    public void Test2() throws InterruptedException{
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("password"));
        actions.contextClick(element).build().perform();
        actions.sendKeys(Keys.chord(Keys.CONTROL, "v")).build().perform();
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
    }

   @AfterTest
    public void Teardown(){
        driver.quit();
    }

    }
