package selenium_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsMethod {

    //Drag and drop blue circle inside the orange box and validate "you did great text" is displayed

    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

       Thread.sleep(1000);

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.xpath("//div[@class='test2']"));


        Actions actions=new Actions(driver);
        actions.dragAndDrop(source,target).perform();


        target=driver.findElement(By.xpath("//div[@class='test2']")); // we have to copy paste it here to be able to handle the exception

        String actual=target.getText();
        String expected="You did great!";
        Assert.assertEquals(actual,expected);

    }
}
