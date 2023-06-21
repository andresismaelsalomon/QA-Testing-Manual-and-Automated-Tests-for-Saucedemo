import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private final By usernameLocator=By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input");
    private final By passwordLocator=By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input");
    private final By loginButtonLocator=By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input");
    private final By loginErrorMessageLocator=By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3");
    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void login(String username,String password){
        waitForElementToBeLocated(usernameLocator).sendKeys(username);
        waitForElementToBeLocated(passwordLocator).sendKeys(password);
        waitForElementToBeLocated(loginButtonLocator).click();
    }

    public void login(){
        waitForElementToBeLocated(usernameLocator).sendKeys("standard_user");
        waitForElementToBeLocated(passwordLocator).sendKeys("secret_sauce");
        waitForElementToBeLocated(loginButtonLocator).click();
    }

    public void goToUrl() {
        String url = "https://www.saucedemo.com";
        getDriver().get(url);
    }

    public String getLoginErrorMessage() {
       return waitForElementToBeLocated(loginErrorMessageLocator).getText();
    }
}
