package selenium_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropPractice {

    @Test
    public void validateDragAndDrop(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));

        Actions actions=new Actions(driver);
        actions.clickAndHold(source).moveToElement(target).release(target).perform();

        String actual=target.getText();
        String expected="You did great!";
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void validateDragAndDropMethod(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(source, target).perform();

        String actual=target.getText();
        String expected="You did great!";
        Assert.assertEquals(actual,expected);
    }

    }

