package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class LogInPage {

    private final SelenideElement userNameField = $("#user-name");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement logInButton = $("#login-button");


    @Step("The user logs in with creds [{0}, {1}]")
    public MainPage logIn(String userName, String password) {
        getUserNameField().shouldBe(Condition.visible).sendKeys(userName);
        getPasswordField().shouldBe(Condition.visible).sendKeys(password);
        getLogInButton().shouldBe(Condition.visible).click();
        return new MainPage();
    }

    public SelenideElement getUserNameField() {
        return userNameField;
    }

    public SelenideElement getPasswordField() {
        return passwordField;
    }

    public SelenideElement getLogInButton() {
        return logInButton;
    }
}