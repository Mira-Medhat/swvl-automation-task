package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TutorialPage {
	
	public AppiumDriver driver;
	@FindBy(id = "skip_btn")
	private MobileElement skipButton;
	
	public TutorialPage(AppiumDriver driver) {

		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
public boolean isTutorialShown() {
    	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    	if (driver.findElements(By.id("skip_btn")).size() != 0) {
    		return true;
    	}
    	return false;
    } 

public LoginPage skipTutorial(){
	if (isTutorialShown() == true)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	skipButton.click();
	}
	return new LoginPage(driver);
}
    

}
