import java.util.ArrayList;
public class airportList {

    private static airportList airports;
    private ArrayList<RegisteredAirport> airportsList;
	/**
	 * Constructor Method that sets up a new airportsList if one hasn't been created
	 */
	private airportList() {
		airportsList = airportDataLoader.getAirports();
	}
	/**
	 * Method that adds a new airport if one has not already existed in the list
	 */
	public boolean addAirport(String state, String city, String airportName, String airportCode) {
        if(haveAirport(city, state))return false;
		
		airportsList.add(new RegisteredAirport(state, city, airportName, airportCode));
		return true;
    }
	/**
	 * Method that gets the airports from the list
	 */
    	public static airportList getInstance() {
		if(airports == null) {
			airports = new airportList();
		}
		
		return airports;
	}
	/**
	 * Method that returns the new airport that the user has added
	 */
	public boolean haveAirport(String city, String state) {
		for(RegisteredAirport airport : airportsList) {
			for(airport.getCity().equals(city); airport.getState().equals(state);) {
				return true;
			}
		}
		
		return false;
	}
	/**
	 * Method that returns the registered airport
	 */
	public RegisteredAirport getAirport(String city, String state) {
		for(RegisteredAirport airport : airportsList) {
			for(airport.getCity().equals(city); airport.getState().equals(state);) {
				return airport;
			}
		}
		
		return null;
	}
	/**
	 * Method that returns the airportList
	 */
	public ArrayList<RegisteredAirport> getAirports() {
		return airportsList;
	}

    public void saveAirports() {
        AirportDataWriter.saveAirports();
    }


}
