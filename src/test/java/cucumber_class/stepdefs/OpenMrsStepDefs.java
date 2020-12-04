package cucumber_class.stepdefs;

import Utils.Driver;
import Utils.PropertyReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.util.List;
import java.util.Map;

import static Utils.PropertyReader.readPropertyByKey;

//Navigate to
//Log in to Registration Desk
//Verify super user(admin)

public class OpenMrsStepDefs {

    WebDriver driver = Driver.getDriver(readPropertyByKey("browser"));

    @When("user navigates to home page")
    public void user_navigates_to_demo_openmrs_org() {
        System.out.println("Navigating to Open MRS page");
        driver.get("https://demo.openmrs.org");
    }

    @When("user logs in to Registration Desk using {string} and {string}")
    public void user_logs_in_to_registration_desk_using_and(String username, String passWord) {
        System.out.println("Logging in to Registration Desk");
        WebElement registrationDesk = driver.findElement(By.id("Registration Desk"));
        registrationDesk.click();
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(username);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(passWord);
        WebElement logint = driver.findElement(By.id("loginButton"));
        logint.click();
    }

    @Then("verify if user is {string}")
    public void verify_if_user_is(String superUser) {
        WebElement text = driver.findElement(By.xpath("//h4"));
        Assert.assertTrue(text.getText().contains(superUser));
    }

    @Given("user logged in to demo.openmrs.org")
    public void user_logged_in_to_demo_openmrs_org() {
        driver.get("https://demo.openmrs.org");
        System.out.println("Logging in to Registration Desk");
        WebElement registrationDesk = driver.findElement(By.id("Registration Desk"));
        registrationDesk.click();
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Admin123");
        WebElement logint = driver.findElement(By.id("loginButton"));
        logint.click();
    }

    @When("user searches for {int} patient on Find Patient Record page")
    public void user_searches_for_patient_on_find_patient_record_page(Integer int1) {
    }

    @Then("no records found")
    public void no_records_found() {
    }

    @When("user navigates to open MRS home page")
    public void user_navigates_to_open_mrs_home_page() {
        System.out.println("Navigate to open MRS home page");
        driver.get("https://demo.openmrs.org");
    }

