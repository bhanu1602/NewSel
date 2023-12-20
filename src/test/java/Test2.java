import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Test2 {

    WebDriver driver;

    @BeforeTest

    public void setup(){

        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test

    public void test1(){
        String s = driver.getTitle();
        System.out.println(s);
    }

    @Test

    public void selectMultiple(){
        WebElement element = driver.findElement(By.id("colors"));
        Select select = new Select(element);
        if (select.isMultiple()){
            System.out.println("True");
        }else{
            System.out.println("false");
        }

        select.selectByIndex(1);
        select.selectByIndex(2);
        select.selectByIndex(3);
        WebElement option1 = select.getFirstSelectedOption();
        System.out.println(option1.getAttribute("value"));
        List<WebElement> elements = select.getAllSelectedOptions();
        for(WebElement element1: elements){
            System.out.println(element1.getAttribute("value"));
        }
    }

    @AfterTest

    public void close(){

        driver.quit();
    }
}
