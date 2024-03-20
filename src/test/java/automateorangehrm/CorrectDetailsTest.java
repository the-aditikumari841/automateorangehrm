package automateorangehrm;

import java.io.IOException;

import org.testng.annotations.Test;

import automateorangehrm.common.pages.LoginPage;
import automateorangehrm.common.utils.supportBrowser;

public class CorrectDetailsTest extends supportBrowser{

	private LoginPage login;
	@Test
    public void testLoginWithCorrectUsernameAndCorrectPassword() throws InterruptedException, IOException {
        login=getLogin(); 
        login.setUsername("Admin");
        login.setPassword("admin123");
        login.clickLoginButton();
        login.isLoginSuccessful();
    }
}