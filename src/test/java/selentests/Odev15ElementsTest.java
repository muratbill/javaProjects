package selentests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class Odev15ElementsTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/java/com/newrdmb/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }
    @Test
    public void demoButtonClickTest(){

        driver.get("https://demoqa.com/elements");
        WebElement buttons = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Buttons')]")));
        buttons.click();
        WebElement btnClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/button[1]")));
        btnClick.click();
        WebElement resultMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='dynamicClickMessage']")));
        Assert.assertTrue(resultMessage.isDisplayed(), "Result message is not displayed.");
        System.out.println(resultMessage.getText());

    }
    @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
