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
	HomePage HP;
	LoginPage LP;
	AdminDashboardPage ADP;
	
	@BeforeClass
	public void adminlogin() {
		HP=new HomePage(driver);
		LP=new LoginPage(driver);
		ADP=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    HP.loginbtnClick();
			LP.setEmail("ictak@example.com");
			LP.setPass("0000");
			LP.login();
	}
	@Test(priority = 1)
	public void testLogoutBtnAvailable() {
//		ADP=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		boolean e=ADP.logoutBtnEnable();
		Assert.assertTrue(e);
	}
	@Test(priority = 2)
	public void testProjectListHeader() {
//		ADP=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertTrue(ADP.projectListHeaderProjects());
		Assert.assertTrue(ADP.projectListHeaderdurations());
		Assert.assertTrue(ADP.projectListHeaderActions());
	}
	@Test(priority=3)
	public void testAddProjectButtonPresent() {
//		ADP=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Assert.assertTrue(ADP.addProjectButtonVisible());
	}
	@Test(priority=4)
	public void testAddprojectButtonFunctinality() {
//		ADP=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ADP.addProjectButtonClick();
		Assert.assertTrue(ADP.addProjectDialogTopicPresent());
		Assert.assertTrue(ADP.addProjectDialogDurationPresent());
	}
	
	@Test(priority=5,dependsOnMethods = {"testAddprojectButtonFunctinality"},dataProvider = "testAddProjectAddCancelBtn",dataProviderClass = DataProviderDP.class)
//	@Test(dependsOnMethods = {"testAddprojectButtonFunctinality"})
	public void testAddProjectAddbutton(String topic,String duration) throws InterruptedException {
//		ADP=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ADP.addProjectDialogTopicEnter(topic);
		ADP.addTopicDialogDurationEnter(duration);
		ADP.clickAddbtnAddProjectDialog();
		Assert.assertEquals(ADP.getAddedTopic(),topic);
		Assert.assertEquals(ADP.getAdddedduration(), duration);
	}
	
	@Test(priority=6,dependsOnMethods = {"testAddProjectAddbutton"},dataProvider = "testAddProjectAddCancelBtn",dataProviderClass = DataProviderDP.class)
	public void testDeleteButtonActions(String topic ,String duration) throws InterruptedException {
//		ADP=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ADP.projectDeleteButtonAction();
		Assert.assertEquals(ADP.switchTodeleteProjectAlert(), prop.getProperty("deleteprojectalert"));
//		Assert.assertNotEquals(ADP.getAddedTopic(), topic);
	}
	
	@Test(priority=7,dependsOnMethods = {"testAddprojectButtonFunctinality"},dataProvider = "testAddProjectAddCancelBtn",dataProviderClass = DataProviderDP.class)
	public void testAddProjectCancelbutton(String topic,String duration) throws InterruptedException {
//		ADP=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ADP.addProjectButtonClick();
		ADP.addProjectDialogTopicEnter(topic);
		ADP.addTopicDialogDurationEnter(duration);
		Assert.assertTrue(ADP.clickCancelbtnAddProjectDialog());
		
	}
	@Test(priority=8,dataProvider = "testAddProjectNegativedata",dataProviderClass = DataProviderDP.class)
	public void testAddProjectNegativeData(String topic,String duration) throws InterruptedException {
//		ADP=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ADP.addProjectButtonClick();
		ADP.addProjectDialogTopicEnter(topic);
		ADP.addTopicDialogDurationEnter(duration);
		ADP.clickAddbtnAddProjectDialog();
		Assert.assertEquals(ADP.switchToAdProjectdemptyAlert(), prop.getProperty("emptyaddprojectalert"));
		ADP.clickCancelbtnAddProjectDialog();	
	}
	@Test(priority=9)
	public void testEditProjectPositive() throws InterruptedException {
//		ADP=new AdminDashboardPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ADP.clickEditButton();
		ADP.editTopic("Sample Test");
		ADP.editDuration("5 months");
		ADP.clickAddbtnAddProjectDialog();
		//ADP.clickCancelbtnAddProjectDialog();
//		Assert.assertEquals(ADP.getEditedTopic(), "Sample Test");
//		Assert.assertEquals(ADP.getEditedduration(), "5 months");
	}
}
