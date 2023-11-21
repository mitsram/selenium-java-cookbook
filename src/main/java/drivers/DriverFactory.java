package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
    BrowserTypeEnum browserType;
    
    public DriverFactory(BrowserTypeEnum browserType) {
        this.browserType = browserType;
    }

    public WebDriver createDriver() throws Exception {

        switch (this.browserType) {
            case Chrome:
                return new ChromeDriver();
            case Firefox:
                return new FirefoxDriver();
            case Safari:
                return new SafariDriver();
            default:
                throw new Exception("Invalid browser type");
        }        
    }
}
