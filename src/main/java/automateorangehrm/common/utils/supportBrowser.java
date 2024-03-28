package automateorangehrm.common.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import automateorangehrm.common.pages.JobPage;
import automateorangehrm.common.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class supportBrowser {
	private static WebDriver driver;
	private static LoginPage login;
	private static JobPage job;

	public static WebDriver createDriver(String browser) {
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser specified. Defaulting to Chrome.");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		return driver;
	}

	@BeforeClass
	public void setUp() throws IOException {
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream("src/main/resources/config.properties");
		properties.load(file);
		String browser = properties.getProperty("browser");
		driver = createDriver(browser);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		login = new LoginPage(driver);
		job = new JobPage(driver);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.get(properties.getProperty("loginUrl"));
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static LoginPage getLogin() {
		return login;
	}

	public static JobPage getJob() {
		return job;
	}
}
