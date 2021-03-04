package PageObjectModel.Pages;

import PageObjectModel.Functions;
import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Bag extends Functions {
    WebDriver driver;

    public Bag(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h3[@class='gl-hidden-s-m gl-vspace-bpall-medium']")
    private WebElement bagMessage;

    public void verifyBag(){
        assertionFunction(bagMessage, "YOUR BAG");
    }

    public void verifyBagPage(){
        String bagLink = "https://www.adidas.co.uk/cart";
        String  currentUrl = driver.getCurrentUrl();
        compareUrlFunction(bagLink, currentUrl);
    }

    @FindBy(xpath = "(//div[@class='line-item__attribute___1qTmy'])[1]")
    private WebElement firstItemSize;

    public void verifyItemSize(){
        compareSizeFunction(firstItemSize,"M" );
    }

    @FindBy(xpath = "(//button[@class='gl-cta gl-cta--icon gl-cta--no-border'])[1]")
    private WebElement firstItemRemoveButton;

    public void removeItem(){
        clickFunction(firstItemRemoveButton);
    }

    @FindBy(xpath = "//h3[@class='no-gutters col-s-12']")
    private WebElement emptyBagMessage;

    public void checkBag(){
        assertionFunction(emptyBagMessage, "YOUR BAG IS EMPTY");
    }


}


