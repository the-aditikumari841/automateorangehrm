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
import org.testng.Assert;

public class JobPage {
	
	private  WebDriver driver;
	private WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Job']//i[@class='oxd-icon bi-chevron-down']")
    private WebElement jobButton;
    
    @FindBy(how = How.XPATH, using = "//li[@class='--active oxd-topbar-body-nav-tab --parent']//li[1]")
    private WebElement jobTitleButton;
    
    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Add']")
    private WebElement addButton;
    
    @FindBy(how = How.XPATH, using = "(//input[@class='oxd-input oxd-input--active'])[2]") 
    private WebElement jobTitleElement;
    
    @FindBy(how = How.XPATH, using = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    private WebElement alreadyExistsMessage;
    
    @FindBy(how = How.XPATH, using = "//textarea[@placeholder='Type description here']")
    private WebElement jobDescElement;
    
    @FindBy(how = How.XPATH, using = "//div[@class='oxd-file-button']")
    private WebElement browseButtonField;
    
    @FindBy(how = How.XPATH, using = "")
    private WebElement addNoteField;
    
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement saveButton;
    

    
	public JobPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver,this);
	}
	
	public void clickJobButton() {
        wait.until(ExpectedConditions.visibilityOf(jobButton));
        jobButton.click();
    }
	
	public void clickAddButton() {
        wait.until(ExpectedConditions.visibilityOf(addButton));
        addButton.click();
    }
	
	public void clickJobTitleButton() {
        wait.until(ExpectedConditions.visibilityOf(jobTitleButton));
        jobTitleButton.click();
    }
	
    public boolean isJobPage() throws IOException
    {
    	Properties properties = new Properties();
    	FileInputStream file = new FileInputStream("src/main/resources/config.properties");
    	
    	properties.load(file);
    	String browser = properties.getProperty("browser");
    	return driver.getCurrentUrl().equals(properties.getProperty("jobTitleUrl"));
    }
    
    public boolean isAddJobTitlePage() throws IOException {
    	Properties properties = new Properties();
    	FileInputStream file = new FileInputStream("src/main/resources/config.properties");
    	
    	properties.load(file);
    	String browser = properties.getProperty("browser");
    	return driver.getCurrentUrl().equals(properties.getProperty("addJobTitleUrl"));
    	
    }
    
    public void enterJobTitle(String jobTitle) {	    	
        wait.until(ExpectedConditions.visibilityOf(jobTitleElement));
        jobTitleElement.sendKeys(jobTitle);
    }
    
    
    public void doesAlreadyExists() {
		try {
			String text = alreadyExistsMessage.getText();
			if (text.equals("Already exists")) {
				Assert.fail("Already existed");

			}
		} catch (Exception e) {

		}

	}
    
    public void clickSaveButton() {
    	wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }
    
}





