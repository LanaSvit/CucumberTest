package pageobjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PlaceOrderPage extends BasicPage {

    private final SelenideElement confirmationText = $(".complete-header");

    public SelenideElement getConfirmationText() {
        return confirmationText;
    }
}