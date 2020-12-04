package selenium_class.Frames;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameTest {

    WebDriver driver;

    @BeforeClass
    public void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @Test
    public void test1(){

        /*
        https://skpatro.github.io/demo/iframes/ navigate to given url and click category1 button and
         print the title of the page from new window
        then click category3 button and print url of the page from new window
         */
        driver.get(" https://skpatro.github.io/demo/iframes/");
        String idOfParentPage=driver.getWindowHandle();

        driver.switchTo().frame("Frame1");
        WebElement category1=driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();

        String newUrl="http://qavalidation.com/category/seleniumtesting/";
        BrowserUtils.switchByUrl(driver,newUrl);
        System.out.println(driver.getTitle());

        //We are inside the main page
        BrowserUtils.switchById(driver,idOfParentPage);
        //we need to switch to the second frame to click category3 button
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();
        //It will open new window and we need to switch to new window after clicking category3 button.
        BrowserUtils.switchByUrl(driver,"http://qavalidation.com/category/softwaretesting/");
        System.out.println(driver.getCurrentUrl());


    }

}
