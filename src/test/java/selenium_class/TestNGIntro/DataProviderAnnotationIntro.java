package selenium_class.TestNGIntro;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnnotationIntro {
    WebDriver driver;



    @BeforeMethod
    public void setup(){
        driver=Driver.getDriver("chrome");

    }

    @Test(dataProvider = "testData")
    public void test1(String firstName,String lastName){

        System.out.println("First name:"+ firstName +", last name: "+ lastName);

    }


    @DataProvider(name="testData")
    public Object[][] getTestData(){
        return new Object[][]{
                {"John", "Smith"},
                {"Mike","Green"},
                {"Priyanka", "Khan"},
                {"admin","Admin123"},
                {" ", "Admin123"},
                {" ", " "},
                {"admin1","adminadmin"}
        };
    }

    @Test(dataProvider = "testData")
    public void logintest(String username, String password)  {

       WebDriver driver= Driver.getDriver("chrome");
       driver.get("https://demo.openmrs.org/openmrs/login.htm");

        WebElement enterUserName=driver.findElement(By.id("username"));
        enterUserName.sendKeys(username);

        WebElement enterPassword=driver.findElement(By.cssSelector("#password"));
        enterPassword.sendKeys(password);

        WebElement loginButton=driver.findElement(By.xpath("//input[@id='loginButton']"));
        loginButton.click();

        WebElement errorMessage=driver.findElement(By.cssSelector("#sessionLocationError"));
        Assert.assertEquals(errorMessage.getText(), "You must choose a location!");





    }

    @AfterMethod
    public void cleanup(){
        driver.quit();
        driver=null;
    }


}
