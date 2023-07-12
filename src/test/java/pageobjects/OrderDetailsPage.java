package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class OrderDetailsPage extends BasicPage{
    private final SelenideElement finishButton = $("#finish");

    @Step("The go to place order page")
    public PlaceOrderPage goToPlaceOrderPage() {
        getFinishButton().shouldBe(Condition.visible).click();
        return new PlaceOrderPage();
    }

    public SelenideElement getFinishButton() {
        return finishButton;
    }
}
