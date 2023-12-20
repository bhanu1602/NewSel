import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Xpath2 {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/form");
    }

    //Absolute Xpath
    @Test(priority = 1)
    public void Test1(){
        driver.findElement(By.xpath("/html/body/div/form/div/div[1]/input")).sendKeys("Bhanu");
        driver.findElement(By.xpath("/html/body/div/form/div/div[2]/input")).sendKeys("Prasad");
    }


    //Relative Xpath
    @Test(priority = 2)
    public void Test2(){
        driver.findElement(By.xpath("//*[@id = 'job-title']")).sendKeys("Testing");
    }

    @AfterTest
    public void down(){

        driver.quit();
    }


}
