import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletingToShoppingCartTest {
    @Test(priority = 4,dependsOnMethods = {"AddingToShoppingCartTest.addingToShoppingCartTest"})
    public void deletingToShoppingCartTest() {
        ShoppingCartPage CartPage = ShoppingCartPage.getShoppingCartPage();
        CartPage.clickCartButton();
        CartPage.clickMenuToggleButton();
        CartPage.clickDeleteButton();

        Assert.assertTrue(CartPage.isCartIsEmpty(), "Shopping cart is not empty");

    }
}
