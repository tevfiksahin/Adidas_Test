package PageObjectModel.PopUpWindows;

import PageObjectModel.Functions;
import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cookies extends Functions {
    WebDriver driver;

    public Cookies(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"modal-root\"]/div/div/div/div[2]/div/div[2]/button[1]/span")
    private WebElement acceptCookiesButton;

    public void acceptCookies(){
        clickFunction(acceptCookiesButton);
    }

}
