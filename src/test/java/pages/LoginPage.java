package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginPage {
	
	public AppiumDriver driver;
	 public LoginPage(AppiumDriver driver) {
       this.driver=driver;
	 }

	@FindBy(id = "expandable_input_view")
	public MobileElement enterPhone;

	@FindBy(id = "flag_image_view")
	public MobileElement countryFlag;

	@FindBy(id = "phone_edit_text")
	public MobileElement phoneInput;

	@FindBy(id = "search_et")
	public MobileElement countrySearchInput;

	@FindBy(id = "countries_recycler_view")
	public MobileElement countriesList;

	@FindBy (id = "next_btn")
	public MobileElement nextButton;
	
	@FindBy (id = "password_edit_text")
	public MobileElement passwordInput;
	
	public void login(String mobileNumber, String password) {

		List<MobileElement> countrylist = new ArrayList<MobileElement>();
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);


		enterPhone.click();
		countryFlag.click();
		countrySearchInput.sendKeys("Egypt");
		countrylist = countriesList.findElements(By.xpath("//android.widget.TextView"));
		
		if (countrylist.size() !=0)
		{
			countrylist.get(0).click();
		}
		
		phoneInput.sendKeys(mobileNumber);
		nextButton.click();
		passwordInput.sendKeys(password);
		nextButton.click();
	}
}
