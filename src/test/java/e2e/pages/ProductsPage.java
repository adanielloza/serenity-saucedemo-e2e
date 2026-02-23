package e2e.pages;

import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class ProductsPage extends PageObject {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addBikeLight;

    @FindBy(className = "shopping_cart_link")
    WebElement cartLink;

    public void addTwoProducts() {
        addBackpack.click();
        addBikeLight.click();
    }

    public void openCart() {
        cartLink.click();
    }
}