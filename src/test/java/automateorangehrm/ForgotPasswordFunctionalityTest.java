package automateorangehrm;

import java.io.IOException;
import org.testng.annotations.Test;
import automateorangehrm.common.pages.LoginPage;
import automateorangehrm.common.utils.supportBrowser;

public class ForgotPasswordFunctionalityTest extends supportBrowser{

	private LoginPage login;
	@Test
    public void testLoginWithCorrectUsernameAndCorrectPassword() throws InterruptedException, IOException {
        login=getLogin(); 
        login.clickForgotPasswordButton();
        login.isResetPasswordPage();
        login.setUsername("Admin");
        login.clickResetPasswordButton();
        login.isPasswordResetSuccessful();
    }
}