package cucumber_class.stepdefs;

import Utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchGoogleStepDefs {

    WebDriver driver= Driver.getDriver("chrome");


    @When("user navigates to {string} search page")
    public void user_navigates_to(String url) {
        driver.get(url);

    }


        @When("user is searching for cucumber on google result page")
        public void user_is_searching_for_cucumber_google() {
            driver.findElement(By.name("q")).sendKeys("cucumber" + Keys.ENTER);

        }


    @Then("user validates the number of google search results to be more than {int}")
    public void user_validates_the_number_of_search_results_to_be_more_than(Integer int1) {

    }

    @When("user enters {string} in search field")
    public void user_enters_in_search_field(String string) {

    }


    @When("user searches for {string} on google")
    public void userSearchesForOnGoogle(String searchCriteria) {
        System.out.println("Searching for " + searchCriteria);
        driver.findElement(By.name("q")).sendKeys(searchCriteria + Keys.ENTER);

    }


    @Then("the number of links on 1st and 2nd result pages more than {int}")
    public void theNumberOfLinksOn1stAnd2ndResultPagesMoreThan(Integer expectedNumOfLinks) {
     List<WebElement> actualLinksListFromPage1= driver.findElements(By.xpath("//h3[contains(@class,'LC20lb')]"));


        System.out.println("Navigate to 2nd result page #2");
        WebElement page2 = driver.findElement(By.xpath("//span[text()='Next']"));
        page2.click();


        List<WebElement> actualLinksListFromPage2= driver.findElements(By.xpath("//h3[contains(@class,'LC20lb')]"));
        int totalNumberOfLinksFrom2Pages= actualLinksListFromPage1.size()+ actualLinksListFromPage2.size();

        Assert.assertTrue("Failed to verify total number of links from 2 pages",
                totalNumberOfLinksFrom2Pages >= expectedNumOfLinks);

   //HOMEWORK

        //RUN ETTIGIMIZ ZAMAN 2. SAYFADA OLDUGUMUZDAN EMIN OLALIM. ODEV


    }


}
