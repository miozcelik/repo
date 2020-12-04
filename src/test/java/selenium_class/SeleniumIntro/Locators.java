package selenium_class.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src//chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("file:///C:/Users/black/OneDrive/Masa%C3%BCst%C3%BC/HTML/Techtorial.html");

        WebElement addressOne=driver.findElement(By.name("address1"));
        addressOne.sendKeys("2200E Devon Ave");

        WebElement addressTwo=driver.findElement(By.name("address2"));
        addressTwo.sendKeys("Suite 309");

        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("Des Plaines");

        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("IL");

        WebElement postalCode=driver.findElement(By.className("pstlCode"));
        postalCode.sendKeys("60008");

        WebElement country=driver.findElement(By.name("country"));
        country.sendKeys("ANDORRA");

        WebElement header=driver.findElement(By.tagName("h1"));
        //header.sendKeys("test"); //ElementNotInteractableRException
        System.out.println(header.getText());

        WebElement bTag=driver.findElement(By.tagName("b"));
        //FindElement method returns single web element.
        //If we have more one matching LOCATOR VALUE IN THE HTML
        //find element method returns only first matching web element
        System.out.println(bTag.getText());

        WebElement seleniumButton=driver.findElement(By.linkText("Selenium"));
        //I have only one matching a tag on the html which has Selenium text.That's why Its unique Element.
        seleniumButton.click();
        driver.navigate().back();

        WebElement testNg=driver.findElement(By.linkText("TestNG"));
        testNg.click();
        driver.navigate().back();

        WebElement restApi= driver.findElement(By.partialLinkText("Rest"));
        restApi.click();
        driver.navigate().back();

        ////////////
        addressOne=driver.findElement(By.name("address1"));
        addressTwo=driver.findElement(By.name("address2"));
        city=driver.findElement(By.name("city"));
        state=driver.findElement(By.name("state"));


        addressOne.clear();
        addressTwo.clear();
        city.clear();
        state.clear();

        WebElement cucumber=driver.findElement(By.linkText("Cucumber"));
        //cucumber.submit();

        WebElement submitButton=driver.findElement(By.id("submitbutton"));
        submitButton.click();





    }
}
