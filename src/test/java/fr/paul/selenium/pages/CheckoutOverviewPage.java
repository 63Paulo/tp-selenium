package fr.paul.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckoutOverviewPage extends BasePage {

    private final By pageTitle = By.xpath("//span[@class='title']");
    private final By cartQuantity = By.xpath("//div[@data-test='item-quantity']");
    private final By priceTotal = By.xpath("//div[@data-test='total-label']");
    private final By buttonFinish = By.xpath("//button[@data-test='finish']");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed(){
        return isDisplayed(pageTitle) && getText(pageTitle).equalsIgnoreCase("Checkout: Overview");
    }

    public int getItemCount(){
        List<WebElement> cartQuantityElements = driver.findElements(cartQuantity);
        int cpt = 0;
        for (WebElement itemCount : cartQuantityElements){
            cpt += Integer.parseInt(itemCount.getText());
        }
        return cpt;
    }

    public String getTotalPrice(){
        scrollTo(priceTotal);
        return getText(priceTotal);
    }

    public CheckoutCompletePage clickFinish(){
        click(buttonFinish);
        return new CheckoutCompletePage(driver);
    }
}
