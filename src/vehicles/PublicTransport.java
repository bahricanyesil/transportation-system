
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;

import locations.Location;
import passengers.Passenger;

/**
 * 
 * Defines an abstract class to implement public transports.
 * @author Bahrican Yesil
 * 
 */
public abstract class PublicTransport {
	
	/**
	 * The unique identity of the public transport vehicle
	 */
	private final int ID;
	/**
	 * One of the x-coordinates of the public transport vehicle's operating range
	 */
	private final double x1; 
	/**
	 * One of the y-coordinates of the public transport vehicle's operating range
	 */
	private final double y1;
	/**
	 * The other one of the x-coordinates of the public transport vehicle's operating range
	 */
	private final double x2;
	/**
	 * The other one of the y-coordinates of the public transport vehicle's operating range
	 */
	private final double y2;
	
	/**
	 * Constructs a public transport vehicle with its unique ID, x and y coordinates.
	 * @param ID An integer representing the unique identity of the public transport vehicle.
	 * @param x1 A double representing the first x coordinate in the operating range of the public transport vehicle.
	 * @param y1 A double representing the first y coordinate in the operating range of the public transport vehicle.
	 * @param x2 A double representing the second x coordinate in the operating range of the public transport vehicle.
	 * @param y2 A double representing the second y coordinate in the operating range of the public transport vehicle.
	 */
	public PublicTransport(int ID, double x1, double y1, double x2, double y2) {
		this.ID = ID;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	/**
	 * Determines if the vehicle is suitable for the journey or not in its operating range which is a rectangle shape
	 * according to the departure and arrival locations.
	 * @param departure	A location object representing the location of the passenger.
	 * @param arrival	A location object representing the location that passenger wants to travel.
	 * @return			A boolean representing whether the departure and arrival locations are within the borders of the vehicle. 
	 */
	public boolean canRide(Location departure, Location arrival) {
		// Firstly, controls if departure location is in the borders of the vehicle. 
		if(departure.getlocationX()>=Math.min(x1, x2) && departure.getlocationX()<=Math.max(x1, x2) && departure.getlocationY()>=Math.min(y1, y2) && departure.getlocationY()<=Math.max(y1, y2)) {
			// After, controls if arrival location is in the borders of the vehicle.
			if(arrival.getlocationX()>=Math.min(x1, x2) && arrival.getlocationX()<=Math.max(x1, x2) && arrival.getlocationY()>=Math.min(y1, y2) && arrival.getlocationY()<=Math.max(y1, y2)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	/**
	 * Abstract method that bus and train classes implement in their own classes
	 * @param distance A double representing the distance between departure and arrival locations
	 * @param p		   A passenger object who wants to travel 
	 * @return		   A double representing the price which should be subtracted from the card balance of the passenger
	 */
	public abstract double getPrice(double distance, Passenger p);
	
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE





