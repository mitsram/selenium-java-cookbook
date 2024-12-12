package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    public static WebDriver createDriver(String browserType) {
        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                
                return new ChromeDriver(options);
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }
    }
}
