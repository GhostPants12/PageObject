import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PansPageObject extends PageObject {
    private String PriceClass = "item-type-card__btn";

    @FindBy(xpath = "//*[@id=\"top-page\"]/div[3]/div/div/div[2]/div/div[1]/ul/li[1]/div/span")
    WebElement SortTypes;

    @FindBy(xpath = "//*[@id=\"top_filters__sorter\"]/li[3]/a")
    WebElement CheapSortButton;


    protected PansPageObject(WebDriver driver) {
        super(driver);
    }

    public void SortByPrice(){
        SortTypes.click();
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(CheapSortButton));
        CheapSortButton.click();
        new WebDriverWait(driver, TIMEOUT)
                .until(jQueryAJAXCompleted());
    }

    public ArrayList<Float> GetPrices(){
        ArrayList<Float> result = new ArrayList<Float>();
        for (WebElement element: driver.findElements(By.className(PriceClass)))
        {
            if(element.getText().length() != 0) {
                result.add(Float.parseFloat(element.getText().replace(" руб.", "").replace(",", ".")));
            }
        }

        return  result;
    }
}
