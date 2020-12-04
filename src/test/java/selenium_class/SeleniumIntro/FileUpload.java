package selenium_class.SeleniumIntro;

import Utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUpload {

    @Test
    public void uploadFile(){
        WebDriver driver= Driver.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/upload");


        WebElement chooseFileButton= driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("C:\\Users\\black\\OneDrive\\Masaüstü\\HTML\\htmlpractice.html");
        // we have to add the file which we created inside of our terminal

        WebElement uploadButton=driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.click();
/*
        1. Navigate to https://the-internet.herokuapp.com/upload
        2. upload the file from your computer
        3. Verify the success upload message
        4. Verify the file name is correct
        1. Navigate to https://demo.openmrs.org/openmrs/login.htm
        2. Enter different usernames and passwords (from @DataProviders)
        3. Choose a location
        4. Click on login button
        5. Verify the success/failure message is shown
 */

    }
}
