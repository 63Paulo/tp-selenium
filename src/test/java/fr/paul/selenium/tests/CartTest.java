package fr.paul.selenium.tests;

import fr.paul.selenium.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest extends BaseTest {

    @Test
    @Feature("Shopping cart")
    @Story("As an user, I want to login to the website, then straight go the the cart page and check if there is" +
            "no element already in the cart")
    @Severity(SeverityLevel.NORMAL)
    @Description("Login with valid credentials, click the cart icon and access to the cart page and check items" +
            "count is equal to zero")
    public void testEmptyCart(){
        int cartItemCount = new LoginPage(driver)
                .login(standard_user, password)
                .clickCartIcon()
                .getItemCount();
        assertEquals(0, cartItemCount);
    }

    @Test
    @Feature("Shopping cart")
    @Story("As an user, I want to login and access to the inventory page, add a product to the cart, go the cart page" +
            "and check if the element I added is present in my cart")
    @Severity(SeverityLevel.NORMAL)
    @Description("Login with valid credentials, access to the inventory page and add one product to the cart, " +
            "the go the cart and check there is one element in this last")
    public void testCartWithOneProduct(){
        int cartItemCount = new LoginPage(driver)
                .login(standard_user, password)
                .addBackpackToCart()
                .clickCartIcon()
                .getItemCount();
        assertEquals(1, cartItemCount);
    }
}
