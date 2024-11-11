package TestCases;

import org.testng.annotations.Test;

import PageObjects.LoginPage;


public class LoginTest extends TestBase{
	LoginPage logobj=null;
	@Test
	public void testproject()throws Exception {
	    logobj = new LoginPage(driver);
		logobj.setEmail(prop.getProperty("emailmentor"));
		logobj.setPass(prop.getProperty("passwordmentor"));
		logobj.login();
	
		}

		
	}


