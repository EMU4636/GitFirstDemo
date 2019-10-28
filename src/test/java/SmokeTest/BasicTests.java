package SmokeTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import Pages.HomePage;
import Pages.SignInPage;

public class BasicTests extends BaseClass{
	
	
    HomePage homepage;	
    SignInPage signin;

	
	
	@Test
	public void homePageverify() {
		homepage = new HomePage(dr);
		homepage.verifyURL();
		homepage.verifyHomeTitle();
		homepage.verifyLogo();
		
	}
	
	@Test
	public void UserLogIn() throws InterruptedException {
		homepage = new HomePage(dr);
		signin = homepage.LogIn();
		signin.typeUserID();
		signin.typeUserPassword();
		signin.ClickForSubmit();
	}
	
	@Test
	public void searchproduct() {
		homepage = new HomePage(dr);
		homepage.searchProduct();
	}
	
	@Test
	public void searchBox() {
		homepage = new HomePage(dr);
		homepage.textBoxsize();
	}
	
		
	

}
