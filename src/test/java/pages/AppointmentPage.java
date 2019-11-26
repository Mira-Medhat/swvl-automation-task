package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppointmentPage {
	public AppiumDriver driver;

	public AppointmentPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	


	@FindBy(id="cancel_booking_iv")
	public MobileElement cancelBtn;
	
	@FindBy(id="confirm_btn")
	public MobileElement confirmCancel;
	
	public void cancelAppointment() {
		cancelBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
confirmCancel.click();
	}
}
