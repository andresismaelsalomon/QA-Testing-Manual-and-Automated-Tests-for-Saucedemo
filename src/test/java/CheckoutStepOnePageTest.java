import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CheckoutStepOnePageTest extends BasePageTest{

    //TC-014
    @Test
    @Parameters({"first_name","last_name","zipcode"})
    public void fillFormAndContinueCheckoutTest(String first_name,String last_name,String zipcode){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.addAllToCart();
        inventoryPage.goToCart();

        CartPage cartPage= new CartPage(inventoryPage.getDriver());
        cartPage.goToCheckout();

        CheckoutStepOnePage checkoutPage=new CheckoutStepOnePage(cartPage.getDriver());

        checkoutPage.writeFirstName(first_name);
        checkoutPage.writeLastName(last_name);
        checkoutPage.writeZipcode(zipcode);

        checkoutPage.clickContinueButton();

        Assert.assertEquals(checkoutPage.getDriver().getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
    }

    //TC-015
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

        checkoutPage.clickCancelButton();

        Assert.assertEquals(checkoutPage.getDriver().getCurrentUrl(),"https://www.saucedemo.com/cart.html");
    }

    //TC-016
    @Test
    @Parameters({"last_name","zipcode"})
    public void tryFillFormAndContinueWithoutFirstNameTest(String last_name,String zipcode){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.addAllToCart();
        inventoryPage.goToCart();

        CartPage cartPage= new CartPage(inventoryPage.getDriver());
        cartPage.goToCheckout();

        CheckoutStepOnePage checkoutPage=new CheckoutStepOnePage(cartPage.getDriver());

        checkoutPage.writeLastName(last_name);
        checkoutPage.writeZipcode(zipcode);

        checkoutPage.clickContinueButton();

        Assert.assertEquals(checkoutPage.getErrorText(),"Error: First Name is required");
    }

    //TC-017
    @Test
    @Parameters({"first_name","zipcode"})
    public void tryFillFormAndContinueWithoutLastNameTest(String first_name,String zipcode){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.addAllToCart();
        inventoryPage.goToCart();

        CartPage cartPage= new CartPage(inventoryPage.getDriver());
        cartPage.goToCheckout();

        CheckoutStepOnePage checkoutPage=new CheckoutStepOnePage(cartPage.getDriver());

        checkoutPage.writeFirstName(first_name);
        checkoutPage.writeZipcode(zipcode);

        checkoutPage.clickContinueButton();

        Assert.assertEquals(checkoutPage.getErrorText(),"Error: Last Name is required");
    }

    //TC-018
    @Test
    @Parameters({"first_name","last_name"})
    public void tryFillFormAndContinueWithoutZipcodeTest(String first_name,String last_name){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.addAllToCart();
        inventoryPage.goToCart();

        CartPage cartPage= new CartPage(inventoryPage.getDriver());
        cartPage.goToCheckout();

        CheckoutStepOnePage checkoutPage=new CheckoutStepOnePage(cartPage.getDriver());

        checkoutPage.writeFirstName(first_name);
        checkoutPage.writeLastName(last_name);

        checkoutPage.clickContinueButton();

        Assert.assertEquals(checkoutPage.getErrorText(),"Error: Postal Code is required");
    }

}
