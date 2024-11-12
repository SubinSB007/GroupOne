package TestCases;

import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;


public class LoginTest extends TestBase{
	HomePage HP;
	LoginPage logobj=null;
	@Test
	public void testproject()throws Exception {
		HP=new HomePage(driver);
	    logobj = new LoginPage(driver);
	    HP.loginbtnClick();
		logobj.setEmail(prop.getProperty("emailmentor"));
		logobj.setPass(prop.getProperty("passwordmentor"));
		logobj.login();
	
		}

		
	}


