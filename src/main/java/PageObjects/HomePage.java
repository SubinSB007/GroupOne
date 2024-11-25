package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	//locators
    @FindBy (xpath="//button[@class=\"btn1\"]") WebElement loginBtn ;
    @FindBy (xpath = "//img[@class='logo']") WebElement Logo;
    @FindBy (xpath= "//H1[text()='Welcome to ICT Academy of Kerala']") WebElement  welcomeMsg;
    @FindBy (xpath="//button[@class=\"btn2\"]") WebElement joinusBtn;
    
	//methods
    
    //check login button is present
	public boolean loginbtnpresent() {
	return loginBtn.isDisplayed();
	
    }
	
	//check logo is displayed
	public boolean logodisplayed() {
		return Logo.isDisplayed();
	    }
	
	//check welcome message is present
	public String welcomemsgPresent() {
		return welcomeMsg.getText();
	    }
	
	//check join us button is enabled
	public boolean joinusbtnEnable() {
		return joinusBtn.isEnabled();
	}
	
	//click the login button
	public void loginbtnClick() {
		loginBtn.click();
	}
}