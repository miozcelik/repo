package selenium_class.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumMethods {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src//chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("file:///C:/Users/black/OneDrive/Masa%C3%BCst%C3%BC/HTML/Techtorial.html");

        WebElement submitButton=driver.findElement(By.id("submitbutton"));
        System.out.println(submitButton.getText());
        System.out.println(submitButton.getAttribute("value"));
        System.out.println(submitButton.getAttribute("type"));

        WebElement nextPage=driver.findElement(By.tagName("button"));
        System.out.println(nextPage.getText());

        WebElement javaButton=driver.findElement(By.linkText("Java"));
        System.out.println(javaButton.getAttribute("href"));

        javaButton.click();

        WebElement seleniumButton=driver.findElement(By.linkText("Selenium"));
        seleniumButton.click();

        WebElement cucumberButton=driver.findElement(By.linkText("Cucumber"));
        cucumberButton.click();

        //driver.close(); // It will close one of them the tab which driver is pointing
        driver.quit(); // it will close all the tabs which is opened using driver
    }
}
