package e2e.pages;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CheckoutInfoPage extends PageObject {

    @FindBy(id = "first-name")
    WebElementFacade firstName;

    @FindBy(id = "last-name")
    WebElementFacade lastName;

    @FindBy(id = "postal-code")
    WebElementFacade postalCode;

    @FindBy(id = "continue")
    WebElementFacade continueBtn;

    // SauceDemo shows this when a required field is missing
    @FindBy(css = "h3[data-test='error']")
    WebElementFacade errorBanner;

    public void fillFormAndContinue(String fn, String ln, String zip) {

        // Wait for form fields
        firstName.waitUntilVisible();
        lastName.waitUntilVisible();
        postalCode.waitUntilVisible();

        // Type values (WebElementFacade.type is reliable)
        firstName.clear();
        firstName.type(fn);

        lastName.clear();
        lastName.type(ln);

        postalCode.clear();
        postalCode.type(zip);

        // Click Continue (robust)
        continueBtn.waitUntilClickable();
        continueBtn.click();

        // If validation error appears, fail fast with a meaningful message
        if (errorBanner.isCurrentlyVisible()) {
            throw new AssertionError("Checkout form validation error: " + errorBanner.getText());
        }

        // Wait for navigation to Overview page (most reliable)
        new WebDriverWait(getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.urlContains("checkout-step-two"));
    }
}