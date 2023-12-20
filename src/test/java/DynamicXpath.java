import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicXpath {


    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.get("https://fs2.formsite.com/meherpavan/form2/index.html?1537702596407");
    }


    //Dynamic Xpath using 'or' and 'and'
    @Test
    public void Test1() throws InterruptedException{
        driver.findElement(By.xpath("//*[@id = 'RESULT_TextField-1' or @name = 'RESULT_TextField-1']")).sendKeys("ABCD");
        driver.findElement(By.xpath("//*[@id = 'RESULT_TextField-2' and @name = 'RESULT_TextField-2']")).sendKeys("DEFG");
        Thread.sleep(3000);
    }

    //contains and starts-with method
    @Test
    public void Test2(){
        driver.findElement(By.xpath("//*[contains(@id, '-3')]")).sendKeys("999999999");
        driver.findElement(By.xpath("//*[starts-with(@id, 'RESULT_TextField-4')]")).sendKeys("India");
    }

    //Xpath with text

    @Test
    public void Test3(){
        driver.findElement(By.xpath("//a[text() = 'Software Testing Tutorials']")).click();
    }

    //chained Xpath
    @Test
    public void Test4(){
        driver.findElement(By.xpath("//form[@id = 'FSForm']//input[@name = 'Submit']")).click();
    }

    @AfterTest
    public void down(){
        driver.quit();
    }

}
