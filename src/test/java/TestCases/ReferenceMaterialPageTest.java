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
	
		 MentorDashboardPage MDP;
		 HomePage HP ;
		 LoginPage LP;
		 ReferenceMaterialPage RMP;
		 @BeforeClass
		 public void  addReference  () {
			 
			 HP = new HomePage(driver);
			 LP = new LoginPage(driver);
			 HP.loginbtnClick();
			 LP.setEmail(prop.getProperty("emailmentor"));
			 LP.setPass(prop.getProperty("passwordmentor"));
			 LP.login();
		 }
		@Test(dataProvider=  "testAddrefmaterial" , dataProviderClass = DataproviderAddrefmaterial.class)
		public void testAddrefmaterialCancelbtn(String Topic , String Reference , String Date,String Url , String status) {
			MDP=new MentorDashboardPage(driver);
			RMP=new ReferenceMaterialPage(driver);
			driver.manage(). timeouts().implicitlyWait(Duration.ofSeconds(15));
			MDP.referenceMaterialClick();
			RMP.addrefMaterialClick();
			RMP.enterTopic(Topic);
			RMP.enterMaterial(Reference);
			RMP.enterUrl(Url);
			RMP.enterStatus(status);
			RMP.setDate(Date);
			Assert.assertTrue(RMP.cancelClick());
		}
		
		 
 }
	


