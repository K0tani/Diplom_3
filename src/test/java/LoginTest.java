import helpers.UserDataGenerator;
import helpers.UserClient;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ForgotPasswordPage;
import pages.RegistrationPage;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static helpers.Url.*;

@Feature("Вход")
public class LoginTest extends BaseSettings{

    private UserDataGenerator userDataGenerator;
    private UserClient user;
    private String auth;
    private MainPage mainPage;

    @Before
    public void setUp() {
        user = new UserClient();
        userDataGenerator = UserDataGenerator.getRandomDataUser();
        ValidatableResponse response = user.userCreate(userDataGenerator);

        auth = response.extract().path("accessToken");
        mainPage = open(MAIN_PAGE, MainPage.class);
    }

    @After
    public void tearDown() {
        if (auth != null) {
            user.deleteUser(auth);
        }
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void loginFromMainPage() {
        mainPage.clickAccountEntryButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(userDataGenerator.getEmail());
        loginPage.setPasswordField(userDataGenerator.getPassword());
        loginPage.login();

        webdriver().shouldHave(url(MAIN_PAGE));
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void loginFromProfileButtonMainPageTest() {
        mainPage.clickProfileButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(userDataGenerator.getEmail());
        loginPage.setPasswordField(userDataGenerator.getPassword());
        loginPage.login();

        webdriver().shouldHave(url(MAIN_PAGE));
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void loginFromRegisterPage() {
        mainPage.clickAccountEntryButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.login();

        loginPage.setEmailField(userDataGenerator.getEmail());
        loginPage.setPasswordField(userDataGenerator.getPassword());
        loginPage.login();

        webdriver().shouldHave(url(MAIN_PAGE));
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void loginFromRestorePasswordPage() {
        mainPage.clickAccountEntryButton();

        LoginPage loginPage = page(LoginPage.class);
        loginPage.restorePassword();

        ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);
        forgotPasswordPage.clickEnterButton();

        loginPage.setEmailField(userDataGenerator.getEmail());
        loginPage.setPasswordField(userDataGenerator.getPassword());
        loginPage.login();

        webdriver().shouldHave(url(MAIN_PAGE));
    }
}