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
 @FindBy(xpath="//a[text()=\"Don’t have an account yet? Sign Up Now\"]") WebElement signup_btn;
 
 
 //get the url
 public String getUrlcurrent() throws InterruptedException {
	 Thread.sleep(3000);
	String url=driver.getCurrentUrl();
	 return url;
	 }
 
 //enter email in email box
	public void setEmail(String emailid){
	email.sendKeys(emailid);
	}
	
	//enter password in the password box
    public void setPass(String password){
    	
    pass.sendKeys(password);
    }
    
    //click login button
    public void login(){
    	
    	log.click();
    }
    
    //navigate back to home page
    public void navigateBack() {
    	driver.navigate().back();
    }
    
    //check sign up button is enabled
	public boolean testSignupEnabled() {
		boolean t=signup_btn.isEnabled();
		return t;
	}
	
}
