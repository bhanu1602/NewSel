import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

public class LocatorsDemo {
    public static void main(String[] args) {

        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        WebDriver driver = new OperaDriver();

        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        //id and name locators are used
        WebElement searchbox = driver.findElement(By.id("username"));
        searchbox.sendKeys("tomsmith");

        WebElement searchbox2 = driver.findElement(By.name("password"));
        searchbox2.sendKeys("SuperSecretPassword!");

        //linktext and partiallinkText

        driver.findElement(By.linkText("Elemental Selenium")).click();
        driver.findElement(By.partialLinkText("Elemental")).click();

        //class name
        int number = driver.findElements(By.className("icard")).size();
        System.out.println(number);

        //tag name
        int links = driver.findElements(By.tagName("a")).size();
        System.out.println(links);

        driver.quit();
    }
}
