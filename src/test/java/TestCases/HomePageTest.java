package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;

public class HomePageTest extends TestBase{
	HomePage HP;

	LoginPage LP;
  
	@Test (priority=1)
	public void TC_HP_7() {
		HP=new HomePage(driver);
		boolean P= HP.loginbtnpresent();
		Assert.assertTrue(P, "Login button is not present");
		System.out.println("Login button present: " + P);
	}


	@Test(priority=2)
	public void TC_HP_5() {
		HP=new HomePage(driver);
		boolean L=HP.logodisplayed();
		Assert.assertTrue(L, "Logo is not displayed");
		System.out.println("Logo icon present: " + L);
	}

	@Test(priority=3)
	public void TC_HP_6() {
		String message = HP.welcomemsgPresent();
		Assert.assertEquals(message,"Welcome to ICT Academy of Kerala");
		System.out.println("Welcome message is present: " + message);
        Assert.assertNotNull(message, "Welcome message is missing");
        System.out.println("Welcome message is present: " + message);
	}


	@Test(priority=4)
	public void TC_HP_3() {
		HP=new HomePage(driver);
		boolean J = HP.joinusbtnEnable();
		Assert.assertTrue(J, "Join us button is not present");
		System.out.println("Join us button present: " + J);

	}

	@Test(priority=5)
	public void TC_HP_8() throws InterruptedException {

		HP=new HomePage(driver);
		LP= new LoginPage(driver);
		HP.loginbtnClick();
		String url= LP.getUrlcurrent();
		Assert.assertEquals(url, "https://ictak-internship-portal-client.vercel.app/login");
		System.out.println("directed to login page"); 

	}
//
//    HP=new HomePage(driver);
//    boolean J = HP.joinusbtnEnable();
//    Assert.assertTrue(J, "Join us button is not present");
//    System.out.println("Join us button present: " + J);
//  
//    }
    
}
