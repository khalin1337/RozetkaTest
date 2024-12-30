import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**Клас ProductPage описує взаємодію зі сторінкою магазину Rozetka(https://rozetka.com.ua/)
 * на яку користувач потрапяє при виборі конкретного продукту з каталогу*/
public class ProductPage {
    /*Конструктор класу реалізований за допомогою патерну Одинак,
    який запобігає створенню непотрібних додаткових об'єктів класу*/
    private static ProductPage productPage;
    private ProductPage() {}
    public static ProductPage getProductPage() {
        if(productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    /*Локатори елементів на сторінці*/
    public SelenideElement byuButton() {
        return $(By.xpath("//button[contains(@class,'buy-button')]"));
    }
    public SelenideElement cartProductTile() {
        return $(By.xpath("//span[contains(@class,'cart-product__title')]"));
    }
    public SelenideElement cartContinueButton(){
        return $(By.xpath("//button[contains(@class,'cart-footer__continue')]"));
    }

    /*Метод який використовується для очікування загрузки елементів */
    public void waitForLoad(SelenideElement element){
        element.shouldBe(visible);
    }

    /*Методи взаємодії з елеиентами на сторінці */
    public void clickBuyButton(){
        waitForLoad(byuButton());
        byuButton().click();
    }
    public void clickCartContinueButton(){
        cartContinueButton().click();
    }

    /*Метод перевірки чи містить продукт у кошику коректну назву*/
    public boolean isCartPageContainKeyword(String keyword){
        waitForLoad(cartProductTile());
        return cartProductTile().getText().toLowerCase().contains(keyword.trim().toLowerCase());
    }
}
