import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;
import static com.codeborne.selenide.Selenide.closeWindow;
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
    @After
    public void tearDown() {
        closeWindow();
    }

    @Test
    @DisplayName("Проверка, что работают переходы к разделам: «Булки»")
    public void checkBunsButton() {
        mainPage.saucesTabClick();
        mainPage.bunsButtonClick();

        assertTrue(mainPage.checkTabContainsClass(0));
    }

    @Test
    @DisplayName("Проверка, что работают переходы к разделам: «Соусы»")
    public void checkSaucesButton() {
        mainPage.saucesTabClick();

        assertTrue(mainPage.checkTabContainsClass(1));
    }

    @Test
    @DisplayName("Проверка, что работают переходы к разделам: «Начинки».")
    public void checkFillingButton() {
        mainPage.fillingsTabClick();

        assertTrue(mainPage.checkTabContainsClass(2));
    }
}