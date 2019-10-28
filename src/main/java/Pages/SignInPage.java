package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Common.DataDrivenClass;
import Common.SharedMethod;

public class SignInPage {
	
	public WebDriver dr;
	SharedMethod sm;
	
	public SignInPage(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(id="username")
	By userBox;
	
	@FindBy(id="password")
	By passBox;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	
	/*(dataProviderClass= DataDrivenClass.class, dataProvider="getData")
	public void typeUserID(String userID, String userPassword) throws InterruptedException {
		sm = new SharedMethod(dr);
		sm.typeOnElement(userBox, "userID");
		sm.mySleep(1000);
		sm.typeOnElement(passBox, userPassword);
		sm.mySleep(2000);
		sm.ClickOnElement(submitButton);
		
		//Must need with Annotations to run DataProvider
	}*/
	
	public void typeUserID() throws InterruptedException {
		sm = new SharedMethod(dr);
		sm.typeOnElement(userBox, "sajedur99_emu@yahoo.com");
		sm.mySleep(2000);
	}

	public void typeUserPassword() throws InterruptedException {
		sm = new SharedMethod(dr);
		sm.typeOnElement(passBox, "Selenium");
		sm.mySleep(2000);
	}
	
	public HomePage ClickForSubmit() throws InterruptedException {
		sm = new SharedMethod(dr);
		sm.ClickOnElement(submitButton);
		sm.mySleep(2000);
		return new HomePage(dr);
	}

	
	
}
