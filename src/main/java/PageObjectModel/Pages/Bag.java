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

    @FindBy(xpath = "(//div[@class='line-item__attribute___1qTmy'])[1]")
    private WebElement firstItemSize;

    public void verifyItemSize(){
        compareSizeFunction(firstItemSize,"M" );
    }

    @FindBy(xpath = "(//button[@class='gl-cta gl-cta--icon gl-cta--no-border'])[1]")
    private WebElement firstItemRemoveButton;

    public void removeFirstItem(){
        clickFunction(firstItemRemoveButton);
    }


}


