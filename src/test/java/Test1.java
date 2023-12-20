import org.openqa.selenium.*;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test1 {

  WebDriver driver;

  @BeforeTest

  public void Setup(){

    System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
    driver = new OperaDriver();

    driver.manage().window().maximize();

    driver.get("https://www.saucedemo.com/v1/");
  }

  @Test

  public void validateTitle(){

    String title = driver.getTitle();
    System.out.println(title);
  }

  @Test(priority = 1)

  public void validateLogin(){

    Point point = driver.manage().window().getPosition();
    System.out.println(point.x);
    System.out.println(point.y);

    Point point1 = new Point(20, 20);
    driver.manage().window().setPosition(point1);

    Dimension dimension = new Dimension(1280, 800);
    driver.manage().window().setSize(dimension);

    driver.findElement(By.id("user-name")).clear();
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    String fontSize = driver.findElement(By.id("user-name")).getCssValue("font-size");
    System.out.println(fontSize);
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("secret_sauce");

    if (driver.findElement(By.id("login-button")).isDisplayed()) {
      driver.findElement(By.id("login-button")).click();
    }
    String url = driver.getCurrentUrl();
    Assert.assertEquals("https://www.saucedemo.com/v1/inventory.html", url);

  }

  @Test(priority = 2)
  public void selectValues(){
    WebElement element = driver.findElement(By.xpath("//select[@class = 'product_sort_container']"));
    Select select = new Select(element);
    select.selectByValue("za");

    if(select.isMultiple()){
      System.out.println("Multiple");
    }else{
      System.out.println("Single");
    }

  }


  @AfterTest

  public void tearDown(){
    driver.quit();
  }

}
