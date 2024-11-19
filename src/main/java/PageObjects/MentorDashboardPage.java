package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
	//get current url
		public String currentMentorUrlReturn() throws InterruptedException {
			Thread.sleep(3000);
			String url=driver.getCurrentUrl();
			return url;
		}

		 // methods 
	//check Dashboard text is displayed

		 public boolean dashboardTextDisplay() {
			boolean d=  dashboard_Display.isDisplayed();
			return d;
		 }
		 //check logout button is  visible
		  public boolean logoutVisible() throws InterruptedException {
			  Thread.sleep(3000);
			  boolean d = logout_btn.isDisplayed();
			  return d;
		  }

		  public void logoutClick() throws InterruptedException {
			  Thread.sleep(3000);

		  //click logout button
		  public void logoutClick() {

			  logout_btn.click();
		  }
		  //Check reference material button is visible.
		  public boolean  referenceMaterialVisible() {
			  boolean d= ReferenceMaterial_btn.isDisplayed();
			  return d;
		  }
		  // Click the reference material button.
		  public void referenceMaterialClick() {
			  ReferenceMaterial_btn.click();
		  }
		  // Click the 'View' button for the MERN Stack Web Development.
		  public void projectSubmitView() {
			  mernProject_view.click();
		  }
		  //Check  the subheading is displayed.
		  public boolean subHeadName() {
			  boolean n = subHead_Name.isDisplayed();
			return n;
		  }
		  //Check  'Batch' subheading is displayed.
		  public boolean subHeadBatch() {
			  boolean b = subHead_Batch.isDisplayed();
			return b;
		  }
		  //Check   'Topic' subheading is displayed.
		  public boolean subHeadTopic() {
			  boolean t = subHead_Topic.isDisplayed();
			return t;
		  }
		  //Check   'Evaluation Status' subheading is displayed.
		  public boolean subHeadStatus() {
			  boolean s = subHead_status.isDisplayed();
			return s;
		  }
		  //Check if the 'Actions' subheading is displayed.
		  public boolean subHeadAction() {
			  boolean a = subHead_Actions.isDisplayed();
			return a;
		  }
		  //Click the batch dropdown.
		  public void batchBoxClick() throws InterruptedException {
			  
			  Thread.sleep(3000);
			  batch_drop.click();
		  }
		  //Select 'January-2024' from the batch dropdown.
		  public void batchJanDropClick() {
			  getBatch_jan().click();
		  }
		  //Click the topic dropdown.
		  public void topicBoxClick() {
			  topic_drop.click();
		  }
		  // Select 'Library Website' from the topic dropdown.
		  public void topicLibrarayClick() {
			  topic_library.click();
		  }
		  //Get the currently selected batch value.
		  public String  getSelectedBatch() {
			  try {
				  String S = batch_drop.getAttribute("value");
				  return S;			
				 }
			  catch(Exception e) {
				  return e.getMessage();
			  }
		  }
		  //Get the currently selected topic value.
		  public String getSelectTopic() {
			  try {
				  return topic_drop.getAttribute("value");
			  }
			  catch(Exception e) {
				  return e.getMessage();
			  }
		  }
		  // Get the 'batch_jan' Webelement
		public WebElement getBatch_jan() {
			return batch_jan;
		}
		// Set 'batch_jan' Webelement
		public void setBatch_jan(WebElement batch_jan) {
			this.batch_jan = batch_jan;
		}
		  


}
