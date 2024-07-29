package selentests;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class Odev15WebtablesTest {
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
    @Test(priority = 1)
    public void odev15AddRecordTest() {
        driver.get("https://demoqa.com/webtables");
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='addNewRecordButton']")));
        addButton.click();
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']")));
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lastName']")));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userEmail']")));
        WebElement ageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='age']")));
        WebElement salaryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='salary']")));
        WebElement departmentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='department']")));
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        String firstName = "Ahmet";
        String lastName = "Can";
        String email = "mc@example.com";
        String age = "22";
        String salary = "13000";
        String department = "Sales";
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        ageField.sendKeys(age);
        salaryField.sendKeys(salary);
        departmentField.sendKeys(department);
        submitButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'rt-tbody')]/div[contains(@class, 'rt-tr-group')]")));
        WebElement lastRow = driver.findElement(By.xpath("//div[contains(@class, 'rt-tbody')]/div[contains(@class, 'rt-tr-group')][4]"));
        WebElement displayedFirstName = lastRow.findElement(By.xpath(".//div[@class='rt-td'][1]"));
        WebElement displayedLastName = lastRow.findElement(By.xpath(".//div[@class='rt-td'][2]"));
        WebElement displayedAge = lastRow.findElement(By.xpath(".//div[@class='rt-td'][3]"));
        WebElement displayedEmail = lastRow.findElement(By.xpath(".//div[@class='rt-td'][4]"));
        WebElement displayedSalary = lastRow.findElement(By.xpath(".//div[@class='rt-td'][5]"));
        WebElement displayedDepartment = lastRow.findElement(By.xpath(".//div[@class='rt-td'][6]"));

        List<String> validationErrors = new ArrayList<>();
        validateText(displayedFirstName,firstName, "FirstName does not match", validationErrors);
        validateText(displayedLastName,lastName,"LastName does not match", validationErrors);
        validateText(displayedEmail,email,"Email does not match", validationErrors);
        validateText(displayedAge,age, "Age does not match.", validationErrors);
        validateText(displayedSalary,salary, "Salary does not match.", validationErrors);
        validateText(displayedDepartment,department,"Department does not match", validationErrors);



        // Print all collected errors if any
        if (!validationErrors.isEmpty()) {
            StringBuilder errorMessages = new StringBuilder("Validation errors found:\n");
            for (String error : validationErrors) {
                errorMessages.append(error).append("\n");
            }
            Assert.fail(errorMessages.toString());
        }





    }
    @Test(priority = 2)
    public void odev15UpdateRecordTest(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lastRowEditButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'rt-tbody')]//div[contains(@class, 'rt-tr-group')][4]//span[@id='edit-record-4']\n")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", lastRowEditButton);
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']")));
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lastName']")));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userEmail']")));
        WebElement ageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='age']")));
        WebElement salaryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='salary']")));
        WebElement departmentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='department']")));
        String updatedFirstName = "Gokhan";
        String updatedLastName = "Cam";
        String updatedEmail = "gc@example.com";
        String updatedAge = "34";
        String updatedSalary = "24600";
        String updatedDepartment = "Finance";

        firstNameField.clear();
        firstNameField.sendKeys(updatedFirstName);
        lastNameField.clear();
        lastNameField.sendKeys(updatedLastName);
        emailField.clear();
        emailField.sendKeys(updatedEmail);
        ageField.clear();
        ageField.sendKeys(updatedAge);
        salaryField.clear();
        salaryField.sendKeys(updatedSalary);
        departmentField.clear();
        departmentField.sendKeys(updatedDepartment);
        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();
        WebElement updatedRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'rt-tbody')]/div[contains(@class, 'rt-tr-group')][4]")));
        WebElement displayedFirstName = updatedRow.findElement(By.xpath(".//div[@class='rt-td'][1]"));
        WebElement displayedLastName = updatedRow.findElement(By.xpath(".//div[@class='rt-td'][2]"));
        WebElement displayedAge = updatedRow.findElement(By.xpath(".//div[@class='rt-td'][3]"));
        WebElement displayedEmail = updatedRow.findElement(By.xpath(".//div[@class='rt-td'][4]"));
        WebElement displayedSalary = updatedRow.findElement(By.xpath(".//div[@class='rt-td'][5]"));
        WebElement displayedDepartment = updatedRow.findElement(By.xpath(".//div[@class='rt-td'][6]"));
        List<String> validationErrors = new ArrayList<>();
        validateText(displayedFirstName, updatedFirstName, "First name does not match.", validationErrors);
        validateText(displayedLastName, updatedLastName, "Last name does not match.", validationErrors);
        validateText(displayedEmail, updatedEmail, "Email does not match.", validationErrors);
        validateText(displayedAge, updatedAge, "Age does not match.", validationErrors);
        validateText(displayedSalary, updatedSalary, "Salary does not match.", validationErrors);
        validateText(displayedDepartment, updatedDepartment, "Department does not match.", validationErrors);

        // Print all collected errors if any
        if (!validationErrors.isEmpty()) {
            StringBuilder errorMessages = new StringBuilder("Validation errors found:\n");
            for (String error : validationErrors) {
                errorMessages.append(error).append("\n");
            }
            Assert.fail(errorMessages.toString());
        }

    }
    private void validateText(WebElement element, String expectedText, String errorMessage, List<String> validationErrors) {
        try {
            String actualText = element.getText();
            if (!actualText.equals(expectedText)) {
                validationErrors.add(STR."\{errorMessage} Expected: \{expectedText}, but found: \{actualText}");
            }
        } catch (Exception e) {
            validationErrors.add(STR."\{errorMessage} (Exception: \{e.getMessage()})");
        }
    }
    @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
