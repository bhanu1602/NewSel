import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class Cookies {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        driver = new OperaDriver();

        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
    }

    @Test
    public void Test1(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //get cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);

        //getting specific cookie
        Cookie user = driver.manage().getCookieNamed("session-username");
        System.out.println(user);

        //delete all cookies
        driver.manage().deleteAllCookies();

        //delete specific cookie
        driver.manage().deleteCookie(user);
        driver.manage().deleteCookieNamed("session-username");

        //creating cookie
        Cookie custom = new Cookie("password", "pass");
        System.out.println(driver.manage().getCookieNamed("password"));
    }
}
