import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutStepTwoPageTest extends BasePageTest {

    //TC-019
    @Test
    public void finishCheckoutTest(){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.addAllToCart();
        inventoryPage.goToCart();

        CartPage cartPage= new CartPage(inventoryPage.getDriver());
        cartPage.goToCheckout();

        CheckoutStepOnePage checkoutPage=new CheckoutStepOnePage(cartPage.getDriver());

        checkoutPage.fillForm();
        checkoutPage.clickContinueButton();

        CheckoutStepTwoPage checkoutPageTwo =new CheckoutStepTwoPage(checkoutPage.getDriver());
        checkoutPageTwo.finishCheckout();

        Assert.assertEquals(checkoutPage.getDriver().getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
    }

    //TC-020
    @Test
    public void cancelCheckoutTest(){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.addAllToCart();
        inventoryPage.goToCart();

        CartPage cartPage= new CartPage(inventoryPage.getDriver());
        cartPage.goToCheckout();

        CheckoutStepOnePage checkoutPage=new CheckoutStepOnePage(cartPage.getDriver());

        checkoutPage.fillForm();
        checkoutPage.clickContinueButton();

        CheckoutStepTwoPage checkoutPageTwo =new CheckoutStepTwoPage(checkoutPage.getDriver());
        checkoutPageTwo.cancelCheckout();

        Assert.assertEquals(checkoutPage.getDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

}
