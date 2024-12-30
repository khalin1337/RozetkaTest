import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**Клас ResultPage описує взаємодію зі сторінкою пошуку магазину Rozetka(https://rozetka.com.ua/)
 * на яку користувач потрапяє при пошуку за ключовим словом*/
public class ResultPage {
    /*Конструктор класу реалізований за допомогою патерну Одинак,
    який запобігає створенню непотрібних додаткових об'єктів класу*/
    private static ResultPage resultPage;
    private ResultPage() {}
    public static ResultPage getResultPage() {
        if(resultPage == null) {
            resultPage = new ResultPage();
        }
        return resultPage;
    }

    /*Локатори елементів на сторінці*/
    public SelenideElement resultElement(){
        return $(By.xpath("(//li[1]//rz-button-product-page[@class='ng-star-inserted'])[1]"));
    }
    public  SelenideElement ageLimit(){
        return $(By.xpath("//input[@class='button button--medium popup-content__button button--green ng-star-inserted']"));
    }
    public  SelenideElement tittleProductPage(){
        return $(By.xpath("//h1"));
    }

    /*Метод який використовується для очікування загрузки елементів */
    public void waitForLoad(SelenideElement element){
        element.shouldBe(visible);
    }

    /*Методи взаємодії з елеиентами на сторінці */
    public void passAgeLimit(){
        waitForLoad(ageLimit());
        ageLimit().click();
    }
    public void clickOnElement() {
        waitForLoad(resultElement());
        resultElement().click();
    }

    /*Метод перевірки назви обраного продукту*/
    public boolean isProductPageContainKeyword(String keyword){
        waitForLoad(tittleProductPage());
        return tittleProductPage().getText().toLowerCase().contains(keyword.trim().toLowerCase());
    }

}
