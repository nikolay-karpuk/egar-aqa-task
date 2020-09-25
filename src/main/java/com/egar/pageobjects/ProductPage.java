package com.egar.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage{

    @NameOfElement("Цена товара")
    @FindBy(css = ".pr-card-prices > div > div:nth-child(2) > div.pr-card-price") //выбираем цену без клубной карты, т.к в корзине всегда отображается без клубной карты
    public SelenideElement productPrice;

    @NameOfElement("Добавить товар в корзину")
    @FindBy(css = ".but_car")
    public SelenideElement buttonBasket;

    @NameOfElement("Корзина")
    @FindBy(css = ".h-cart")
    public SelenideElement hCart;

}
