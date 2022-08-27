package pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage {
    //Локаторы
    //Кнопка "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement accountEntryButton;

    //Кнопка "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//p[text()='Личный Кабинет']")
    private SelenideElement profileButton;

    //Таб "Булки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsTab;

    //Таб "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesTab;

    //Таб "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingsTab;

    //Коллекция элементов для табов
    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'tab_tab')]")
    private ElementsCollection constructorTabs;

    //Методы
    @Step("Кликаем на 'Войти в аккаунт' ")
    public void clickAccountEntryButton() {
        accountEntryButton.click();
    }
    @Step("Кликаем на кнопку 'Личный кабинет' ")
    public void clickProfileButton() {
        profileButton.click();
    }
    //Возвращаем номер таба
    public SelenideElement getTab(int number) {
        return constructorTabs.get(number);
    }
    @Step("Проверка наличия 'tab_tab_type_current' класса у активной вкладки")
    public boolean checkTabContainsClass(int numberOfTab) {
        return getTab(numberOfTab).getAttribute("class").contains("tab_tab_type_current");
    }
    @Step("Клик по вкладке Булки")
    public void bunsButtonClick() {
        bunsTab.click();
    }
    @Step("Клик по вкладке Соусы")
    public void saucesTabClick() {
        saucesTab.click();
    }
    @Step("Клик по вкладке Начинки")
    public void fillingsTabClick() {
        fillingsTab.click();
    }

}