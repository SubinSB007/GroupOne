package TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AdminDashboardPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MentorListPage;
import Utilities.DataproviderAddMentor;

public class MentorList extends TestBase{
	
	HomePage hp;
	LoginPage lp;
	AdminDashboardPage adp;
	MentorListPage mlp;
	
	@Test(priority=1,groups= {"regression"})
	public void testMentorListPageNavigation() throws InterruptedException {
		logger.info("Started mentorlist navigation");
		
		hp=new HomePage(driver);
		lp=new LoginPage(driver);
		adp=new AdminDashboardPage(driver);
		mlp= new MentorListPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		hp.loginbtnClick();
		lp.setEmail(prop.getProperty("emailadmin"));
		lp.setPass(prop.getProperty("passwordadmin"));
		lp.login();
		adp.mentorMenuItemClick();
		
		logger.info("clicked on mentor in the sidebar");
		Assert.assertEquals(mlp.currentUrlReturn(), prop.getProperty("mentorlistpageurl"));
	}
	
	@Test(priority=2,groups= {"regression"})
	public void testMentorListHeader() {
		logger.info("Started the testing of mentor list table headers");
		
		mlp= new MentorListPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertEquals(mlp.mentorListheadMentorText(), "Mentors");
		Assert.assertEquals(mlp.mentorListHeadEmailText(), "Email");
		Assert.assertEquals(mlp.mentorListHeadphoneText(), "Phone");
		Assert.assertEquals(mlp.mentorListHeadTopicsText(), "Project Topics");
		Assert.assertEquals(mlp.mentorListHeadActionText(), "Actions");
		
		logger.info("All mentor list headers are available");
	}
	
	@Test(priority=3,groups= {"regression"})
	public void testAddmentorButtonVisible() {
		logger.info("Start testing add mentor visibility");
		
		mlp= new MentorListPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertTrue(mlp.addMentorbtnVisible());
		
		logger .info("Add mentor button is visible");
	}
	
	@Test(priority=4,groups= {"regression"})
	public void testAddMentorDialogBox() throws InterruptedException {
		logger .info("Start testing necssary fields are available in the add mentor dialog box");
		
		mlp= new MentorListPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		mlp.clickAddMentorButton();
		Assert.assertTrue(mlp.checkNamefieldVisible());
		Assert.assertTrue(mlp.checkEmailFieldVisible());
		Assert.assertTrue(mlp.checkPasswordfieldvisible());
		Assert.assertTrue(mlp.checkPhoneFieldVisible());
		Assert.assertTrue(mlp.checkTopicFieldVisible());
		mlp.clickCancelBtnAddDialogBox();
		
		logger.info("All fields are available in the add mentor dialog box");
	}
	
	@Test(priority=5,groups= {"regression"})
	public void testAddedProjectTopicDropdown() throws InterruptedException {
		logger.info("started testing the added project available in the topic dropdown in add mentordialog box");
		
		adp=new AdminDashboardPage(driver);
		mlp= new MentorListPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		mlp.clickDashboardSidebar();
		adp.addProjectButtonClick();
		adp.addProjectDialogTopicEnter(prop.getProperty("topictest"));
		adp.addTopicDialogDurationEnter(prop.getProperty("durationtest"));
		adp.clickAddbtnAddProjectDialog();
		adp.mentorMenuItemClick();
		mlp.clickAddMentorButton();
		int f=mlp.checkAddedProjectTopicdropDown(prop.getProperty("topictest"));
		mlp.clickCancelBtnAddDialogBox();
		
		if(f==1) {
			logger.info("Added project is available in the topic down in the add mentor dialog box");
			Assert.assertTrue(true);
		}else {
			logger.error("Added project is not available in the topic down in the add mentor dialog box");
			Assert.fail();
		}
	
	}
	
	@Test(priority=7,groups= {"regression"},dataProvider = "testAddMentorValid", dataProviderClass = DataproviderAddMentor.class)
	public void testValidDataEntryAddMentor(String name,String email,String phone,String password,String topic) throws InterruptedException {
		logger.info("Started mentor adding with valid data");
		
		mlp= new MentorListPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		mlp.clickAddMentorButton();
		mlp.enterNameAddMentorDialog(name);
		mlp.enterEmailAddMentorDialog(email);
		mlp.enterPhoneFieldAddMentorDialog(phone);
		mlp.enterPasswordAddMentorDialog(password);
		mlp.enterTopicAddMentorDialog(topic);
		mlp.clickAddbtnAddDialogBox();
		
		logger.info("clicked on the add button in the add mentor dialog box");
		int f=mlp.checkMentorIsAdded(name);
		if(f==1) {
			Assert.assertTrue(true);
		}else {
			logger.error("Mentor is not added");
			Assert.fail();
		}
	}
	
	@Test(priority=6,groups= {"regression"},dataProvider ="testAddMentorInValid", dataProviderClass =DataproviderAddMentor.class )
	public void testInvalidDataAddMentor(String name,String email,String phone,String password,String topic) throws InterruptedException {
		
		logger.info("Started mentor adding with invalid data");
		
		mlp= new MentorListPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		mlp.clickAddMentorButton();
		mlp.enterNameAddMentorDialog(name);
		mlp.enterEmailAddMentorDialog(email);
		mlp.enterPhoneFieldAddMentorDialog(phone);
		mlp.enterPasswordAddMentorDialog(password);
		mlp.enterTopicAddMentorDialog(topic);
		mlp.clickAddbtnAddDialogBox();
		String alertmsg=mlp.addMentorWarningAlert();
		mlp.clickCancelBtnAddDialogBox();
		
		logger.info("Click on the add button");
		
		if(alertmsg.equals(prop.getProperty("addMentoralertmsg1"))) {
			Assert.assertTrue(true);
		}else if(alertmsg.equals(prop.getProperty("addMentoralertmsg2"))) {
			Assert.assertTrue(true);
		}else if(alertmsg.equals(prop.getProperty("addMentoralertmsg3"))) {
			Assert.assertTrue(true);
		}else {
			logger .error("Alert message not showed");
			Assert.fail();
		}
	}
}
