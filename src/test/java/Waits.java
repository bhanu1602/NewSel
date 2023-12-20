import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Waits {

    WebDriver driver;


    @BeforeTest

    public void Setup() {

        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        driver = new OperaDriver();

        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);

    }

    @Test

    public void validateLogin(){

        //Explicit Wait 'only waits for element to display'
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
    }

    public void validateLogin1(){

        //fluent wait
        Wait <WebDriver> wait1 = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(1))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait1.until(new ExpectedCondition<WebElement>() {
            @NullableDecl
            @Override
            public WebElement apply(@NullableDecl WebDriver webDriver) {
                return driver.findElement(By.id("login-button"));
            }
        });
    }



}
