package screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CheckoutInformationScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "test-First Name")
    public WebElement firstName;

    @AndroidFindBy(accessibility = "test-Last Name")
    public WebElement lastName;

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    public WebElement postalcode;

    @AndroidFindBy(accessibility = "test-CONTINUE")
    public WebElement continueButton;

    @AndroidFindBy(accessibility = "test-FINISH")
    public WebElement finish;

    @AndroidFindBy(accessibility = "test-BACK HOME")
    public WebElement backHome;
}
