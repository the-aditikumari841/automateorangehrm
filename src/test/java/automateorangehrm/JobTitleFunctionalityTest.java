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
        job.enterJobTitle("Account Assistantsssss");
        Thread.sleep(3000);
        job.errorIfExists();
        job.editJobDesc("Descriptionssssssssssssssss");
        Thread.sleep(3000);
        job.uploadSpecification();
        job.editNote("Note");
        Thread.sleep(3000);        
        job.clickSaveButton();
        Thread.sleep(5000);
        boolean ans = job.checkAdded("Account Assistantsssss");
        if(ans) {
        	System.out.println("Job added successfully");
        }
        else {
        	System.out.println("Job Not added");
        }
    }
	
	
	@Test(priority = 2)
	public void testEditFunctionalityWithKeepingFile() throws IOException, InterruptedException {
		
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
        job.edit("Account Assistantsssss");
        Thread.sleep(3000);
        job.editJobTitle("Account Assistantt");
        Thread.sleep(3000);
        job.editJobDesc("Descriptionssssssssssssssss");
        job.editNote("Note");
        job.clickSaveButton();
        System.out.println("Job Edited Successfully");
	}
	
	@Test(priority = 3)
	public void testEditFunctionalityToReplaceFile() throws IOException, InterruptedException {
		
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
        job.edit("Account Assistantt");
        Thread.sleep(3000);
        job.replaceSpecification();
        job.editNote("Note");
        job.clickSaveButton();
        System.out.println("Job Edited Successfully");
	}
	
	@Test(priority = 4)
	public void testEditFunctionalityToDeleteFile() throws IOException, InterruptedException {
		
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
        job.edit("Account Assistantt");
        Thread.sleep(3000);
        job.deleteSpecification();
        Thread.sleep(3000);
        job.clickSaveButton();
        Thread.sleep(3000);
        System.out.println("Job Edited Successfully");
	}
	
	@Test(priority = 5)
	public void testDeleteFunctionality() throws InterruptedException, IOException {
		
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
        job.delete("Account Assistantt");
        Thread.sleep(3000);
        boolean ans = job.checkDeleted("Account Assistantsssss");
        if(ans) {
        	System.out.println("Job Title Deleted Successfully");
        }
        else {
        	System.out.println("Job Title not Deleted");
        }
	}
}

