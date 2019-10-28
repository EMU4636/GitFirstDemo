package Common;

import org.testng.annotations.DataProvider;

public class DataDrivenClass {
	
	@DataProvider
	public void getData() {
		
		Object[][] data= new Object[1][2];
		data[0][0]="sajedur99_emu@yahoo.com";
		data[0][1]="Selenium";
		
	}

}
