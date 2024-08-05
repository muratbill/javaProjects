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

public class DemoAddRecordTest {
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
    public void demoAddRecordTest() {
        driver.get("https://demoqa.com/webtables");
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn-primary#addNewRecordButton")));
        addButton.click();
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#firstName")));
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#lastName")));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#userEmail")));
        WebElement ageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#age")));
        WebElement salaryField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#salary")));
        WebElement departmentField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#department")));
        WebElement submitButton = driver.findElement(By.cssSelector("form#userForm button[type='submit']"));
        String firstName = "Ahmet";
        String lastName = "Can";
        String email = "mc@example.com";
        String age = "22";
        String salary = "12000";
        String department = "Sales";
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        ageField.sendKeys(age);
        salaryField.sendKeys(salary);
        departmentField.sendKeys(department);
        submitButton.click();
        //WebElement resultMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#resultMessage")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rt-tbody")));

        // Validate and assert the entered data
        // Find the last row of the table
        WebElement lastRow = driver.findElement(By.cssSelector(".rt-tbody .rt-tr-group:nth-child(4)"));

        WebElement displayedFirstName = lastRow.findElement(By.cssSelector(".rt-td:nth-of-type(1)"));
        WebElement displayedLastName = lastRow.findElement(By.cssSelector(".rt-td:nth-of-type(2)"));
        WebElement displayedAge = lastRow.findElement(By.cssSelector(".rt-td:nth-of-type(3)"));
        WebElement displayedEmail = lastRow.findElement(By.cssSelector(".rt-td:nth-of-type(4)"));
        WebElement displayedSalary = lastRow.findElement(By.cssSelector(".rt-td:nth-of-type(5)"));
        WebElement displayedDepartment = lastRow.findElement(By.cssSelector(".rt-td:nth-of-type(6)"));

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
    public void demoUpdateRecordTest() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lastRowEditButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".rt-tbody .rt-tr-group:nth-child(4) .action-buttons span#edit-record-4")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", lastRowEditButton);
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#firstName")));
        WebElement lastNameField = driver.findElement(By.cssSelector("input#lastName"));
        WebElement emailField = driver.findElement(By.cssSelector("input#userEmail"));
        WebElement ageField = driver.findElement(By.cssSelector("input#age"));
        WebElement salaryField = driver.findElement(By.cssSelector("input#salary"));
        WebElement departmentField = driver.findElement(By.cssSelector("input#department"));
        String updatedFirstName = "Ziya";
        String updatedLastName = "Can";
        String updatedEmail = "vc@example.com";
        String updatedAge = "24";
        String updatedSalary = "14010";
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


        WebElement submitButton = driver.findElement(By.cssSelector("button#submit"));
        submitButton.click();


         WebElement updatedRow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".rt-tbody .rt-tr-group:nth-child(4)")));
        WebElement displayedFirstName = updatedRow.findElement(By.cssSelector(".rt-td:nth-of-type(1)"));
        WebElement displayedLastName = updatedRow.findElement(By.cssSelector(".rt-td:nth-of-type(2)"));
        WebElement displayedAge = updatedRow.findElement(By.cssSelector(".rt-td:nth-of-type(3)"));
        WebElement displayedEmail = updatedRow.findElement(By.cssSelector(".rt-td:nth-of-type(4)"));
        WebElement displayedSalary = updatedRow.findElement(By.cssSelector(".rt-td:nth-of-type(5)"));
        WebElement displayedDepartment = updatedRow.findElement(By.cssSelector(".rt-td:nth-of-type(6)"));
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
