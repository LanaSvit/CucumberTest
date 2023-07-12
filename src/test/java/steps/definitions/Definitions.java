package steps.definitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.*;
import utils.SharedData;

public class Definitions {
    private final SharedData sharedData = SharedData.getSharedData();

    @When("\\[UI] User logs in with username (.*) and (.*)$")
    public void userLogsIn(String username, String password) {
        Configuration.browser = "chrome";
        Selenide.open("https://www.saucedemo.com/");
        new LogInPage().logIn(username, password);
    }

    @When("[UI] User logs in with username")
    public void userLogsIn() {
        Configuration.browser = "chrome";
        Selenide.open("https://www.saucedemo.com/");
        new LogInPage().logIn("standard_user", "secret_sauce");
    }

    @When("\\[UI] User chose item (.*)$")
    public void userChoseItemAndGoProductDetailsPage(String itemName) {
        new MainPage().choseItemAndGoProductDetailsPage(itemName);
    }

    @When("[UI] User add product to cart")
    public void addProductToCart() {
        new ProductDetailsPage().addProductToCart();
    }

    @When("[UI] User opens cart")
    public void openCartPage() {
        new ProductDetailsPage().openCartPage();
    }

    @When("[UI] User go to checkout")
    public void goToCheckout() {
        new CartPage().goToCheckout();
    }

    @When("\\[UI] User fills his personal data firstName (.*), lastName (.*) and postCode (.*)$")
    public void fillDataAndContinue(String firstName, String lastName, String zipCode) {
        new CheckoutPage().fillDataAndContinue(firstName, lastName, zipCode);
    }

    @When("[UI] User go to place order page")
    public void goToPlaceOrderPage() {
        SelenideElement confirmationText = new OrderDetailsPage()
                .goToPlaceOrderPage()
                .getConfirmationText();

        sharedData.setConfirmationText(confirmationText);
    }


//    @When("\\[UI] User do checkout with product (.*)$")
//    public void userCheckouts(String itemName) {
//        Configuration.browser = "chrome";
//
//        SelenideElement confirmationText = new MainPage()
//                .choseItemAndGoProductDetailsPage(itemName)
//                .addProductToCart()
//                .openCartPage()
//                .goToCheckout()
//                .fillDataAndContinue("Alex", "Po", "1111")
//                .goToPlaceOrderPage()
//                .getConfirmationText();
//
//        sharedData.setConfirmationText(confirmationText);
//    }

    @Then("[UI] User should be on main page")
    public void userShouldBeLoggedIn() {
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html"
                , "The logIn was not successful");
    }

    @Then("[UI] User should see Thank you message")
    public void userShouldSeeThankYouMessage() {
        sharedData.getConfirmationText().shouldBe(Condition.visible);
        sharedData.getConfirmationText().shouldHave(Condition.text("Thank you for your order!"));
    }
}