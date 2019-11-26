package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SideMenuPage {
	
	public AppiumDriver driver;

	public SideMenuPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(id = "menu_iv")
	public MobileElement sideMenu;
	
	@FindBy(xpath = "//android.widget.CheckedTextView")
	public MobileElement yourTrips;
	
	public MyTrips getBookingPage() {
		
		sideMenu.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
yourTrips.click();

     return new MyTrips(driver);
	}
	
}

