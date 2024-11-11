package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MentorDashboardPage {
WebDriver driver;
	
	public MentorDashboardPage(WebDriver driver) {
		this.driver=driver;
	}
	//locators
		 WebElement logout_btn = driver.findElement(By.xpath("//span[text()=\"Logout\"]"));
		 WebElement ReferenceMaterial_btn = driver.findElement(By.xpath("//span[text()=\"Reference Materials\"]"));
		 WebElement dashboard_Display = driver.findElement(By.xpath("//span[text()=\"Dashboard\"]"));
		 WebElement mernProject_view = driver.findElement(By.xpath("//h6[text()=\"MERN Stack Web Development\"]//parent::div//button"));
		 WebElement subHead_Name = driver.findElement(By.xpath("//th[text()=\"Student Name\"]"));
		 WebElement subHead_Batch = driver.findElement(By.xpath("//th[text()=\"Batch\"]"));
		 WebElement subHead_Topic = driver.findElement(By.xpath("//th[text()=\"Topic\"]"));
		 WebElement subHead_status = driver.findElement(By.xpath("//th[text()=\"Evaluation status\"]"));
		 WebElement subHead_Actions = driver.findElement(By.xpath("//th[text()=\"Actions\"]")); 
		 WebElement batch_drop = driver.findElement(By.xpath("//input[@id=\"batch-combo-box\"]")); 
		 WebElement batch_jan = driver.findElement(By.xpath("//li[text()=\"January-2024\"]"));
		 WebElement topic_drop = driver.findElement(By.xpath("//input[@id=\"topic-combo-box\"]"));
		 WebElement topic_library = driver.findElement(By.xpath("//li[text()=\"Library website\"]"));
		 // methods
		 public boolean dashboardTextDisplay() {
			boolean d=  dashboard_Display.isDisplayed();
			return d;
		 }
		  public boolean logoutVisible() {
			  boolean d = logout_btn.isDisplayed();
			return d;
		  }
		  public void logoutClick() {
			  logout_btn.click();
		  }
		  public boolean  referenceMaterialVisible() {
			  boolean d= ReferenceMaterial_btn.isDisplayed();
			  return d;
		  }
		  public void referenceMaterialClick() {
			  ReferenceMaterial_btn.click();
		  }
		  public void projectSubmitView() {
			  mernProject_view.click();
		  }
		  public boolean subHeadName() {
			  boolean n = subHead_Name.isDisplayed();
			return n;
		  }
		  public boolean subHeadBatch() {
			  boolean b = subHead_Batch.isDisplayed();
			return b;
		  }
		  public boolean subHeadTopic() {
			  boolean t = subHead_Topic.isDisplayed();
			return t;
		  }
		  public boolean subHeadStatus() {
			  boolean s = subHead_status.isDisplayed();
			return s;
		  }
		  public boolean subHeadAction() {
			  boolean a = subHead_Actions.isDisplayed();
			return a;
		  }
		  public void batchBoxClick() {
			  batch_drop.click();
		  }
		  public void batchJanDropClick() {
			  batch_jan.click();
		  }
		  public void topicBoxClick() {
			  topic_drop.click();
		  }
		  public void topicLibrarayClick() {
			  topic_library.click();
		  }
		  public String  getSelectedBatch() {
			  try {
				 return batch_drop.getAttribute("value");
			  }
			  catch(Exception e) {
				  return e.getMessage();
			  }
		  }
		  public String getSelectTopic() {
			  try {
				  return topic_drop.getAttribute("value");
			  }
			  catch(Exception e) {
				  return e.getMessage();
			  }
		  }

}
