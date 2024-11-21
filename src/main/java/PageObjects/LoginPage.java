package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
 
 public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
 @FindBy(xpath="//input[@name='email']") WebElement email;
 @FindBy(xpath="//input[@name='password']") WebElement pass;
 @FindBy(xpath="//button[@type='submit']") WebElement log;
 
 public String getUrlcurrent() throws InterruptedException {
	 Thread.sleep(3000);
	String url=driver.getCurrentUrl();
	 return url;
	 
 }
	public void setEmail(String emailid)
	{
	
	email.sendKeys(emailid);
	}
    public void setPass(String password)
    {
    	
    pass.sendKeys(password);
    }
    public void login()
    {
    	
    	log.click();
    }
	
	
}
