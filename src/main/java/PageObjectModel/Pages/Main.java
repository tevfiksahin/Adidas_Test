package PageObjectModel.Pages;

import PageObjectModel.Functions;
import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Main extends Functions {

    WebDriver driver;

    public Main(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchBar;

    public void sendKeysToSearchBar(){
        String keyword = "running";
        sendKeysFunction(searchBar, keyword);
        submitFunction(searchBar);
    }

}
