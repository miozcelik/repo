package selenium_class.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTech {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src//chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("file:///C:/Users/black/OneDrive/Masa%C3%BCst%C3%BC/Techtorial.html?submitbutton=Next+step");

        WebElement header=driver.findElement(By.id("techtorial1"));

        //get text, click element, is displayed, is selected, send key
        //getText() ---> returns the text frp, web element.Return type of getText method is String.
        System.out.println(header.getText());

        WebElement firstNameInput=driver.findElement(By.id("FrstName"));
        firstNameInput.sendKeys("Muhammed");

        WebElement lastNameInput=driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Ozcelik");

        WebElement  phoneInput=driver.findElement(By.id("phoneNum"));
        phoneInput.sendKeys("2242242424");

        WebElement emailInput=driver.findElement(By.id("userName"));
        emailInput.sendKeys("muhammed@gmail.com");

    }
}
