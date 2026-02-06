package fr.paul.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By pageTitle = By.xpath("//span[@class='title']");
    private final By firstNameInput = By.xpath("//input[@data-test='firstName']");
    private final By lastNameInput = By.xpath("//input[@data-test='lastName']");
    private final By zipCodeInput = By.xpath("//input[@data-test='postalCode']");
    private final By continueButton = By.xpath("//input[@data-test='continue']");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed(){
        return isDisplayed(pageTitle) && getText(pageTitle).equalsIgnoreCase("Checkout: Your Information");
    }

    public CheckoutPage fillInformation(String firstName, String lastName, String zipCode){
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(zipCodeInput, zipCode);
        return this;
    }

    public CheckoutOverviewPage clickContinue(){
        click(continueButton);
        return new CheckoutOverviewPage(driver);
    }

    public String getErrorMessage(){
        return getText(errorMessage);
    }
}
