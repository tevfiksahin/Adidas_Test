package PageObjectModel.PopUpWindows;

import PageObjectModel.Functions;
import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp extends Functions {
    WebDriver driver;

    public SignUp(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement signUpWindowCloseButton;

    public void closeSignUpWindow(){
        clickFunction(signUpWindowCloseButton);
    }

}
