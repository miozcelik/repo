package selenium_class.SelectIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleTask {

    //navigate to the google and search the selenium then validate all result has selenium keyword

    @Test
    public void testA(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        WebElement searchButton=driver.findElement(By.xpath("//input[@name='btnK']"));
        searchButton.click();
        List<WebElement> titles=driver.findElements(By.xpath("//h3//span"));
        for(WebElement title: titles){
            System.out.println(title.getText());
        }
        for(WebElement title: titles){
            if(!title.getText().equals("")) {
                Assert.assertTrue(title.getText().toLowerCase().contains("selenium"));
            }
        }






    }
}
