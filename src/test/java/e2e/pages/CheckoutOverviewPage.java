package e2e.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CheckoutOverviewPage extends PageObject {

    @FindBy(id = "finish")
    private WebElementFacade finishBtn;

    public void finish() {

        // Espera que cargue la pantalla (en ms, compatible con tu Serenity)
        waitForTextToAppear("Checkout: Overview", 15000);

        // Click robusto
        finishBtn.waitUntilPresent();
        finishBtn.waitUntilVisible();
        finishBtn.waitUntilClickable();
        finishBtn.click();

        // Espera navegación a Complete por URL (más estable que texto)
        waitForCondition().until(driver ->
                getDriver().getCurrentUrl().contains("checkout-complete")
        );
    }
}