
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DashboardPage {
    private WebDriver driver;
    private By searchInputLocator = By.xpath("//input");
    private By orderRowsLocator = By.xpath("//tbody/tr");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchOrder() {
        WebElement searchInput = driver.findElement(searchInputLocator);
        searchInput.clear();
        searchInput.sendKeys(Keys.chord(Keys.COMMAND, "v"));
        searchInput.sendKeys(Keys.ENTER);
    }

    public int getOrderResultCount() {
        List<WebElement> rows = driver.findElements(orderRowsLocator);
        return rows.size();
    }
}
