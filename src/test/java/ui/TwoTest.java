package ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TwoTest {
    @Test
    void twoOpen(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        driver.quit();
    }
}
