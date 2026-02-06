package fr.paul.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameInput = By.xpath("//input[@data-test='username']");
    private final By passwordInput = By.xpath("//input[@data-test='password']");
    private final By submitButton = By.xpath("//input[@name='login-button']");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open(){
        goTo(ROOT_URL);
        return this;
    }

    public InventoryPage login(String username, String password){
        open();
        waitUntilVisible(usernameInput);

        type(usernameInput, username);
        type(passwordInput, password);
        click(submitButton);
        return new InventoryPage(driver);
    }

    public String getErrorMessage(){
        return getText(errorMessage);
    }

    public boolean isErrorDisplayed(){
        return isDisplayed(errorMessage);
    }

}
