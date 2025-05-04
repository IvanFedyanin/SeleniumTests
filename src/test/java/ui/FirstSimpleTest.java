package ui;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstSimpleTest {
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
    void openHomePage(){
        String actualTitle = driver.getTitle();
        assertEquals("Hands-On Selenium WebDriver with Java",actualTitle);
    }

    @Test
    void openWebForm(){
        String webFormUrl ="web-form.html";
        driver
                .findElement(By.xpath("//a[@href ='web-form.html']"))
                .click();
        String currentUrl = driver.getCurrentUrl();
        WebElement titleText = driver.findElement(By.className("display-6"));
        assertEquals(BASE_URL+webFormUrl, currentUrl);
        assertEquals("Web form",titleText.getText());
    }
    @Test
    void openAllLink() throws InterruptedException {
        List<WebElement> capters =  driver.findElements(By.cssSelector("h5.card-title"));
        for (WebElement capter : capters){
            System.out.println(capter.getText());
            List<WebElement> links = capter.findElements(By.xpath("./../a"));
            for (WebElement link : links){
                System.out.println(link.getText());
                link.click();
                Thread.sleep(1000);
                driver.navigate().back();
            }
        }
    }


}
