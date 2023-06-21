import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage {

    private final By selectLocator=By.xpath("/html/body/div/div/div/div[1]/div[2]/div/span/select");
    private final By itemNameLocator=By.xpath("//*[@class=\"inventory_item_name\"]");
    private final By numberOnCartLocator=By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");
    private final By cartIconLocator=By.xpath("//*[@id=\"shopping_cart_container\"]");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public void sortNameFromAToZ(){
        WebElement selectElement = waitForElementToBeLocated(selectLocator);
        Select select = new Select(selectElement);
        select.selectByValue("az");
    }

    public void sortNameFromZToA(){
        WebElement selectElement = waitForElementToBeLocated(selectLocator);
        Select select = new Select(selectElement);
        select.selectByValue("za");
    }
    public void sortPriceFromLowToHigh(){
        WebElement selectElement = waitForElementToBeLocated(selectLocator);
        Select select = new Select(selectElement);
        select.selectByValue("lohi");
    }
    public void sortPriceFromHighToLow(){
        WebElement selectElement = waitForElementToBeLocated(selectLocator);
        Select select = new Select(selectElement);
        select.selectByValue("hilo");
    }

    public String getNamesOfProducts() {
        List<WebElement> elements = waitForElements(itemNameLocator);
        List<String> NamesOfProducts = new ArrayList<>();
        for (WebElement element:elements) {
            NamesOfProducts.add(element.getText());
        }
        return NamesOfProducts.toString();
    }

    public void addAllToCart() {
        List<WebElement> elements = waitForElements(By.xpath("//*[@class=\"btn btn_primary btn_small btn_inventory\"]"));
        for (WebElement element: elements
             ) {
            element.click();
        }
    }

    public void removeAllFromCart() {
        List<WebElement> elements = waitForElements(By.xpath("//*[@class=\"btn btn_secondary btn_small btn_inventory\"]"));
        for (WebElement element: elements
        ) {
            element.click();
        }
    }

    public void goToCart(){
        waitForElementToBeLocated(getCartIconLocator()).click();
    }

    //Getters
    public String getNumberOnCart() {
        return waitForElementToBeLocated(getNumberOnCartLocator()).getText();
    }

    public By getNumberOnCartLocator() {
        return numberOnCartLocator;
    }

    public By getCartIconLocator() {
        return cartIconLocator;
    }

}
