package selenium_class.Sentrifugo;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class TestBase {


 //Inside this class I will be initializing the WebDriver and call the driver from this class
//this one will help us to avoid creating WebDriverManager.Chrome().setup .. in every class

    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver= Driver.getDriver("firefox");
        driver= Driver.getDriver("chrome");
        driver.manage().window().maximize();
        System.out.println("setup");

    }


}