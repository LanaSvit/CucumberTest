package steps.hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class ShopHooks {

    @BeforeAll
    public static void startBrowser(){

    }

//    @Before(order = 1, value = "@preConditionCreateTask")
//    public static void setUp(){
//        RestAssure.given().when().then();
//    }
//
//    @Before(value = "@preConditionCreateTask")
//    public static void setUp(){
//        RestAssure.given().when().then();
//    }
//
//    @Before()
//    public static void setUp(){
//        Selenide.open("url");
//    }
}