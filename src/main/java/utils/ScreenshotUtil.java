package utils;  // Declares that this class belongs to the 'utils' package

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

// Utility class for taking screenshots during test execution
public class ScreenshotUtil {

    /**
     * Captures a screenshot of the current browser window and saves it as a PNG file.
     *
     * @param driver The WebDriver instance used to take the screenshot
     * @param name   The name of the screenshot file (without extension)
     * @return       The path to the saved screenshot as a String, or null if an error occurred
     */
    public static String takeScreenshot(WebDriver driver, String name) {
        try {
            // Capture the screenshot and store it in a temporary file
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define the destination path as 'reports/name.png'
            Path dest = Path.of("reports", name + ".png");

            // Create the directory if it does not exist
            Files.createDirectories(dest.getParent());

            // Copy the screenshot file to the destination path
            Files.copy(src.toPath(), dest);

            // Return the absolute path of the saved screenshot
            return dest.toString();
        } catch (Exception e) {
            // Print the stack trace in case of any exceptions
            e.printStackTrace();
            return null;
        }
    }
}
