package automateorangehrm.common.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private  WebDriver driver;
	private WebDriverWait wait;

	@FindBy(how = How.NAME, using = "username")
    private WebElement usernameElement;

    @FindBy(how = How.NAME, using = "password")
    private WebElement passwordElement;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement loginButton;
        
    @FindBy(how = How.XPATH, using = "//li[1]//a[1]//span[1]")
    private WebElement adminButton;
    
    @FindBy(how = How.XPATH, using = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	private WebElement requiredUsername;

	@FindBy(how = How.XPATH, using = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
	private WebElement requiredPassword;
	
	@FindBy(how = How.XPATH, using = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text' and text()='Invalid credentials']")    
	private WebElement invalidMessage;
	
	@FindBy(how = How.XPATH, using = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	private WebElement forgotPassword;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement resetPasswordButton;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}
	
	public void setUsername(String username) {	    	
        wait.until(ExpectedConditions.visibilityOf(usernameElement));
        usernameElement.sendKeys(username);
    }

    public void setPassword(String password) {
         wait.until(ExpectedConditions.visibilityOf(passwordElement));
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
    }   
    
    public void clickForgotPasswordButton() {
    	wait.until(ExpectedConditions.visibilityOf(forgotPassword));
    	forgotPassword.click();
    }

    public boolean isLoginSuccessful() throws IOException {
    	Properties properties = new Properties();
    	FileInputStream file = new FileInputStream("src/main/resources/config.properties");
    	
    	properties.load(file);
    	String browser = properties.getProperty("browser");
    	return driver.getCurrentUrl().equals(properties.getProperty("dashboardUrl"));
    	
    }
    
	public void clickAdminButton() {
        wait.until(ExpectedConditions.visibilityOf(adminButton));
        adminButton.click();
    }
	
	public void clickResetPasswordButton() {
        wait.until(ExpectedConditions.visibilityOf(resetPasswordButton));
        resetPasswordButton.click();
    }

	
	public boolean isAdminPage() throws IOException 
	{
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream("src/main/resources/config.properties");
		properties.load(file);
		String browser = properties.getProperty("browser");
		return driver.getCurrentUrl().equals("adminUrl");
	}
	
	public boolean 	isResetPasswordPage() throws IOException 
	{
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream("src/main/resources/config.properties");
		properties.load(file);
		String browser = properties.getProperty("browser");
		return driver.getCurrentUrl().equals("resetUrl");
	}
	
	public boolean 	isPasswordResetSuccessful() throws IOException 
	{
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream("src/main/resources/config.properties");
		properties.load(file);
		String browser = properties.getProperty("browser");
		return driver.getCurrentUrl().equals("sentCodeUrl");
	}
	
	

    
    public String getInvalidMessage() {
    	wait.until(ExpectedConditions.visibilityOf(invalidMessage));
        return invalidMessage.getText();
    }
    
    public String getRequiredUsernameMessage() {
    	wait.until(ExpectedConditions.visibilityOf(requiredUsername));
    	return requiredUsername.getText();
    }
    
    public String getRequiredPasswordMessage() {
    	wait.until(ExpectedConditions.visibilityOf(requiredPassword));
    	return requiredPassword.getText();
    }

}