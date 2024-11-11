package TestCases;

import org.testng.annotations.Test;

import PageObjects.LoginPage;


public class LoginTest extends TestBase{
	LoginPage logobj=null;
	@Test
	public void testproject()throws Exception {
	    logobj = new LoginPage(driver);
	    logobj.goinUs();
		logobj.setEmail(prop.getProperty("email"));
		logobj.setPass(prop.getProperty("password"));
		logobj.login();
		
		}

		
	}


