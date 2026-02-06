package fr.paul.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private final By pageTitle = By.xpath("//span[@class='title']");
    private final By confirmMessage = By.xpath("//h2[@data-test='complete-header']");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed(){
        return isDisplayed(pageTitle) && getText(pageTitle).equalsIgnoreCase("Checkout: Complete!");
    }

    public String getConfirmationMessage(){
        return getText(confirmMessage);
    }
}
