package fr.paul.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private final By pageTitle = By.xpath("//span[@class='title']");
    private final By buttonAddToCartSauceLabsBackpack = By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']");
    private final By cartItemCount = By.xpath("//span[@data-test='shopping-cart-badge']");
    private final By buttonOpenShoppingCart = By.xpath("//a[@data-test='shopping-cart-link']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed(){
        return isDisplayed(pageTitle) && getPageTitle().equalsIgnoreCase("Products");
    }

    public String getPageTitle(){
        return getText(pageTitle);
    }

    public InventoryPage addBackpackToCart(){
        click(buttonAddToCartSauceLabsBackpack);
        return this;
    }

    public int getCartItemCount(){
        return Integer.parseInt(getText(cartItemCount));
    }

    public CartPage clickCartIcon(){
        click(buttonOpenShoppingCart);
        return new CartPage(driver);
    }
}
