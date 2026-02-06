package fr.paul.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private final By pageTitle = By.xpath("//span[@class='title']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed(){
        String txt = getText(pageTitle);
        return txt.equals("Products");
    }
}
