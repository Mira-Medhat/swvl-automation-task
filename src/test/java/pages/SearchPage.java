package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SearchPage {
	public AppiumDriver driver;
	public SearchPage(AppiumDriver driver) {
		this.driver=driver;
	}
	@FindBy (id = "got_it_tv")
	public MobileElement gotItBtn;
	
	@FindBy (id = "where_to")
	public MobileElement whereTo;
	
	@FindBy (id = "home_icon")
	public MobileElement homeAddressBtn;
	
	@FindBy (id = "work_icon")
	public MobileElement workAddressBtn;
	
	@FindBy (id = "add_quick_destination_icon")
	public MobileElement addQuickAddressBtn;

public BookPage beginSearch() {
		
		if (driver.findElements(By.id("got_it_tv")).size() != 0) {
			gotItBtn.click();
		}
		return new BookPage(driver);
}
}
