package org.example;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MailTest {
    public static LoginPage loginPage;
    public static InboxPage inboxPage;
    public static WebDriver driver;


    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        inboxPage = new InboxPage(driver);

        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //ожидание
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //ереходим на нужную страницу
        driver.get(ConfProperties.getProperty("loginpage"));

    }

    @Test
    public void startTest() {
        loginPage.clickEnterBtn();
        //вводим логин
        loginPage.inputLogin("tes711test");
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //вводим пароль
        loginPage.inputPasswd("123456As!");
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        inboxPage.clickMailBtn();
    }

    @AfterClass
    public static void getCount() {
        //вводим адрес
        inboxPage.inputMailAdress("tes711test@yandex.com");
        //вводим тему
        inboxPage.inputMailSubject("Simbirsoft Тестовое задание. Туленкова");
        //вводим текст письма
        inboxPage.inputMailText("Количество писем:"+ inboxPage.counter());
        //нажимаем отправить
        inboxPage.clickSendBtn();
        //отключаем драйвер
        driver.quit();
    }

}
