package pageobjects;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class BasicPage {
    private final SelenideElement cartButton = $("#shopping_cart_container");

    @Step("The user open cart")
    public CartPage openCartPage() {
        getCartButton().shouldBe(Condition.visible).click();
        return new CartPage();
    }
    public SelenideElement getCartButton() {
        return cartButton;
    }
}