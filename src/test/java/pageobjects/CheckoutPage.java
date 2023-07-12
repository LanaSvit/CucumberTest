package pageobjects;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    private final SelenideElement firstNameInput = $("#first-name");
    private final SelenideElement lastNameInput = $("#last-name");
    private final SelenideElement zipCodeInput = $("#postal-code");
    private final SelenideElement continueButton = $("#continue");

    @Step("The user fills his/her personal details [(0), (1),(2)]")
    public OrderDetailsPage fillDataAndContinue(String firstName, String lastName, String zipCode) {
        getFirstNameInput().shouldBe(Condition.visible).sendKeys(firstName);
        getLastNameInput().shouldBe(Condition.visible).sendKeys(lastName);
        getZipCodeInput().shouldBe(Condition.visible).sendKeys(zipCode);
        getContinueButton().shouldBe(Condition.visible).click();
        return new OrderDetailsPage();
    }

    public SelenideElement getFirstNameInput() {
        return firstNameInput;
    }

    public SelenideElement getLastNameInput() {
        return lastNameInput;
    }

    public SelenideElement getZipCodeInput() {
        return zipCodeInput;
    }

    public SelenideElement getContinueButton() {
        return continueButton;
    }
}
