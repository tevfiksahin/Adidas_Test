package StepDefinitions;

import PageObjectModel.Pages.Cart;
import PageObjectModel.Pages.Main;
import PageObjectModel.Pages.PLP;
import PageObjectModel.PopUpWindows.Bag;
import PageObjectModel.PopUpWindows.Cookies;
import PageObjectModel.PopUpWindows.Location;
import PageObjectModel.PopUpWindows.SignUp;
import Utilities.Driver;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Shopping {

    private WebDriver driver;
    Main mainPage = new Main();
    Location location = new Location();
    Cookies cookies = new Cookies();
    PLP plp = new PLP();
    SignUp signUp = new SignUp();
    Cart cart = new Cart();
    Bag bag = new Bag();


    @Given("^Open Amazon uk page$")
    public void open_Amazon_uk_page() throws Throwable {
        driver = Driver.getDriver();
        driver.get("https://www.adidas.co.uk");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        location.selectCountry();
        location.acceptCountry();
        cookies.acceptCookies();

    }

    @Given("^Search for the word running$")
    public void search_for_the_word_running() throws Throwable {
        mainPage.sendKeysToSearchBar();

    }

    @Given("^From the opened page PLP click on the first product\\.$")
    public void from_the_opened_page_PLP_click_on_the_first_product() throws Throwable {
        plp.selectFirstItem();
        signUp.closeSignUpWindow();

    }

    @Given("^Verify that you have navigated to the correct product page by checking the URL\\.$")
    public void verify_that_you_have_navigated_to_the_correct_product_page_by_checking_the_URL() throws Throwable {
        plp.verifyPageAndProduct();

    }

    @Given("^Click on the last color variation\\.$")
    public void click_on_the_last_color_variation() throws Throwable {
        plp.selectLastColor();

    }

    @Given("^Verify that the page is refreshed with the color change\\.$")
    public void verify_that_the_page_is_refreshed_with_the_color_change() throws Throwable {

    }

    @Given("^Pick any size and click on Add to Bag button\\.$")
    public void pick_any_size_and_click_on_Add_to_Bag_button() throws Throwable {
        plp.selectSize();
        plp.addToCart();

    }

    @Given("^Verify that you have successfully added one item to the bag\\.$")
    public void verify_that_you_have_successfully_added_one_item_to_the_bag() throws Throwable {
        cart.verifyItemAdd();


    }

    @Given("^Click on View Bag button and navigate to the shopping cart page\\.$")
    public void click_on_View_Bag_button_and_navigate_to_the_shopping_cart_page() throws Throwable {
        cart.viewBag();

    }

    @Given("^Verify that you are on the cart page by the title is Your Bag\\.$")
    public void verify_that_you_are_on_the_cart_page_by_the_title_is_Your_Bag() throws Throwable {
        bag.verifyBag();

    }

    @Given("^Change the size of your product\\.$")
    public void change_the_size_of_your_product() throws Throwable {
        driver.navigate().back();
        plp.setNewSize();
        plp.addToCart();
        cart.viewBag();

    }

    @When("^Verify the size is changed\\.$")
    public void verify_the_size_is_changed() throws Throwable {

    }

    @Then("^Remove that product from your bag\\.$")
    public void remove_that_product_from_your_bag() throws Throwable {

    }

    @After
    public void quitDriver() throws InterruptedException{
        Thread.sleep(3000);
    }


}
