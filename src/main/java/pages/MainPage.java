package pages;

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

    //Кнопка "Булки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunsButton;

    //Кнопка "Соусы"
    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement saucesButton;

    //Кнопка "Начинки"
    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingsButton;

    //Последний элемент в конструкторе для проверки переходов
    @FindBy(how = How.XPATH, using = "//p[text()='Сыр с астероидной плесенью']")
    private SelenideElement lastIngredient;

    //Корзина для создания заказа
    @FindBy(how = How.CLASS_NAME, using = "BurgerConstructor_basket__list__l9dp_")
    private SelenideElement orderBasket;

    //Элемент из раздела булок для drag and drop
    @FindBy(how = How.XPATH, using = ".//p[text()='Флюоресцентная булка R2-D3']")
    private SelenideElement bunForDrop;

    //Отображение булки после перемещения в корзину
    @FindBy(how = How.XPATH, using = ".//span[text()='Флюоресцентная булка R2-D3 (верх)']")
    private SelenideElement bunInBasket;

    //Элемент из раздела соусов для drag and drop
    @FindBy(how = How.XPATH, using = ".//p[text()='Соус Spicy-X']")
    private SelenideElement sauceForDrop;

    //Отображение соуса после перемещения в корзину
    @FindBy(how = How.XPATH, using = ".//span[text()='Соус Spicy-X']")
    private SelenideElement sauceInBasket;

    //Элемент из раздела начинок для drag and drop
    @FindBy(how = How.XPATH, using = ".//p[text()='Хрустящие минеральные кольца']")
    private SelenideElement fillingForDrop;

    //Отображение начинки после перемещения в корзину
    @FindBy(how = How.XPATH, using = ".//span[text()='Хрустящие минеральные кольца']")
    private SelenideElement fillingInBasket;

    //Методы
    @Step("Кликаем на 'Войти в аккаунт' ")
    public void clickAccountEntryButton() {
        accountEntryButton.click();
    }
    @Step("Кликаем на кнопку 'Личный кабинет' ")
    public void clickProfileButton() {
        profileButton.click();
    }
    @Step("Нажать на кнопку 'Начинки', переместить элемент начинок в корзину и проверить его отображение в корзине")
    public boolean clickFillingButtonAndCheckTheSign() {
        fillingsButton.click();
        fillingForDrop.dragAndDropTo(orderBasket);
        return fillingInBasket.isDisplayed();
    }
    @Step("Листаем список вниз и жмем на кнопку 'Соусы', перемещаем элемент соусов в корзину, проверяем отображение элемента в корзине")
    public boolean clickSaucesButtonAndCheckTheSign() throws InterruptedException {
        lastIngredient.scrollIntoView(true);
        saucesButton.click();
        sauceForDrop.dragAndDropTo(orderBasket);
        return sauceInBasket.isDisplayed();
    }
    @Step("Листаем список вниз и жмем на кнопку 'Булки', перемещаем булок в корзину, проверяем отображение элемента в корзине")
    public boolean clickBunsButtonCheckTheSign() {
        lastIngredient.scrollIntoView(true);
        bunsButton.click();
        bunForDrop.dragAndDropTo(orderBasket);
        return bunInBasket.isDisplayed();
    }
}