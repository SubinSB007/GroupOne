package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MentorListPage {
WebDriver driver;
WebDriverWait mywait;
	public MentorListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Dashboard']") WebElement DashboardMenuItemSide;
	@FindBy(xpath="//table[@aria-label=\"simple table\"]//thead//th[1]") WebElement MentorListHead_mentors;
	@FindBy(xpath="//table[@aria-label=\"simple table\"]//thead//th[2]") WebElement mentorListHead_Email;
	@FindBy(xpath="//table[@aria-label=\"simple table\"]//thead//th[3]") WebElement mentorListHead_phone;
	@FindBy(xpath="//table[@aria-label=\"simple table\"]//thead//th[4]") WebElement mentorListHead_Topics;
	@FindBy(xpath="//table[@aria-label=\"simple table\"]//thead//th[5]") WebElement mentorListHead_Actions;
	@FindBy(xpath="//div[@class=\"MuiBox-root css-irrfx6\"]//button") WebElement addMentorButton;
	@FindBy(xpath="//div[@role=\"dialog\"]//input[@name=\"name\"]") WebElement addMentor_nameField;
	@FindBy(xpath="//div[@role=\"dialog\"]//input[@name=\"email\"]") WebElement addMentor_emailField;
	@FindBy(xpath="//div[@role=\"dialog\"]//input[@name=\"phone\"]") WebElement addMentor_phonefield;
	@FindBy(xpath="//div[@role=\"dialog\"]//input[@name=\"password\"]") WebElement addMentor_passwordfield;
	@FindBy(xpath="//div[@role=\"dialog\"]//input[@role=\"combobox\"]") WebElement addMentor_ProjectTopicField;
	@FindBy(xpath="//ul[@role=\"listbox\"]//li[text()=\"Sample Project\"]") WebElement addmentor_TopicList_TopicSelect;
	@FindBy(xpath="//div[@role=\"dialog\"]//div[@class=\"MuiDialogActions-root MuiDialogActions-spacing css-1vskg8q\"]//button[2]") WebElement AddButton_AddMentorDialog;
	@FindBy(xpath="//div[@role=\"dialog\"]//div[@class=\"MuiDialogActions-root MuiDialogActions-spacing css-1vskg8q\"]//button[1]") WebElement CancelButton_AddMentorDialog;
	@FindBy(xpath="//ul[@role=\"listbox\"]//li") List <WebElement> ProjectList_AddMentorDropDown; 
	@FindBy(xpath="//table[@aria-label=\"simple table\"]//tbody//th") List <WebElement> Mentor_names;
	
	
	//return mentor list page url
	public String currentUrlReturn() {
		String url=driver.getCurrentUrl();
		return url;
	}
	
	//click on the Dashboard in menu item side bar
	public void clickDashboardSidebar() {
		DashboardMenuItemSide.click();
	}
	
	//return mentor list header mentor text
	public String mentorListheadMentorText() {
		String m=MentorListHead_mentors.getText();
		return m;
	}
	
	//return mentor list header email text
	public String mentorListHeadEmailText() {
		String e=mentorListHead_Email.getText();
		return e;
	}
	
	//return mentor list header phone text
	public String mentorListHeadphoneText() {
		String t=mentorListHead_phone.getText();
		return t;
	}
	
	//return mentor list head topics text
	public String mentorListHeadTopicsText() {
		String t=mentorListHead_Topics.getText();
		return t;
	}
	
	//return mentor list head actions
	public String mentorListHeadActionText() {
		String a=mentorListHead_Actions.getText();
		return a;
	}
	
	//check add mentor button is visible
	public boolean addMentorbtnVisible() {
		boolean v=addMentorButton.isDisplayed();
		return v;
	}
	
	//click add mentor button functionality
	public void clickAddMentorButton() throws InterruptedException {
		Thread.sleep(5000);
		addMentorButton.click();
	}
	
	//check name field in add mentor dialog box is visible
	public boolean checkNamefieldVisible() {
		boolean n=addMentor_nameField.isDisplayed();
		return n;
	}
	
	//check email field in add mentor dialog box is visible
	public boolean checkEmailFieldVisible() {
		boolean e=addMentor_emailField.isDisplayed();
		return e;
	}
	
	//check phone field in add mentor dialog box is visible
	public boolean checkPhoneFieldVisible() {
		boolean p=addMentor_phonefield.isDisplayed();
		return p;
	}
	
	//check password field in add mentor dialog box is visible
	public boolean checkPasswordfieldvisible() {
		boolean p=addMentor_passwordfield.isDisplayed();
		return p;
	}
	
	//check topic field is visible in the add mentor dialog box
	public boolean checkTopicFieldVisible() {
		boolean t=addMentor_passwordfield.isDisplayed();
		return t;
	}
	
	//enter name in name field in add mentor dialog box
	public void enterNameAddMentorDialog(String name) {
		addMentor_nameField.sendKeys(name);
	}
	
	//enter email in email field in add mentor dialog box
	public void enterEmailAddMentorDialog(String email) {
		addMentor_emailField.sendKeys(email);
	}
	
	//enter phone number in add mentor dialog box
	public void enterPhoneFieldAddMentorDialog(String phone) {
		addMentor_phonefield.sendKeys(phone);
	}
	
	//enter password in add mentor dialog box
	public void enterPasswordAddMentorDialog(String password) {
		addMentor_passwordfield.sendKeys(password);
	}
	
	//enter topic in add mentor dialog box
	public void enterTopicAddMentorDialog(String topic) {
		addMentor_ProjectTopicField.sendKeys(topic +Keys.ARROW_DOWN +Keys.ENTER);
		
	}
	
	//return added project from the topic drop down in add mentor dialog box
	public int checkAddedProjectTopicdropDown(String topic) {
		addMentor_ProjectTopicField.click();
		int flag=0;
		for(WebElement x:ProjectList_AddMentorDropDown) {
			String n=x.getText();
			if(n.equals(topic)) {
				flag++;
				break;
			}
		}
		return flag;
	}
	
	//click the add button in add mentor dialog box
	public void clickAddbtnAddDialogBox() {
		AddButton_AddMentorDialog.click();
	}
	
	//Check mentor is added to the mentor list
	public int checkMentorIsAdded(String name) throws InterruptedException {
		Thread.sleep(2000);
		int flag=0;
		for(WebElement x:Mentor_names) {
			String n=x.getText();
			if(n.equals(name)) {
				flag++;
				break;
			}
		}
		return flag;
	}
	
	//click cancel button in add mentor dialog box
	public void clickCancelBtnAddDialogBox() {
		CancelButton_AddMentorDialog.click();
	}
	//Switch to add mentor warning dialog box
	 public String addMentorWarningAlert() {
		 mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		 Alert myalert=mywait.until(ExpectedConditions.alertIsPresent());
		 String s=myalert.getText();
		 myalert.accept();
		 return s;
	 }
}
