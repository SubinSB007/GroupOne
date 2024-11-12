package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReferenceMaterialPage {
WebDriver driver;
	
	public ReferenceMaterialPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//span[text()=\"Logout\"]") WebElement logout_btn;
	@FindBy(xpath ="//h1[text()='Reference Materials']") WebElement referenceMaterialsHeader;
	@FindBy(xpath ="//div[@class=\"MuiBox-root css-irrfx6\"]//button") WebElement addReferenceMaterial_btn;
	@FindBy(xpath ="//th[text()=\"Topic\"]") WebElement refMatTopic_head;
	@FindBy(xpath ="//th[text()=\"Reference Material\"]") WebElement refMatRefMaterial_head;
	@FindBy(xpath ="//th[text()=\"Actions\"]") WebElement refMatActions_head;
	@FindBy(xpath ="//td[text()=\"Python full stack\"]//parent::tr//descendant::button") WebElement deleteButton;
	@FindBy(xpath ="//input[@id=\"topic\"]") WebElement addrefMatTopic;
	@FindBy(xpath ="//input[@id=\"referenceMaterial\"]") WebElement addrefMatMaterial;
	@FindBy(xpath ="//input[@id=\"url\"]") WebElement addrefMatUrl;
	@FindBy(xpath ="//input[@id=\"status\"]") WebElement addrefMatStatus;
	@FindBy(xpath ="//button[@type=\"submit\"]") WebElement submit_btn;
	@FindBy(xpath ="//button[@type=\"button\"]") WebElement cancel_btn;
	
	    public boolean isReferenceMaterialsHeaderVisible() {
	        return referenceMaterialsHeader.isDisplayed();
	    }

	    public boolean isLogoutButtonVisible() {
	        return logout_btn.isDisplayed();
	    }

	    public void clickLogout() {
	        logout_btn.click();
	    }
	    public boolean addrefMaterial() {
	    	boolean ad = addReferenceMaterial_btn.isDisplayed();
			return ad;
	    }
	    public void addrefMaterialClick() {
	    	addReferenceMaterial_btn.click();
	    }
	    public boolean refmaterialTopicVisible() {
	    	return refMatTopic_head.isDisplayed();
	    }
	    public boolean refmaterialHeadVisible() {
	    	return refMatRefMaterial_head.isDisplayed();
	    }
	    public boolean refmaterialActionsVisible() {
	    	return refMatActions_head.isDisplayed();
	    }
	    public boolean deleteButtonEnable() {
	    	return deleteButton.isEnabled();
	    }
	    public void submitClick() {
	    	submit_btn.click();
	    }
	    public void cancelClick() {
	    	cancel_btn.click();
	    }
	    public void enterTopic(String t) {
	    	addrefMatTopic.sendKeys(t);
	    }
	    public void enterMaterial(String t) {
	    	addrefMatMaterial.sendKeys(t);
	    }
	    public void enterUrl(String t) {
	    	addrefMatUrl.sendKeys(t);
	    }
	    public void enterStatus(String t) {
	    	addrefMatStatus.sendKeys(t);
	    }
}
