package tests;

import constants.Messages;
import constants.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MainPage;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Login Tests")
public class AuthTests extends BaseTest {

    @Test
    @Description("Successful login")
    public void loginTest() {
        new LoginPage().enterUsername(TestData.VALID_LOGIN)
                .enterPassword(TestData.VALID_PASSWORD)
                .clickLoginButton();
        MainPage mainAppScreen = new MainPage();
        assertAll(
                () -> assertTrue(mainAppScreen.isSuccessMessageDisplayed(), "Success message is not displayed"),
                () -> assertEquals(Messages.SUCCESS_LOGIN, mainAppScreen.getSuccessMessage(), "Success message is wrong")
        );
    }

    @Test
    @Description("Wrong data login")
    public void wrongDataLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(TestData.INVALID_LOGIN)
                .enterPassword(TestData.INVALID_PASSWORD)
                .clickLoginButton();
        assertAll(
                () -> assertEquals(Messages.LOGIN_TITLE, loginPage.getTitle()),
                () -> assertEquals(Messages.NOT_VALID_DATA, loginPage.getErrorMessage())
        );
    }
}

