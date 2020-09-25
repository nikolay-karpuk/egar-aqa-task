package com.egar.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends AbstractPage {

    @NameOfElement("Цена в товара в корзине")
    @FindBy(css = ".cart-item-mobile-label")
    public SelenideElement basketPrice;

    @NameOfElement("Продукт в корзине")
    @FindBy(css = ".js-cart-itemlist")
    public SelenideElement productTitle;

}
