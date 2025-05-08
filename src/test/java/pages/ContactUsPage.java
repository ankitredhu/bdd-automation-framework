package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    private WebDriver driver;
    

    // Locators for Contact Us page elements
    @FindBy(css = "input[name='name']")
    private WebElement nameField;

    @FindBy(css = "input[name='email']")
    private WebElement emailField;

    @FindBy(css = "input[name='subject']")
    private WebElement subjectField;

    @FindBy(css = "textarea[name='message']")
    private WebElement messageField;

    @FindBy(css = "input[name='upload_file']")
    private WebElement fileUploadField;

    @FindBy(css = "input[name='submit']")
    private WebElement submitButton;

    @FindBy(css = ".status.alert.alert-success")
    private WebElement successMessage;
    

    // Constructor
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    

    // Methods to interact with the page
    public void fillContactForm(String name, String email, String subject, String message) {
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        subjectField.sendKeys(subject);
        messageField.sendKeys(message);
    }

    public void uploadFile(String filePath) {
        fileUploadField.sendKeys(filePath);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getSuccessMessage() {
    	Alert alert = driver.switchTo().alert();
    	alert.accept();
        return successMessage.getText();
    }
}