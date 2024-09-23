package autotests;

import io.qameta.allure.Issue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import pages.LoginPage;

@Slf4j
public class LoginNegativeTest extends BaseTest {

    private final String USERNAME_LOCKED_OUT = "locked_out_user";
    private final String PASSWORD = "secret_sauce";
    private final String EXPECTED_RESULT_ERROR_EMPTY_TEXT = "Epic sadface: Username is required";
    private final String EXPECTED_RESULT_LOCKED_OUT_TEXT = "Epic sadface: Sorry, this user has been locked out.";

    @Test
    @DisplayName("Текст ошибки при авторизация с заблокированным пользователем")
    @Tag("smoke")
    @Issue("JIRA-50")
    public void loginLockedOutUserTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .typeUsername(USERNAME_LOCKED_OUT)
                .typePassword(PASSWORD)
                .clickLoginButton();
        Assertions.assertEquals(loginPage.getErrorH3LockedOutText(), EXPECTED_RESULT_LOCKED_OUT_TEXT);
    }

    @Test
    @DisplayName("Текст ошибки при авторизации с пустым username и password")
    @Tag("regress")
    @Issue("JIRA-51")

    public void errorTextAuthWithoutUsernameAndPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .clickLoginErrorTextButton();
        Assertions.assertEquals(loginPage.getErrorH3EmptyText(), EXPECTED_RESULT_ERROR_EMPTY_TEXT);
    }

}