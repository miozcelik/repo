package selenium_class.TestNGIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestAnnotation {

    @Test
    public void testA() throws InterruptedException {

        //It will download the chromeDriver for your automation.
        //All dependencies will be downloaded inside .m2 file
        // ~/.m2 and C://users//yourName//2
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.facebook.com/");

        WebElement clickButton=driver.findElement(By.id("u_0_2"));
        clickButton.click();

        Thread.sleep(2000);

        WebElement firstName=driver.findElement(By.name("firstname"));
        firstName.sendKeys("Kral");

        WebElement lastName=driver.findElement(By.name("lastname"));
        lastName.sendKeys("Baron");

        WebElement phoneNum=driver.findElement(By.name("reg_email__"));
        phoneNum.sendKeys("22422251551515");

        WebElement password=driver.findElement(By.id("password_step_input"));
        password.sendKeys("123456");

        WebElement month=driver.findElement(By.id("month"));
        Select selectMonth=new Select(month);
        selectMonth.selectByVisibleText("May");
        Thread.sleep(1000);

        selectMonth.selectByValue("2");
        Thread.sleep(1000);

        selectMonth.selectByIndex(9);


        /*
        -It might be opening new window
        -It might be inside the iframe
        -it might be javascript alert
        -your page might be refreshed after you find the element

         */





    }
}
