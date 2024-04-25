package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import screens.BaseScreen;
import screens.CartScreen;
import screens.CheckoutInformationScreen;
import screens.ProductsScreen;

import java.util.Objects;

public class CheckoutSteps extends BaseSteps {

    @And("I click on cart icon")
    public void iClickOnCartIcon() {
        waitAndClick(new ProductsScreen().cartButton);
        waitUntilViewDisplayed(BaseScreen.withText("YOUR CART"));
    }

    @And("I checkout the product")
    public void iCheckoutTheProduct() {
        waitAndClick(new CartScreen().checkout);
    }

    @And("I enter {string} as {string}")
    public void iEnterAs(String arg0, String arg1) {
        WebElement e = null;
        switch (arg0.toLowerCase()){
            case "firstname":
               e = new CheckoutInformationScreen().firstName;
               break;
            case "lastname":
                e = new CheckoutInformationScreen().lastName;
                break;
            case "postal code":
                e = new CheckoutInformationScreen().postalcode;
                break;
        }
        enterText(e, arg1);
    }

    @And("I click on continue")
    public void iClickOnContinue() {
        waitAndClick(new CheckoutInformationScreen().continueButton);
    }

    @Then("I can see checkout overview screen")
    public void iCanSeeCheckoutOverviewScreen() {
        waitUntilViewDisplayed(BaseScreen.withText("CHECKOUT: OVERVIEW"));
        waitUntilViewDisplayed(new ProductsScreen().price);
        System.out.println(new ProductsSteps().price);
        System.out.println(new ProductsSteps().price);
        System.out.println(new ProductsSteps().price);
    }

    @And("I click on finish")
    public void iClickOnFinish() {
        scrollUntilViewDisplayed(new CheckoutInformationScreen().finish, "up");
        waitAndClick(new CheckoutInformationScreen().finish);
    }

    @Then("I can see order confirmation screen")
    public void iCanSeeOrderConfirmationScreen() {
        waitUntilViewDisplayed(BaseScreen.withText("THANK YOU FOR YOU ORDER"));
        waitUntilViewDisplayed(new CheckoutInformationScreen().backHome);
    }
}
