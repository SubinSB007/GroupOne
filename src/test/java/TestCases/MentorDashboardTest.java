package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import org.testng.Assert;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MentorDashboardPage;
import PageObjects.ReferenceMaterialPage;

public class MentorDashboardTest extends TestBase {
	 MentorDashboardPage MDP;
	 HomePage HP ;
	 LoginPage LP;
	 ReferenceMaterialPage RMP;
	 @BeforeClass
	 public void loginMentorDash() {
		 HP = new HomePage(driver);
		 LP = new LoginPage(driver);
		 HP.loginbtnClick();
		 LP.setEmail(prop.getProperty("emailmentor"));
		 LP.setPass(prop.getProperty("passwordmentor"));
		 LP.login();
	 }
//	    @Test(priority = 1)
//	    public void testLogoutAvailable() {
//	    	MDP = new MentorDashboardPage(driver);
//	    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//	        boolean d = MDP.logoutVisible();
//	        Assert.assertTrue(d);
	  //  }
	    @Test(priority = 1)
	    public void testrefMatVisibleSide() {
	        MDP = new MentorDashboardPage(driver);
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        boolean d =MDP.referenceMaterialVisible();
	        Assert.assertTrue(d);
	    }
	   
	    @Test(priority = 2)
	    public void testsubmissionListPage() {
	        MDP = new MentorDashboardPage(driver);
	        MDP.projectSubmitView();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        boolean s = MDP.subHeadName();
	        Assert.assertTrue(s);
	        System.out.println("Header Student Name is Visible");
	        boolean t = MDP.subHeadTopic();
	        Assert.assertTrue(t);
	        System.out.println("Header Topic is Visible");
	        boolean b = MDP.subHeadBatch();
	        Assert.assertTrue(b);
	        System.out.println("Header Batch is Visible");
	        boolean sa = MDP.subHeadStatus();
	        Assert.assertTrue(sa);
	        System.out.println("Header Status is Visible");
	        boolean a = MDP.subHeadAction();
	        Assert.assertTrue(a);
	        System.out.println("Header Actions is Visible");
	   }
	    @Test(priority = 3)
	    public void testBatchDropdown() throws InterruptedException {
	    MDP = new MentorDashboardPage(driver);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    MDP.batchBoxClick();
	    MDP.batchJanDropClick();
	    String S = MDP.getSelectedBatch();
	    Assert.assertEquals(S, "January-2024");
	   }
	    @Test(priority = 4)
	    public void testTopicDropdown() {
		    MDP = new MentorDashboardPage(driver);
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		    MDP.topicBoxClick();
		    MDP.topicLibrarayClick();
		  String T = MDP.getSelectTopic();
		  Assert.assertEquals(T, "Library website");
	    }
	    @Test(priority = 5)
	    public void testRefMaterialClickable() {
		    MDP = new MentorDashboardPage(driver);
		    RMP = new ReferenceMaterialPage(driver);
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		    MDP.referenceMaterialClick();
		    String url = RMP.refMaterialPageUrl();
		    Assert.assertEquals(url, "https://ictak-internship-portal-client.vercel.app/reference-materials");
	    }
	    @Test(priority = 6,dependsOnMethods = {"testRefMaterialClickable"})
	    public void testRefMatTableHeader() {
	    	RMP = new ReferenceMaterialPage(driver);
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		    boolean t = RMP.refmaterialTopicVisible();
		    Assert.assertTrue(t);
		    System.out.println("Topic Header Visible = "+t);
		    boolean M = RMP.refmaterialHeadVisible();
		    Assert.assertTrue(M);
		    System.out.println("Reference Material Header Visible = "+M);
		    boolean A = RMP.refmaterialActionsVisible();
		    Assert.assertTrue(A);
		    System.out.println("Actions Header Visible = "+A);
		    }
	    @Test(priority = 7,dependsOnMethods = {"testRefMaterialClickable"})
	    public void testActionsDeletebtnEnable() {
	    	RMP = new ReferenceMaterialPage(driver);
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		    boolean d = RMP.deleteButtonEnable();
		    Assert.assertTrue(d);
	    }
	    @Test(priority = 8,dependsOnMethods = {"testRefMaterialClickable"})
	    public void testAddRefMaterailDisplayed() {
	    	RMP = new ReferenceMaterialPage(driver);
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		    boolean p = RMP.addrefMaterial();
		    Assert.assertTrue(p);
		    
	    }
	    @Test(priority = 9,dependsOnMethods = {"testAddRefMaterailDisplayed"})
	    public void testAddRefMaterailFunction() {
	    	RMP = new ReferenceMaterialPage(driver);
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		    RMP.addrefMaterialClick();
		     String url = RMP.addRefMaterialPageUrl();
		     Assert.assertEquals(url, "https://ictak-internship-portal-client.vercel.app/reference-materials-form");
	    }
	    
	}
