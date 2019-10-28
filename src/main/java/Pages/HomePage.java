package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.SharedMethod;

public class HomePage {
	
	WebDriver dr;
	SharedMethod sm;
	
	public HomePage(WebDriver dr) {
		this.dr= dr;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//a[@class='Logo-u9pbds-0 eyHlXO Link-sc-1khjl8b-0 jvxzGg']")
	WebElement HomeLogo;
	
	@FindBy(xpath="//span[@class='AccountLink__SvgUserWrapper-gx13jw-0 hFdggM']")
	WebElement SignInLogo;
	
	@FindBy(id="accountNav-signIn")
	WebElement SignInLink;
	
	@FindBy(xpath="//span[text()='Sajedur Rahman']")
	WebElement UserName;
	
	@FindBy(id="headerMain")
	By TopMenuBar;
	
	@FindBy(xpath="//div[@class='h-display-inline-flex Row-uds8za-0 bxeUwG']")
	By BottomMenu;
	
	@FindBy(id="search")
	By searchBox;
	

	public void verifyHomeTitle() {
		sm = new SharedMethod(dr);
		sm.verifyTitle("Target : Expect More. Pay Less.");
	}
	
	public void verifyURL() {
		sm = new SharedMethod(dr);
		sm.verifyURL("https://www.target.com/");
	}
	
	public void verifyLogo() {
		sm = new SharedMethod(dr);
		sm.verifyIsElementDisplayed(HomeLogo);	
	}
	
	public SignInPage LogIn() throws InterruptedException {
		sm = new SharedMethod(dr);
		sm.ClickOnElement(SignInLogo);
		sm.mySleep(1500);
		sm.ClickOnElement(SignInLink);
		sm.mySleep(1500);
		return new SignInPage(dr);
		
	}
	
	
	public void verifyUserAccount() {
		sm = new SharedMethod(dr);
		sm.verifyIsElementDisplayed(UserName);
	}
	
	public void getSizeOfTopMenuBar() {
		sm = new SharedMethod(dr);
		sm.getLinkSize(TopMenuBar);
	}
	
	public void getSizeOfBottomMenuBar() {
		sm = new SharedMethod(dr);
		sm.getLinkSize(BottomMenu);
	}
	
	public void getTitleOfCategories() throws InterruptedException {
		dr.findElement(By.xpath("//a[@class='h-hidden-sm-down h-margin-l-tight HeaderMainLink-sc-1tx0dwp-0 euAKwz Link-sc-1khjl8b-0 jvxzGg']"));
	  int size = dr.findElements(By.xpath("//ul[@class='NavigationList-sc-1ltyzy8-0 iHsBIj']/li")).size();
		
	  for(int i=0; i<=size; i++) {
		  dr.findElement(By.xpath("//a[@class='h-hidden-sm-down h-margin-l-tight HeaderMainLink-sc-1tx0dwp-0 euAKwz Link-sc-1khjl8b-0 jvxzGg']")).click();
		  dr.findElement(By.xpath("//ul[@class='NavigationList-sc-1ltyzy8-0 iHsBIj']/li["+ i +"]/a")).click();
		  sm.mySleep(2500);
		 System.out.println( dr.getTitle());
		 sm.mySleep(2500);
		  dr.navigate().back();
	  }
	}
	
	public void searchProduct() {
		sm = new  SharedMethod(dr);
		sm.typeOnElement(searchBox, "Humidifier");
		dr.findElement(By.id("searchBox")).sendKeys(Keys.DOWN);
		dr.findElement(By.id("searchBox")).sendKeys(Keys.DOWN);
		System.out.println(dr.findElement(By.id("searchBox")).getText());
		
	}

		
	
	
	
	public void textBoxsize() {
		sm = new SharedMethod(dr);
		sm.getHeightAndWidthofTextBox(searchBox);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
