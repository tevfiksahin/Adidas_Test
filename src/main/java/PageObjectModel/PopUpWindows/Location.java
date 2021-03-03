package PageObjectModel.PopUpWindows;

import PageObjectModel.Functions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utilities.Driver;

public class Location extends Functions {
    WebDriver driver;

    public Location(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//span[@class='gl-radio-input__label'])[2]")
    private WebElement countrySelector;

    public void selectCountry(){
        clickFunction(countrySelector);
    }

    @FindBy(xpath ="//button[@type='button' and @aria-label='Go']")
    private WebElement acceptButton;

    public void acceptCountry(){
        clickFunction(acceptButton);
        Actions action = new Actions(driver);
        action.click(acceptButton).build().perform();
    }
}
