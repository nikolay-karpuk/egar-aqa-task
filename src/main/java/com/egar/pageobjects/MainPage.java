package com.egar.pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.xpath;

public class MainPage extends AbstractPage{

    @NameOfElement("Поиск по каталогу")
    @FindBy(xpath = "//input[@name='q']")
    public SelenideElement searchInput;

    @NameOfElement("Поиск")
    @FindBy(css = ".button_search")
    public SelenideElement productInSerach;

}
