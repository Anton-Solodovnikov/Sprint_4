package ru.praktikum_services.qa_scooter.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {

    private WebDriver driver;
    //Поле для ввода имени
    private By nameInput = By.xpath(".//input[@placeholder = '* Имя']");
    //Поле для ввода фамилии
    private By lastNameInput = By.xpath(".//input[@placeholder = '* Фамилия']");
    //Поле для ввода адреса
    private By adressInput = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле для ввода номера телефона
    private By phoneNumberInput = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //Поле выбора станции метро
    private By metroStationButton = By.xpath(".//input[@placeholder = '* Станция метро']");
    //Кнопка "далее"
    private By nextButton = By.xpath(".//button[text()='Далее']");
    public OrderPage(WebDriver driver) {

        this.driver = driver;

    }

    //Выбор станции метро
    public void selectMetroStation (String stationName){
        driver.findElement(metroStationButton).click();
        WebElement element = driver.findElement(By.xpath(".//div[text()='"+ stationName +"']/.."));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
    //Ввод текста в поле имя
    public void setName(String name) {
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
    }
    //Ввод текста в поле фамилия
    public void setLastName(String lastName) {
        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);
    }
    //Ввод текста в поле адрес
    public void setAdress(String adress) {
        driver.findElement(adressInput).clear();
        driver.findElement(adressInput).sendKeys(adress);
    }
    //Ввод номера телефона
    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberInput).clear();
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }
    //Нажатие на кнопку далее
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    //Метод полного заполнения карточки заказа
    public void setOrderForm(String name, String lastName, String adress, String stationName, String phoneNumber) {
        setName(name);
        setLastName(lastName);
        setAdress(adress);
        selectMetroStation(stationName);
        setPhoneNumber(phoneNumber);
        clickNextButton();
    }

}
