package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginContext;
import org.testng.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import pages.AppointmentPage;
import pages.BookPage;
import pages.LoginPage;
import pages.MyTrips;
import pages.SearchPage;
import pages.SideMenuPage;
import pages.TutorialPage;

public class BaseTest {

	public AppiumDriver driver;
	TutorialPage tutorialPage;
	SearchPage searchPage;
	LoginPage loginPage;
	BookPage bookPage;
	SideMenuPage sideMenu;
	MyTrips myTrip;
	AppointmentPage appointment;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/resources");
		File app = new File(appDir, "Swvl-v5.3.1.apk");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "OPPO F5");
		caps.setCapability("udid", "VOFIU8JNMRSCLBKF"); // Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.1.1");
		caps.setCapability("app", app.getAbsolutePath());
		caps.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, "io.swvl.customer.*");
		// caps.setCapability("appPackage", "io.swvl.customer");
		// caps.setCapability("appActivity",
		// "io.swvl.customer.features.LaunchScreenActivity");
		caps.setCapability("autoGrantPermissions", true);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		//driver.findElementByAccessibilityId("ALLOW").click();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();

		tutorialPage = new TutorialPage(driver);
		loginPage = new LoginPage(driver);
		searchPage = new SearchPage(driver);
		bookPage = new BookPage(driver);
		sideMenu = new SideMenuPage(driver);
		myTrip = new MyTrips(driver);
		appointment = new AppointmentPage(driver);
	}

	@AfterClass
	public void stop() {

		driver.quit();

	}
}
