import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

//preferred to show minimal selenium code on this page, better to keep it on other pages instead
//research robot framewor
//incorporate java 8 more (stream,lambda, functional interface, method reference)
public class PersonalTest {
    private ChromeDriver driver;
    private BasePage page;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new BasePage(driver);
    }

    @AfterMethod
    public void stop() {
        if (driver != null) driver.quit();
    }

    @Test
    public void checkBox() {
        page.open("checkboxes");
        List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        boxes.get(0).click();
        boxes.get(1).click();
    }

    @Test
    public void dropDown() throws InterruptedException {
        page.open("dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 2");
        Thread.sleep(3000);
    }

    @Test
    public void inputsTest() {
        page.open("inputs");
        driver.findElement(By.tagName("input")).sendKeys("4");
    }

    @Test
    public void addRemoveElements() throws InterruptedException {
        page.open("add_remove_elements/");
        driver.findElement(By.xpath("//div[@id='content']/div[@class='example']/button")).click();
        driver.findElement(By.xpath("//div[@id='elements']/button[@class='added-manually']")).click();
    }


    @Test
    public void basicAuth() throws AWTException { //???????
        page.open("basic_auth");
        Robot robot = new Robot();
        Actions actions = new Actions(driver);

        actions.sendKeys("admin").perform();
        robot.keyPress(KeyEvent.VK_TAB);
        actions.sendKeys("admin").perform();
        actions.sendKeys(Keys.ENTER).perform();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(driver1 -> driver.findElement(By.xpath("//h3")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//h3")).getText().equals("Basic Auth"));

    }

    @Test
    public void entryAd() {
        page.open("entry_ad");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("modal")));
        closeBtn.click();
    }

    @Test
    public void javaAlerts() {
        page.open("javascript_alerts");
        List<WebElement> buttons = driver.findElements(By.xpath("//div[@id='content']/div[@class='example']/ul/li"));
        /*buttons.stream().map(webElement -> {
            webElement.click();
            webElement.sendKeys(Keys.ENTER);

        });
         */
        buttons.forEach(webElement -> {
            webElement.click();
            webElement.sendKeys(Keys.ENTER);
        });

       /* buttons.get(0).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        buttons.get(1).click();
        actions.sendKeys(Keys.ENTER).perform();
        buttons.get(2).click();
        */
    }

    @Test
    public void keyPress() {
        page.open("key_presses");
        driver.findElement(By.id("target")).sendKeys("d");
        assertTrue(driver.findElement(By.id("result")).isDisplayed());
    }

    @Test
    public void window() throws InterruptedException {
        page.open("windows");
        driver.findElement(By.linkText("Click Here")).click();
    }

    @Test
    public void slider() throws InterruptedException {
        page.open("horizontal_slider");
        driver.findElement(By.xpath("//div[@id='content']/div[@class='example']/div[@class='sliderContainer']/input")).click();
        String range = driver.findElement(By.id("range")).getText();
        assertEquals("2.5", range);
    }

    public void quill(String input) throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://quillbot.com/summarize");
        Thread.sleep(3000);
        driver.findElement(By.id("inputBoxSummarizer")).sendKeys(input);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Summarize']")).click();
        Thread.sleep(2000);
        String output = driver.findElement(By.id("outputBoxSummarizer")).getText();
        int count = 0;

        for(int i = 0; i<output.length(); i++){
            if(output.substring(i,i+1).equals(" ")){
                count++;
            }
            if(count==8){
                System.out.println(output.substring(0,i));
                output = output.substring(i+1);
                i=0;
                count = 0;
            }
        }
        System.out.println(output);
        driver.quit();
    }

}