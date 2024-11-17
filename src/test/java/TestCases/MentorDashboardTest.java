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
		 MDP= new MentorDashboardPage(driver);
		 RMP = new ReferenceMaterialPage(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 HP.loginbtnClick();
		 LP.setEmail(prop.getProperty("emailmentor"));
		 LP.setPass(prop.getProperty("passwordmentor"));
		 LP.login();
	 }
	    @Test(priority = 1)
	    public void testLogoutAvailable() throws InterruptedException {
	        boolean d = MDP.logoutVisible();
	        Assert.assertTrue(d);
	    }
	    @Test(priority = 2)
	    public void testrefMatVisibleSide() {
	    	boolean d =MDP.referenceMaterialVisible();
	        Assert.assertTrue(d);
	    }
	   
	    @Test(priority = 3)
	    public void testsubmissionListPage() {
	        MDP.projectSubmitView();	       
	        boolean s = MDP.subHeadName();
	        Assert.assertTrue(s);	        
	        boolean t = MDP.subHeadTopic();
	        Assert.assertTrue(t);	       
	        boolean b = MDP.subHeadBatch();
	        Assert.assertTrue(b);	        
	        boolean sa = MDP.subHeadStatus();
	        Assert.assertTrue(sa);	        
	        boolean a = MDP.subHeadAction();
	        Assert.assertTrue(a);	        
	   }
	    @Test(priority = 4)
	    public void testBatchDropdown() throws InterruptedException {   
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    MDP.batchBoxClick();
	    MDP.batchJanDropClick();
	    String S = MDP.getSelectedBatch();
	    Assert.assertEquals(S, "January-2024");
	   }
	    @Test(priority = 5)
	    public void testTopicDropdown() {		   		    
		    MDP.topicBoxClick();
		    MDP.topicLibrarayClick();
		  String T = MDP.getSelectTopic();
		  Assert.assertEquals(T, "Library website");
	    }
	    @Test(priority = 6)
	    public void testRefMaterialClickable() {		    		   
		    MDP.referenceMaterialClick();
		    String url = RMP.refMaterialPageUrl();
		    Assert.assertEquals(url, "https://ictak-internship-portal-client.vercel.app/reference-materials");
	    }
	    @Test(priority = 7,dependsOnMethods = {"testRefMaterialClickable"})
	    public void testRefMatTableHeader() {	    			    
		    boolean t = RMP.refmaterialTopicVisible();
		    Assert.assertTrue(t);		   
		    boolean M = RMP.refmaterialHeadVisible();
		    Assert.assertTrue(M);		    
		    boolean A = RMP.refmaterialActionsVisible();
		    Assert.assertTrue(A);		    
		    }
	    @Test(priority = 8,dependsOnMethods = {"testRefMaterialClickable"})
	    public void testActionsDeletebtnEnable() {	    			   
		    boolean d = RMP.deleteButtonEnable();
		    Assert.assertTrue(d);
	    }
	    @Test(priority = 9,dependsOnMethods = {"testRefMaterialClickable"})
	    public void testAddRefMaterailDisplayed() {	    			   
		    boolean p = RMP.addrefMaterial();
		    Assert.assertTrue(p);
		    
	    }
	    @Test(priority = 10,dependsOnMethods = {"testAddRefMaterailDisplayed"})
	    public void testAddRefMaterailFunction() {	    			   
		    RMP.addrefMaterialClick();
		     String url = RMP.addRefMaterialPageUrl();
		     Assert.assertEquals(url, "https://ictak-internship-portal-client.vercel.app/reference-materials-form");
	    }
	    
	}
