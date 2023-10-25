package tests;

import constants.Messages;
import constants.TestData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Login Field Validation")
public class LoginFieldValidationTests extends BaseTest {

    @Test
    @Description("Try to log in with empty data(not input of user, password)")
    public void tryToLoginWithEmptyDataTest() {
        LoginPage loginScreen = new LoginPage();
        loginScreen.clickLoginButton();
        assertEquals(loginScreen.getErrorMessage(), Messages.NOT_VALID_DATA);
    }

    @Test
    @Description("Validation of max length field(input) - username input")
    @Issue("BUG-123")
    public void validationUsernameMaxLengthTest() {
        LoginPage loginScreen = new LoginPage();
        loginScreen.enterUsername(TestData.BIG_DATA_INPUT)
                .enterPassword(TestData.VALID_PASSWORD)
                .clickLoginButton();
        assertAll(
                () -> assertEquals(loginScreen.getEnteredLogin().length(), 50),
                () -> assertEquals(loginScreen.getErrorMessage(), Messages.NOT_VALID_DATA)
        );
    }

    @Test
    @Description("Validation of forbidden field(input) - username input with russian and special characters")
    @TmsLink("TMS-456")
    public void validationUsernameForbiddenInputTest() {
        LoginPage loginScreen = new LoginPage();
        loginScreen.enterUsername(TestData.FORBIDDEN_INPUT)
                .enterPassword(TestData.VALID_PASSWORD)
                .clickLoginButton();
        assertEquals(loginScreen.getErrorMessage(), Messages.NOT_VALID_DATA);
    }
}
