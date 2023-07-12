package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
public class ProductDetailsPage extends BasicPage{
    private final SelenideElement addToCartButton = $("#add-to-cart-sauce-labs-bike-light");
    @Step("The user add product to cart")
    public ProductDetailsPage addProductToCart() {
        getAddToCartButton().shouldBe(Condition.visible).click();
        return this;
    }
    public SelenideElement getAddToCartButton() {
        return addToCartButton;
    }
}