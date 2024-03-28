package automateorangehrm.common.pages;

import java.io.FileInputStream;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JobPage {
	
	private static WebDriver driver;
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
    
    @FindBy(how = How.XPATH, using = "//label[normalize-space()='Delete Current']//span[@class='oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input']")
    private WebElement deleteFileOption;
    
    @FindBy(how = How.XPATH, using = "//label[normalize-space()='Replace Current']")
    private WebElement replaceFileOption;
    
    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Yes, Delete']")
    private WebElement confirmDelete;

    @FindBy(how = How.XPATH, using = "//textarea[@placeholder='Add note']")
    private WebElement noteElement;
    
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    private WebElement saveButton;
    
    @FindBy(how = How.XPATH, using = "//input[@type='file']")
    private WebElement browse;
    
    @FindBy(how = How.XPATH, using = "//div[@class='oxd-toast-container oxd-toast-container--bottom']")
    private WebElement toast;
    
	public JobPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
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
    
    public void errorIfExists() {
		try {
			String text = alreadyExistsMessage.getText();
			if (text.equals("Already exists")) {
				Assert.fail("Job already exists");

			}
		} catch (Exception e) {
		}
	}
    
    public void clickSaveButton() {
    	wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
        try {
            wait.until(ExpectedConditions.visibilityOf(toast));
            System.out.println("Toast message present");
        } catch (Exception e) {
        	System.out.println("Toast message not present");
        }
    }
    
    public static WebElement findExistenceByXPATH(String xpath) {
    	return driver.findElement(By.xpath(xpath));
    }

	public boolean doesAlreadyExists(String job) {
		try {
			WebElement jobElement = findExistenceByXPATH("//div[contains(@class, 'oxd-table-row oxd-table-row--with-border')]/div[contains(@class, 'oxd-table-cell oxd-padding-cell')]/div[contains(text(), '"
					+ job + "')]");
			wait.until(ExpectedConditions.visibilityOf(jobElement));
			return (jobElement != null);
		}
		catch (Exception e) {
			System.out.println("Job Title Not Present");
			return false ;
		}
	}
    public void clickButton(WebElement button) {
    	wait.until(ExpectedConditions.visibilityOf(button));
        button.click();
    }
    

	
	public void delete(String job) {
		if(doesAlreadyExists(job)) {
			WebElement deleteButton = findExistenceByXPATH(
					"//div[contains(@class, 'oxd-table-row--with-border')]/div[contains(@class, 'oxd-padding-cell')]/div[contains(text(), '"+job+"')]/../following-sibling::div//i[contains(@class, 'bi-trash')]");
			clickButton(deleteButton);
			clickButton(confirmDelete);
			try {
	            wait.until(ExpectedConditions.visibilityOf(toast));
	            System.out.println("Toast message present");
	        } catch (Exception e) {
	        	System.out.println("Toast message not present");
	        }
		}
		else {
			System.out.println("Job Not Present");
		}
	}

	public void edit(String job) {
		if(doesAlreadyExists(job)) {
			WebElement editButton = findExistenceByXPATH(
					"//div[contains(@class, 'oxd-table-row--with-border')]/div[contains(@class, 'oxd-padding-cell')]/div[contains(text(), '"+job+"')]/../following-sibling::div//i[contains(@class, 'bi-pencil-fill')]");
			clickButton(editButton);
		}
		else { 
			System.out.println("Job Not Present");
		}

		
	}
	

	public void editJobTitle(String jobTitleField) {
		 Actions actions = new Actions(driver);
		 actions.moveToElement(jobTitleElement).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
			.sendKeys(Keys.DELETE).sendKeys(jobTitleField).perform();
		
	}

	public void editJobDesc(String jobDescField) {
		Actions actions = new Actions(driver);
		 actions.moveToElement(jobDescElement).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
			.sendKeys(Keys.DELETE).sendKeys(jobDescField).perform();
	}

	public void uploadSpecification() throws InterruptedException {
		browse.sendKeys("C:\\Users\\Aditi\\Pictures\\Screenshots\\OrangeHRM.png");	
	}
	
	public void replaceSpecification() throws InterruptedException {
		replaceFileOption.click();
		browse.sendKeys("C:\\Users\\Aditi\\Pictures\\Screenshots\\OrangeHRM.png");
	}
	
	public void deleteSpecification() throws InterruptedException {
		deleteFileOption.click();
	}

	public void editNote(String noteField) {
		Actions actions = new Actions(driver);
		 actions.moveToElement(noteElement).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
			.sendKeys(Keys.DELETE).sendKeys(noteField).perform();
	}

	public boolean checkAdded(String job) throws InterruptedException {
		driver.get(driver.getCurrentUrl());
		Thread.sleep(5000);
		try {
			WebElement jobElement = findExistenceByXPATH("//div[contains(@class, 'oxd-table-row oxd-table-row--with-border')]/div[contains(@class, 'oxd-table-cell oxd-padding-cell')]/div[contains(text(), '"
					+ job + "')]");
			wait.until(ExpectedConditions.visibilityOf(jobElement));
			return (jobElement != null);
		}
		catch (Exception e) {
			System.out.println("Job Title Not Present");
			return false ;
		}
	
	}

	public boolean checkDeleted(String job) throws InterruptedException {
		driver.get(driver.getCurrentUrl());
		Thread.sleep(5000);
		try {
			WebElement jobElement = findExistenceByXPATH("//div[contains(@class, 'oxd-table-row oxd-table-row--with-border')]/div[contains(@class, 'oxd-table-cell oxd-padding-cell')]/div[contains(text(), '"
					+ job + "')]");
			wait.until(ExpectedConditions.visibilityOf(jobElement));
			return (!(jobElement != null));
		}
		catch (Exception e) {
			return true;
		}
	}
}




