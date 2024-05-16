package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

public class TestRoutingServlet {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "/Users/mac/Downloads/chromedriver-mac-x64-2/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run headless for automated testing
        driver = new ChromeDriver(options);
    }

    @Test
    public void testLoginPageRedirectToQ1() {
        // Open the login form
        driver.get("http://localhost:8080/login");
    
        // Fill in the form
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("ahsan");
    
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("ahsan_pass");
        captureScreenshot("testLoginPage");

        // Submit the form
        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        loginButton.click();
    
        // Wait for redirect to Q1 page
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/q1")); // Wait until URL contains '/q1'
    
        captureScreenshot("testQ1Page");

        // Verify message or element on Q1 page
        WebElement resultElement = driver.findElement(By.tagName("h2"));
        String resultText = resultElement.getText().trim();
        assertEquals("Q1", resultText);
    }
    

    @Test
    public void testQ1Page() {
        // Open the Q1 form
        driver.get("http://localhost:8080/q1");

        // Fill in the form
        WebElement number1Input = driver.findElement(By.id("number1"));
        number1Input.sendKeys("10");

        WebElement number2Input = driver.findElement(By.id("number2"));
        number2Input.sendKeys("20");

        WebElement result = driver.findElement(By.id("result"));
        result.sendKeys("30");

        captureScreenshot("testQ1Page");

        // Submit the form
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

        // Wait for response
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/q2")); // Wait until URL contains '/q1'

        // Verify message or element on Q1 page
        WebElement resultElement = driver.findElement(By.tagName("h2"));
        String resultText = resultElement.getText().trim();
        assertEquals("Q2", resultText);
    }


    @Test
    public void testQ1PageFail() {
        // Open the Q1 form
        driver.get("http://localhost:8080/q1");

        // Fill in the form
        WebElement number1Input = driver.findElement(By.id("number1"));
        number1Input.sendKeys("10");

        WebElement number2Input = driver.findElement(By.id("number2"));
        number2Input.sendKeys("20");

        WebElement result = driver.findElement(By.id("result"));
        result.sendKeys("40");
        // Submit the form
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        captureScreenshot("testQ1PageFail");

    
        // Verify message or element on Q1 page
        WebElement resultElement = driver.findElement(By.tagName("div"));
        String resultText = resultElement.getText().trim();
        assertEquals("Wrong answer, try again.", resultText);
    }
    @Test
    public void testQ2Page() {
        // Open the Q1 form
        driver.get("http://localhost:8080/q2");

        // Fill in the form
        WebElement number1Input = driver.findElement(By.id("number1"));
        number1Input.sendKeys("20");

        WebElement number2Input = driver.findElement(By.id("number2"));
        number2Input.sendKeys("10");

        WebElement result = driver.findElement(By.id("result"));
        result.sendKeys("10");
        captureScreenshot("testQ2Page");

        // Submit the form
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

        // Wait for response
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/q3")); // Wait until URL contains '/q1'

        // Verify message or element on Q1 page
        WebElement resultElement = driver.findElement(By.tagName("h1"));
        String resultText = resultElement.getText().trim();
        assertEquals("Math Question 3: Multiplication", resultText);
    }
    @Test
    public void testQ2PageFail() {
        // Open the Q1 form
        driver.get("http://localhost:8080/q2");

        // Fill in the form
        WebElement number1Input = driver.findElement(By.id("number1"));
        number1Input.sendKeys("10");

        WebElement number2Input = driver.findElement(By.id("number2"));
        number2Input.sendKeys("20");

        WebElement result = driver.findElement(By.id("result"));
        result.sendKeys("30");
        // Submit the form
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        captureScreenshot("testQ12PageFail");

    
        // Verify message or element on Q1 page
        WebElement resultElement = driver.findElement(By.tagName("div"));
        String resultText = resultElement.getText().trim();
        assertEquals("Wrong answer, try again.", resultText);
    }
    @Test
    public void testQ3Page() {
        // Open the Q1 form
        driver.get("http://localhost:8080/q3");

        // Fill in the form
        WebElement number1Input = driver.findElement(By.id("number1"));
        number1Input.sendKeys("2");

        WebElement number2Input = driver.findElement(By.id("number2"));
        number2Input.sendKeys("3");

        WebElement result = driver.findElement(By.id("result"));
        result.sendKeys("6");
        captureScreenshot("testQ3Page");

        // Submit the form
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

        // Wait for response
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/q4")); // Wait until URL contains '/q1'

        // Verify message or element on Q1 page
        WebElement resultElement = driver.findElement(By.tagName("h1"));
        String resultText = resultElement.getText().trim();
        assertEquals("Math Question 4: Division", resultText);
    }
    @Test
    public void testQ3PageFail() {
        // Open the Q1 form
        driver.get("http://localhost:8080/q3");

        // Fill in the form
        WebElement number1Input = driver.findElement(By.id("number1"));
        number1Input.sendKeys("10");

        WebElement number2Input = driver.findElement(By.id("number2"));
        number2Input.sendKeys("20");

        WebElement result = driver.findElement(By.id("result"));
        result.sendKeys("50");
        // Submit the form
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

        captureScreenshot("testQ3PageFail");

        // Verify message or element on Q1 page
        WebElement resultElement = driver.findElement(By.tagName("div"));
        String resultText = resultElement.getText().trim();
        assertEquals("Wrong answer, try again.", resultText);
    }
    @Test
    public void testQ4Page() {
        // Open the Q1 form
        driver.get("http://localhost:8080/q4");

        // Fill in the form
        WebElement number1Input = driver.findElement(By.id("number1"));
        number1Input.sendKeys("4");

        WebElement number2Input = driver.findElement(By.id("number2"));
        number2Input.sendKeys("2");

        WebElement result = driver.findElement(By.id("result"));
        result.sendKeys("2");
        captureScreenshot("testQ4Page");

        // Submit the form
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();

        // Wait for response
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains("/q5")); // Wait until URL contains '/q1'

        // Verify message or element on Q1 page
        WebElement resultElement = driver.findElement(By.tagName("h1"));
        String resultText = resultElement.getText().trim();
        assertEquals("Math Question 5: Multiplication", resultText);
    }

    @Test
    public void testQ4PageFail() {
        // Open the Q1 form
        driver.get("http://localhost:8080/q3");

        // Fill in the form
        WebElement number1Input = driver.findElement(By.id("number1"));
        number1Input.sendKeys("4");

        WebElement number2Input = driver.findElement(By.id("number2"));
        number2Input.sendKeys("2");

        WebElement result = driver.findElement(By.id("result"));
        result.sendKeys("1");
        // Submit the form
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        captureScreenshot("testQ4PageFail");

    
        // Verify message or element on Q1 page
        WebElement resultElement = driver.findElement(By.tagName("div"));
        String resultText = resultElement.getText().trim();
        assertEquals("Wrong answer, try again.", resultText);
    }
    @After
    public void tearDown() {
        // Close the WebDriver instance
        if (driver != null) {
            driver.quit();
        }
    }
        private void captureScreenshot(String testName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotDirectory = "./screenshots/";
        String screenshotPath = screenshotDirectory + testName + ".png";

        try {
            // Save screenshot to file
            org.apache.commons.io.FileUtils.copyFile(screenshotFile, new File(screenshotPath));
            System.out.println("Screenshot captured: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
