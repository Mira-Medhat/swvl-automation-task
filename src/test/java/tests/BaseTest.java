package tests;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pages.BookPage;
import pages.LoginPage;
import pages.SearchPage;
import pages.TutorialPage;

public class BaseTest  {

    public AppiumDriver driver;
    TutorialPage tutorialPage;
    SearchPage searchPage;
    LoginPage loginPage;
    BookPage bookPage;
    
    
@BeforeClass
	public void setUp() 
			throws MalformedURLException  {
	File classpathRoot = new File(System.getProperty("user.dir"));
	File appDir = new File(classpathRoot, "/resources");
	File app = new File(appDir, "Swvl-v5.3.1.apk");
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("deviceName", "OPPO F5");
	caps.setCapability("udid", "VOFIU8JNMRSCLBKF"); //Give Device ID of your mobile phone
	caps.setCapability("platformName", "Android");
	caps.setCapability("platformVersion", "7.1.1");
	caps.setCapability("appPackage", "io.swvl.customer");
	caps.setCapability("appActivity", "io.swvl.customer.features.LaunchScreenActivity");
	caps.setCapability("noReset", "true");
    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

tutorialPage = new TutorialPage(driver);
loginPage = new LoginPage(driver);
searchPage = new SearchPage(driver);
bookPage = new BookPage(driver);
	}
	
	@AfterClass
	public void stop() {
        
        driver.quit();
        
    }
	}
	
	
	

