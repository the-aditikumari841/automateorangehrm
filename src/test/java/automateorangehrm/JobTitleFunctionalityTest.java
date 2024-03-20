package automateorangehrm;

import java.io.IOException;

import org.testng.annotations.Test;

import automateorangehrm.common.pages.JobPage;
import automateorangehrm.common.pages.LoginPage;
import automateorangehrm.common.utils.supportBrowser;

public class JobTitleFunctionalityTest extends supportBrowser {
	
	private LoginPage login;
	private JobPage job;
	
	@Test(priority = 1)
    public void testAddFunctionality() throws InterruptedException, IOException {
        login=getLogin(); 
        login.setUsername("Admin");
        login.setPassword("admin123");
        login.clickLoginButton();
        login.isLoginSuccessful();
        login.clickAdminButton();
        login.isAdminPage();
        job = getJob();
        job.clickJobButton(); 
        job.clickJobTitleButton();
        job.isJobPage();    
        job.clickAddButton();
        Thread.sleep(5000);
        job.enterJobTitle("Account Assistants");
        Thread.sleep(3000);
        job.doesAlreadyExists();
        job.clickSaveButton();
        Thread.sleep(5000);
        
    }
	
	@Test(priority = 2)
	public void testEditFunctionality() throws IOException {
		
        login=getLogin(); 
        login.setUsername("Admin");
        login.setPassword("admin123");
        login.clickLoginButton();
        login.isLoginSuccessful();
        login.clickAdminButton();
        login.isAdminPage();
        job = getJob();
        job.clickJobButton(); 
        job.clickJobTitleButton();
        job.isJobPage(); 
        
		
	}
	
	
	@Test(priority = 3)
	public void testDeleteFunctionality() throws IOException {
		
        login=getLogin(); 
        login.setUsername("Admin");
        login.setPassword("admin123");
        login.clickLoginButton();
        login.isLoginSuccessful();
        login.clickAdminButton();
        login.isAdminPage();
        job = getJob();
        job.clickJobButton(); 
        job.clickJobTitleButton();
        job.isJobPage(); 
        
		
	}
	
	
	
	


}







