package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class ProfilePage {

    //Локаторы
    //Кнопка "Выход"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Выход')]")
    private SelenideElement logoutButton;

    //Кнопка "Конструктор"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Конструктор')]")
    private SelenideElement constructorButton;

    //Логотип сайта "Stellar Burgers"
    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logoImage;

    //Методы
    @Step("Кликаем на выход")
    public LoginPage clickExitButton() {
        logoutButton.click();
        return page(LoginPage.class);
    }
    @Step("Кликаем на Конструктор")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return page(MainPage.class);
    }
    @Step("Кликаем на лого")
    public MainPage clickLogoImage() {
        logoImage.click();
        return page(MainPage.class);
    }
}