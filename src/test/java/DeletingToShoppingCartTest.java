import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletingToShoppingCartTest {
    @Test(priority = 4,dependsOnMethods = {"AddingToShoppingCartTest.addingToShoppingCartTest"})
    public void deletingToShoppingCartTest() {
        ShoppingCartPage cartpage = ShoppingCartPage.getShoppingCartPage();

        cartpage.clickCartButton();
        cartpage.clickMenuToggleButton();
        cartpage.clickDeleteButton();

        Assert.assertTrue(cartpage.isCartIsEmpty(), "Shopping cart is not empty");

    }
}
