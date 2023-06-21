import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage{

    private final By cancelLocator=By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[9]/button[1]");
    private final By finishLocator= By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[9]/button[2]");

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public void finishCheckout() {
        waitForElementToBeLocated(finishLocator).click();
    }

    public void cancelCheckout(){
        waitForElementToBeLocated(cancelLocator).click();
    }
}
