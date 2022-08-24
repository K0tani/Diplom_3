import helpers.UserDataGenerator;
import helpers.UserClient;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static helpers.Url.*;
import static helpers.UserDataGenerator.FAKER;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertTrue;

@Feature("Регистрация")
public class RegistrationTest extends BaseSettings{

    private UserDataGenerator userDataGenerator;
    private UserClient user;
    private MainPage mainPage;
    private String auth;



    @Before
    public void setUp() {
        user = new UserClient();
        userDataGenerator = UserDataGenerator.getRandomDataUser();

        mainPage = open(MAIN_PAGE, MainPage.class);

        mainPage.clickAccountEntryButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegistrationButton();
    }

    @After
    public void tearDown() {
        if (auth != null) {
            user.deleteUser(auth);
        }
    }

    @Test
    @DisplayName("Успешная регистрация")
    public void validRegistrationTest() {

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setNameField(userDataGenerator.getName());
        registrationPage.setEmailField(userDataGenerator.getEmail());
        registrationPage.setPasswordField(userDataGenerator.getPassword());

        registrationPage.submitRegistration();

        webdriver().shouldHave(url(LOGIN));
        auth = user.loginUser(userDataGenerator).extract().body().path("accessToken");
    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля. Минимальный пароль — шесть символов")
    public void invalidRegistrationTest() {

        RegistrationPage registrationPage = page(RegistrationPage.class);
        registrationPage.setNameField(userDataGenerator.getName());
        registrationPage.setEmailField(userDataGenerator.getEmail());
        registrationPage.setPasswordField(FAKER.bothify("?#?#?"));

        registrationPage.submitRegistration();
        if (user.loginUser(userDataGenerator).extract().statusCode() == SC_OK) {
            auth = user.loginUser(userDataGenerator).extract().body().path("accessToken");
        }

        assertTrue(registrationPage.getPasswordError());
    }
}
