package e2e.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class CartPage extends PageObject {

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public void goToCheckout() {
        waitFor(checkoutButton).waitUntilClickable();
        checkoutButton.click();
    }
}