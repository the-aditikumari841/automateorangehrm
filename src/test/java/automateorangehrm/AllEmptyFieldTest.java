package automateorangehrm;

import org.testng.annotations.Test;

import automateorangehrm.common.pages.LoginPage;
import automateorangehrm.common.utils.supportBrowser;

public class AllEmptyFieldTest extends supportBrowser {

	private LoginPage login;
	@Test
    public void testLoginWithAllEmptyFields() throws InterruptedException {
        login=getLogin(); 
        login.setUsername("");
        login.setPassword("");
        login.clickLoginButton();
        login.getRequiredUsernameMessage();
        login.getRequiredPasswordMessage();
        
    }	
}
