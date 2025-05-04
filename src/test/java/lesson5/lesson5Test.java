package lesson5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class lesson5Test {
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
    void openAllLinkTest() throws InterruptedException {
        int linkQt =0;
        List<WebElement> capters =  driver.findElements(By.cssSelector("h5.card-title"));
        for (WebElement capter : capters){
            System.out.println(capter.getText());
            List<WebElement> links = capter.findElements(By.xpath("./../a"));
            linkQt += links.size();
            for (WebElement link : links){
                System.out.println(link.getText());
                link.click();
                Thread.sleep(100);
                driver.navigate().back();
            }
        }
        assertEquals(6, capters.size());
        assertEquals(27, linkQt);
    }
    @Test
    void classPlusTest(){
        List<WebElement> links = driver.findElements(By.cssSelector(".btn.btn-outline-primary.mb-2"));
        assertEquals(27, links.size());
    }

}
