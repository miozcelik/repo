package selenium_class.SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntro {

    public static void main(String[] args) {

        //windows os should add chromedriver.exe

        System.setProperty("webdriver.chrome.driver","src//chromedriver.exe");
        //WebDriver is an interface.Thats we can not instantiate the Webdriver with new WebDriver();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com/");
        String googleTitle=driver.getTitle();
        System.out.println(googleTitle);

        driver.get("https://www.techtorialacademy.com/");
        String techtorialTitle=driver.getTitle();
        System.out.println(techtorialTitle);


        if(techtorialTitle.equals("Home Page - Techtorial")) {
            System.out.println("Title is correct");
        }else{
            System.out.println("Title is not correct");


        }
        //GET CURRENT URL
        String currentUrl=driver.getCurrentUrl();
        System.out.println(currentUrl);

      //  System.out.println(driver.getPageSource());

        /*
        There are 2 ways to navigate to the page
        1-driver.get("url"); -- It wait until you page loaded
        2-driver.navigate().to("url);- It will not wait whole page to load
         */

        driver.navigate().to("https://www.facebook.com/");

        driver.navigate().back();

        driver.navigate().forward();







    }
}
