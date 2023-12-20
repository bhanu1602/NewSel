import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;

public class Examples{
        public static void main(String[] args) throws InterruptedException { //thread used to wait

            System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
            WebDriver driver = new OperaDriver();

            driver.get("https://www.saucedemo.com/v1/");
            driver.manage().window().maximize();
            Thread.sleep(5000); //thread used to wait
            String title = driver.getTitle();
            Assert.assertTrue(title.equals("Swag Labs"));
            driver.quit();
        }
    }

