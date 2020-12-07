import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPageObject extends PageObject {

    @FindBy(className = "i-button__text")
    WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"top-page\"]/div[3]/div/div[1]/div/div[2]/div[3]/div/div[1]/div[2]/div/div[1]/a/span/span[2]")
    WebElement alreadyInCart;

    protected ProductPageObject(WebDriver driver) {
        super(driver);
    }

    public String buyProduct(){
        addToCartButton.click();
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(alreadyInCart));
        return alreadyInCart.getText();
    }
}
