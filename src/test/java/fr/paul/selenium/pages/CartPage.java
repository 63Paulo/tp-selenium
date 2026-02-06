package fr.paul.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private final By pageTitle = By.xpath("//span[@data-test='title']");
    private final By cartQuantity = By.xpath("//div[@data-test='item-quantity']");
    private final By checkoutButton = By.xpath("//button[@data-test='checkout']");
    private final By continueShoppingButton = By.xpath("//button[@data-test='continue-shopping']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed(){
        return isDisplayed(pageTitle) && getText(pageTitle).equalsIgnoreCase("Your Cart");
    }

    public int getItemCount(){
        List<WebElement> cartQuantityElements = driver.findElements(cartQuantity);
        int cpt = 0;
        for (WebElement itemCount : cartQuantityElements){
            cpt += Integer.parseInt(itemCount.getText());
        }
        return cpt;
    }

    public CheckoutPage clickCheckout(){
        scrollTo(checkoutButton);
        click(checkoutButton);
        return new CheckoutPage(driver);
    }

    public InventoryPage clickContinueShopping(){
        scrollTo(continueShoppingButton);
        click(continueShoppingButton);
        return new InventoryPage(driver);
    }
}
