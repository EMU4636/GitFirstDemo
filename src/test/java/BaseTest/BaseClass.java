package BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import BaseUtilities.PostAnnotations;
import BaseUtilities.PreAnnotations;
import Pages.HomePage;

public class BaseClass {
	
	public WebDriver dr;
	PreAnnotations preAnn;
	PostAnnotations postAnn;
	
	/*public BaseClass(WebDriver dr) {
		this.dr =dr;
	}*/
	
	
     /*@Parameters({"browser"})
	public void openBrowser() {
		preAnn = new PreAnnotations(dr);
		//preAnn.beforeSuiteOpenBrowser("browser");
		preAnn.beforeSuiteOpenBrowser();
		//this method did not work
	}*/
	
	/*@BeforeSuite
	public void beforeSuiteOpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\13474\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//This method worked
	}*/
	
	/*public void getWebSite() {
		preAnn = new PreAnnotations(dr);
		//preAnn.beforeClass("https://www.target.com");
		preAnn.beforeMethod("https://www.target.com");
		//this method did not work
	}*/
	
	/*public void closeBrowser() {
		postAnn = new PostAnnotations(dr);
		postAnn.afterSuiteCloseBrowser();
		//this method did not work
	}*/
	
	@BeforeMethod
	public HomePage beforeMethodGetWebSite() {
		dr.get("https://www.target.com");
		return new HomePage(dr);
		//This method worked
	}
	
	   /* @Parameters({"browser"})
		@BeforeSuite
		public void beforeSuiteOpenBrowser(String bwsr) {
	    	
			if(bwsr.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\13474\\Downloads\\geckodriver-master (1)\\firefoxdriver.exe");
				dr = new FirefoxDriver();
			}
			else if(bwsr.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\13474\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
				dr = new ChromeDriver();	
			}	
			
			dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//this one did not work
		}*/
	
	
	@BeforeSuite
	public void dynamicOpenBrowser() throws IOException {
		
		Properties prop= new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\13474\\eclipse-workspace\\TestNGEnd2EndProject\\data.properties");
		
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\13474\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			dr = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\13474\\Downloads\\geckodriver-master (1)\\firefoxdriver.exe");
			dr = new FirefoxDriver();	
		}
		
		else if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\13474\\Downloads\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			dr = new InternetExplorerDriver();
		}
		
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//this method worked
		//need to fix FirefoxDriver and IE driver
	}
	
	@AfterSuite
	public void closeBrowser() {
		dr.quit();
	}
	
	
	
	

}
