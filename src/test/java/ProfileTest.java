import helpers.UserDataGenerator;
import helpers.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static helpers.Url.*;


@Feature("Переходы")
public class ProfileTest extends BaseSettings{

    private UserDataGenerator userDataGenerator;
    private Utils user;
    private String auth;
    private MainPage mainPage;

    @Before
    public void setUp() {

        user = new Utils();
        userDataGenerator = UserDataGenerator.getRandomDataUser();
        ValidatableResponse response = user.userCreate(userDataGenerator);

        auth = response.extract().path("accessToken");
        mainPage = open(MAIN_PAGE, MainPage.class);

        mainPage.clickProfileButton();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.setEmailField(userDataGenerator.getEmail());
        loginPage.setPasswordField(userDataGenerator.getPassword());
        loginPage.login();
        mainPage.clickProfileButton();
    }

    @After
    public void tearDown() {
        if (auth != null) {
            user.deleteUser(auth);
        }
    }

    @Test
    @DisplayName("Провека перехода по клику на «Личный кабинет»")
    public void checkProfilePageUrlAfterClickOnProfile() {
        webdriver().shouldHave(url(PROFILE));
    }

    @Test
    @DisplayName("Проверка перехода по клику на «Конструктор»")
    public void checkGoToConstructorFromProfile() {
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickConstructorButton();

        webdriver().shouldHave(url(MAIN_PAGE));
    }

    @Test
    @DisplayName("Проверка перехода по клику на логотип Stellar Burgers.")
    public void checkGoToConstructorClickLogo() {
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickLogoImage();

        webdriver().shouldHave(url(MAIN_PAGE));
    }

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете.")
    public void checkLogout() {
        ProfilePage profilePage = page(ProfilePage.class);
        profilePage.clickExitButton();

        webdriver().shouldHave(url(LOGIN));
    }
}