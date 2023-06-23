import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BasePageTest{
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver=new ChromeDriver(options);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void driverTest(){
        driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
