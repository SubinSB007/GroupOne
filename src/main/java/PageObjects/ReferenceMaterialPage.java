package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReferenceMaterialPage {
WebDriver driver;
	//Constructor
	public ReferenceMaterialPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Locators
	@FindBy(xpath ="//span[text()=\"Logout\"]") WebElement logout_btn;
	@FindBy(xpath ="//h1[text()='Reference Materials']") WebElement referenceMaterialsHeader;
	@FindBy(xpath ="//div[@class=\"MuiBox-root css-irrfx6\"]//button") WebElement addReferenceMaterial_btn;
	@FindBy(xpath ="//th[text()=\"Topic\"]") WebElement refMatTopic_head;
	@FindBy(xpath ="//th[text()=\"Reference Material\"]") WebElement refMatRefMaterial_head;
	@FindBy(xpath ="//th[text()=\"Actions\"]") WebElement refMatActions_head;
	@FindBy(xpath ="//td[text()=\"Python full stack\"]//parent::tr//descendant::button") WebElement deleteButton;
	@FindBy(xpath ="//input[@id=\"topic\"]") WebElement addrefMatTopic;
	@FindBy(xpath ="//input[@id=\"referenceMaterial\"]") WebElement addrefMatMaterial;
	@FindBy(xpath = "//input[@name=\"postedDate\"]") WebElement DateReferencematerial;
	@FindBy(xpath ="//input[@id=\"url\"]") WebElement addrefMatUrl;
	@FindBy(xpath ="//input[@id=\"status\"]") WebElement addrefMatStatus;
	@FindBy(xpath ="//button[@type=\"submit\"]") WebElement submit_btn;
	@FindBy(xpath ="//button[@type=\"button\"]") WebElement cancel_btn;
		// Methods

    // Sets the date for reference material
		public void setDate(String date) {
			DateReferencematerial.sendKeys(date);
		}
		// Retrieves the current page Url
		public String refMaterialPageUrl() {
			String URL = driver.getCurrentUrl();
			return URL;
		}
		//Retrieves the current URL for the Add Reference Material page
		public String addRefMaterialPageUrl() {
			String url = driver.getCurrentUrl();
			return url; 
					
		}
		//Check  Reference Material's header is visible
	    public boolean isReferenceMaterialsHeaderVisible() {
	        return referenceMaterialsHeader.isDisplayed();
	    }
	    // Check  logout button is visible
	    public boolean isLogoutButtonVisible() {
	        return logout_btn.isDisplayed();
	    }
	    // Click the logout button
	    public void clickLogout() {
	        logout_btn.click();
	    }
	    //Check Add Reference Material button is visible
	    public boolean addrefMaterial() {
	    	boolean ad = addReferenceMaterial_btn.isDisplayed();
			return ad;
	    }
	    // Click the Add Reference Material button
	    public void addrefMaterialClick() {
	    	addReferenceMaterial_btn.click();
	    }
	    //Check  the Topic header is visible
	    public boolean refmaterialTopicVisible() {
	    	return refMatTopic_head.isDisplayed();
	    }
	    // Check the Reference Material header is visible
	    public boolean refmaterialHeadVisible() {
	    	return refMatRefMaterial_head.isDisplayed();
	    }
	    //Check  the Actions header is visible
	    public boolean refmaterialActionsVisible() {
	    	return refMatActions_head.isDisplayed();
	    }
	    // Check the delete button is enabled
	    public boolean deleteButtonEnable() {
	    	return deleteButton.isEnabled();
	    }
	    //Click the submit button
	    public void submitClick() {
	    	submit_btn.click();
	    }
	   // Click the cancel button //and returns its enabled state
	    public boolean cancelClick() {
	    	boolean e = cancel_btn.isEnabled();
	    	cancel_btn.click();
	    	return e;
	    }
	    //Enter a topic into the topic input field
	    public void enterTopic(String t) {
	    	addrefMatTopic.sendKeys(t);
	    }
	    //Enter material details into the material input field
	    public void enterMaterial(String t) {
	    	addrefMatMaterial.sendKeys(t);
	    }
	    //Enter a URL into the URL input field
	    public void enterUrl(String t) {
	    	addrefMatUrl.sendKeys(t);
	    }
	    // Enter a status into the status input field
	    public void enterStatus(String t) {
	    	addrefMatStatus.sendKeys(t);
	    }
	    // swtich to Addreference material confirmation alert
	    public String swtichToAlert() throws InterruptedException {
	    Thread.sleep(3000);
	     Alert js =driver.switchTo().alert();
	     String S = js.getText();
	     js.accept();
	     return S;
	    	
	    }
}
