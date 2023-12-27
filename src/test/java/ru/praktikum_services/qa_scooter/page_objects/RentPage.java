package ru.praktikum_services.qa_scooter.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentPage {
    private WebDriver driver;
    //Поле когда привезти самокат
    private By whenInput = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //Поле срок аренды
    private By periodInput = By.xpath(".//*[@class = 'Dropdown-root']");
    //Поле комментария для курьера
    private By commentInput = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //Кнопка "Заказать"
    private By orderButton = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    //Кнопка да в окне подтверждения заказа
    private By yesButton = By.xpath(".//button[text() = 'Да']");
    //Окно с результатом оформления заказа
    private By successOrder = By.xpath(".//div[text() = 'Заказ оформлен']");

    public RentPage(WebDriver driver) {

        this.driver = driver;

    }

    //Ввести дату в поле когда привезти самокат, формат 01.01.2000
    public void setWhenInput (String date) {
        driver.findElement(whenInput).clear();
        driver.findElement(whenInput).sendKeys(date);
        driver.findElement(whenInput).sendKeys(Keys.ENTER);
    }
    //Выбрать срок аренды
    public void selectRentPeriod (String period) {
        driver.findElement(periodInput).click();
        driver.findElement(By.xpath(".//div[text() = '"+ period +"']")).click();
    }
    //Выбрать цвет самоката, нужно указать либо black либо grey
    public void selectColor (String color) {
        driver.findElement(By.id(color)).click();
    }
    //Ввести комментарий для курьера
    public void setComment (String comment) {
        driver.findElement(commentInput).sendKeys(comment);
    }
    //Нажать на кнопку "заказать"
    public void clickOrderButton () {
        driver.findElement(orderButton).click();
    }
    //Нажать на кнопку "Да"
    public void clickYesButton () {
        driver.findElement(yesButton).click();
    }
    //Проверка наличия сообщения об успешном заказе
    public void checkSuccessOrder () {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(successOrder)).isDisplayed();

    }

    //Метод заполнения формы аренды и подтверждения заказа
    public void setRentForm (String date, String period, String color, String comment) {
        setWhenInput(date);
        selectRentPeriod(period);
        selectColor(color);
        setComment(comment);
        clickOrderButton();
        clickYesButton();
        checkSuccessOrder();
    }



}
