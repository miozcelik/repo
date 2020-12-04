package cucumber_class.stepdefs;

import Utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class TechtorialStepDefs {

    WebDriver driver = Driver.getDriver("chrome");

    @When("user navigates to Techtorial academy home page")
    public void user_navigates_to_techtorial_academy_home_page() {
        System.out.println("User navigates to Techtorial academy home page");
        driver.get("https://www.techtorialacademy.com/");

    }

    @When("user uses {string} as username abd {string} as password")
    public void user_uses_as_username_abd_as_password(String string, String string2) {


        System.out.println("User tries to log in");
        WebElement studentLogin = driver.findElement(By.xpath("(//a[contains(text(),'Student login')])[2]"));
        studentLogin.click();

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .pollingEvery(Duration.ofSeconds(2))
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(ElementNotInteractableException.class);
        WebElement emailField = fluentWait.until(myDriver -> {
            WebElement emailFieldInt = myDriver.findElement(By.name("signup[signup_email]"));
            emailFieldInt.sendKeys("admin");
            return emailFieldInt;
        });
        WebElement passwordField = driver.findElement(By.name("signup[signup_password]"));
        passwordField.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.cssSelector("#LoginSubmit"));
        loginButton.click();


    }

    @Then("user logged in")
    public void user_logged_in() {

        System.out.println("User was able to log in");
        WebElement error = driver.findElement(By.xpath("//div[@class='toast-message']"));
        WebElement error2 = driver.findElement(By.xpath("//div[@class='toast-title']"));
        Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.getText(), "Invalid Email or Password");
        Assert.assertTrue(error2.isDisplayed());
        Assert.assertEquals(error2.getText(), "Error");


    }

}
