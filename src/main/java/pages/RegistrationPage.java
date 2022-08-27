package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {
    //Локаторы
    //Поле "Имя"
    @FindBy(how = How.XPATH, using = ".//fieldset[1]//input")
    private SelenideElement nameField;

    //Поле "Email"
    @FindBy(how = How.XPATH, using = ".//fieldset[2]//input")
    private SelenideElement emailField;

    //Поле "Пароль"
    @FindBy(how = How.NAME,using="Пароль")
    private SelenideElement passwordField;

    //Кнопка Войти
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement login;

    //Кнопка Зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registrationButton;

    //Сообщения об ошибке
    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Некорректный пароль')]")
    private SelenideElement errorPasswordField;

    //Методы
    @Step("Установить имя")
    public void setNameField(String name) {
        nameField.click();
        nameField.setValue(name);
    }
    @Step("Установить email")
    public void setEmailField(String email) {
        emailField.click();
        emailField.setValue(email);
    }
    @Step("Установить пароль")
    public void setPasswordField(String password) {
        passwordField.click();
        passwordField.setValue(password);
    }
    @Step("Клик по кнопке Зарегистрироваться")
    public void submitRegistration() {
        registrationButton.click();
    }
    @Step("Получить текст об ошибке")
    public boolean getPasswordError() {
        return errorPasswordField.isDisplayed();
    }
    @Step("Жмём кнопку на 'Войти' ")
    public LoginPage login() {
        login.click();
        return page(LoginPage.class);
    }
}