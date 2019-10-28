package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SharedMethod {
	
	public WebDriver dr;
	
	public SharedMethod(WebDriver dr) {
		this.dr = dr;
	}

	public void verifyURL(String expectedURL) {
		String actualURL = dr.getCurrentUrl();
		if(actualURL.contains(expectedURL)) {
			System.out.println("Right WebSite");
		}
		else {
			System.out.println("Wrong WebSite");
		}
	}
	
	public void verifyTitle(String expectedTitle) {
		String actualTitle = dr.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Title Matched");
		}
		else {
			System.out.println("Title did not Matched");
		}
	}
	
	public void ClickOnElement(WebElement element) {
		element.click();
	}
	
	public void ClickWithCondition(WebElement element) {
		if(element.isDisplayed()) {
			element.click();
		}
		else {
			System.out.println("Element is disable");
		}
	}
	
	public void verifyIsElementDisplayed(WebElement element) {
		if(element.isDisplayed()) {
			System.out.println("Element is Visiable");
		}
		else {
			System.out.println("Element not Visiable");
		}
		
	}
	
	public void typeOnElement(By a, String value) {
		//dr.findElement(textbox).clear();
		dr.findElement(a).sendKeys(value);
		
	}
	
	public void getLinkSize(By link) {
	int size = dr.findElements(link).size();
		System.out.println(size);	
	}

	public void verifyCheckBox(By checkbox) {
		System.out.println(dr.findElement(checkbox).isSelected());
	}
	
	public void mySleep(long Sceond) throws InterruptedException {
		Thread.sleep(Sceond);
	}
	
	
	
	public void getHeightAndWidthofTextBox(By by) {
	int width =	dr.findElement(by).getSize().getWidth();
	int height =	dr.findElement(by).getSize().getHeight();
	System.out.println(width);
	System.out.println(height);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
