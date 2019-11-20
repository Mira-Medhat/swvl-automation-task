package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TutorialPage {
	
	public AppiumDriver driver;
	@FindBy(id = "skip_btn")
	private MobileElement skipButton;
	
	public TutorialPage(AppiumDriver driver) {
		this.driver=driver;
	}
	
public boolean isTutorialShown() {
    	
    	if (driver.findElements(By.id("skip_btn")).size() != 0) {
    		return true;
    	}
    	return false;
    } 

public LoginPage skipTutorial(){
	if (isTutorialShown() == true)
	skipButton.click();
	return new LoginPage(driver);
}
    

}
