package e2e.steps;

import org.assertj.core.api.Assertions;

import e2e.pages.CartPage;
import e2e.pages.CheckoutCompletePage;
import e2e.pages.CheckoutInfoPage;
import e2e.pages.CheckoutOverviewPage;
import e2e.pages.LoginPage;
import e2e.pages.ProductsPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class PurchaseSteps extends UIInteractionSteps {

    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutInfoPage checkoutInfoPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;

    @Step("Login with user {0}")
    public void login(String user, String pass) {
        loginPage.openLogin();
        loginPage.loginAs(user, pass);
    }

    @Step("Add two products to cart")
    public void addTwoProducts() {
        productsPage.addTwoProducts();
    }

    @Step("View cart")
    public void viewCart() {
        productsPage.openCart();
    }

    @Step("Complete checkout flow")
public void completeCheckoutForm() {
    cartPage.goToCheckout();
    checkoutInfoPage.fillFormAndContinue("Andres", "Loza", "170150");
    checkoutOverviewPage.finish();

    // Optional: forces a sync point right after Finish
    checkoutCompletePage.confirmationMessage();
}

    @Step("Validate confirmation message")
    public void shouldSeeConfirmation(String expected) {

    String actual = checkoutCompletePage.confirmationMessage();

    String normalizedActual = actual.trim().toLowerCase().replaceAll("[^a-z0-9\\s]", "");
    String normalizedExpected = expected.trim().toLowerCase().replaceAll("[^a-z0-9\\s]", "");

    Assertions.assertThat(normalizedActual)
            .isEqualTo(normalizedExpected);
    
    }
}
