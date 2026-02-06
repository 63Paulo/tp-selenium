package fr.paul.selenium.tests;

import fr.paul.selenium.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutCompleteTest extends BaseTest{

    @Test
    @Feature("Order completion")
    @Story("As an user, I login, add a product to the cart, access checkout, fill informations, continue and confirm")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login with valid credentials, add a product to cart, go to cart, go to checkout, fill informations" +
            "confirm and check is the confirmation message is here")
    public void testCompleteOrderFlow(){
        String confirmMessage = new LoginPage(driver)
                .login(standard_user, password)
                .addBackpackToCart()
                .clickCartIcon()
                .clickCheckout()
                .fillInformation("a", "a", "a")
                .clickContinue()
                .clickFinish()
                .getConfirmationMessage();
        assertTrue(confirmMessage.contains("Thank you"));
    }
}
