package fr.paul.selenium.tests;

import fr.paul.selenium.pages.InventoryPage;
import fr.paul.selenium.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryTest extends BaseTest {

    @Test
    @Feature("Inventory management")
    @Story("As an user, I want to access to the inventory page")
    @Severity(SeverityLevel.CRITICAL)
    @Description("First, try to login with valid credential and check if the inventory page is displayed" +
            "then, check if the title of the page is 'Products'")
    public void testInventoryPageDisplayed(){
        boolean isInventoryPageDisplayed = new LoginPage(driver)
                .login(standard_user, password)
                .isDisplayed();
        assertTrue(isInventoryPageDisplayed);

        String pageTitle = new InventoryPage(driver).getPageTitle();
        assertEquals("Products", pageTitle);
    }

    @Test
    @Feature("Inventory management")
    @Story("As an user, i want to login, access to the inventory page and add the backpack to the cart")
    @Severity(SeverityLevel.NORMAL)
    @Description("Login with valid credentials, then add the backpack to the cart and chack the cart items count is" +
            "equal to one")
    public void testAddProductToCart(){
        int cartItemCount = new LoginPage(driver)
                .login(standard_user, password)
                .addBackpackToCart()
                .getCartItemCount();
        assertEquals(1, cartItemCount);
    }
}
