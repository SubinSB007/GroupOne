package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;

public class HomePageTest extends TestBase{
	HomePage HP;
	@Test
	public void TC_HP_7() {
    HP=new HomePage(driver);
    boolean P= HP.loginbtnpresent();
    Assert.assertTrue(P, "login button present");
}
}
