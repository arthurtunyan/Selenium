
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void orderTest() throws InterruptedException {
        NavigationBar nav = new NavigationBar(driver);
        nav.navigateTo("Orders");
    }

    @Test
    public void patientTest() throws InterruptedException {
        NavigationBar nav = new NavigationBar(driver);
        nav.navigateTo("Patients");
    }

    @Test
    public void newOrderTest() throws InterruptedException {
        NavigationBar nav = new NavigationBar(driver);
        nav.navigateTo("New Order");
        NewOrderPage newOrderPage = new NewOrderPage(driver);
        Assert.assertTrue(newOrderPage.isStep1Displayed());
    }

    @Test
    public void checkOrderCount() throws InterruptedException {
        NavigationBar nav = new NavigationBar(driver);

        OrdersPage ordersPage = new OrdersPage(driver);
        int totalOrders = ordersPage.getTotalOrdersCount();
        ordersPage.clickTotalOrders();
        nav.navigateTo("Orders");
        Thread.sleep(3000);
        int tableCount = ordersPage.getOrderTableCount();
        Assert.assertEquals(totalOrders, tableCount);
    }

    @Test
    public void searchOrder() throws InterruptedException {
        NavigationBar nav = new NavigationBar(driver);
        nav.navigateTo("Orders");
        OrdersPage ordersPage = new OrdersPage(driver);
        ordersPage.copyOrderId();
        nav.navigateTo("Dashboard");
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.searchOrder();
        Assert.assertEquals(dashboard.getOrderResultCount(), 1);
    }

    @Test
    @SneakyThrows
    public void sequentialNavigationTest() throws InterruptedException {
        NavigationBar nav = new NavigationBar(driver);
        nav.navigateTo("New Order");
        NewOrderPage newOrderPage = new NewOrderPage(driver);
        Assert.assertTrue(newOrderPage.isStep1Displayed(), "Step 1 should be displayed on the New Order page");

        nav.navigateTo("Patients");
        PatientsPage patientsPage = new PatientsPage(driver);
        Assert.assertTrue(patientsPage.isPatientsHeaderDisplayed(), "Patients header should be displayed");

        nav.navigateTo("Orders");
        boolean ordersHeaderDisplayed = driver.findElement(By.xpath("//h1[text()='Orders']")).isDisplayed();
        Assert.assertTrue(ordersHeaderDisplayed, "Orders header should be displayed");

        nav.logout();
        boolean loginDisplayed = driver.findElement(By.xpath("//label[text()='Username']/following-sibling::div/input")).isDisplayed();
        Assert.assertTrue(loginDisplayed, "Login username field should be displayed after logout");
    }

    @Test
    public void logoutTest() throws InterruptedException {
        NavigationBar nav = new NavigationBar(driver);
        nav.logout();
        boolean loginDisplayed = driver.findElement(By.xpath("//label[text()='Username']/following-sibling::div/input")).isDisplayed();
        Assert.assertTrue(loginDisplayed);
    }
}
//page factory it's an extension to page order
//java annotations