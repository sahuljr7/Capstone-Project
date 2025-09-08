package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;
import utils.ExcelUtil;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    static String excelPath;
    static String sheetName;

    @BeforeClass
    public void setUp() {
        ConfigReader.loadConfig();
        excelPath = ConfigReader.getProperty("excelPath");
        sheetName = ConfigReader.getProperty("sheetName");
    }

    // ✅ DataProvider to feed each row as a test
    @DataProvider(name = "LoginData")
    public Object[][] getData() {
        int rowCount = ExcelUtil.getRowCount(excelPath, sheetName);
        int colCount = ExcelUtil.getColCount(excelPath, sheetName);

        Object[][] data = new Object[rowCount - 1][colCount]; // skip header

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = ExcelUtil.getCellData(excelPath, sheetName, i, j);
            }
        }
        return data;
    }

    @BeforeMethod
    public void startBrowser() {
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.getProperty("url"));
        loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "LoginData")
    public void loginDataDrivenTest(String username, String password, String expected) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        if (expected.equalsIgnoreCase("Products")) {
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                    "❌ Login failed for: " + username);
        } else {
            String actualError = loginPage.getErrorMsg();
            Assert.assertTrue(actualError.contains(expected),
                    "❌ Expected: " + expected + " but got: " + actualError);
        }
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
