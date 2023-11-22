import drivers.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setup() throws Exception {
        driver = Driver.initializeDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}