package utils;  // Declares that this class belongs to the 'utils' package

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

// Factory class to initialize and manage WebDriver instances
public class DriverFactory {

    // ThreadLocal to ensure thread-safety when running tests in parallel (e.g., with TestNG)
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // Initializes the WebDriver based on the given browser name
    public static WebDriver initDriver(String browser) {
        WebDriver driver = null;

        // If no browser is provided, default to Chrome
        if (browser == null) browser = "chrome";

        // Switch to determine which WebDriver to initialize
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup(); // Automatically handles ChromeDriver binaries
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*"); // Fixes Chrome CDP warning (optional)
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup(); // Automatically handles GeckoDriver binaries
                driver = new FirefoxDriver();
                break;

            default:
                // Default to Chrome if browser name is unrecognized
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set an implicit wait globally to handle dynamic web elements
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Store the driver instance in ThreadLocal for thread safety
        tlDriver.set(driver);

        return driver;
    }

    // Returns the current WebDriver instance (thread-safe)
    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    // Quits the WebDriver and removes it from ThreadLocal storage
    public static void quitDriver() {
        if (tlDriver.get() != null) {
            tlDriver.get().quit();   // Close browser
            tlDriver.remove();       // Remove reference to avoid memory leaks
        }
    }
}
