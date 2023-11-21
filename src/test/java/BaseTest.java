import drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {

    protected WebDriver driver;

    public BaseTest() throws Exception {
        driver = Driver.initializeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}