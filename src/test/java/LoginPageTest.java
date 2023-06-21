import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BasePageTest {

    //TC-001
    @Test
    @Parameters({"standard_user","password"})
    public void loginTest(String username,String password){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login(username,password);

        Assert.assertEquals(loginPage.getDriver().getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

    //TC-002
    @Test
    @Parameters({"locked_out_user","password"})
    public void loginWithLockedOutUserTest(String username,String password){
        LoginPage loginPage=new LoginPage(getDriver());
        loginPage.goToUrl();
        loginPage.login(username,password);

        Assert.assertEquals(loginPage.getLoginErrorMessage(),"Epic sadface: Sorry, this user has been locked out.");
    }


}
