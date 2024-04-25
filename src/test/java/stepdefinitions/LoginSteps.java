package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.LoginScreen;
import utils.DriverManager;

import java.io.IOException;

public class LoginSteps extends BaseSteps {

    @When("I open the application")
    public static void openTheApplication() throws Exception {
        new DriverManager().initializeDriver();
    }

    @Then("I see login screen")
    public void iSeeLoginScreen() {
        waitUntilViewDisplayed(new LoginScreen().swaglabsLogo);
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) throws IOException {
        enterText(new LoginScreen().username, username);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        enterText(new LoginScreen().password, password);
    }

    @And("I click on login")
    public void iClickOnLogin() throws IOException {
        waitAndClick(new LoginScreen().loginButton);
        getScreenshot();
    }
}
