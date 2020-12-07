import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageObject extends PageObject {

    private static final String MAIN_PAGE_URL = "https://oz.by/";

    @FindBy(xpath = "//*[@id=\"top-page\"]/div[2]/div[1]/div[1]/div/div/ul/li[4]/a")
    private WebElement householdCategory;

    @FindBy(xpath = "//*[@id=\"top-page\"]/div[2]/div[1]/div[1]/div/div/ul/li[4]/div/div/ul/li[2]/ul[3]/li[2]/a")
    private WebElement pansCategory;

    @FindBy(id="top-s")
    private WebElement searchField;

    @FindBy(className = "top-panel__search__btn")
    private WebElement searchButton;

    protected MainPageObject(WebDriver driver) {
        super(driver);
    }

    public void openPage(){
        driver.get(MAIN_PAGE_URL);
        new WebDriverWait(driver, TIMEOUT)
                .until(jQueryAJAXCompleted());
    }

    public ProductPageObject findProduct(){
        searchField.sendKeys("10764941");
        searchButton.click();
        return new ProductPageObject(driver);
    }

    public PansPageObject selectPans(){
        Actions selectHousehold = new Actions(driver);
        selectHousehold.moveToElement(householdCategory);
        selectHousehold.perform();
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(pansCategory));
        pansCategory.click();
        return new PansPageObject(driver);
    }
}
