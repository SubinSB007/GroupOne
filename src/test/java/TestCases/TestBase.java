package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class TestBase {
	WebDriver driver;
	Properties prop;
	public Logger logger;
	
	public void readProp() throws IOException {
		prop=new Properties();
		FileInputStream fileIn=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	   prop.load(fileIn);
	}
	
	
	@SuppressWarnings("deprecation")
	@BeforeClass(groups = {"sanity", "regression"})
	 @Parameters({"Browser","OS"}) // Here we specify that the "Browser" parameter will be passed to this method
	public void testSetUp(String browser,String os) throws InterruptedException, IOException {
//    public void testSetUp() throws InterruptedException, IOException { //use while executing test directly in test class
		 logger=LogManager.getLogger(this.getClass());
		 readProp();
//		String browser=prop.getProperty("browser");
		//Remote execution
			if (prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
			    DesiredCapabilities capabilities = new DesiredCapabilities();
	
			    // os
			    if (os.equalsIgnoreCase("windows")) {
			        capabilities.setPlatform(Platform.WIN10);
			    } else if (os.equalsIgnoreCase("mac")) {
			        capabilities.setPlatform(Platform.MAC);
			    } else if(os.equalsIgnoreCase("Linux")) {
			    	capabilities.setPlatform(Platform.LINUX);
			    }else {
			        System.out.println("No matching os");
			        return;
			    }
	
			    // browser
			    switch (browser.toLowerCase()) {
			        case "chrome":
			            capabilities.setBrowserName("chrome");
			            break;
			        case "edge":
			            capabilities.setBrowserName("MicrosoftEdge");
			            break;
			        case "firefox":
			        	capabilities.setBrowserName("firefox");
			        break;
			        default:
			            System.out.println("No matching browser");
			            return;
			    }
	
			    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			}
			
			//local execution
			if (prop.getProperty("execution_env").equalsIgnoreCase("local")) {	
		switch(browser.toLowerCase()){
			case "chrome":
				driver=new ChromeDriver();
				break;
			case "firefox":
				driver=new FirefoxDriver();
				break;
			case "edge":
				driver=new EdgeDriver();
				break;
			default:
				System.out.println("Invalid browser name");
				return;
		}
			}
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
	
	}
	
	
	@AfterClass(groups= {"sanity","regression"})
	public void tearDown() {
		driver.quit();
	}
	

}
