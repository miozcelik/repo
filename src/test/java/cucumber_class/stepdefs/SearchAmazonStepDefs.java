package cucumber_class.stepdefs;

import Utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchAmazonStepDefs {

    WebDriver driver= Driver.getDriver("chrome");


    @When("user navigates to {string} home page")
    public void user_navigates_to(String url) {
        driver.get(url);

    }

    @When("user is searching for cucumber on amazon result page")
    public void user_is_searching_for_cucumber_amazon() {


        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("cucumber" + Keys.END);

    }

    @Then("user validates the number of amazon search results to be more than {int}")
    public void user_validates_the_number_of_search_results_to_be_more_than(Integer int1) {

    }

}
