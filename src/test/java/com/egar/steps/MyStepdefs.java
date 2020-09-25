package com.egar.steps;

import com.codeborne.selenide.Condition;
import com.egar.pageobjects.BasketPage;
import com.egar.pageobjects.MainPage;
import com.egar.pageobjects.ProductPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyStepdefs {

    String price = null;

    MainPage mainPage = page(MainPage.class);
    ProductPage productPage = page(ProductPage.class);
    BasketPage basketPage = page(BasketPage.class);

    @Given("^open (\\d+)\\.by$")
    public void openBy(int arg0) {
        open("https://www.777555.by");
    }


    @When("^type to input with name \"([^\"]*)\" text: \"([^\"]*)\"$")
    public void typeToInputWithNameText(String nameOfElement, String text){
        mainPage.get(nameOfElement).sendKeys(text);
    }

    @When("^click on the search button \"([^\"]*)\"$")
    public void clickOnTheSearchButton(String value) {
        mainPage.get(value).waitUntil(Condition.enabled, 3000).click();
    }

    @When("^click on the button \"([^\"]*)\"$")
    public void clickOnTheButton(String value){
        // у меня на 2к млс не всегда работало, поставил 6к
        productPage.get(value).waitUntil(Condition.enabled, 6000).click();
    }

    @When("^click on the button \"([^\"]*)\" in header$")
    public void clickOnTheButtonInHeader(String value){
        price = productPage.get("Цена товара").text();
        productPage.get(value).waitUntil(Condition.enabled, 2000).click();
    }


    @When("^product \"([^\"]*)\" in page displayed$")
    public void productInPageDisplayed(String nameProduct){
        assertThat(basketPage.get("Продукт в корзине").text(), containsString(nameProduct));
    }

    @Then("^\"([^\"]*)\" coincides with \"([^\"]*)\"$")
    public void coincidesWith(String priceProduct, String priceInBasket) {
        System.out.println("Цена на странице продукта- " + price);
        System.out.println("Цена в корзине" + basketPage.get("Продукт в корзине").text());
        assertThat(basketPage.get("Продукт в корзине").text(),containsString(price));
    }
}