    @When("user logs in using following data:")
    public void user_logs_in_using_following_data(io.cucumber.datatable.DataTable dataTable) {
        //we store multiple maps in one list: list of maps
        List<Map<String, String>> dataTableList = dataTable.asMaps();
        //print out the size of list
        System.out.println("Size of list of maps is: " + dataTableList.size());
        //getting first element from list of maps
        Map<String, String> dataMap = dataTableList.get(0);
        //getting username from map
        String usernameValue = dataMap.get("username");
        //getting password from map
        String passwordValue = dataMap.get("password");
        //getting deparment name from map
        String deptName = dataMap.get("departmentName");
        System.out.println("Getting values from datatable:");
        System.out.println("Username: " + usernameValue);
        System.out.println("Password: " + passwordValue);
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(usernameValue);
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(passwordValue);
        WebElement regDesk = driver.findElement(By.id(deptName));
        regDesk.click();
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("user is logged in as {string}")
    public void user_is_logged_in_as(String userInfo) {
        //TODO add implementation
        WebElement title = driver.findElement(By.tagName("h4"));
        Assert.assertTrue(title.getText().contains(userInfo));
    }

    @Given("user logged in to demo.openmrs.org as admin")
    public void user_logged_in_to_demo_openmrs_org_as_admin() {
        System.out.println("Navigate to open MRS home page");
        driver.get("https://demo.openmrs.org");
        System.out.println("Logging in to Registration Desk");
        WebElement registrationDesk = driver.findElement(By.id("Registration Desk"));
        registrationDesk.click();
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(PropertyReader.readPropertyByKey("username"));
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(PropertyReader.readPropertyByKey("password"));
        WebElement logint = driver.findElement(By.id("loginButton"));
        logint.click();
    }

    @When("user registers a new patient with following information:")
    public void user_registers_a_new_patient_with_following_information(io.cucumber.datatable.DataTable dataTable) {
        WebElement registerPatientButton = driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension"));
        registerPatientButton.click();
        List<Map<String, String>> dataList = dataTable.asMaps();
        Map<String, String> dataMap = dataList.get(0);
        String givenName = dataMap.get("GivenName");
        String familyName = dataMap.get("FamilyName");
        String genderValue = dataMap.get("Gender");
        String birthDayValue = dataMap.get("Birthday");
        String birthMonthValue = dataMap.get("BirthMonth");
        String birthYearValue = dataMap.get("BirthYear");
        String addressValue = dataMap.get("Address");
        String cityValue = dataMap.get("City");
        String stateValue = dataMap.get("State");
        String countryValue = dataMap.get("Country");
        String postalCodeValue = dataMap.get("PostalCode");
        String phoneNumberValue = dataMap.get("PhoneNumber");
        String relativeNameValue = dataMap.get("RelativeName");
        System.out.println("Filling up first and last names");
        WebElement givenNameField = driver.findElement(By.name("givenName"));
        WebElement familyNameField = driver.findElement(By.name("familyName"));
        givenNameField.sendKeys(givenName);
        familyNameField.sendKeys(familyName);
        System.out.println("Filling up gender info");
        WebElement genderLabel = driver.findElement(By.id("genderLabel"));
        genderLabel.click();
        Select genderSelect = new Select(driver.findElement(By.id("gender-field")));
        genderSelect.selectByVisibleText(genderValue);
        System.out.println("Filling up birthdate info");
        WebElement birthdateLabel = driver.findElement(By.id("birthdateLabel"));
        birthdateLabel.click();
        WebElement birthdateField = driver.findElement(By.id("birthdateDay-field"));
        birthdateField.sendKeys(birthDayValue);
        WebElement birthMonthField = driver.findElement(By.id("birthdateMonth-field"));
        Select birthMonthDropdown = new Select(birthMonthField);
        birthMonthDropdown.selectByVisibleText(birthMonthValue);
        WebElement birthyearField = driver.findElement(By.id("birthdateYear-field"));
        birthyearField.sendKeys(birthYearValue);
    }

    @Then("new patient is registered")
    public void new_patient_is_registered() {
    }

    @When("user logs in using following data with different table:")
    public void user_logs_in_using_following_data_with_different_table(DataTable dataTable) {
        System.out.println("Getting data from variant 2 datatable");
        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
        String deptNameValue = dataMap.get("departmentName");
        String usernameValue = dataMap.get("username");
        String passwordValue = dataMap.get("password");

        System.out.println("dept name: " + deptNameValue);
        System.out.println("username: " + usernameValue);
        System.out.println("password: " + passwordValue);
    }

    @When("user registers a new patient with following information in a new format:")
    public void user_registers_a_new_patient_with_following_information_in_a_new_format(DataTable dataTable) {

        Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

        String nameValue = dataMap.get("GivenName");
        String familyNameValue = dataMap.get("FamilyName");
        String genderValue = dataMap.get("Gender");
        String birthDayValue = dataMap.get("BirthDay");
        String birthMonthValue = dataMap.get("BirthMonth");
        String birthYearValue = dataMap.get("BirthYear");
        String addressValue = dataMap.get("Address");
        String cityValue = dataMap.get("City");
        String stateValue = dataMap.get("State");
        String countryValue = dataMap.get("Country");
        String postalCodeValue = dataMap.get("PostalCode");
        String phoneNumberValue = dataMap.get("PhoneNumber");
        // String relativeNameValue = dataMap.get("RelativeName"); //NULL


        WebElement registerPatientButton = driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension"));
        registerPatientButton.click();


        WebElement name = driver.findElement(By.name("givenName"));
        name.sendKeys(nameValue);
        WebElement familyName = driver.findElement(By.name("familyName"));
        familyName.sendKeys(familyNameValue);
        WebElement genderButton = driver.findElement(By.xpath("//span[@id='genderLabel']"));
        genderButton.click();
        WebElement option = driver.findElement(By.xpath("//select[contains(@class,'required')]"));
        Select select = new Select(option);
        if (genderValue.contains("F") || genderValue.contains("f")) {
            select.selectByValue("F");
        } else {
            select.selectByValue("M");
        }
        WebElement birthInfoButton = driver.findElement(By.id("birthdateLabel"));
        birthInfoButton.click();
        WebElement bday = driver.findElement(By.id("birthdateDay-field"));
        bday.sendKeys(birthDayValue);
        WebElement bMonth = driver.findElement(By.id("birthdateMonth-field"));
        select = new Select(bMonth);
        select.selectByValue(birthMonthValue);
        WebElement bYear = driver.findElement(By.id("birthdateYear-field"));
        bYear.sendKeys(birthYearValue);
        WebElement addressButton = driver.findElement(By.xpath("//span[text()='Address']"));
        addressButton.click();
        WebElement address1 = driver.findElement(By.xpath("//input[@id='address1']"));
        address1.sendKeys(addressValue);
        WebElement city = driver.findElement(By.id("cityVillage"));
        city.sendKeys(cityValue);
        WebElement state = driver.findElement(By.id("stateProvince"));
        state.sendKeys(stateValue);
        WebElement countryinfo = driver.findElement(By.id("country"));
        countryinfo.sendKeys(countryValue);
        WebElement postalCode = driver.findElement(By.id("postalCode"));
        postalCode.sendKeys(postalCodeValue);
        WebElement phoneNumButton = driver.findElement(By.xpath("//span[text()='Phone Number']"));
        phoneNumButton.click();
        WebElement phoneNum = driver.findElement(By.name("phoneNumber"));
        phoneNum.sendKeys(phoneNumberValue);
        WebElement relativesButton = driver.findElement(By.xpath("//span[text()='Relatives']"));
        relativesButton.click();
        WebElement relativetype = driver.findElement(By.id("relationship_type"));
        select = new Select(relativetype);
        select.selectByVisibleText("Sibling");
        //   WebElement relativename = driver.findElement(By.xpath("//input[@placeholder = 'Person Name']"));
        //  relativename.sendKeys(relativeNameValue);
        WebElement confirmButton = driver.findElement(By.id("confirmation_label"));
        confirmButton.click();
        WebElement confirmationSubmit = driver.findElement(By.id("submit"));
        confirmationSubmit.click();


    }


    @Then("verify new patient is registered")
    public void verify_new_patient_is_registered() {

    }


    @Given("user is logged in to demo.openmrs.org as admin")
    public void user_is_logged_in_to_demo_openmrs_org_as_admin() {
        System.out.println("Navigate to openMRS");
    }


    @When("user creates a new patient with following data: {string}, {string}, {string}")
    public void user_creates_a_new_patient_with_following_data(String givenName, String familyName, String gender) {
        System.out.println("Given name of the new patient: " + givenName);
        System.out.println("Family name of new patient: " + familyName);
        System.out.println("Gender of new patient: " + gender);

    }

    @When("with extra information: {string}, {string}, {int}")
    public void with_extra_information(String birthDay, String birthMonth, Integer birthYear) {
        System.out.println("Birth date is: " + birthDay + " " + birthMonth + " " + birthYear);

    }

    @When("with address: {string}, {string}, {string}, {string}, and {string}")
    public void with_address_and(String address, String city, String state, String country, String postalCode) {
        System.out.println("Patient address is: " + address);
        System.out.println("Patient city is: " + city);
        System.out.println("Patient state is: " + state);
        System.out.println("Patient country is: " + country);
        System.out.println("Patient postalCode is: " + postalCode);


    }

    @Then("new patient has been registered with {string} and {string}")
    public void new_patient_has_been_registered_with_and(String givenName, String familyName) {
        System.out.println("Registered patient name: " + givenName);
        System.out.println("Registered patient family name: " + familyName);


    }

    @Then("address of new patient is {string}, {string}, {string}")
    public void address_of_new_patient_is(String address, String city, String state) {
        System.out.println("Registered patient address: " + address);
        System.out.println("Registered patient city: " + city);
        System.out.println("Registered patient state: " + state);

    }

    @Given("user navigated to openMRS login page with the link {string}")
    public void user_navigated_to_open_mrs_login_page_with_the_link(String url) {
        driver.get(url);
    }

    @When("user uses provides {string} and {string} and {string} to log in")
    public void user_uses_provides_and_and_to_log_in(String username, String password, String location) {
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys(username);

        WebElement passWord = driver.findElement(By.id("password"));

        WebElement locatioN = driver.findElement(By.id(location));

        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
    }

    @Then("user has {string}")
    public void user_has(String errorMessage) {
        WebElement error = driver.findElement(By.id("error-message"));
        String actualErrorMessage = error.getText().trim();
        Assert.assertEquals(actualErrorMessage, errorMessage);


    }

}