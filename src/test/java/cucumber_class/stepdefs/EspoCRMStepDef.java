package cucumber_class.stepdefs;

import Utils.Driver;
import cucumber_class.pages.EspoCRMHomePage;
import cucumber_class.pages.EspoCRMLoginPage;
import cucumber_class.pages.EtsyResultsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class EspoCRMStepDef {

    WebDriver driver = Driver.getDriver("chrome");
    EspoCRMHomePage espoCRMHomePage=new EspoCRMHomePage(driver);

    @Given("user navigates to {string}")
    public void user_navigates_to(String string) {
        driver.get(string);
    }

    @When("the user opens the home page")
    public void the_user_opens_the_home_page() {
        EspoCRMLoginPage espoLogin = EspoCRMLoginPage.getEspoLoginPage(driver);
        espoLogin.clickLoginButton();
    }

    @Then("the user should see the function names")
    public void the_user_should_see_the_function_names(DataTable dataTable) {
        List<Map<String, String>> dataTableList = dataTable.asMaps();
        Map<String, String> dataMap = dataTableList.get(0);
        for (int i=0;i<espoCRMHomePage.getFunctions().size();i++){
         String functionNumber= String.valueOf(i);
            System.out.println(dataMap.get(functionNumber));
            System.out.println(espoCRMHomePage.getFunctions().get(i).getText());
            Assert.assertEquals(dataMap.get(functionNumber), espoCRMHomePage.getFunctions().get(i).getText());

        }

    }

}
