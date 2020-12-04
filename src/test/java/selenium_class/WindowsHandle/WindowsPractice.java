package selenium_class.WindowsHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsPractice {


    @Test
    public void validateWindowHandle(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement clickHere=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();

        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());

        String currentPageId=driver.getWindowHandle();
        Set<String> ids=driver.getWindowHandles();

        for(String id : ids){
            if (!id.equals(currentPageId)){
                //it will switch to the new window
                driver.switchTo().window(id);
            }
        }
        //it will throw stale element exception since we switch driver to the new window
        WebElement clickButton=driver.findElement(By.xpath("//a[.='Click Here']"));
        clickButton.click(); //stale element exception
        WebElement newWindowText= driver.findElement(By.tagName("h3"));
        System.out.println("Text from new window : "+newWindowText.getText());
        Assert.assertEquals(newWindowText.getText(),"New Window");

        driver.switchTo().window(currentPageId);

        WebElement parentPageText= driver.findElement(By.tagName("h3"));
        System.out.println("Text from new window : "+parentPageText.getText());



    }

    @Test
    public void validateNewWindows(){

        /*
        Navigate  to the following page and close all the new windows except your parent window
         */


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.popuptest.com/popuptest12.html");
        String parentWindow = driver.getWindowHandle();
        Set<String> ids=driver.getWindowHandles();

        for(String id : ids) {
            if (!id.equals(parentWindow)) {
                driver.switchTo().window(id);
                driver.close();
            }


        }

       // System.out.println("Title "+driver.getTitle()); ==>since we closed all windows except parent window

        driver.switchTo().window(parentWindow);

        System.out.println("Title1 :"+driver.getTitle());


    }
}
