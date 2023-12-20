import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class cssSelectors {

    public static void main(String[] args) {

        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        WebDriver driver = new OperaDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        //Tag and ID
        driver.findElement(By.cssSelector("#email")).sendKeys("Dany");
        driver.findElement(By.cssSelector("input#email")).sendKeys("Dany");

        //Tag and Class
        driver.findElement(By.cssSelector("input.inputtext")).sendKeys("Daya");
        driver.findElement(By.cssSelector(".inputtext")).sendKeys("Daya");

        //Tag and Attribute
        driver.findElement(By.cssSelector("[name = email]")).sendKeys("Ariana");
        driver.findElement(By.cssSelector("input[name = email]")).sendKeys("Ariana");


        //Tag, Class and Attribute
        driver.findElement(By.cssSelector("input.inputtext[data-testid=royal_email]")).sendKeys("Smith");
        driver.findElement(By.cssSelector("input.inputtext[data-testid=royal_pass]")).sendKeys("abc");
        driver.quit();
    }
}
