
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewOrderPage {
    private WebDriver driver;
    private By step1HeaderLocator = By.xpath("//h5[text()='Step 1: Search or Create Patient']");

    public NewOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isStep1Displayed() {
        return driver.findElement(step1HeaderLocator).isDisplayed();
    }
}
