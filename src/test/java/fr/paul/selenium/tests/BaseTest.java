package fr.paul.selenium.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    protected void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        String headless = System.getenv("HEADLESS");
        if ("true".equalsIgnoreCase(headless)) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            try {
                saveScreenshot();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            driver.quit();
        }
    }

    @Attachment(fileExtension = ".png", type = "image/png", value = "Screenshot of the test")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
