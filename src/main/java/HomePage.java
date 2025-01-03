import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**Клас HomePage описує взаємодію зі сторінкою магазину Rozetka(https://rozetka.com.ua/)
 * на яку користувач потрапяє при заході на сайт*/
public class HomePage {

    /*Конструктор класу реалізований за допомогою патерну Одинак,
    який запобігає створенню непотрібних додаткових об'єктів класу*/
    private static HomePage home;

    private HomePage() {}

    public static HomePage getHomePage() {
        if(home == null) {
            home= new HomePage();
        }
        return home;
    }

    /*Метод який відкривае головну сторінку сайту*/
    @Step("Open the main page")
    public void openHomePage(){
        open("https://rozetka.com.ua/");
        getWebDriver().manage().window().maximize();
        waitForLoad("//div[@class='list']");
    }

    /*Локатори елементів на сторінці*/
    public SelenideElement searchInput() {
        return $(By.xpath("//input[contains(@class,'search-form__input')]"));
    }
    public ElementsCollection searchingResult() {
        return $$(By.xpath("//li[contains(@class,'catalog-grid__cell')]"));
    }

    /*Метод який використовується для очікування загрузки елементів */
    public void waitForLoad(String xp) {
        $(By.xpath(xp)).shouldBe(visible);
    }

    /*Методи взаємодії з елеиентами на сторінці */
    @Step("Search by name")
    public void clickSearchButton() {
        searchInput().pressEnter();
    }
    @Step("Entering the name: \"{keyword}\" of the product in the search field")
    public void enterSearchKeyword(String keyword) {
        searchInput().val(keyword);
    }

    /*Метод перевірки чи завантажилася наступна сторінка*/
    @Step("Checking if the results page has loaded")
    public boolean isResultLoaded() {
        waitForLoad("//li[contains(@class,'catalog-grid__cell')]");
        return !searchingResult().isEmpty();
    }
}
