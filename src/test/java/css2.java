import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class css2 {

    public static void main(String[] args) {
        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        WebDriver driver = new OperaDriver();

        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/css-selectors-practice.html");
        String s = driver.getTitle();
        System.out.println(s);

        //Tag and ID input#firstName
        driver.findElement(By.cssSelector("#lastName")).sendKeys("Bhanu");

        //Tad and ClassName input.name
        driver.findElement(By.cssSelector(".name")).sendKeys("Prasad");

        //Tag and Attribute input[placeholder = Gender]
        driver.findElement(By.cssSelector("[placeholder = Gender]")).sendKeys("Male");

        //Tag, class and attribute;

        driver.quit();



    }
}

