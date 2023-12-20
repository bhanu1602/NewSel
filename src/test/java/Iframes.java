import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Iframes {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        driver = new OperaDriver();

        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.xpath("//*[@id = 'tinymce']/p")).sendKeys("Hi, there");
    }
}
