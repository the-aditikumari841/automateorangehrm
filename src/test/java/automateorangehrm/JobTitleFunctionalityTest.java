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
        job.enterJobTitle("Account Assistantssssssssssss");
        job.editJobDesc("Descriptionssssssssssssssss");
        Thread.sleep(3000);
        //job.uploadSpecification();
        job.editNote("Note");
        Thread.sleep(3000);
        job.errorIfExists();
        job.clickSaveButton();
        Thread.sleep(5000);
        
    }
	
	
	@Test(priority = 2)
	public void testEditFunctionality() throws IOException, InterruptedException {
		
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
        Thread.sleep(3000);
        job.edit("Account Assistantss");
        Thread.sleep(3000);
        job.editJobTitle("Account Assistantt");
        Thread.sleep(3000);
        job.editJobDesc("Descriptionssssssssssssssss");
        job.editNote("Note");
        job.clickSaveButton();
        Thread.sleep(3000);
	}
	
	
	@Test(priority = 3)
	public void testDeleteFunctionality() throws InterruptedException, IOException {
		
        login=getLogin(); 
        login.setUsername("Admin");
        login.setPassword("admin123");
        login.clickLoginButton();
        login.isLoginSuccessful();
        //Thread.sleep(3000);
        login.clickAdminButton();
        login.isAdminPage();
        //Thread.sleep(3000);
        job = getJob();
        //Thread.sleep(3000);
        job.clickJobButton();
        //Thread.sleep(3000);
        job.clickJobTitleButton();
        //Thread.sleep(3000);
        job.isJobPage(); 
        Thread.sleep(3000);
        job.delete("Account Assistantt");
        Thread.sleep(3000);
		
	}
	
}

