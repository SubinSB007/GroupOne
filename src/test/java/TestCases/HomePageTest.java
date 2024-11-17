package TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;

public class HomePageTest extends TestBase{
	HomePage HP;

	LoginPage LP;
	@BeforeClass
	public void setUP() {
		HP = new HomePage(driver);
		LP = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	@Test (priority=1)
	public void testLoginBtnPresent() {
		boolean P= HP.loginbtnpresent();
		Assert.assertTrue(P, "Login button is not present");
		
	}


	@Test(priority=2)
	public void testLogoIsDisplayed() {
		boolean L=HP.logodisplayed();
		Assert.assertTrue(L, "Logo is not displayed");
		
	}

	@Test(priority=3)
	public void testWelcomeMessagepresent() {
		String message = HP.welcomemsgPresent();
		Assert.assertEquals(message,"Welcome to ICT Academy of Kerala");     
	}


	@Test(priority=4)
	public void testJoinUsBtnEnable() {
		boolean J = HP.joinusbtnEnable();
		Assert.assertTrue(J, "Join us button is not present");
	}

	@Test(priority=5)
	public void testLoginBtnFunctionality() {
		HP.loginbtnClick();
		String url= LP.getUrlcurrent();
		Assert.assertEquals(url, "https://ictak-internship-portal-client.vercel.app/login");
    }
    
}
