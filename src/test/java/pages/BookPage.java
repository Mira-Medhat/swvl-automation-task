package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BookPage {

	public AppiumDriver driver;
	public BookPage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@FindBy(id = "pickup_et")
	public MobileElement pickupInput;

	@FindBy(id = "dropoff_et")
	public MobileElement dropoffInput;

	@FindBy(id = "pickup_dropoff_swap_iv")
	public MobileElement swapBtn;

	@FindBy(id = "places_rv")
	public MobileElement placesResult;

	@FindBy(id = "rides_recycler_view")
	public MobileElement ridesResult;
	
	@FindBy (id = "next_btn")
	public MobileElement nextBtn;
	
	@FindBy (id = "book_btn")
	public MobileElement bookBtn;

	public void selectPickupDropoff(String pickup, String dropoff) {

		List<MobileElement> placesresults = new ArrayList<MobileElement>();

		pickupInput.click();
		pickupInput.sendKeys(pickup);
		placesresults = driver.findElements(By.xpath("//android.widget.TextView"));

		if (placesresults.size() != 0) {
			placesresults.get(0).click();
		}

		dropoffInput.sendKeys(dropoff);
		placesresults = driver.findElements(By.xpath("//android.widget.TextView"));
		if (placesresults.size() != 0) {
			placesresults.get(0).click();
		}
		
		((RemoteWebElement) driver.findElements
		(By.xpath("//android.view.ViewGroup")).get(1)).click();
		nextBtn.click();
		bookBtn.click();
	}

}
