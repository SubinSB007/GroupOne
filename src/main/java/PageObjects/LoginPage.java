package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
WebDriver driver;
 
 public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
 public void goinUs() {
		WebElement log=driver.findElement(By.xpath("//button[@class='btn1']"));
 	log.click();	
	}
	public void setEmail(String emailid)
	{
	WebElement email =driver.findElement(By.xpath("//input[@name='email']"));
	email.sendKeys(emailid);
	}
    public void setPass(String password)
    {
    WebElement pass=driver.findElement(By.xpath("//input[@name='password']"));	
    pass.sendKeys(password);
    }
    public void login()
    {
    	WebElement log=driver.findElement(By.xpath("//button[@type='submit']"));
    	log.click();
    }
	
	
}
