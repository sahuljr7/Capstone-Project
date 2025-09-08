package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExcelUtil;

import java.util.List;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("I run login tests with data from Excel")
    public void i_run_login_tests_with_data_from_excel() {
        ConfigReader.loadConfig();
        String excelPath = ConfigReader.getProperty("excelPath");
        String sheetName = ConfigReader.getProperty("sheetName");

        List<String[]> data = ExcelUtil.getExcelData(excelPath, sheetName);

        for (String[] row : data) {
            String username = row[0];
            String password = row[1];
            String expected = row[2];

            driver = DriverFactory.getDriver();
            driver.get(ConfigReader.getProperty("url"));
            loginPage = new LoginPage(driver);

            if (!username.isEmpty()) loginPage.enterUsername(username);
            if (!password.isEmpty()) loginPage.enterPassword(password);
            loginPage.clickLogin();

            if (expected.equalsIgnoreCase("Products")) {
                Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                        "Login failed for: " + username);
            } else {
                String actualError = loginPage.getErrorMsg();
                Assert.assertTrue(actualError.toLowerCase().contains(expected.toLowerCase()),
                        "Expected: " + expected + " but got: " + actualError);
            }

            DriverFactory.quitDriver();
        }
    }
}
