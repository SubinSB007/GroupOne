package TestCases;

import org.testng.annotations.Test;

import java.time.Duration;

import org.testng.Assert;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MentorDashboardPage;
import PageObjects.ReferenceMaterialPage;

public class MentorDashboardTest extends TestBase {
	 MentorDashboardPage mdp;
	 HomePage hp ;
	 LoginPage lp;
	 ReferenceMaterialPage rmp;
	 
	    @Test(priority = 1,groups= {"regression"})
	    public void testLogoutAvailable() throws InterruptedException {
	    	
	    	 hp = new HomePage(driver);
			 lp = new LoginPage(driver);
			 mdp= new MentorDashboardPage(driver);
			 rmp = new ReferenceMaterialPage(driver);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			 hp.loginbtnClick();
			 lp.setEmail(prop.getProperty("emailmentor"));
			 lp.setPass(prop.getProperty("passwordmentor"));
			 lp.login();
	        boolean d = mdp.logoutVisible();
	        Assert.assertTrue(d);
	    }
	    
	    @Test(priority = 2,groups= {"regression"})
	    public void testrefMatVisibleSide() {
	    	
	    	mdp= new MentorDashboardPage(driver);
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    	boolean d =mdp.referenceMaterialVisible();
	    	Assert.assertTrue(d);
	    }
	   
	    @Test(priority = 3,groups= {"regression"})
	    public void testsubmissionListPage() {
	    	
	    	mdp= new MentorDashboardPage(driver);
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	        mdp.projectSubmitView();	       
	        boolean s = mdp.subHeadName();
	        Assert.assertTrue(s);	        
	        boolean t = mdp.subHeadTopic();
	        Assert.assertTrue(t);	       
	        boolean b = mdp.subHeadBatch();
	        Assert.assertTrue(b);	        
	        boolean sa = mdp.subHeadStatus();
	        Assert.assertTrue(sa);	        
	        boolean a = mdp.subHeadAction();
	        Assert.assertTrue(a);	        
	   }
	    
	    @Test(priority = 4,groups= {"regression"})
	    public void testBatchDropdown() throws InterruptedException {   
	    	
	    mdp= new MentorDashboardPage(driver);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    mdp.batchBoxClick();
	    mdp.batchJanDropClick();
	    String S = mdp.getSelectedBatch();
	    Assert.assertEquals(S, "January-2024");
	   }
	    
	    @Test(priority = 5,groups= {"regression"})
	    public void testTopicDropdown() {
	    	
	    	mdp= new MentorDashboardPage(driver);
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    mdp.topicBoxClick();
		    mdp.topicLibrarayClick();
		  String T = mdp.getSelectTopic();
		  Assert.assertEquals(T, "Library website");
	    }
	    
	    @Test(priority = 6,groups= {"regression"})
	    public void testRefMaterialClickable() {	
	    	
	    	 mdp= new MentorDashboardPage(driver);
			 rmp = new ReferenceMaterialPage(driver);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    mdp.referenceMaterialClick();
		    String url = rmp.refMaterialPageUrl();
		    Assert.assertEquals(url, prop.getProperty("referencematerialpageurl"));
	    }
	    
	    @Test(priority = 7,groups= {"regression"},dependsOnMethods = {"testRefMaterialClickable"})
	    public void testRefMatTableHeader() {
	    	
	    	rmp = new ReferenceMaterialPage(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    boolean t = rmp.refmaterialTopicVisible();
		    Assert.assertTrue(t);		   
		    boolean M = rmp.refmaterialHeadVisible();
		    Assert.assertTrue(M);		    
		    boolean A = rmp.refmaterialActionsVisible();
		    Assert.assertTrue(A);		    
		    }
	    
	    @Test(priority = 8,groups= {"regression"},dependsOnMethods = {"testRefMaterialClickable"})
	    public void testActionsDeletebtnEnable() {	
	    	
	    	 rmp = new ReferenceMaterialPage(driver);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    boolean d = rmp.deleteButtonEnable();
		    Assert.assertTrue(d);
	    }
	    
	    @Test(priority = 9,groups= {"regression"},dependsOnMethods = {"testRefMaterialClickable"})
	    public void testAddRefMaterailDisplayed() {	  
	    	
	    	 rmp = new ReferenceMaterialPage(driver);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    boolean p = rmp.addrefMaterial();
		    Assert.assertTrue(p);
		    
	    }
	    
	    @Test(priority = 10,groups= {"regression"},dependsOnMethods = {"testAddRefMaterailDisplayed"})
	    public void testAddRefMaterailFunction() {
	    	 rmp = new ReferenceMaterialPage(driver);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    rmp.addrefMaterialClick();
		     String url = rmp.addRefMaterialPageUrl();
		     Assert.assertEquals(url, prop.getProperty("addreferncematerialpageurl"));
	    }
	    
	}
