//import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

public class HotelListTest {
	private HotelList hotels = HotelList.getInstance();
	private ArrayList<HotelList> HotelList = HotelList.getHotels();
	
	@BeforeEach
	public void setup() {
		HotelList.clear();
		HotelList.add(new RegisteredHotel("Marriot", "Charlotte", "North Carolina", "open", "March 18", "March 22", "$150"));
		HotelList.add(new RegisteredHotel("Ritz-Carlton", "Los Angeles", "California", "open", "June 15", "June 20", "$800"));
		DataWriter.saveHotels();
	}
	
	@AfterEach
	public void tearDown() {
		hotels.getInstance().getHotels().clear();
		DataWriter.saveHotels();
	}
	
	
	@Test
	void testHaveHotelsValidFirstItem() {
		boolean hasAmy = HotelList.haveHotel("asmith");
		assertTrue(hasMariott);
	}
	
	@Test
	void testHaveHotelsValidLastItem() {
		boolean hasBob = hotels.haveHotels("bwhite");
		assertTrue(hasBob);
	}
	
	@Test
	void testHaveHotelsInValid() {
		boolean hasJoe = hotels.haveHotels("jsmith");
		assertFalse(hasJoe);
	}
	
	@Test
	void testHaveHotelEmpty() {
		boolean hasEmpty = hotels.haveHotels("");
		assertFalse(hasEmpty);
	}
	
	@Test
	void testHaveHotelNull() {
		boolean hasNull = hotels.haveHotels(null);
		assertFalse(hasNull);
	}
}