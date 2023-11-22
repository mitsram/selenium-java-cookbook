import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage;
    
    @BeforeClass
    public void testSetup() {
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void login_ValidCredentials_ReturnsSuccessful() {       
        loginPage.login(dotenv.get("USERNAME"), dotenv.get("PASSWORD"));

        boolean isLoggedIn = loginPage.isLoggedIn();
        Assert.assertTrue(isLoggedIn);
    }
}
