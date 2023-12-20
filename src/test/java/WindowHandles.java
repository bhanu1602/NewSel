import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandles {

    WebDriver driver;


    @BeforeTest

    public void Setup() {

        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        driver = new OperaDriver();

        driver.get("https://www.salesforce.com/ap/?ir=1");
        driver.manage().window().maximize();
    }

    @Test
    public void Test1() throws InterruptedException{

        //Handling Tab in browser
        driver.findElement(By.xpath("//body/main[@id='main-content']/div[2]/section[1]/div[1]/article[1]/div[2]/div[1]/pbc-button[1]/a[1]")).click();
        Thread.sleep(10000);

        Set<String> windowHandles = driver.getWindowHandles();

        String webtitle = "CRM Free Trial: Salesforce 30-Day Trial - Salesforce";

        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (handle.equals(webtitle)) {
                System.out.println("New Tab Title: " + driver.getTitle());
                break;
            }
        }
        driver.findElement(By.id("UserFirstName-Sw7Z']")).sendKeys("ABC");
        driver.findElement(By.id("UserLastName-P18s")).sendKeys("DEF");
    }


    @AfterTest
    public void quit(){
        driver.quit();
    }
}
