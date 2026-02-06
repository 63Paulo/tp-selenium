package fr.paul.selenium.tests;

import fr.paul.selenium.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @Feature("Login functionality")
    @Story("As an user, I want to login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Type an username and a password into the login input then submit and check if the inventory page" +
            "is displayed")
    public void testLoginWithValidCredentials(){
        boolean isInventoryPageDisplayed = new LoginPage(driver)
                .login("standard_user", "secret_sauce")
                .isDisplayed();
        assertTrue(isInventoryPageDisplayed);
    }

    @Test
    @Feature("Login functionality")
    @Story("As an user, I try to login with a locked out account")
    @Severity(SeverityLevel.NORMAL)
    @Description("Type login information of an account that is locked out and check if the error message of " +
            "the login contains 'locked out'")
    public void testLoginWithLockedUser(){
        new LoginPage(driver).login("locked_out_user", "secret_sauce");
        String loginError = new LoginPage(driver).getErrorMessage();
        assertTrue(loginError.contains("locked out"));
    }

    @Test
    @Feature("Login functionality")
    @Story("As an user, I try to login with an invalid password")
    @Severity(SeverityLevel.NORMAL)
    @Description("Type an incorrect password in the login page and check if an error message is displayed")
    public void testLoginWithInvalidPassword(){
        new LoginPage(driver).login("standard_user", "wrong_password");
        boolean isErrorMessageDisplayed = new LoginPage(driver).isErrorDisplayed();
        assertTrue(isErrorMessageDisplayed);
    }

    @Test
    @Feature("Login functionality")
    @Story("As an user, I try to login with empty credentials")
    @Severity(SeverityLevel.NORMAL)
    @Description("Try to login with nothing in the login input and check if an error message is displayed")
    public void testLoginWithEmptyCredentials(){
        new LoginPage(driver).login("", "");
        boolean isErrorMessageDisplayed = new LoginPage(driver).isErrorDisplayed();
        assertTrue(isErrorMessageDisplayed);
    }
}
