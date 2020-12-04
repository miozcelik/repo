package selenium_class.AlertPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertTest {

    WebDriver driver;
    SoftAssert softAssert;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        softAssert = new SoftAssert();

    }

    @Test
    public void validateHtmlPopup() throws InterruptedException {
        driver.navigate().to("https://sweetalert.js.org/");

        WebElement htmlPreview = driver.findElement(By.xpath("//button[contains(@onclick,'swal')]"));
        htmlPreview.click();
        Thread.sleep(2000);
        WebElement errorSymbol = driver.findElement(By.xpath("//div[@role='dialog']//div[contains(@class, 'swal-icon--error')]"));

        softAssert.assertTrue(errorSymbol.isDisplayed());

        WebElement swalTitle = driver.findElement(By.xpath("//div[@class='swal-title']"));
        String actualTitle = swalTitle.getText();
        String expectedTitle = "Oops";

        softAssert.assertEquals(actualTitle, expectedTitle);

        WebElement swalText = driver.findElement(By.xpath("//div[@class='swal-text']"));
        String actualText = swalText.getText();
        String expectedText = "Something went wrong!";

        softAssert.assertEquals(actualText, expectedText);

        WebElement okButton = driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();

        softAssert.assertAll("HTML Popup Validation Message");
    }

    @Test
    public void validateJSAlert() {
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();

        Alert alert = driver.switchTo().alert();
        //We have 4 methods inside alert class 1-accept() 2-Dismiss() 3-getText() 4-sendKey()
        String actualMessage = alert.getText();
        String expectedMessage = "I am a JS Alert";


        softAssert.assertEquals(actualMessage, expectedMessage);

        alert.accept();

        WebElement resultMessage = driver.findElement(By.id("result"));
        String actualResult = resultMessage.getText();
        String expectedResult = "You successfuly clicked an alert";

        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll("JS Alert Validation");

    }

    @Test
    public void validateJsPrompt() {
        driver.navigate().to(" https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();

        Alert alert = driver.switchTo().alert();

        String actualAlertText = alert.getText();
        String expectedAlertText = alert.getText();

        softAssert.assertEquals(actualAlertText, expectedAlertText);

        alert.sendKeys("Techtorial");

        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        String actualResult = result.getText();
        String expectedResult = "You entered: Techtorial";
        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll("Validate of JS Prompt");


    }

    @Test
    public void validateJsDismiss() { //dismiss will click cancel button
        driver.navigate().to(" https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();

        Alert alert = driver.switchTo().alert();

        String actualAlertText = alert.getText();
        String expectedAlertText = alert.getText();

        softAssert.assertEquals(actualAlertText, expectedAlertText);

        alert.sendKeys("Techtorial");

        alert.dismiss(); //it will click cancel button on js alert

        WebElement result = driver.findElement(By.id("result"));
        String actualResult = result.getText();
        String expectedResult = "You entered: null";
        softAssert.assertEquals(actualResult, expectedResult);

        softAssert.assertAll("Validation of JS Prompt dismiss");

    }
}