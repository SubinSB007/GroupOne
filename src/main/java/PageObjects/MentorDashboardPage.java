package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MentorDashboardPage {
WebDriver driver;
	
	public MentorDashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
 }
	//locators 
	@FindBy(xpath ="//span[text()=\"Logout\"]") WebElement logout_btn;
	@FindBy(xpath ="//span[text()=\"Reference Materials\"]") WebElement ReferenceMaterial_btn;
	@FindBy(xpath ="//span[text()=\"Dashboard\"]") WebElement dashboard_Display;
	@FindBy(xpath ="//h6[text()=\"MERN Stack Web Development\"]//parent::div//button") WebElement mernProject_view;
	@FindBy(xpath ="//th[text()=\"Student Name\"]") WebElement subHead_Name;
	@FindBy(xpath ="//th[text()=\"Batch\"]") WebElement subHead_Topic;
	@FindBy(xpath ="//th[text()=\"Batch\"]") WebElement subHead_Batch;
	@FindBy(xpath ="//th[text()=\"Evaluation status\"]") WebElement subHead_status;
	@FindBy(xpath ="//th[text()=\"Actions\"]") WebElement subHead_Actions;
	@FindBy(xpath ="//input[@id=\"batch-combo-box\"]") WebElement batch_drop;
	@FindBy(xpath ="//li[text()=\"January-2024\"]") WebElement batch_jan;
	@FindBy(xpath ="//input[@id=\"topic-combo-box\"]") WebElement topic_drop;
	@FindBy(xpath ="//li[text()=\"Library website\"]") WebElement topic_library;
	
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
