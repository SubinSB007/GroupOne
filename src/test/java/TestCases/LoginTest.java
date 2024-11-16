package TestCases;

import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;


public class LoginTest extends TestBase{

	LoginPage lp=null;
	HomePage hp=null;

	HomePage HP;
	LoginPage logobj=null;

	@Test

	public void testMentorLogin()throws Exception {
	    lp = new LoginPage(driver);
	    hp = new HomePage(driver);
	    hp.loginbtnclick();
		lp.setEmail(prop.getProperty("emailadmin"));
		lp.setPass(prop.getProperty("passwordadmin"));
		lp.login();
		
	
		}
	@Test
	public void testAdminLogin()throws Exception {
	    lp = new LoginPage(driver);
	    hp = new HomePage(driver);
	    hp.loginbtnclick();
		lp.setEmail(prop.getProperty("emailmentor"));
		lp.setPass(prop.getProperty("passwordmentor"));
		lp.login();
		

	public void testproject()throws Exception {
		HP=new HomePage(driver);
	    logobj = new LoginPage(driver);
	    HP.loginbtnClick();
		logobj.setEmail(prop.getProperty("emailmentor"));
		logobj.setPass(prop.getProperty("passwordmentor"));
		logobj.login();

	
		}

		
	}


