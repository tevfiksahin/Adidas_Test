package PageObjectModel.PopUpWindows;

import PageObjectModel.Functions;
import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart extends Functions {
    WebDriver driver;

    public Cart(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h5[@class='gl-heading gl-heading--no-margin gl-modal__title gl-heading--m']")
    private WebElement cartMessage;

    public void verifyItemAdd(){
        assertionFunction(cartMessage, "SUCCESSFULLY ADDED TO BAG!");

    }

    @FindBy(xpath = "(//a[@class='gl-cta gl-cta--primary gl-cta--full-width gl-vspace'])[1]")
    private WebElement viewBagButton;

    public void viewBag(){
        clickFunction(viewBagButton);
    }



}
