package StepDefinitions;

import PageObjectModel.Pages.Bag;
import PageObjectModel.Pages.Main;
import PageObjectModel.Pages.PLP;
import PageObjectModel.PopUpWindows.Cart;
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

public class ShoppingSteps {

    private WebDriver driver;
    Main mainPage = new Main();
    Location location = new Location();
    Cookies cookies = new Cookies();
    PLP plp = new PLP();
    SignUp signUp = new SignUp();
    Bag bag = new Bag();
    Cart cart = new Cart();


    @Given("^Open Amazon uk page$")
    public void open_Amazon_uk_page() throws Throwable {
        driver = Driver.getDriver();
        driver.get("https://www.adidas.co.uk");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // Location is handled
        location.selectCountry();
        location.acceptCountry();
        // Cookies is accepted
        cookies.acceptCookies();

    }

    @Given("^Search for the word running$")
    public void search_for_the_word_running() throws Throwable {
        mainPage.sendKeysToSearchBar();
        Thread.sleep(1000);

    }

    @Given("^From the opened page PLP click on the first product\\.$")
    public void from_the_opened_page_PLP_click_on_the_first_product() {
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
        plp.getItemColorOnListingUrl(); // Check if the selected color is last color

    }

    @Given("^Verify that the page is refreshed with the color change\\.$")
    public void verify_that_the_page_is_refreshed_with_the_color_change() throws Throwable {
        plp.verifyPageRefreshed();
        plp.checkClassValue();
        System.out.println("Page is refreshed");


    }

    @Given("^Pick any size and click on Add to Bag button\\.$")
    public void pick_any_size_and_click_on_Add_to_Bag_button() throws Throwable {
        plp.selectSize();
        plp.addToCart();

    }

    @Given("^Verify that you have successfully added one item to the bag\\.$")
    public void verify_that_you_have_successfully_added_one_item_to_the_bag() throws Throwable {
        cart.verifyItemAdd();
        System.out.println("Your item added to cart!");

    }

    @Given("^Click on View Bag button and navigate to the shopping cart page\\.$")
    public void click_on_View_Bag_button_and_navigate_to_the_shopping_cart_page() throws Throwable {
        cart.viewBag();

    }

    @Given("^Verify that you are on the cart page by the title is Your Bag\\.$")
    public void verify_that_you_are_on_the_cart_page_by_the_title_is_Your_Bag() throws Throwable {
        bag.verifyBag();
        // Check if you're in the desired page!
        bag.verifyBagPage();
        System.out.println("This is your Bag!");

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
        bag.verifyItemSize();
        bag.removeItem();
    }

    @Then("^Remove that product from your bag\\.$")
    public void remove_that_product_from_your_bag() throws Throwable {
        Thread.sleep(3000);
        bag.removeItem();
        bag.checkBag();
    }

    @After
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        Driver.closeDriver();
    }

}
