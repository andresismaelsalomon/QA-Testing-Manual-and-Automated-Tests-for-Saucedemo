import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BasePageTest{
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
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
