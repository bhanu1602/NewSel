import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingAlerts {

    WebDriver driver;

    @BeforeTest

    public void setup(){
        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        driver = new OperaDriver();

        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
        driver.manage().window().maximize();
    }

    @Test

    public void Test1(){

        //alert and accept
        driver.findElement(By.name("alert")).click();
        driver.switchTo().alert().accept();

        //prompt and enter text
        WebElement element = driver.findElement(By.name("prompt"));
        element.click();

        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Pras");
        promptAlert.dismiss();
    }

    @Test
    public void Test2(){
        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[text() = 'Digest Authentication']")).click();
        driver.switchTo().alert().sendKeys("user");
    }

    @AfterTest
    public void sleep(){
        driver.quit();
    }
}
