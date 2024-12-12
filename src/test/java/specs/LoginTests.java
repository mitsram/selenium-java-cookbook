package specs;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;
import utils.ConfigReader;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
            ConfigReader.getProperty("username"), 
            ConfigReader.getProperty("password")
        );
        
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
