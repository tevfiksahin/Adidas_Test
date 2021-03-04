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


    @FindBy(xpath = "(//div[@class='grid-item___3rAkS'])[1]")
    private WebElement firstItem;

    public void selectFirstItem(){
        clickFunction(firstItem);
    }

    @FindBy(xpath = "(//a[@class='gl-product-card__assets-link'])[1]")
    // @FindBy(css = "a.gl-product-card__assets-link:first-child")
    private WebElement productLink;

    public void verifyPageAndProduct(){
        String firstItemLink = "https://www.adidas.co.uk/runfalcon-2.0-shoes/FZ2808.html";
        String  currentUrl = driver.getCurrentUrl();
//        System.out.println("current Url "+ currentUrl);
        compareUrlFunction(firstItemLink, currentUrl);
//        System.out.println("Correct product page by checking the URL verified");
    }

    @FindBy(css = "a.variation___32b4d:first-child")
    private WebElement firstColor;

    @FindBy(css = "a.variation___32b4d:last-child")
    private WebElement lastColor;

    public void selectLastColor(){
        if(firstColor==lastColor){
            System.out.println("There is only one color");
        }else{
            clickFunction(lastColor);
        }
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

    public void verifyPageRefreshed(){
        String expectedUrl = "https://www.adidas.co.uk/runfalcon-2.0-shoes/FZ2808.html";
        String  currentUrl = driver.getCurrentUrl();
        compareUrlFunction(expectedUrl, currentUrl);
    }

    @FindBy(css = "a.variation___32b4d:last-child")
    private WebElement classValue;

    public void checkClassValue(){
        String value = classValue.getAttribute("class");
        compareUrlFunction(value, "variation___32b4d selected___3Xezl");
    }

    @FindBy(css= "a.variation___32b4d:last-child")
    private WebElement itemColorOnListing;

    public void getItemColorOnListingUrl(){
        String currentUrl = driver.getCurrentUrl();
        compareColorFunction(itemColorOnListing, currentUrl);
    }

}
