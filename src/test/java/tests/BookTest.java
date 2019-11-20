package tests;

import org.testng.annotations.Test;



public class BookTest extends BaseTest 
{
@Test
	public void bookTest() {

		tutorialPage.skipTutorial();

		loginPage.login("01092548176", "Youssef");
		
		searchPage.beginSearch();
		
		bookPage.selectPickupDropoff("El Obour City","Masr elgedida");
	}
	}
	

