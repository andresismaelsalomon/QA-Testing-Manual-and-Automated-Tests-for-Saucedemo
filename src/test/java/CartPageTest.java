import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BasePageTest{

    //TC-010
    @Test
    public void removeAllFromCartTest(){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.addAllToCart();
        inventoryPage.goToCart();

        CartPage cartPage= new CartPage(inventoryPage.getDriver());
        cartPage.removeAllFromCart();

        Assert.assertTrue(cartPage.cartIsEmpty());
    }

    //TC-011
    @Test
    public void goBackToInventoryTest(){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.addAllToCart();
        inventoryPage.goToCart();

        CartPage cartPage= new CartPage(inventoryPage.getDriver());
        cartPage.goBackToInventory();

        Assert.assertEquals(cartPage.getDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    //TC-012
    @Test
    public void goToCheckoutTest(){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.addAllToCart();
        inventoryPage.goToCart();

        CartPage cartPage= new CartPage(inventoryPage.getDriver());
        cartPage.goToCheckout();

        Assert.assertEquals(cartPage.getDriver().getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
    }

}
