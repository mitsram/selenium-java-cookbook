package drivers;

import org.openqa.selenium.WebDriver;

public class Driver {
    
    public static WebDriver initializeDriver() throws Exception {
        DriverFactory factory = new DriverFactory(getBrowserTypeFromEnv());
        return factory.createDriver();
    }

    public static BrowserTypeEnum getBrowserTypeFromEnv() {
        String envBrowserType = System.getenv("BROWSER_TYPE");
        String browserType = (envBrowserType == null || envBrowserType.isEmpty()) ? "Chrome" : envBrowserType;

        try {
            return Enum.valueOf(BrowserTypeEnum.class, browserType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid browser type: " + browserType);
        }
    }
}
