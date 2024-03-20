package automateorangehrm;

import org.testng.annotations.Test;

import automateorangehrm.common.pages.LoginPage;
import automateorangehrm.common.utils.supportBrowser;

public class InvalidDetailsTest extends supportBrowser {

	private LoginPage login;
	@Test(priority = 1)
    public void testLoginWithIncorrectUsernameAndIncorrectPassword() throws InterruptedException {
        login=getLogin(); 
        login.setUsername("Admin1");
        login.setPassword("admin1234");
        login.clickLoginButton();
        login.getInvalidMessage();
        
    }	
	
	@Test(priority = 2)
	public void testLoginWithIncorrectUsernameAndCorrectPassword() throws InterruptedException {
        login=getLogin(); 
        login.setUsername("Admin1");
        login.setPassword("admin123");
        login.clickLoginButton();
        login.getInvalidMessage();
        
    }	
	
	@Test(priority = 3)
    public void testLoginWithCorrectUsernameAndIncorrectPassword() throws InterruptedException {
        login=getLogin(); 
        login.setUsername("Admin");
        login.setPassword("admin1234");
        login.clickLoginButton();
        login.getInvalidMessage();
        
    }	
	
}
