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
        HomePage Home = HomePage.getHomePage();
        Home.openHomePage();
        Home.enterSearchKeyword(keyword);
        Home.clickSearchButton();
        Assert.assertTrue(Home.isResultLoaded(),"Page do not loaded");
    }
}
