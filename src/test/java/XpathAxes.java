import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;

import java.util.List;

public class XpathAxes {

    public static void main(String[] args) {

        System.setProperty("webdriver.opera.driver", "resources/operadriver.exe");
        WebDriver driver = new OperaDriver();

        driver.get("https://money.rediff.com/gainers");
        driver.manage().window().maximize();

        //self node 'always one'
        String text = driver.findElement(By.xpath("//a[normalize-space()='Goblin India']/self::a")).getText();
        System.out.println("Get self node text: "+text);

        //Parent node 'always one'
        text = driver.findElement(By.xpath("//a[normalize-space()='Goblin India']/parent::td")).getText();
        System.out.println("Get parent node text" +text);

        //child node 'all children'
        List <WebElement> child = driver.findElements(By.xpath("//a[normalize-space()='Goblin India']/ancestor::tr/child::td"));
        System.out.println("Number of child nodes: " +child.size());

        //ancestor 'parent and grand parents'
        text = driver.findElement(By.xpath("//a[normalize-space()='Goblin India']/ancestor::tr")).getText();
        System.out.println("Get ancestor node text: "+text);

        //descendant 'children and grand children'
        List <WebElement> descendants = driver.findElements(By.xpath("//a[normalize-space()='Goblin India']/ancestor::tr/descendant::*"));
        System.out.println("Number of descendant nodes: " +descendants.size());

        //following nodes 'starts with current node and till the end of the page'
        List <WebElement> followingNodes = driver.findElements(By.xpath("//a[normalize-space()='Goblin India']/ancestor::tr/following::tr"));
        System.out.println("Number of following nodes: " +followingNodes.size());

        //following siblings
        List <WebElement> siblingNodes = driver.findElements(By.xpath("//a[normalize-space()='Goblin India']/ancestor::tr/following-sibling::tr"));
        System.out.println("Number of following sibling nodes: " +siblingNodes.size());

        //preceding 'selects all from the root node'
        List <WebElement> precedingNodes = driver.findElements(By.xpath("//a[normalize-space()='Goblin India']/ancestor::tr/preceding::tr"));
        System.out.println("Get the preceding elements " +precedingNodes.size());

        //preceding sibling 'selects all from the root node'
        List <WebElement> precedingSiblingNodes = driver.findElements(By.xpath("//a[normalize-space()='Goblin India']/ancestor::tr/preceding-sibling::tr"));
        System.out.println("Get the preceding siblings "+precedingSiblingNodes.size());



        driver.quit();


    }
}
