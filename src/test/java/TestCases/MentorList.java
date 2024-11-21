package TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
	
	@BeforeClass
	public void setUp() {
		hp=new HomePage(driver);
		lp=new LoginPage(driver);
		adp=new AdminDashboardPage(driver);
		mlp= new MentorListPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		hp.loginbtnClick();
		lp.setEmail("ictak@example.com");
		lp.setPass("0000");
		lp.login();
		}
	
	@Test(priority=1)
	public void testMentorListPageNavigation() {
		adp.mentorMenuItemClick();
		Assert.assertEquals(mlp.currentUrlReturn(), "https://ictak-internship-portal-client.vercel.app/admin/mentorslist/");
	}
	
	@Test(priority=2)
	public void testMentorListHeader() {
		Assert.assertEquals(mlp.mentorListheadMentorText(), "Mentors");
		Assert.assertEquals(mlp.mentorListHeadEmailText(), "Email");
		Assert.assertEquals(mlp.mentorListHeadphoneText(), "Phone");
		Assert.assertEquals(mlp.mentorListHeadTopicsText(), "Project Topics");
		Assert.assertEquals(mlp.mentorListHeadActionText(), "Actions");
	}
	
	@Test(priority=3)
	public void testAddmentorButtonVisible() {
		Assert.assertTrue(mlp.addMentorbtnVisible());
	}
	
	@Test(priority=4)
	public void testAddMentorDialogBox() {
		mlp.clickAddMentorButton();
		Assert.assertTrue(mlp.checkNamefieldVisible());
		Assert.assertTrue(mlp.checkEmailFieldVisible());
		Assert.assertTrue(mlp.checkPasswordfieldvisible());
		Assert.assertTrue(mlp.checkPhoneFieldVisible());
		Assert.assertTrue(mlp.checkTopicFieldVisible());
		mlp.clickCancelBtnAddDialogBox();
	}
	@Test(priority=5)
	public void testAddedProjectTopicDropdown() throws InterruptedException {
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
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
	
	}
	
	@Test(priority=6,dataProvider = "testAddMentorValid", dataProviderClass = DataproviderAddMentor.class)
	public void testValidDataEntryAddMentor(String name,String email,String phone,String password,String topic) throws InterruptedException {
		mlp.clickAddMentorButton();
		mlp.enterNameAddMentorDialog(name);
		mlp.enterEmailAddMentorDialog(email);
		mlp.enterPhoneFieldAddMentorDialog(phone);
		mlp.enterPasswordAddMentorDialog(password);
		mlp.enterTopicAddMentorDialog(topic);
		mlp.clickAddbtnAddDialogBox();
		int f=mlp.checkMentorIsAdded(name);
		if(f==1) {
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
	}

}
