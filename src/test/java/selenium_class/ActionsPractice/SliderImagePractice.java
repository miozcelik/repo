package selenium_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class SliderImagePractice {


    @Test
    public void validateYCoordinate(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demos.telerik.com/kendo-ui/slider/angular");

        WebElement redCircle= driver.findElement(By.xpath("//div[contains(@class,'vertical')]//a[@role='slider']"));
        WebElement ten=driver.findElement(By.xpath("//div[contains(@class,'vertical')]//li[@title='10']"));
        WebElement zero=driver.findElement(By.xpath("//div[contains(@class,'vertical')]//li[@title='0']"));

        Point tenPoint=ten.getLocation();
        Point zeroPoint= zero.getLocation();
        System.out.println(tenPoint.getY());
        System.out.println(zeroPoint.getY());
        System.out.println(tenPoint.getY()- zeroPoint.getY());



        Actions actions=new Actions(driver);
        actions.clickAndHold(redCircle)
                .moveByOffset(0,25)
                .release()
                .perform();





    }

    @Test
    public void validateXCoordinate(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demos.telerik.com/kendo-ui/slider/angular");

        WebElement redCircle= driver.findElement(By.xpath("//div[contains(@class,'horizontal')]//a[@role='slider']"));
        WebElement ten=driver.findElement(By.xpath("//div[contains(@class,'horizontal')]//li[@title='10']"));
        WebElement zero=driver.findElement(By.xpath("//div[contains(@class,'horizontal')]//li[@title='0']"));

        Point tenPoint=ten.getLocation();
        Point zeroPoint= zero.getLocation();
        System.out.println(tenPoint.getX());
        System.out.println(zeroPoint.getX());
        System.out.println(tenPoint.getX()- zeroPoint.getX());
        int difference= tenPoint.getX()-zeroPoint.getX();


        Actions actions=new Actions(driver);
        actions.clickAndHold(redCircle)
                .moveByOffset(difference+5,0)
                .release()
                .perform();
    }


}
