import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryPageTest extends BasePageTest{

    //TC-003
    @Test
    public void addToCartTest(){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.addAllToCart();

        Assert.assertEquals(inventoryPage.getNumberOnCart(),"6");
    }

    //TC-004
    @Test
    public void removeAllFromCartTest(){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.addAllToCart();
        inventoryPage.removeAllFromCart();

        Assert.assertEquals(inventoryPage.waitForElementToBeInvisible(inventoryPage.getNumberOnCartLocator()),true);
    }

    //TC-005
    @Test
    public void sortItemsFromAToZ(){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.sortNameFromAToZ();

        Assert.assertEquals(inventoryPage.getNamesOfProducts(),
                "[Sauce Labs Backpack, Sauce Labs Bike Light, Sauce Labs Bolt T-Shirt, Sauce Labs Fleece Jacket, Sauce Labs Onesie, Test.allTheThings() T-Shirt (Red)]");
    }

    //TC-006
    @Test
    public void sortItemsFromZToA(){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.sortNameFromZToA();

        Assert.assertEquals(inventoryPage.getNamesOfProducts(),
                "[Test.allTheThings() T-Shirt (Red), Sauce Labs Onesie, Sauce Labs Fleece Jacket, Sauce Labs Bolt T-Shirt, Sauce Labs Bike Light, Sauce Labs Backpack]");
    }

    //TC-007
    @Test
    public void sortItemsFromLowToHigh(){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.sortPriceFromLowToHigh();

        Assert.assertEquals(inventoryPage.getNamesOfProducts(),
                "[Sauce Labs Onesie, Sauce Labs Bike Light, Sauce Labs Bolt T-Shirt, Test.allTheThings() T-Shirt (Red), Sauce Labs Backpack, Sauce Labs Fleece Jacket]");
    }

    //TC-008
    @Test
    public void sortItemsFromHighToLow(){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.sortPriceFromHighToLow();

        Assert.assertEquals(inventoryPage.getNamesOfProducts(),
                "[Sauce Labs Fleece Jacket, Sauce Labs Backpack, Sauce Labs Bolt T-Shirt, Test.allTheThings() T-Shirt (Red), Sauce Labs Bike Light, Sauce Labs Onesie]");
    }

    //TC-009
    @Test
    public void goToCartTest(){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login();

        InventoryPage inventoryPage=new InventoryPage(loginPage.getDriver());
        inventoryPage.goToCart();

        Assert.assertEquals(inventoryPage.getDriver().getCurrentUrl(),"https://www.saucedemo.com/cart.html");
    }
}
