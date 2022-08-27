package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    //Локаторы
    //Поле "Email"
    @FindBy(how = How.NAME,using="name")
    private SelenideElement emailField;

    //Поле "Пароль"
    @FindBy(how = How.NAME,using="Пароль")
    private SelenideElement passwordField;

    //Кнопка "Войти"
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Войти')]")
    private SelenideElement login;

    //Кнопка "Зарегистрироваться"
    @FindBy(how = How.LINK_TEXT,using="Зарегистрироваться")
    private SelenideElement registrationButton;

    //Кнопка "Восстановить пароль"
    @FindBy(how = How.LINK_TEXT,using="Восстановить пароль")
    private SelenideElement restorePassword;

    //Методы
    @Step("Заполнить email")
    public LoginPage setEmailField(String email){
        emailField.setValue(email);
        return this;
    }
    @Step("Заполнить пароль")
    public LoginPage setPasswordField(String password) {
        passwordField.setValue(password);
        return this;
    }
    @Step("Клик на кнопку 'Войти' ")
    public MainPage login() {
        login.click();
        return page(MainPage.class);
    }
    @Step("Клик на кнопку 'Зарегистрироваться' ")
    public RegistrationPage clickRegistrationButton() {
        registrationButton.click();
        return page(RegistrationPage.class);
    }
    @Step("Клик на кнопку 'Восстановить пароль' ")
    public ForgotPasswordPage restorePassword() {
        restorePassword.click();
        return page(ForgotPasswordPage.class);
    }
}