package automateorangehrm;

import org.testng.annotations.Test;

import automateorangehrm.common.pages.LoginPage;
import automateorangehrm.common.utils.supportBrowser;

public class EmptyUsernameFieldTest extends supportBrowser {

	private LoginPage login;
	@Test(priority =1)
    public void testLoginWithEmptyUsernameFieldAndCorrectPassword() throws InterruptedException {
        login=getLogin(); 
        login.setUsername("");
        login.setPassword("admin123");
        login.clickLoginButton();
        login.getRequiredUsernameMessage();
        
    }	
	
	@Test(priority =2)
    public void testLoginWithEmptyUsernameFieldAndIncorrectPassword() throws InterruptedException {
        login=getLogin(); 
        login.setUsername("");
        login.setPassword("admin1234");
        login.clickLoginButton();
        login.getRequiredUsernameMessage();
        
    }	

}
