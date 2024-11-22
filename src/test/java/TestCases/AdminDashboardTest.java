package TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AdminDashboardPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Utilities.DataProviderDP;


public class AdminDashboardTest extends TestBase{
	HomePage hp;
	LoginPage lp;
	AdminDashboardPage adp;
	
	@Test(priority = 1,groups= {"regression"})
	public void testLogoutBtnAvailable() {
		hp=new HomePage(driver);
		lp=new LoginPage(driver);
		adp=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    hp.loginbtnClick();
			lp.setEmail(prop.getProperty("emailadmin"));
			lp.setPass(prop.getProperty("passwordadmin"));
			lp.login();
		boolean e=adp.logoutBtnEnable();
		Assert.assertTrue(e);
	}
	
	@Test(priority = 2,groups= {"regression"})
	public void testProjectListHeader() {
		
		adp=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertTrue(adp.projectListHeaderProjects());
		Assert.assertTrue(adp.projectListHeaderdurations());
		Assert.assertTrue(adp.projectListHeaderActions());
	}
	
	@Test(priority=3,groups= {"regression"})
	public void testAddProjectButtonPresent() {
		
		adp=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertTrue(adp.projectListHeaderProjects());
		Assert.assertTrue(adp.addProjectButtonVisible());
	}
	
	@Test(priority=4,groups= {"regression"})
	public void testAddprojectButtonFunctinality() {
		
		adp=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		adp.addProjectButtonClick();
		Assert.assertTrue(adp.addProjectDialogTopicPresent());
		Assert.assertTrue(adp.addProjectDialogDurationPresent());
	}
	
	@Test(priority=5,groups= {"regression"},dependsOnMethods = {"testAddprojectButtonFunctinality"},dataProvider = "testAddProjectAddCancelBtn",dataProviderClass = DataProviderDP.class)
	public void testAddProjectAddbutton(String topic,String duration) throws InterruptedException {
		
		adp=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		adp.addProjectDialogTopicEnter(topic);
		adp.addTopicDialogDurationEnter(duration);
		adp.clickAddbtnAddProjectDialog();
		int t=adp.getAddedTopic(topic);
		int d=adp.getAdddedduration(duration);
		if(t==1 && d==1) {
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
	
	}
	
	@Test(priority=6,groups= {"regression"},dependsOnMethods = {"testAddProjectAddbutton"},dataProvider = "testAddProjectAddCancelBtn",dataProviderClass = DataProviderDP.class)
	public void testDeleteButtonActions(String topic ,String duration) throws InterruptedException {
		
		adp=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		adp.projectDeleteButtonAction();
		Assert.assertEquals(adp.switchTodeleteProjectAlert(), prop.getProperty("deleteprojectalert"));
//		Assert.assertNotEquals(ADP.getAddedTopic(), topic);
	}
	
	@Test(priority=7,groups= {"regression"},dependsOnMethods = {"testAddprojectButtonFunctinality"},dataProvider = "testAddProjectAddCancelBtn",dataProviderClass = DataProviderDP.class)
	public void testAddProjectCancelbutton(String topic,String duration) throws InterruptedException {
		
		adp=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		adp.addProjectButtonClick();
		adp.addProjectDialogTopicEnter(topic);
		adp.addTopicDialogDurationEnter(duration);
		Assert.assertTrue(adp.clickCancelbtnAddProjectDialog());
		
	}
	
	@Test(priority=8,groups= {"regression"},dataProvider = "testAddProjectNegativedata",dataProviderClass = DataProviderDP.class)
	public void testAddProjectNegativeData(String topic,String duration) throws InterruptedException {
		
		adp=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		adp.addProjectButtonClick();
		adp.addProjectDialogTopicEnter(topic);
		adp.addTopicDialogDurationEnter(duration);
		adp.clickAddbtnAddProjectDialog();
		Assert.assertEquals(adp.switchToAdProjectdemptyAlert(), prop.getProperty("emptyaddprojectalert"));
		adp.clickCancelbtnAddProjectDialog();	
	}
	
	@Test(priority=9,groups= {"regression"})
	public void testEditProjectPositive() throws InterruptedException {
		
		adp=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		adp.clickEditButton();
		adp.editTopic("Sample Test");
		adp.editDuration("5 months");
		adp.clickAddbtnAddProjectDialog();
		//ADP.clickCancelbtnAddProjectDialog();
//		Assert.assertEquals(ADP.getEditedTopic(), "Sample Test");
//		Assert.assertEquals(ADP.getEditedduration(), "5 months");
		}
}
