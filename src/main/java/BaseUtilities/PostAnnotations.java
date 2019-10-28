package BaseUtilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class PostAnnotations {
	
	WebDriver dr;
	
	public PostAnnotations(WebDriver dr) {
		this.dr = dr;
	}
	
	@AfterSuite
	public void afterSuiteCloseBrowser() {
		dr.quit();
		
	}
	
	@AfterTest
	public void afterTest() {
		
	}
	
	@AfterClass
	public void afterClass() {
		
	}
	
	@AfterMethod
	public void afterMethod() {
		
	}

}
