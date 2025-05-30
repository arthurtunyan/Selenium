package pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    //testing github
    protected static final String BASE_URL = "https://the-internet.herokuapp.com/";
    protected ChromeDriver driver;

    public BasePage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void open(String pageSuffix) {
        driver.get(BASE_URL + pageSuffix);
    }
}