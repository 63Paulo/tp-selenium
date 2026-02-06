package fr.paul.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BasePage {

    protected final WebDriverWait wait;
    protected final WebDriver driver;

    protected static String ROOT_URL = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    protected BasePage goTo(String url) {
        driver.get(url);
        return this;
    }

    protected WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator){
        WebElement element = waitUntilClickable(locator);
        element.click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitUntilClickable(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isDisplayed(By locator){
        WebElement element = waitUntilVisible(locator);
        return element.isDisplayed();
    }

    protected WebElement goHover(By locator) {
        WebElement element = waitUntilVisible(locator);
        new Actions(driver)
                .moveToElement(element)
                .perform();
        return element;
    }

    public void keyDown(By element, Keys key){
        WebElement webElement= waitUntilClickable(element);
        webElement.sendKeys(key);
    }

    protected String getText(By locator) {
        return waitUntilVisible(locator).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void scrollTo(By locator) {
        new Actions(driver).moveToElement(driver.findElement(locator)).perform();
    }
}
