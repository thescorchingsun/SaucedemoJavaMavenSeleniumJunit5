package autotests;

import io.qameta.allure.Issue;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

@Slf4j
public class LoginPositiveTest extends BaseTest {

    private final String URL_CATALOG = "https://www.saucedemo.com/inventory.html";
    private final String USERNAME_STANDARD = "standard_user";
    private final String PASSWORD = "secret_sauce";

    @Test
    @DisplayName("Авторизация со стандартным пользователем")
    @Tag("smoke")
    @Issue("JIRA-52")
    public void loginStandardUserTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage()
                .typeUsername(USERNAME_STANDARD)
                .typePassword(PASSWORD)
                .clickLoginButton();
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(URL_CATALOG, actualUrl);
    }


}
