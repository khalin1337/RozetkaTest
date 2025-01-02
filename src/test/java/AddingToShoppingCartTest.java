import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddingToShoppingCartTest {
    @DataProvider(name = "Keywords")
    public Object[] Keywords() {
        return new Object[]{SearchTest.keyword};
    }
    @Test(dataProvider = "Keywords",priority = 3,dependsOnMethods = {"ProductPageTest.productPageTest"})
    public void addingToShoppingCartTest(String keyword) {
        ProductPage product = ProductPage.getProductPage();

        product.clickBuyButton();
        boolean TittleCheck = product.isCartPageContainKeyword(keyword);
        product.clickCartContinueButton();

        Assert.assertTrue(TittleCheck,String.format("Cart page do not contain keyword:\"%s\"",keyword));
    }
}
