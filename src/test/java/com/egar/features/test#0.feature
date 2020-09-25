@smoketest
Feature: test #1, go to the product page
  @success
  Scenario: Сhecking the display of goods in the cart

    #actions at first page
    Given open 777555.by
    When type to input with name "Поиск по каталогу" text: "Espada EBoard3D4"
    When click on the search button "Поиск"
    When click on the button "Добавить товар в корзину"
    When click on the button "Корзина" in header
    When product "Espada EBoard3D4" in page displayed
    Then "Цена товара" coincides with "Цена товара в корзине"


