import org.testng.Assert;
import org.testng.annotations.*;


public class SearchTest {
    public  static String keyword = System.getProperty("Keyword","123123");
    @DataProvider(name = "Keywords")
    public Object[] Keywords() {
        return new Object[]{keyword};
    }

    @Test(dataProvider = "Keywords",priority = 1)
    public void searchTest(String keyword) {
        HomePage homepage = HomePage.getHomePage();

        homepage.openHomePage();
        homepage.enterSearchKeyword(keyword);
        homepage.clickSearchButton();

        Assert.assertTrue(homepage.isResultLoaded(),"Page do not loaded");
    }
}
