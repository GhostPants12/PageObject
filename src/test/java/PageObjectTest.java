import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;

public class PageObjectTest {
    @Test
    public void cheapSortedTest(){
        WebDriver driver = new ChromeDriver();
        MainPageObject mainObj = new MainPageObject(driver);
        mainObj.openPage();
        PansPageObject pansObj = mainObj.selectPans();
        pansObj.SortByPrice();
        ArrayList<Float> valueToCheck = pansObj.GetPrices();
        Collections.sort(valueToCheck);
        Assert.assertEquals(valueToCheck, pansObj.GetPrices());
    }

    @Test
    public void alreadyInCartTest(){
        WebDriver driver = new ChromeDriver();
        MainPageObject mainObj = new MainPageObject(driver);
        mainObj.openPage();
        ProductPageObject product = mainObj.findProduct();
        Assert.assertEquals("Уже в корзине", product.buyProduct());
    }
}
