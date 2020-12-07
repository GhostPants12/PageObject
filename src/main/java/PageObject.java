import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

public abstract class PageObject {
    protected WebDriver driver;
    protected static final int TIMEOUT = 10;

    protected PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected static ExpectedCondition<Boolean> jQueryAJAXCompleted(){
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver){
                return (Boolean) ((JavascriptExecutor)
                        driver).executeScript("return (window.jQuery != null) && (jQuery.active == 0);");
            }
        };
    }
}