package ru.praktikum_services.qa_scooter.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;
    //кнопка заказать вверху
    private By upOrderButton = By.xpath(".//div[@class = 'Header_Nav__AGCXC']/button[text()='Заказать']");
    //кнопка заказать внизу
    private By downOrderButton = By.xpath(".//div[@class = 'Home_FinishButton__1_cWm']/button[text()='Заказать']");
    public MainPage(WebDriver driver) {

        this.driver = driver;
    }



    //Нажать на плитку с вопросом, найти ответ, проверить что он видимый, прочитать ответ
    public String getAnswer(String index) {
        By importantQuestions = By.id("accordion__heading-" + index);
        By importantAnswers = By.id("accordion__panel-" + index);
        WebElement element = driver.findElement(importantQuestions);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(importantAnswers));
        return driver.findElement(importantAnswers).getText();
    }
    //Нажать на верхнюю кнопку "заказать"
    public void clickUpOrderButton (){
        driver.findElement(upOrderButton).click();
    }
    //Нажать на нижнюю кнопку "заказать"
    public void clickDownOrderButton (){
        WebElement element = driver.findElement(downOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(downOrderButton));
        element.click();
    }




}
