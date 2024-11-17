package TestCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;

public class HomePageTest extends TestBase{
	HomePage hp;

<<<<<<< HEAD
	LoginPage lp;
  
=======
	LoginPage LP;
	@BeforeClass
	public void setUP() {
		HP = new HomePage(driver);
		LP = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
>>>>>>> branch 'Subin' of https://github.com/SubinSB007/GroupOne.git
	@Test (priority=1)
<<<<<<< HEAD
	public void TC_HP_7() {
		hp=new HomePage(driver);
		boolean P= hp.loginbtnpresent();
=======
	public void testLoginBtnPresent() {
		boolean P= HP.loginbtnpresent();
>>>>>>> branch 'Subin' of https://github.com/SubinSB007/GroupOne.git
		Assert.assertTrue(P, "Login button is not present");
		
	}


	@Test(priority=2)
<<<<<<< HEAD
	public void TC_HP_5() {
		hp=new HomePage(driver);
		boolean L=hp.logodisplayed();
=======
	public void testLogoIsDisplayed() {
		boolean L=HP.logodisplayed();
>>>>>>> branch 'Subin' of https://github.com/SubinSB007/GroupOne.git
		Assert.assertTrue(L, "Logo is not displayed");
		
	}

	@Test(priority=3)
<<<<<<< HEAD
	public void TC_HP_6() {
		String message = hp.welcomemsgPresent();
		Assert.assertEquals(message,"Welcome to ICT Academy of Kerala");
		System.out.println("Welcome message is present: " + message);
        Assert.assertNotNull(message, "Welcome message is missing");
        System.out.println("Welcome message is present: " + message);
=======
	public void testWelcomeMessagepresent() {
		String message = HP.welcomemsgPresent();
		Assert.assertEquals(message,"Welcome to ICT Academy of Kerala");     
>>>>>>> branch 'Subin' of https://github.com/SubinSB007/GroupOne.git
	}


	@Test(priority=4)
<<<<<<< HEAD
	public void TC_HP_3() {
		hp=new HomePage(driver);
		boolean J = hp.joinusbtnEnable();
=======
	public void testJoinUsBtnEnable() {
		boolean J = HP.joinusbtnEnable();
>>>>>>> branch 'Subin' of https://github.com/SubinSB007/GroupOne.git
		Assert.assertTrue(J, "Join us button is not present");
	}

	@Test(priority=5)
<<<<<<< HEAD
	public void TC_HP_8() {

		hp=new HomePage(driver);
		lp= new LoginPage(driver);
		hp.loginbtnClick();
		String url= lp.getUrlcurrent();
=======
	public void testLoginBtnFunctionality() {
		HP.loginbtnClick();
		String url= LP.getUrlcurrent();
>>>>>>> branch 'Subin' of https://github.com/SubinSB007/GroupOne.git
		Assert.assertEquals(url, "https://ictak-internship-portal-client.vercel.app/login");
<<<<<<< HEAD
		System.out.println("directed to login page"); 

	}

//    HP=new HomePage(driver);
//    boolean J = hp.joinusbtnEnable();
//    Assert.assertTrue(J, "Join us button is not present");
//    System.out.println("Join us button present: " + J);
//  
//    }
=======
    }
>>>>>>> branch 'Subin' of https://github.com/SubinSB007/GroupOne.git
    
}
