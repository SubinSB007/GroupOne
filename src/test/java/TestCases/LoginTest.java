package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AdminDashboardPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MentorDashboardPage;
import PageObjects.ReferenceMaterialPage;
import Utilities.DataProviderLogin;


public class LoginTest extends TestBase{

	LoginPage lp;
	HomePage hp;
	AdminDashboardPage adp;
	MentorDashboardPage mdp;
	ReferenceMaterialPage rmp;
	
	@Test(priority=1,groups= {"sanity","regression"})
	public void testAdminLogin()throws Exception {
	    lp = new LoginPage(driver);
	    hp = new HomePage(driver);
	    adp = new AdminDashboardPage(driver);
	    hp.loginbtnClick();
		lp.setEmail(prop.getProperty("emailadmin"));
		lp.setPass(prop.getProperty("passwordadmin"));
		lp.login();
		String url = adp.currentAdminUrlReturn();
		adp.logoutBtnClick();
		Assert.assertEquals(url,prop.getProperty("admindashboardurl"));
	
		}
	
	@Test(priority=2,groups= {"sanity","regression"})
	public void testMentorLogin()throws Exception {
	    lp = new LoginPage(driver);
	    hp = new HomePage(driver);
	    mdp = new MentorDashboardPage(driver);
	    hp.loginbtnClick();
		lp.setEmail(prop.getProperty("emailmentor"));
		lp.setPass(prop.getProperty("passwordmentor"));
		lp.login();
		String url = mdp.currentMentorUrlReturn();
		mdp.logoutClick();
		Assert.assertEquals(url, prop.getProperty("mentordashboardurl"));
	}
	
	@Test(priority=3,groups= {"sanity","regression"},dataProvider = "testlogindataNegative",dataProviderClass = DataProviderLogin.class )
	public void testLoginNegative(String email,String password)throws Exception {
	    lp = new LoginPage(driver);
	    hp = new HomePage(driver);
	    hp.loginbtnClick();
		lp.setEmail(email);
		lp.setPass(password);
		lp.login();
		String url = lp.getUrlcurrent();
		lp.navigateBack();
		Assert.assertEquals(url,prop.getProperty("loginpageurl"));
	}
	
	@Test(priority=4,groups= {"sanity","regression"})
		public void testSignUpEnabled() {
			 lp = new LoginPage(driver);
			 hp = new HomePage(driver);
			 hp.loginbtnClick();
			 boolean s=lp.testSignupEnabled();
			 Assert.assertTrue(s);
			
		}
	}

		
	


