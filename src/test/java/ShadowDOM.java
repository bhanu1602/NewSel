import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class ShadowDOM {

    public static void main(String[] args) {

        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        WebDriver driver = new OperaDriver();

        driver.get("https://books-pwakit.appspot.com/");
        driver.manage().window().maximize();

        //driver.findElement(By.xpath("//*[@id='input']")).sendKeys("Epic"); //no such element Exception


    }
}
