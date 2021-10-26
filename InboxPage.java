package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InboxPage {
    public WebDriver driver;
    public InboxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора кнопки создания исходящего письма письма
     */
    @FindBy(xpath = "//a[@href = \"#compose\"]")
    private WebElement mailBtn;

    /**
     * определение локатора поля ввода e-mail
     */
    @FindBy(xpath = "//*[@class=\"composeYabbles\"]")
    private WebElement mailAdress;

    /**
     * определение локатора поля ввода текста
     */
    @FindBy(xpath = "//*[@role=\"textbox\"]")
    private WebElement mailText;

    /**
     * определение локатора поля ввода темы
     */
    @FindBy(xpath = "//*[@name=\"subject\"]")
    private WebElement mailSubject;

    /**
     * определение локатора кнопки отправки
     */
    @FindBy(xpath = "//button[contains(@class, 'circle')]")
    private WebElement sendBtn;

    public void clickMailBtn() {
        mailBtn.click();
    }

    public void inputMailAdress(String mail) {
        mailAdress.click();
        mailAdress.sendKeys(mail);
    }

    public void inputMailSubject(String subject) {
        mailSubject.click();
        mailSubject.sendKeys(subject);
    }

    public void inputMailText(String text) {
        mailText.sendKeys(text);

    }
  public void clickSendBtn() {
        sendBtn.click();
    }

    /**
     * метод посчета количества писем по локатору
     */
    public int counter() {

        List<WebElement> a = driver.findElements(By.xpath("//*[contains(@title, 'Simbirsoft Тестовое задание')]"));
        return a.size();
        }

}
