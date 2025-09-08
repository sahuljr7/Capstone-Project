package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMsg = By.cssSelector("h3");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String uname) {
        driver.findElement(usernameField).sendKeys(uname);
    }

    public void enterPassword(String pwd) {
        driver.findElement(passwordField).sendKeys(pwd);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
