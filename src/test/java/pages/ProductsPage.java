package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductsPage extends BasePage {

    private final By titleText = By.xpath("/span[@data-test='title']");
    private final By burgerMenuButton = By.xpath("//div/div/div[@id='menu_button_container']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение заголовка")
    public ProductsPage getTitleText() {
        driver.findElement(titleText).getText();
        return this;
    }

    @Step("Кнопка - бургер отображается на странице")
    public ProductsPage burgerMenuButtonIsVisible() {
        driver.findElement(burgerMenuButton).isDisplayed();
        return this;
    }
}

