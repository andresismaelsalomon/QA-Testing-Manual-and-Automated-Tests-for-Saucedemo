import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By removeLocator=By.xpath("//*[@class=\"btn btn_secondary btn_small cart_button\"]");
    private final By goBackToInventoryLocator=By.xpath("//*[@id=\"continue-shopping\"]");
    private final By goToCheckoutLocator=By.xpath("/html/body/div/div/div/div[2]/div/div[2]/button[2]");
    public void removeAllFromCart() {
        List<WebElement> elements = waitForElements(removeLocator);
        for (WebElement element: elements
        ) {
            element.click();
        }

    }

    public void goBackToInventory() {
        waitForElementToBeLocated(goBackToInventoryLocator).click();
    }
    public void goToCheckout() {
        waitForElementToBeLocated(goToCheckoutLocator).click();
    }

    public boolean cartIsEmpty(){
        //if TimeoutException is thrown that means no elements were found on that time period
        //so emptinnesOfCart flag should be true and return it.
        boolean emptinessOfCart=false;
        try{
            waitForElementToBeLocated(removeLocator);
        }catch (TimeoutException e){
            emptinessOfCart=true;
        }
        return emptinessOfCart;
    }
        //It is not the best way to ensure the cart is empty.
}
