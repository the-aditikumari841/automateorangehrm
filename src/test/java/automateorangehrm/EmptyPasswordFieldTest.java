package automateorangehrm;

import org.testng.annotations.Test;

import automateorangehrm.common.pages.LoginPage;
import automateorangehrm.common.utils.supportBrowser;

public class EmptyPasswordFieldTest extends supportBrowser {

	private LoginPage login;

	@Test(priority = 1)
	public void testLoginWithEmptyPasswordFieldAndCorrectUsername() throws InterruptedException {
		login = getLogin();
		login.setUsername("Admin");
		login.setPassword("");
		login.clickLoginButton();
		login.getRequiredPasswordMessage();
	}

	@Test(priority = 2)
	public void testLoginWithEmptyPasswordFieldAndIncorrectUsername() throws InterruptedException {
		login = getLogin();
		login.setUsername("Admin1");
		login.setPassword("");
		login.clickLoginButton();
		login.getRequiredPasswordMessage();
	}
}
