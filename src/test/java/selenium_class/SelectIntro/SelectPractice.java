package selenium_class.SelectIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectPractice {


    @Test
    public void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.facebook.com/");
        /*

        TASK:Navigate to facebook page and click create new account button
        -select the month June using by index
        -select the day 26 using by value
        -select the year 1998 using by text
         */
        WebElement clickButton=driver.findElement(By.id("u_0_2"));
        clickButton.click();

        Thread.sleep(2000);

         /*

        TASK:Navigate to facebook page and click create new account button
        -select the month June using by index
        -select the day 26 using by value
        -select the year 1998 using by text
         */


        WebElement month=driver.findElement(By.id("month"));
        Select selectMonth=new Select(month);
        selectMonth.selectByIndex(6);

        WebElement day=driver.findElement(By.id("day"));
        Select selectDay=new Select(day);
        selectDay.selectByValue("26");

        WebElement year=driver.findElement(By.id("year"));
        Select selectYear=new Select(year);
        selectYear.selectByVisibleText("1998");

        Thread.sleep(1000);
        year.sendKeys("2010");




    }

    @Test
    public void test2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.facebook.com/");

        WebElement clickButton=driver.findElement(By.id("u_0_2"));
        clickButton.click();

        Thread.sleep(2000);

        WebElement month=driver.findElement(By.id("month"));
        Select selectMonth=new Select(month);
        //getFirstSelectedOption()--> this method returns the webelement of first selected option
        WebElement selectedOption=selectMonth.getFirstSelectedOption();
        String actual=selectedOption.getText().toLowerCase();

        System.out.println(LocalDate.now().getMonth().toString());

        String expected=LocalDate.now().getMonth().toString().substring(0,3).toLowerCase();; //business requirement

        Assert.assertEquals(actual,expected);

    }

    @Test
    public void test3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.facebook.com/");

        WebElement clickButton=driver.findElement(By.id("u_0_2"));
        clickButton.click();

        Thread.sleep(2000);
        WebElement month=driver.findElement(By.id("month"));
        Select selectMonth=new Select(month);

        //getOptions()==> method return all options under given select element.We can store this method as List of WebElement then get the text

        List<WebElement> options=selectMonth.getOptions();
        ArrayList<String>actualOptions=new ArrayList<>();

        for(WebElement option :options){

            actualOptions.add(option.getText());

        }

        String[] expOptions={"Month","Jan","Feb","Mar","Apr","May","Jun","Jul", "Aug", "Sep","Oct","Nov","Dec"};
        List<String> expectedOptions= Arrays.asList(expOptions);

        Assert.assertEquals(expectedOptions,actualOptions);




    }
}
