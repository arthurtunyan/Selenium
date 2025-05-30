
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientsPage {
    private WebDriver driver;
    private By patientsHeaderLocator = By.xpath("//h1[text()='Patients']");

    public PatientsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isPatientsHeaderDisplayed() {
        return driver.findElement(patientsHeaderLocator).isDisplayed();
    }
}
