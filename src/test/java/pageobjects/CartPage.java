package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasicPage{
    private final SelenideElement checkoutButton = $("#checkout");

    @Step("The user go to checkout")
    public CheckoutPage goToCheckout() {
        getCheckoutButton().shouldBe(Condition.visible).click();
        return new CheckoutPage();
    }

    public SelenideElement getCheckoutButton() {
        return checkoutButton;
    }
}