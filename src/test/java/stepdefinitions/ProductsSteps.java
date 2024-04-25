package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.BaseScreen;
import screens.ProductsScreen;

import java.io.IOException;

public class ProductsSteps extends BaseSteps{

    public String price;

    @Then("I can see products screen")
    public void iCanSeeProductsScreen() throws IOException {
        waitUntilViewDisplayed(BaseScreen.withText("PRODUCTS"));
        getScreenshot();
    }

    @When("I click on {string} text")
    public void iClickOnText(String product) {
        waitAndClick(BaseScreen.withText(product));
    }

    @And("I can see {string} product screen")
    public void iCanSeeProductScreen(String product) throws InterruptedException {
        waitUntilViewDisplayed(new ProductsScreen().backToProducts);
        Thread.sleep(2000);
    }

    @And("I check price of product")
    public void iCheckPriceOfProduct() {
        waitUntilViewDisplayed(new ProductsScreen().price);
    }

    @And("I click on add to cart")
    public void iClickOnAddToCart() {
        scrollUntilViewDisplayed(new ProductsScreen().addToCart, "up");
        waitAndClick(new ProductsScreen().addToCart);
        waitUntilViewDisplayed(new ProductsScreen().remove);
    }
}
