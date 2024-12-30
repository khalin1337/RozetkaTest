import com.codeborne.selenide.SelenideElement;
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
    public void waitForLoad(String xp){
        $(By.xpath(xp)).shouldBe(visible);
    }

    /*Методи взаємодії з елеиентами на сторінці */
    public void clickMenuToggleButton() {

        menuToggleButton().click();
    }
    public void clickDeleteButton() {
        waitForLoad("//rz-trash-icon//button");
        deleteButton().click();
    }
    public void clickCartButton() {
        cartButton().click();
    }

    /*Метод перевірки чи порожній кошик*/
    public boolean isCartIsEmpty() {
        return emptyCartHeading().getText().equals("Кошик порожній");
    }

}
