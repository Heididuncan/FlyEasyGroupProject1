//import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

public class HotelListTest {
	private HotelList hotels = HotelList.getInstance();
	private ArrayList<RegisteredHotel> hotelList = hotels.getHotels();
	
	@BeforeEach
	public void setup() {
		hotelList.add(new RegisteredHotel("Marriot", "Charlotte", "North Carolina", "open", "March 18", "March 22", "$150", null));
		hotelList.add(new RegisteredHotel("Ritz-Carlton", "Los Angeles", "California", "open", "June 15", "June 20", "$800", null));
	}
	
	@AfterEach
	public void tearDown() {
		hotels.getInstance().getHotels().clear();
	}
	
	
	@Test
	public void testHaveHotelsValidFirstItem() {
		boolean hasMarriot = HotelList.haveHotels("Marriot");
		assertTrue(hasMarriot);
	}
	
	@Test
	public void testHaveHotelsValidLastItem() {
		boolean hasRitzCarlton = hotels.haveHotels("bwhite");
		assertTrue(hasRitzCarlton);
	}
	
	@Test
	public void testHaveHotelsInValid() {
		boolean hasJoe = hotels.haveHotels("jsmith");
		assertFalse(hasJoe);
	}
	
	@Test
	public void testHaveHotelEmpty() {
		boolean hasEmpty = hotels.haveHotels("");
		assertFalse(hasEmpty);
	}
	
	@Test
	public void testHaveHotelNull() {
		boolean hasNull = hotels.haveHotels(null);
		assertFalse(hasNull);
	}
}