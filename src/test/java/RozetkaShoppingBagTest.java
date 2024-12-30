import org.testng.Assert;
import org.testng.annotations.*;


public class RozetkaShoppingBagTest {


    @DataProvider(name = "Keywords")
    public Object[] Keywords() {
        String keyword = System.getProperty("Keyword","123123");
        return new Object[]{keyword};
    }

    @Test(dataProvider = "Keywords",priority = 1)
    public void SearchTest(String keyword) {
        HomePage Home = HomePage.getHomePage();
        Home.openHomePage();
        Home.enterSearchKeyword(keyword);
        Home.clickSearchButton();
        Assert.assertTrue(Home.isResultLoaded(),"Page do not loaded");
    }

    @Test(dataProvider = "Keywords",priority = 2)
    public void ProductPageTest(String keyword) {
        ResultPage Result = ResultPage.getResultPage();
        //Result.passAgeLimit();
        Result.clickOnElement();
        Assert.assertTrue(Result.isProductPageContainKeyword(keyword),String.format("Product page does not contain keyword: \"%s\"",keyword));
    }
    @Test(dataProvider = "Keywords",priority = 3)
    public void AddingToShoppingCartTest(String keyword) {
        ProductPage Product = ProductPage.getProductPage();
        Product.clickBuyButton();
        boolean TittleCheck = Product.isCartPageContainKeyword(keyword);
        Product.clickCartContinueButton();

        Assert.assertTrue(TittleCheck,String.format("Cart page do not contain keyword:\"%s\"",keyword));
    }
    @Test(priority = 4)
    public void DeletingToShoppingCartTest() {
        ShoppingCartPage CartPage = ShoppingCartPage.getShoppingCartPage();
        CartPage.clickCartButton();
        CartPage.clickMenuToggleButton();
        CartPage.clickDeleteButton();

        Assert.assertTrue(CartPage.isCartIsEmpty(),"Shopping cart is not empty");
    }

}
