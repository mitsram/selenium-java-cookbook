package specs;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;
import utils.AppConfig;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {        
        String username = AppConfig.getEnvVariable("SAUCEDEMO_USERNAME");
        String password = AppConfig.getEnvVariable("SAUCEDEMO_PASSWORD");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.getInventoryItemCount() > 0, "Inventory page not loaded");
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "wrong_password");
        
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
    }
}
