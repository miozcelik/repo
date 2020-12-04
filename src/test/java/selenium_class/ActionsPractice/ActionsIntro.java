package selenium_class.ActionsPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsIntro {


    WebDriver driver;
    // Before Class Annotation will run before everything in this class
    @BeforeClass
    public void initialize(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    @Test
    public void validationOfContextClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement box=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        // If you are using the perform method from Actions class you don't need to use the build method
        actions.contextClick(box).perform();
        // Once you use the Action interface you need to use the build() then perform() method.
//        Action action=actions.contextClick(box).build();
//        action.perform();
    }
    @Test
    public void validateHoverOverAction() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        // control + z --> it will bring deleted text back
        List<WebElement> headers=driver.findElements(By.xpath("//h5"));
        for ( WebElement header :headers ) {
            System.out.println("header: "+ header.getText());
        }
        List<WebElement> images=driver.findElements(By.xpath("//div[@id='content']//img"));
        Actions actions=new Actions(driver);
        for(int i=0;i<images.size();i++){
            actions.moveToElement(images.get(i)).perform();
            System.out.println("header2: "+headers.get(i).getText());
        }
    }
    @Test
    public void validationOfDoubleClick(){
        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        // TASK: Navigate to the page and find all click and doubleclick buttons on the page
        // and print the text (click and doubleClick)  for those webelements
        List<WebElement> buttons=driver.findElements(By.xpath("//table//div[@class='ui-panel-content ui-widget-content']"));
        for(WebElement button : buttons){
            switch (button.getText()){
                case "click":
                    button.click();
                    break;
                case "doubleclick":
                    Actions actions=new Actions(driver);
                    actions.doubleClick(button).perform();
                    break;
            }
        }
    }

}
