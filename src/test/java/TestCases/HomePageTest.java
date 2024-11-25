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


	@Test (priority=1,groups= {"sanity","regression"})
	public void testLoginBtnPresent() {
		hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		boolean P= hp.loginbtnpresent();
		Assert.assertTrue(P, "Login button is not present");
		
	}


	@Test(priority=2,groups= {"sanity","regression"})
	public void testLogoIsDisplayed() {
		hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		boolean L=hp.logodisplayed();
		Assert.assertTrue(L, "Logo is not displayed");
		
	}

	@Test(priority=3,groups= {"sanity","regression"})
	public void testWelcomeMessagepresent() {
		hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String message = hp.welcomemsgPresent();
		Assert.assertEquals(message,"Welcome to ICT Academy of Kerala");     
	}


	@Test(priority=4,groups= {"sanity","regression"})
	public void testJoinUsBtnEnable() {
		hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		boolean J = hp.joinusbtnEnable();
		Assert.assertTrue(J, "Join us button is not present");
	}

	@Test(priority=5,groups= {"sanity","regression"})
	public void testLoginBtnFunctionality() throws InterruptedException {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		hp.loginbtnClick();
		String url= lp.getUrlcurrent();
		Assert.assertEquals(url, prop.getProperty("loginpageurl"));

	}


    }


