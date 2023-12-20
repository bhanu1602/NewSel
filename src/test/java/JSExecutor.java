import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
public class JSExecutor {

    public static void main(String[] args) {

        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        WebDriver driver = new OperaDriver();

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

       WebElement element = (WebElement) js.executeScript("return document.getElementById('email');");
       element.sendKeys("Bhanu");

        js.executeScript("document.getElementById('email').value = 'Prasu';");

        js.executeScript("document.getElementsByName('login')[0].click();");

        js.executeScript("document.getElementById('email').style.border='2px red solid';");

        js.executeScript("document.getElementById('email').style.background='yellow';");

        js.executeScript("document.getElementById('email').setAttribute('style', 'border:5px red solid; background:yellow');");

        js.executeScript("window.scrollTo(0,500)");

        js.executeScript("window.scrollBy(0,500)");

        js.executeScript("document.getElementById('email').scrollIntoView();");



    }
}
