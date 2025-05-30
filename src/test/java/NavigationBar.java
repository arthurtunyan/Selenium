
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBar {
    private WebDriver driver;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
    }

    @SneakyThrows
    public void navigateTo(String pageName) throws InterruptedException {
        WebElement page = driver.findElement(By.xpath("//span[text()='" + pageName + "']"));
        page.click();
        Thread.sleep(3000);
    }

    public void logout() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Logout']")).click();
        Thread.sleep(3000);
    }
}
