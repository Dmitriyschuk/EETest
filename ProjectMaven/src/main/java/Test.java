import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

        WebElement inputGoogle = driver.findElement(By.className("gLFyf gsfi"));
        inputGoogle.sendKeys("hello world", Keys.ENTER);
        inputGoogle.submit();
//        WebElement button = driver.findElement(By.className("gNO89b"));
//        button.click();

    }
}
