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
    @FindBy (className = "btn1") WebElement loginBtn ;
    @FindBy (xpath = "//img[@class='logo']") WebElement Logo;
    @FindBy (xpath= "//H1[text()='Welcome to ICT Academy of Kerala']") WebElement  welcomeMsg;
    @FindBy (className = "btn2") WebElement joinusBtn;
    
	//methods
	public boolean loginbtnpresent() {
	return loginBtn.isDisplayed();
	
    }
	
	public boolean logodisplayed() {
		return Logo.isDisplayed();
	    }
	public String welcomemsgPresent() {
		return welcomeMsg.getText();
	    }
	public boolean joinusbtnEnable() {
		return joinusBtn.isEnabled();
	}
	public void loginbtnClick() {
		loginBtn.click();
	}
}