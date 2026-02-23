package e2e.stepdefinitions;

import e2e.steps.PurchaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class PurchaseStepDefinitions {

    @Steps
    PurchaseSteps purchaseSteps;

    @Given("I login to SauceDemo with {word} and {word}")
    public void i_login(String user, String pass) {
        purchaseSteps.login(user, pass);
    }

    @When("I add two products to the cart")
    public void i_add_two_products() {
        purchaseSteps.addTwoProducts();
    }

    @And("I view the cart")
    public void i_view_cart() {
        purchaseSteps.viewCart();
    }

    @And("I complete the checkout form")
    public void i_complete_checkout() {
        purchaseSteps.completeCheckoutForm();
    }

    @Then("I should see the confirmation message {string}")
    public void i_should_see_confirmation(String message) {
        purchaseSteps.shouldSeeConfirmation(message);
    }
}
