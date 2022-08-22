import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import static com.codeborne.selenide.Selenide.open;
import static helpers.Url.*;
import static org.junit.Assert.assertTrue;

@Feature("Раздел «Конструктор»")
public class MainPageTests extends BaseSettings{

    private MainPage mainPage;

    @Before
    public void setUp() {
        mainPage = open(MAIN_PAGE, MainPage.class);
        }

    @Test
    @DisplayName("Проверка, что работают переходы к разделам: «Булки»")
    public void checkBunsButton() {
        MainPage main = open(MAIN_PAGE, MainPage.class);
        assertTrue(main.clickBunsButtonCheckTheSign());
    }

    @Test
    @DisplayName("Проверка, что работают переходы к разделам: «Соусы»")
    public void checkSaucesButton() throws InterruptedException {
        MainPage main = open(MAIN_PAGE, MainPage.class);
        assertTrue(main.clickSaucesButtonAndCheckTheSign());
    }

    @Test
    @DisplayName("Проверка, что работают переходы к разделам: «Начинки».")
    public void checkFillingButton() {
        MainPage main = open(MAIN_PAGE, MainPage.class);
        assertTrue(main.clickFillingButtonAndCheckTheSign());
    }
}