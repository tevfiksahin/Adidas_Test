Feature: Shopping a Product

  Scenario: Go to Adidas UK website and test selected item and shopping cart

    Given Open Amazon uk page
    And   Search for the word running
    And   From the opened page PLP click on the first product.
    And   Verify that you have navigated to the correct product page by checking the URL.
    And   Click on the last color variation.
    And   Verify that the page is refreshed with the color change.
    And   Pick any size and click on Add to Bag button.
    And   Verify that you have successfully added one item to the bag.
    And   Click on View Bag button and navigate to the shopping cart page.
    And   Verify that you are on the cart page by the title is Your Bag.
    And   Change the size of your product.
    When  Verify the size is changed.
    Then  Remove that product from your bag.