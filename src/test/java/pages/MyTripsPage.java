package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyTripsPage {

	public AppiumDriver driver;

	public MyTripsPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(id = "bookings_recycler_view")
	public MobileElement myTripsList;

	public TripDetailsPage getFirstBooking() {
		List<MobileElement> myTripList = new ArrayList<MobileElement>();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myTripList = myTripsList.findElements(By.xpath(
				"//android.widget.FrameLayout//android.view.ViewGroup//androidx.recyclerview.widget.RecyclerView"));
		if (myTripList.size() != 0) {
			myTripList.get(0).click();
		}
		return new TripDetailsPage(driver);
	}

}
