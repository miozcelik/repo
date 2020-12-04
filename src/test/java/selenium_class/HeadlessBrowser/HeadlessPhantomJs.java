package selenium_class.HeadlessBrowser;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HeadlessPhantomJs {

    WebDriver driver;

    @BeforeMethod

    public void setup(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headless");
        driver=new ChromeDriver(options);


    }

    @Test
    public void phantomTest() throws IOException {
        driver= new PhantomJSDriver();
        driver.get("https://www.techtorialacademy.com/");
        BrowserUtils.takeScreenshot(driver,"phantom");
    }

}
