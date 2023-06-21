import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage {
    private final By firstNameLocator= By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input");
    private final By lastNameLocator=By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input");
    private final By zipcodeLocator=By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input");

    private final By cancelLocator=By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/button");
    private final By continueLocator=By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input");

    private final By errorLocator=By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3");

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void writeFirstName(String firstName){
        waitForElementToBeLocated(firstNameLocator).sendKeys(firstName);
    }

    public void writeLastName(String lastName){
        waitForElementToBeLocated(lastNameLocator).sendKeys(lastName);
    }

    public void writeZipcode(String zipcode){
        waitForElementToBeLocated(zipcodeLocator).sendKeys(zipcode);
    }

    public void clickCancelButton(){
        waitForElementToBeLocated(cancelLocator).click();
    }

    public void clickContinueButton(){
        waitForElementToBeLocated(continueLocator).click();
    }

    public String getErrorText(){
        return waitForElementToBeLocated(errorLocator).getText();
    }


    public void fillForm() {
        writeFirstName("John");
        writeLastName("Doe");
        writeZipcode("12345");
    }
}
