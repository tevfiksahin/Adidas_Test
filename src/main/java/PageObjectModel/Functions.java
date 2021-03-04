package PageObjectModel;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class Functions {

    private WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver,20);

    public void clickFunction(WebElement clickElement){
        wait.until(ExpectedConditions.elementToBeClickable(clickElement));
        clickElement.click();
    }

    public void sendKeysFunction(WebElement sendKeysElement, String value){
        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.sendKeys(value);
    }

    public void submitFunction(WebElement submitElement){
        wait.until(ExpectedConditions.visibilityOf(submitElement));
        submitElement.submit();

    }

    public void assertionFunction(WebElement actualElement, String expected){
        wait.until(ExpectedConditions.visibilityOf(actualElement));
        Assert.assertEquals(actualElement.getText(), expected);

    }

    public void compareUrlFunction(String productUrl, String currentUrl){
        Assert.assertEquals(productUrl, currentUrl);

    }

    public void compareSizeFunction(WebElement firstItemSize, String secondItemSize){
        wait.until(ExpectedConditions.visibilityOf(firstItemSize));
        System.out.println("Your first size choose"+ firstItemSize.getText());
        if (firstItemSize.getText().equals(secondItemSize)){
            System.out.println("Size was not changed");
        }else{
            System.out.println("Size successfully changed");
        }

    }






}
