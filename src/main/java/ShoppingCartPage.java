import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**Клас HomePage описує взаємодію зі сторінкою магазину Rozetka(https://rozetka.com.ua/)
 * на яку користувач потрапяє при натисканні іконки кошику у правому верхньому кутку*/
public class ShoppingCartPage {
    /*Конструктор класу реалізований за допомогою патерну Одинак,
    який запобігає створенню непотрібних додаткових об'єктів класу*/
    private static ShoppingCartPage cartPage;
    private ShoppingCartPage() {}
    public static ShoppingCartPage getShoppingCartPage() {
        if(cartPage == null) {
            cartPage = new ShoppingCartPage();
        }
        return cartPage;
    }

    /*Локатори елементів на сторінці*/
     public SelenideElement menuToggleButton() {
        return $(By.xpath("//button[contains(@id,'cartProductActions')]"));
    }
    public SelenideElement deleteButton() {
        return $(By.xpath("//rz-trash-icon//button"));
    }
    public SelenideElement cartButton() {
        return $(By.xpath("//button[@class='header-cart__button']"));
    }
    public SelenideElement emptyCartHeading() {
        return $(By.xpath("//h4[@class='cart-dummy__heading']"));
    }

    /*Метод який використовується для очікування загрузки елементів */
    public void waitForLoad(SelenideElement element){
        element.shouldBe(visible);
    }

    /*Методи взаємодії з елеиентами на сторінці */
    public void clickMenuToggleButton() {
        waitForLoad(menuToggleButton());
        menuToggleButton().click();
    }
    @Step("Deleting from shopping cart")
    public void clickDeleteButton() {
        waitForLoad(deleteButton());
        deleteButton().click();
    }
    @Step("Open shopping cart")
    public void clickCartButton() {
        waitForLoad(cartButton());
        cartButton().click();
    }

    /*Метод перевірки чи порожній кошик*/
    @Step("Checking if the cart is empty after removing the product")
    public boolean isCartIsEmpty() {
        return emptyCartHeading().getText().equals("Кошик порожній");
    }

}
