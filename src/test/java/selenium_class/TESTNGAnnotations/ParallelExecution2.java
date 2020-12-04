package selenium_class.TESTNGAnnotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParallelExecution2 {

    @Test
    @Parameters("url")
    public void navigateToUrl(String myFavUrl){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www." + myFavUrl+ ".com");

        Assert.assertTrue(driver.getCurrentUrl().contains(myFavUrl));

        driver.findElement(By.id("dfd"));

    }
}
