package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage {
	public AppiumDriver driver;

	public SearchPage(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(id = "got_it_tv")
	public MobileElement gotItBtn;

	@FindBy(id = "where_to")
	public MobileElement whereTo;

	@FindBy(id = "home_icon")
	public MobileElement homeAddressBtn;

	@FindBy(id = "work_icon")
	public MobileElement workAddressBtn;

	@FindBy(id = "add_quick_destination_icon")
	public MobileElement addQuickAddressBtn;

	public BookPage beginSearch() {

		if (driver.findElements(By.id("got_it_tv")).size() != 0) {
			gotItBtn.click();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		whereTo.click();
		return new BookPage(driver);
	}
}
