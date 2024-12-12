package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;

    private By inventoryItems = By.className("inventory_item");
    private By addToCartButton = By.cssSelector(".btn_inventory");
    private By cartBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getInventoryItemCount() {
        return driver.findElements(inventoryItems).size();
    }

    public void addFirstItemToCart() {
        List<WebElement> addToCartButtons = driver.findElements(addToCartButton);
        if (!addToCartButtons.isEmpty()) {
            addToCartButtons.get(0).click();
        }
    }

    public int getCartItemCount() {
        try {
            return Integer.parseInt(driver.findElement(cartBadge).getText());
        } catch (Exception e) {
            return 0;
        }
    }
}
