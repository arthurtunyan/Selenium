
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrdersPage {
    private WebDriver driver;
    private By totalOrdersLocator = By.xpath("//h6[text()='Total Orders']/following-sibling::div/h4");
    private By orderRowsLocator = By.xpath("//tbody/tr");
    private By orderOptionsButtonLocator = By.xpath("//tbody/tr/td/button");
    private By copyOrderIdLocator = By.xpath("//li[text()='Copy Order ID']");

    @FindBy(xpath = "//li[text()='Copy Order ID']")
    WebElement totalOrdersLocator1;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getTotalOrdersCount() {
        WebElement totalOrdersElement = driver.findElement(totalOrdersLocator);
        return Integer.parseInt(totalOrdersElement.getText());
    }

    public int getOrderTableCount() {
        List<WebElement> rows = driver.findElements(orderRowsLocator);
        return rows.size();
    }

    public void clickTotalOrders() {
        new DriverHelper(driver).click(driver.findElement(totalOrdersLocator));
    }

    public void copyOrderId() throws InterruptedException {
        driver.findElement(orderOptionsButtonLocator).click();
        driver.findElement(copyOrderIdLocator).click();
        Thread.sleep(3000);
    }


}
