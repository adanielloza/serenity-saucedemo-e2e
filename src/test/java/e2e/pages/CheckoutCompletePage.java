package e2e.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CheckoutCompletePage extends PageObject {

    @FindBy(css = ".complete-header")
    WebElementFacade completeHeader;

    public String confirmationMessage() {
        completeHeader.waitUntilPresent();
        completeHeader.waitUntilVisible();
        return completeHeader.getText();
    }
}