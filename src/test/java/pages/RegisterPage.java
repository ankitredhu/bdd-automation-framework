package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ActionHelper;

public class RegisterPage extends ActionHelper {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    // Locators
    private By nameInput = By.name("name");
    private By emailInput = By.xpath("//input[@data-qa='signup-email']");
    private By signupButton = By.xpath("//button[@data-qa='signup-button']");
    private By genderMale = By.id("id_gender1");
    private By passwordInput = By.id("password");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");
    private By firstNameInput = By.id("first_name");
    private By lastNameInput = By.id("last_name");
    private By addressInput = By.id("address1");
    private By stateInput = By.id("state");
    private By cityInput = By.id("city");
    private By zipCodeInput = By.id("zipcode");
    private By mobileNumberInput = By.id("mobile_number");
    private By createAccountButton = By.xpath("//button[@data-qa='create-account']");
    private By accountCreatedMessage = By.xpath("//b[contains(text(),'Account Created!')]");
    private By emailAlreadyExistsError = By.xpath("//*[contains(text(),'Email Address already exist!')]");

    // Actions

    public void enterNameAndEmail(String name, String email) {
        type(nameInput, name);
        type(emailInput, email);
        click(signupButton);
    }
    
    public void clearNameAndEmail() {
    	clear(nameInput);
    	clear(emailInput);
    }
    
    public boolean isUserAlreadyExistsErrorVisible() {
        return isElementVisible(emailAlreadyExistsError);
    }

    public void fillAccountDetails(String password, String day, String month, String year) {
        click(genderMale);
        type(passwordInput, password);
        selectByVisibleText(dayDropdown, day);
        selectByVisibleText(monthDropdown, month);
        selectByVisibleText(yearDropdown, year);
    }

    public void fillAddressDetails(String firstName, String lastName, String address, String state, String city, String zipcode, String mobile) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(addressInput, address);
        type(stateInput, state);
        type(cityInput, city);
        type(zipCodeInput, zipcode);
        type(mobileNumberInput, mobile);
    }

    public void clickCreateAccount() {
        click(createAccountButton);
    }
    
    

    public boolean isAccountCreated() {
        return isElementVisible(accountCreatedMessage);
    }
}
