package cucumber_class.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EspoCRMLoginPage {

    private EspoCRMLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "btn-login")
    WebElement loginButton;

    public static EspoCRMLoginPage getEspoLoginPage(WebDriver driver){
        return new EspoCRMLoginPage(driver);
    }

    public void clickLoginButton(){
        loginButton.click();
    }


}

