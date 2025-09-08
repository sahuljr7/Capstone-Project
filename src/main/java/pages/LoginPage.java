package pages;  // Declares that this class belongs to the 'pages' package

import org.openqa.selenium.By;        // Importing By class to locate elements on a web page
import org.openqa.selenium.WebDriver; // Importing WebDriver to interact with the browser

// Page Object Model (POM) class representing the Login Page
public class LoginPage {
    
    private WebDriver driver;  // WebDriver instance used to interact with web elements on the page

    // Locators for username, password, and login button using their HTML element IDs
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");

    // Constructor to initialize the WebDriver instance for this page
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to enter the username into the username input field
    public void enterUsername(String u) {
        driver.findElement(username).sendKeys(u);
    }

    // Method to enter the password into the password input field
    public void enterPassword(String p) {
        driver.findElement(password).sendKeys(p);
    }

    // Method to click the login button
    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }
}
