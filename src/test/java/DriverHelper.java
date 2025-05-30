import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DriverHelper {
    WebDriver driver;

    public DriverHelper(WebDriver driver){
        this.driver = driver;
    }

    public void click(WebElement webElement){
        System.out.println("Before clicking element");
        webElement.click();
        System.out.println("After clicking element");
    }


}
