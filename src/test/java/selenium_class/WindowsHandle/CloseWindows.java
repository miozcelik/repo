package selenium_class.WindowsHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseWindows {

    @Test
    public void validateWindowClose(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://www.popuptest.com/popuptest12.html");
        String parentId=driver.getWindowHandle();

        BrowserUtils.closeWindows(driver,parentId);

        System.out.println(driver.getCurrentUrl());


    }
}
