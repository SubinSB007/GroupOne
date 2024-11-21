package TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;

public class HomePageTest extends TestBase{
	HomePage hp;
	LoginPage lp;
  
	LoginPage LP;
	@BeforeClass
	public void setUP() {
		hp = new HomePage(driver);
		LP = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	
	@Test (priority=1)
	public void testLoginBtnPresent() {
		boolean P= hp.loginbtnpresent();
		Assert.assertTrue(P, "Login button is not present");
		
	}


	@Test(priority=2)
	public void testLogoIsDisplayed() {
		boolean L=hp.logodisplayed();
		Assert.assertTrue(L, "Logo is not displayed");
		
	}

	@Test(priority=3)
	public void testWelcomeMessagepresent() {
		String message = hp.welcomemsgPresent();
		Assert.assertEquals(message,"Welcome to ICT Academy of Kerala");     
	}


	@Test(priority=4)
	public void testJoinUsBtnEnable() {
		boolean J = hp.joinusbtnEnable();
		Assert.assertTrue(J, "Join us button is not present");
	}

	@Test(priority=5)
	public void testLoginBtnFunctionality() {
		hp.loginbtnClick();
		String url= LP.getUrlcurrent();
		Assert.assertEquals(url, "https://ictak-internship-portal-client.vercel.app/login");
		System.out.println("directed to login page"); 

	}
    
}
