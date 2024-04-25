package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import stepdefinitions.BaseSteps;

public class CartScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    public WebElement checkout;
}
