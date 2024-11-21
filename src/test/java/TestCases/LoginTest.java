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

	LoginPage lp=null;
	HomePage hp=null;
	AdminDashboardPage adp;
	MentorDashboardPage mdp;
	ReferenceMaterialPage rmp;
	@Test
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
		Assert.assertEquals(url,"https://ictak-internship-portal-client.vercel.app/admin");
	
		}
	@Test
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
		Assert.assertEquals(url, "https://ictak-internship-portal-client.vercel.app/mentordashboard");
	}
	@Test(dataProvider = "testadminlogindata",dataProviderClass = DataProviderLogin.class )
	public void testAdminLoginNegative(String email,String password)throws Exception {
	    lp = new LoginPage(driver);
	    hp = new HomePage(driver);
	    hp.loginbtnClick();
		lp.setEmail(email);
		lp.setPass(password);
		lp.login();
		String url = lp.getUrlcurrent();
		Assert.assertEquals(url, "https://ictak-internship-portal-client.vercel.app/login");
	}
		}

		
	


