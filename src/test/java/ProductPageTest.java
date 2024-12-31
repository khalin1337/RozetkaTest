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
        ResultPage resultpage = ResultPage.getResultPage();

        //resultpage.passAgeLimit();
        resultpage.clickOnElement();

        Assert.assertTrue(resultpage.isProductPageContainKeyword(keyword),String.format("Product page does not contain keyword: \"%s\"",keyword));
    }
}
