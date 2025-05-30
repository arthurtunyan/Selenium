import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    ChromeDriver driver;

    @BeforeMethod
    public void driverInit() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://med-corp.ashoon.com/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement username = driver.findElement(By.xpath("//label[text()='Username']/following-sibling::div/input"));
        username.sendKeys("sirvard.saponjyan@lavanya.com");
        WebElement password = driver.findElement(By.xpath("//label[text()='Password']/following-sibling::div/input"));
        password.sendKeys("Admin123!");

        WebElement login = driver.findElement(By.xpath("//button[text()='Login']"));
        login.sendKeys(Keys.ENTER);
        Thread.sleep(3000);


    }

    @AfterMethod
    public void driverQuit() {
        driver.quit();
    }
}
