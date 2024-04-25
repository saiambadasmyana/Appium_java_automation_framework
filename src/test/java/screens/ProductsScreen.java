package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProductsScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "test-Menu")
    public WebElement menuButton;

    @AndroidFindBy(accessibility = "test-Cart")
    public WebElement cartButton;

    @AndroidFindBy(accessibility = "test-ADD TO CART")
    public WebElement addToCart;

    @AndroidFindBy(accessibility = "test-BACK TO PRODUCTS")
    public WebElement backToProducts;

    @AndroidFindBy(accessibility = "test-Price")
    public WebElement price;

    @AndroidFindBy(accessibility = "test-REMOVE")
    public WebElement remove;
}
