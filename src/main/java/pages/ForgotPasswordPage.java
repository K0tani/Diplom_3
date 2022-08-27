package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class ForgotPasswordPage {

    //Локатор
    //Кнопка "Войти"
    @FindBy(how = How.LINK_TEXT,using="Войти")
    private SelenideElement login;

    //Метод
    @Step("Кликнуть на кнопку 'Войти'")
    public LoginPage clickEnterButton () {
        login.click();
        return page(LoginPage.class);
    }
}
