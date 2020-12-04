package cucumber_class.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EspoCRMHomePage {

    public EspoCRMHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);


}

@FindBy(xpath = "//li[contains(@class, 'not-in-more')]")
    List<WebElement> functions;

    public List<WebElement> getFunctions() {
        return functions;
    }
}

