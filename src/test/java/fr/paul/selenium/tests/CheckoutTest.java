package fr.paul.selenium.tests;

import fr.paul.selenium.pages.CheckoutOverviewPage;
import fr.paul.selenium.pages.CheckoutPage;
import fr.paul.selenium.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test
    @Feature("Checkout process")
    @Story("As an user, I want to login and access to the inventory page, add a product to cart, access cart, access" +
            "checkout, fill personal information, click continue")
    @Severity(SeverityLevel.NORMAL)
    @Description("Login with valid crendentials, add a product to cart, access cart, access checkout, fill informations, " +
            "click continue and check onvrview page is displayed")
    public void testCheckoutWithValidInformation(){
        boolean isCheckoutOverviewPageDisplayed = new LoginPage(driver)
                .login(standard_user, password)
                .addBackpackToCart()
                .clickCartIcon()
                .clickCheckout()
                .fillInformation("Prénom", "Nom", "00000")
                .clickContinue()
                .isDisplayed();
        assertTrue(isCheckoutOverviewPageDisplayed);
    }

    @Test
    @Feature("Checkout process")
    @Story("As an user, i login, add a product to cart, go to cart, go to overview, fill informations with empty" +
            "first name")
    @Severity(SeverityLevel.NORMAL)
    @Description("Login with valid crendentials, add a product to cart, access cart, access checkout, fill informations with missing first nale, " +
            "click continue and check error message is displayed")
    public void testCheckoutWithMissingFirstName(){
        new LoginPage(driver)
                .login(standard_user, password)
                .addBackpackToCart()
                .clickCartIcon()
                .clickCheckout()
                .fillInformation("", "Nom", "00000")
                .clickContinue();
        String errorMessage = new CheckoutPage(driver).getErrorMessage();
        assertTrue(errorMessage.contains("Error"));
    }
}
