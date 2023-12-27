package ru.praktikum_services.qa_scooter.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum_services.qa_scooter.page_objects.MainPage;
import ru.praktikum_services.qa_scooter.page_objects.OrderPage;
import ru.praktikum_services.qa_scooter.page_objects.RentPage;

public class SetOrderTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void setOrderViaTopButtonTest() {

        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        RentPage rentPage = new RentPage(driver);
        mainPage.clickUpOrderButton();
        orderPage.setOrderForm("Антон","Солодовников","ул. Пушкина 36","Сокольники","+79998883344");
        rentPage.setRentForm("31.12.2023", "шестеро суток", "black","Пожалуйста привезите самокат");
    }

    @Test
    public void setOrderViaDownButtonTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPage mainPage = new MainPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        RentPage rentPage = new RentPage(driver);
        mainPage.clickDownOrderButton();
        orderPage.setOrderForm("Анастасия","Фетанова","ул. Русская 36","Динамо","+79998884949");
        rentPage.setRentForm("01.01.2024", "сутки", "grey","привезите самокат в 12:00");
    }

    @After
    public void tearDown() {

        driver.quit();
    }
}
