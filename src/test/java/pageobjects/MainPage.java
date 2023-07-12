package pageobjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends BasicPage{
    private final SelenideElement title = $(".app_logo");
    private final SelenideElement filterDropDown = $(".product_sort_container");
    private final SelenideElement linkTitle = $("a div");
    private final ElementsCollection linkTitles = $$("a div");

    public MainPage sort(String visibleText) {
        Select select = new Select(getFilterDropDown());
        select.selectByVisibleText(visibleText);
        return this;
    }

    @Step("The user chose item with name [{0}]")
    public ProductDetailsPage choseItemAndGoProductDetailsPage(String itemName) {
        getLinkTitles().stream().filter(linkTitle -> linkTitle.getText().contains(itemName))
                .findFirst().orElseThrow().click();

        return new ProductDetailsPage();
    }


    public SelenideElement getTitle() {
        return title;
    }

    public SelenideElement getFilterDropDown() {
        return filterDropDown;
    }

    public SelenideElement getLinkTitle() {
        return linkTitle;
    }

    public ElementsCollection getLinkTitles() {
        return linkTitles;
    }
}
