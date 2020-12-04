package cucumber_class.stepdefs;

import Utils.Driver;
import cucumber_class.pages.EtsyHomePage;
import cucumber_class.pages.EtsyResultsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class EtsyStepDef {


    WebDriver driver = Driver.getDriver("firefox");

    @Given("user is on etsy home page")
    public void userIsOnEtsyHomePage() {
        driver.get("https://etsy.com");
    }
    @When("user searches for {string}")
    public void userSearchesFor(String searchPhrase) {
        EtsyHomePage etsyHomePage = EtsyHomePage.getEtsyHomePage(driver);
        etsyHomePage.searchField.sendKeys(searchPhrase + Keys.ENTER);
    }
    @Then("the result page has total price more than {int}")
    public void theResultPageHasTotalPriceMoreThan(Integer minimumPrice) {
        EtsyResultsPage etsyResultsPage = EtsyResultsPage.getEtsyResultPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<WebElement> priceList =
                wait.until(ExpectedConditions.visibilityOfAllElements(EtsyResultsPage.getEtsyResultPage(driver).allPrices));
        double totalPrice = 0;
        for (WebElement price : priceList) {
            try {
                totalPrice += Double.parseDouble(price.getText().replace(",", ""));
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        Assert.assertTrue(totalPrice > minimumPrice);
    }








}
