import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    LoginPage loginPage;
    
    public LoginTests() throws Exception {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void login_ValidCredentials_ReturnsSuccessful() {        
        loginPage.login("tomsmith", "SuperSecretPassword!");

        boolean isLoggedIn = loginPage.isLoggedIn();
        Assert.assertTrue(isLoggedIn);
    }
}
