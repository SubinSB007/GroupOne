package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class AdminDashboardPage {
	WebDriver driver;
	JavascriptExecutor js;
	
	public AdminDashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()=\"Logout\"]") WebElement AdminLogout_btn;
	@FindBy(xpath="//span[text()='Mentors']") WebElement mentorMenuItemSide;
	@FindBy(xpath="//th[text()=\"Projects\"]") WebElement Projecthead_Projects;
	@FindBy(xpath="//th[text()=\"Duration\"]") WebElement Projecthead_Duration;
	@FindBy(xpath="//th[text()=\"Actions\"]") WebElement Projecthead_Actions;
	@FindBy(xpath="//div[@class=\"MuiBox-root css-irrfx6\"]//button") WebElement Addproject_button;
	@FindBy(xpath="//div[@role=\"dialog\"]") WebElement AddProject_dialog;
	@FindBy(xpath="//div[@role=\"dialog\"]//input[@name=\"topic\"]") WebElement TopicInput_Addproject;
	@FindBy(xpath="//div[@role=\"dialog\"]//input[@name=\"duration\"]") WebElement durationInput_Addproject;
	@FindBy(xpath="//div[@role=\"dialog\"]//button[2]") WebElement AddprojectDialog_AddBtn;
	@FindBy(xpath="//div[@role=\"dialog\"]//button[1]") WebElement AddprojectDialog_cancelBtn;
	@FindBy(xpath="//table[@aria-label=\"simple table\"]//tr") WebElement ProjectTable_rows;
	@FindBy(xpath="//table[@aria-label='simple table']//tr/th[text()=\"Sample Project\"]") WebElement getAddedproject;
	@FindBy(xpath="//table[@aria-label=\"simple table\"]//tr//td[text()='3 months']") WebElement getAddedduration;
	@FindBy(xpath="//table[@aria-label='simple table']//tr/th[text()=\"Sample Test\"]") WebElement getEditedTopic;
	@FindBy(xpath="//table[@aria-label=\"simple table\"]//tr//td[text()='5 months']") WebElement getEditedDuration;
	@FindBy(xpath="//table[@aria-label=\"simple table\"]//tr//th[text()=\"Sample Project\"]//parent ::tr//button[2]") WebElement DeleteButton;
	@FindBy(xpath="//table[@aria-label=\"simple table\"]//tr//th[text()=\"Sample Project\"]//parent ::tr//button[1]") WebElement editButton;
	
	//get current url
	public String currentAdminUrlReturn() throws InterruptedException  {
		Thread.sleep(3000);
		String url=driver.getCurrentUrl();
		return url;
	}
	//check logout button enabled
	public boolean logoutBtnEnable() {
		boolean e=AdminLogout_btn.isEnabled();
		return e;
	}
	//clicking on logout button
	public void logoutBtnClick() throws InterruptedException {
		Thread.sleep(3000);
		AdminLogout_btn.click();
	}
	//check mentor is displayed as menu item in the side bar
	public  boolean mentorMenuItemDisplay() {
		boolean d=mentorMenuItemSide.isDisplayed();
		return d;
	}
	//click on the mentor in the side bar
	public void mentorMenuItemClick() {
		mentorMenuItemSide.click();
	}
	//get the project list row number
	public int ProjectListRowNumber() {
		int row=driver.findElements(By.xpath("//table[@aria-label=\"simple table\"]//tr")).size();
		return row;
	}
	//return the added topic
	public String getAddedTopic() throws InterruptedException {
			Thread.sleep(3000);
			try{
			String topic =getAddedproject.getText();
			return topic;
			}catch(Exception e) {
				return e.getMessage();
			}	
	}
	//return the added duration
	public String getAdddedduration() throws InterruptedException {
		Thread.sleep(3000);
		try {
		String duration=getAddedduration.getText();
		return duration;
		}catch(Exception e) {
			return e.getMessage();
		}
	}
	//return the project as project list header
	public boolean projectListHeaderProjects() {
		boolean p=Projecthead_Projects.isDisplayed();
		return p;
	}
	//return the project list header duration
	public boolean projectListHeaderdurations() {
		boolean d=Projecthead_Duration.isDisplayed();
		return d;
	}
	//return the project list header actions
	public boolean projectListHeaderActions()	{
		boolean a=Projecthead_Actions.isDisplayed();
		return a;
	}
	//check add project button is visible or not
		public boolean addProjectButtonVisible() {
		boolean v =Addproject_button.isDisplayed();
		return v;
	}
	//click the add project button
	public void addProjectButtonClick() {
		Addproject_button.click();
	}
	//check add project dialog box is visible
	public boolean addProjectDialogBoxVisible() throws InterruptedException {
		Thread.sleep(3000);
		return AddProject_dialog.isDisplayed();
	}
	//check the topic field is present in the add project dialog box
	public  boolean addProjectDialogTopicPresent() {
		boolean t=TopicInput_Addproject.isDisplayed();
		return t;
	}
	//enter data to the topic field in the add project dialog box
	public void addProjectDialogTopicEnter(String topic) throws InterruptedException {
		Thread.sleep(3000);
		TopicInput_Addproject.sendKeys(topic);
	}
	//check duration field is present in the add project dialog box
	public boolean addProjectDialogDurationPresent() {
		boolean d=durationInput_Addproject.isDisplayed();
		return d;
		
	}
	//enter duration in the add topic dialog box
	public void addTopicDialogDurationEnter(String duration) {
		durationInput_Addproject.sendKeys(duration);
	}
	//click on the add button in the add project dialog box
	public void clickAddbtnAddProjectDialog() {
//		js=(JavascriptExecutor)driver;
//		 // Use JavaScript to perform a click on the element
//		  js.executeScript("arguments[0].click();", AddprojectDialog_AddBtn);
		AddprojectDialog_AddBtn.click();
	}
	//click on the cancel button in the add project dialog box and check it is enabled or not
	public boolean clickCancelbtnAddProjectDialog() {
		boolean e=AddprojectDialog_cancelBtn.isEnabled();
		AddprojectDialog_cancelBtn.click();
		return e;
		}
	//click on the delete button in the actions column
	public void projectDeleteButtonAction() throws InterruptedException {
		Thread.sleep(3000);
		js=(JavascriptExecutor)driver;
		 // Use JavaScript to perform a click on the element
		  js.executeScript("arguments[0].click();", DeleteButton);
	}
	//switch to js alert for delete button
	public String switchTodeleteProjectAlert() throws InterruptedException {
		Thread.sleep(3000);
		Alert deleteAlert=driver.switchTo().alert();
		String s=deleteAlert.getText();
		deleteAlert.accept();
		return s;
		}
	//switch to alert showing when click add with empty fields in add project
	public String switchToAdProjectdemptyAlert() throws InterruptedException {
		Thread.sleep(3000);
		Alert deleteAlert=driver.switchTo().alert();
		String s=deleteAlert.getText();
		deleteAlert.accept();
		return s;
		}
	//click on the edit button
	public void clickEditButton() throws InterruptedException {
		Thread.sleep(3000);
		js=(JavascriptExecutor)driver;
		 // Use JavaScript to perform a click on the element
		  js.executeScript("arguments[0].click();", editButton);
	}
	//edit the topic in the edit project dialog box
	public void editTopic(String topic) {
//		TopicInput_Addproject.clear();//clear the topic input field
		TopicInput_Addproject.sendKeys(Keys.CONTROL + "a");// Select all text
		TopicInput_Addproject.sendKeys(Keys.BACK_SPACE);  // Delete the selected text
		TopicInput_Addproject.sendKeys(topic);
		
	}
	//edit the duration in the edit project dialog box
	public void editDuration(String duration) {
//		durationInput_Addproject.clear();
		durationInput_Addproject.sendKeys(Keys.CONTROL + "a");
		durationInput_Addproject.sendKeys(Keys.BACK_SPACE);
		durationInput_Addproject.sendKeys(duration);
	}
	//return the edited topic
		public String getEditedTopic() throws InterruptedException {
				Thread.sleep(3000);
				try{
				String topic =getEditedTopic.getText();
				return topic;
				}catch(Exception e) {
					return e.getMessage();
				}	
		}
		//return the edited duration
		public String getEditedduration() throws InterruptedException {
			Thread.sleep(3000);
			try {
			String duration=getEditedDuration.getText();
			return duration;
			}catch(Exception e) {
				return e.getMessage();
			}
		}
	
	}
