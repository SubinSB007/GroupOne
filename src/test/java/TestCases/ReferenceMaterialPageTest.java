package TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MentorDashboardPage;
import PageObjects.ReferenceMaterialPage;
import Utilities.DataproviderAddrefmaterial;

public class ReferenceMaterialPageTest extends TestBase{
	
		 MentorDashboardPage mdp;
		 HomePage hp ;
		 LoginPage lp;
		 ReferenceMaterialPage rmp;

		@Test(groups= {"regression"},dataProvider=  "testAddrefmaterial" , dataProviderClass = DataproviderAddrefmaterial.class)
		public void testAddrefmaterialCancelbtn(String Topic , String Reference , String Date,String Url , String status) {
			
			hp = new HomePage(driver);
			 lp = new LoginPage(driver);
			 mdp = new MentorDashboardPage(driver);
			 rmp = new ReferenceMaterialPage(driver);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			 hp.loginbtnClick();
			 lp.setEmail(prop.getProperty("emailmentor"));
			 lp.setPass(prop.getProperty("passwordmentor"));
			 lp.login();
			mdp.referenceMaterialClick();
			rmp.addrefMaterialClick();
			rmp.enterTopic(Topic);
			rmp.enterMaterial(Reference);
			rmp.enterUrl(Url);
			rmp.enterStatus(status);
			rmp.setDate(Date);
			Assert.assertTrue(rmp.cancelClick());
			
		}
		@Test(groups= {"regression"},dataProvider=  "testAddrefmaterial" , dataProviderClass = DataproviderAddrefmaterial.class)
		public void testAddrefmaterialSubmitbtn(String Topic , String Reference , String Date,String Url , String status) throws InterruptedException {			
			
			mdp = new MentorDashboardPage(driver);
			rmp = new ReferenceMaterialPage(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			mdp.referenceMaterialClick();
			rmp.addrefMaterialClick();
			rmp.enterTopic(Topic);
			rmp.enterMaterial(Reference);
			rmp.enterUrl(Url);
			rmp.enterStatus(status);
			rmp.setDate(Date);
			rmp.submitClick();
			rmp.swtichToAlert();
			int s=rmp.checkRefMaterialAdded(prop.getProperty("addedrefMaterial"));
			if(s==1) {
				Assert.assertTrue(true);
			}else {
				Assert.fail();
			}
			
		}
		 
 }
	


