package selenium_class.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathPractice {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src//chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.get("file:///C:/Users/black/OneDrive/Masa%C3%BCst%C3%BC/HTML/Techtorial.html");

        WebElement register= driver.findElement(By.xpath("//a[starts-with(@href, 'mercuryr')]"));
        System.out.println(register.getText());

        WebElement contact=driver.findElement(By.xpath("//td[(@name='contactbtn')]//a"));
        System.out.println(contact.getText());

    }
}
