# 🚀 Final Capstone Project - SauceDemo Automation

![Java](https://img.shields.io/badge/Java-17-blue?style=flat-square&logo=java)
![Maven](https://img.shields.io/badge/Maven-Build-orange?style=flat-square&logo=apachemaven)
![Selenium](https://img.shields.io/badge/Selenium-Automation-brightgreen?style=flat-square&logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-Testing-yellow?style=flat-square)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-green?style=flat-square&logo=cucumber)

---

## 📖 Overview
This is a **capstone automation framework** built using:
- **Java 17**
- **Selenium WebDriver**
- **TestNG**
- **Cucumber (BDD)**
- **Maven**

It automates the [SauceDemo](https://www.saucedemo.com/) web application, covering:
- 🔑 Login  
- 🛒 Add to Cart  
- 📦 Checkout  
- ✅ End-to-End Purchase Flow  

---

## 📂 Project Structure

```

final-capstone-project/
│── pom.xml                        # Maven dependencies & build config
│── README.md                      # Project documentation
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── utils/             # Utility classes (DriverFactory, ConfigReader, ScreenshotUtil)
│   │
│   └── test/
│       └── java/
│           ├── pages/             # Page Object Model classes (LoginPage, ProductsPage, CheckoutPage)
│           ├── stepDefinitions/   # Cucumber Step Definitions
│           ├── runners/           # TestNG/Cucumber Test Runners
│           └── features/          # .feature files (BDD Scenarios)
│
└── target/                        # Auto-generated test reports & compiled code

````

---

## ⚙️ Setup & Installation

### 1️⃣ Prerequisites
- Install [Java 17+](https://adoptium.net/)
- Install [Maven](https://maven.apache.org/)
- Install any IDE (IntelliJ IDEA / Eclipse / VS Code)
- Install Chrome & [ChromeDriver](https://chromedriver.chromium.org/)

### 2️⃣ Clone the Repository
```bash
git clone https://github.com/sahuljr7/final-capstone-project.git
cd final-capstone-project
````

### 3️⃣ Build the Project

```bash
mvn clean install
```

### 4️⃣ Run the Tests

* Run via **Maven**

```bash
mvn test
```

* Run via **TestNG**

```bash
mvn -Dtest=TestRunner test
```

* Run via **Cucumber**

```bash
mvn verify
```

---

## 📌 Example `pom.xml` Dependencies

Below is the **important part of `pom.xml`** you need for this project:

```xml
<dependencies>
    <!-- Selenium WebDriver -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.23.0</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.10.2</version>
        <scope>test</scope>
    </dependency>

    <!-- Cucumber -->
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.15.0</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-testng</artifactId>
        <version>7.15.0</version>
    </dependency>

    <!-- WebDriver Manager -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.9.2</version>
    </dependency>

    <!-- Extent Reports (for better HTML reports) -->
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>extentreports</artifactId>
        <version>5.1.1</version>
    </dependency>
</dependencies>
```

---

## 🧪 Test Reports

After execution, reports will be available in:

```
target/surefire-reports/
target/cucumber-reports/
```

---

## 📌 Example Feature File (`Login.feature`)

```gherkin
Feature: SauceDemo End-to-End Tests

  Scenario: Login with valid credentials
    Given I open the saucedemo login page
    When I login with username "standard_user" and password "secret_sauce"
    Then I should land on the products page
```

---

## 🛠️ Technologies Used

* **Java 17**
* **Selenium WebDriver**
* **Cucumber (BDD)**
* **TestNG**
* **Maven**
* **Extent Reports**

---

