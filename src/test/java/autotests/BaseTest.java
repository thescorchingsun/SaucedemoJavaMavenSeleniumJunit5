package autotests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@Slf4j
public class BaseTest {

    protected WebDriver driver;

    @BeforeAll
    public static void downloadDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeEach
    public void setUp() {
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless"); //для CICD
        //driver = new ChromeDriver(options);
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterEach
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
    }


}