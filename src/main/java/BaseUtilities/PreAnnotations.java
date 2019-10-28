package BaseUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Pages.HomePage;

public class PreAnnotations {
	
	WebDriver dr;
	
	public PreAnnotations(WebDriver dr) {
		this.dr = dr;
	}
	
	
	
    /*@Parameters({"browser"})
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
	}*/
	@BeforeSuite
	public void beforeSuiteOpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\13474\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	@BeforeTest
	public HomePage beforeTest(String url) {
		dr.get(url);
		return new HomePage(dr);
		
	}
	
	

	@BeforeClass
	public void beforeClass(String url) {
		dr.get(url);
	}
	
	@BeforeMethod
	public HomePage beforeMethod(String URL) {
		dr.get(URL);
		return new HomePage(dr);
		
	}
	
	@BeforeGroups
	public void beforeGroups() {
		
	}
	

}
