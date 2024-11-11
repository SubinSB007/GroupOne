package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReferenceMaterialPage {
WebDriver driver;
	
	public ReferenceMaterialPage(WebDriver driver) {
		this.driver=driver;
	}
	    WebElement logout_btn = driver.findElement(By.xpath("//span[text()='Logout']"));
	    WebElement referenceMaterialsHeader = driver.findElement(By.xpath("//h1[text()='Reference Materials']"));
	    WebElement addReferenceMaterial_btn = driver.findElement(By.xpath("//button[text()='+ ADD REFERENCE MATERIAL']"));
	    WebElement refMatTopic_head = driver.findElement(By.xpath("//th[text()=\"Topic\"]"));
	    WebElement refMatRefMaterial_head = driver.findElement(By.xpath("//th[text()=\"Reference Material\"]"));
	    WebElement refMatActions_head = driver.findElement(By.xpath("//th[text()=\"Actions\"]"));
	    WebElement deleteButton = driver.findElement(By.xpath("//td[text()=\"Python full stack\"]//parent::tr//descendant::button"));
	    WebElement addrefMatTopic = driver.findElement(By.xpath("//input[@id=\"topic\"]"));
	    WebElement addrefMatMaterial = driver.findElement(By.xpath("id=\"referenceMaterial\""));
	    WebElement addrefMatUrl = driver.findElement(By.xpath("//input[@id=\"url\"]"));
	    WebElement addrefMatStatus = driver.findElement(By.xpath("//input[@id=\"status\"]"));
	    WebElement submit_btn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
	    WebElement cancel_btn = driver.findElement(By.xpath("//button[@type=\"button\"]"));
	     
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
