package tests;

import org.testng.annotations.Test;

public class CancelTest extends BaseTest {

	@Test
	public void CancelAppointment() throws InterruptedException {
		BookTest book = new BookTest();
		book.bookTest();
		sideMenu.getBookingPage();
		myTrip.getFirstBooking();
		appointment.cancelAppointment();
	}

}
