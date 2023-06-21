import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver=driver;
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public WebElement waitForElementToBeLocated(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public Boolean waitForElementToBeInvisible(By locator){
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public List<WebElement> waitForElements(By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebDriver getDriver(){
        return driver;
    }

}
