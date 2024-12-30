import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductPageTest {
    @DataProvider(name = "Keywords")
    public Object[] Keywords() {
        return new Object[]{SearchTest.keyword};
    }
    @Test(dataProvider = "Keywords",priority = 2,dependsOnMethods = {"SearchTest.searchTest"})
    public void productPageTest(String keyword) {
        ResultPage Result = ResultPage.getResultPage();
        //Result.passAgeLimit();
        Result.clickOnElement();
        Assert.assertTrue(Result.isProductPageContainKeyword(keyword),String.format("Product page does not contain keyword: \"%s\"",keyword));
    }
}
