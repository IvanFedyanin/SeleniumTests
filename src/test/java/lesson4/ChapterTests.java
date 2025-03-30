package lesson4;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChapterTests {
    WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }

    @Test
    void countingSectionsTest() {
        WebElement textChapter = driver.findElement(By.xpath("(//div[@class ='card-body']//h5)[1]"));
        assertEquals("Chapter 3. WebDriver Fundamentals",textChapter.getText());
    }

    @Test
    void ChptersLinkTest(){
        String webFormUrl ="web-form.html";
        driver
                .findElement(By.xpath("//a[@href ='web-form.html']"))
                .click();
        String currentUrl = driver.getCurrentUrl();
        WebElement titleText = driver.findElement(By.className("display-6"));
        assertEquals(BASE_URL+webFormUrl, currentUrl);
        assertEquals("Web form",titleText.getText());
    }


}
