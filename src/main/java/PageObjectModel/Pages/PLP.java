package PageObjectModel.Pages;

import PageObjectModel.Functions;
import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PLP extends Functions {
    WebDriver driver;

    public PLP(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//a[@class='gl-product-card__assets-link'])[1]")
    private WebElement productLink;
    public void verifyPageAndProduct(){
        String firstItemLink = productLink.getAttribute("href");
        System.out.println("First Item link "+firstItemLink);
       // compareFunction(driver, firstItemLink);

    }

    @FindBy(xpath = "(//div[@class='grid-item___3rAkS'])[1]")
    private WebElement firstItem;

    public void selectFirstItem(){
        clickFunction(firstItem);
    }



    @FindBy(css = "a.variation___32b4d:last-child")
    private WebElement lastColor;

    public void selectLastColor(){
        clickFunction(lastColor);
    }

    @FindBy(xpath = "(//button[@class='gl-label size___TqqSo'])[1]")
    private WebElement pickAnySize;

    public void selectSize(){
        clickFunction(pickAnySize);
    }

    @FindBy(xpath = "//button[@title='Add To Bag']")
    private WebElement addToCartButton;

    public void addToCart(){
        clickFunction(addToCartButton);
    }

    @FindBy(xpath = "(//button[@class='gl-label size___TqqSo'])[2]")
    private WebElement newSize;

    public void setNewSize(){
        clickFunction(newSize);
    }



}
