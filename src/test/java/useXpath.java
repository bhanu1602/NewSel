import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Driver;

public class useXpath {

    WebDriver driver;

    @BeforeTest

    public void setup(){

        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");
        String s = driver.getTitle();
        System.out.println(s);

    }

    @Test

    public void test2(){

        //contains
        driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("standard_user");

        //starts-with
        driver.findElement(By.xpath("//input[starts-with(@id,'user')]")).sendKeys("standard_user");

        //or
        driver.findElement(By.xpath("//input[@id = 'user-name' or @name = 'user-name')]")).sendKeys("standard_user");

        //and
        driver.findElement(By.xpath("//input[@id = 'user-name' and @name = 'user-name')]")).sendKeys("standard_user");

        //text
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).isDisplayed();


        driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[1]")).click();

    }

    @AfterTest

    public void quit(){
        driver.quit();
    }

}
