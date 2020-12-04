package selenium_class.Sentrifugo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        //initElements method will initialize the webelements
        //'this' keyword refers the class itself
        PageFactory.initElements(driver,this);

    }

    //We will be using FindBy annotation to store the webelements inside the class
        @FindBy(id = "username")
        public WebElement userName;

        @FindBy(id = "password")
         public  WebElement passWord;


        @FindBy(id = "loginsubmit")
        public WebElement loginButton;

        @FindBy(xpath = "//input[@id='password']/following-sibling::div")
        public WebElement errorMessage;

        public  void login(String username, String password){
            userName.sendKeys(username);
            passWord.sendKeys(password);
            loginButton.click();



        }









}
