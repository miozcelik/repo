package selenium_class.SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class XPathPro {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("file:///C:/Users/black/OneDrive/Masa%C3%BCst%C3%BC/HTML/Techtorial.html");

        //findElements() method return List<WebElement>

        List<WebElement> titles = driver.findElements(By.xpath("//b"));


        for (WebElement title : titles) {

            System.out.println(title.getText());
        }

        //Store the web element using findElements method and print all the links for those buttons
        //Find the web element
        //print all links for buttons


        List<WebElement> links = driver.findElements(By.xpath("//tr[@valign='top']//a"));

        for (WebElement link : links) {

            System.out.println(link.getAttribute("href"));

        }

       WebElement home=driver.findElement(By.xpath("//a"));

        System.out.println(home.getText());

        List<WebElement> functions=driver.findElements(By.xpath("//a")); // 11 matching value

        for(WebElement function : functions){
            System.out.println(function.getText());
        }


    }
}
