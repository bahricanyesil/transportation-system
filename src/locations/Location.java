
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package locations;

import java.util.ArrayList;

import passengers.Passenger;

/**
 * 
 * Defines <code>Location</code> class to implement locations with their IDs, 
 * x, y locations and history, current array lists. 
 * @author Bahrican Yesil
 * 
 */
public class Location{
	
	/**
	 * The unique identity of the location.
	 */
	private final int ID; 
	/**
	 * The x-coordinate of the location
	 */
	private final double locationX; 
	/**
	 * The y-coordinate of the location
	 */
	private final double locationY; 
	/**
	 * Keeps track of every passenger who has visited
	 */
	private ArrayList<Passenger> history = new ArrayList<Passenger>();
	/**
	 * Keeps track of the passengers currently here
	 */
	private ArrayList<Passenger> current = new ArrayList<Passenger>(); 
	
	/**
	 * Creates a location with a specified <code>ID</code> and
	 * with its <code>locationX</code> and <code>locationY</code> (x and y) coordinates.
	 * @param ID 		An integer representing the unique identity of the location
	 * @param locationX A double representing the x-coordinate of the location
	 * @param locationY A double representing the y-coordinate of the location
	 */
	public Location(int ID, double locationX, double locationY) {
		this.ID = ID;
		this.locationX = locationX;
		this.locationY = locationY;
	}
	
	/**
	 * Calculates the distance between the object itself 
	 * and <code>other</code> Location.
	 * @param other The location whose distance will be calculated
	 * @return 		A double representing the distance between the object itself and the <code>other</code> location.
	 */
	public double getDistance(Location other) {
		final double first = (other.locationY - this.locationY)*(other.locationY - this.locationY); // the square of the distance between y coordinates
		final double second = (other.locationX - this.locationX)*(other.locationX - this.locationX); //the square of the distance between x coordinates
		return Math.sqrt(first + second);
	}
	
	/**
	 * Adds the passenger <code>p</code> who came to the location to the <code>current</code> list and
	 * if the passenger hasn't come to the location before, also adds to the <code>history</code> list.
	 * @param p The passenger who comes to the location.
	 */
	public void incomingPassenger(Passenger p) {
		current.add(p);
		if(!(history.contains(p))) {
			history.add(p);
		}
	}
	
	/**
	 * Removes the passenger <code>p</code> who leaves from 
	 * the location from the <code>current</code> list.
	 * @param p The passenger who leaves from the location.
	 */
	public void outgoingPassenger(Passenger p) {
		current.remove(p);
	}
	
	/**
	 * Gets the <code>ID</code> of the location, the getter method of the ID field.
	 * @return An integer representing the specific <code>ID</code> of the location.
	 */
	public int getID() {
		return this.ID;
	}
	
	/**
	 * Gets the 'x' coordinate of the location, the getter method of the locationX field.
	 * @return A double representing the <code>locationX</code>  ('x' coordinate) of the location. 
	 */
	public double getlocationX() {
		return this.locationX;
	}
	
	/**
	 * Gets the 'y' coordinate of the location, the getter method of the locationY field.
	 * @return A double representing the <code>locationY</code>  ('y' coordinate) of the location. 
	 */
	public double getlocationY() {
		return this.locationY;
	}
	
	/**
	 * Gets the list of passengers currently here, the getter method of the 'current' field.
	 * @return An array list representing the current passengers in the location.
	 */
	public ArrayList<Passenger> getCurrent(){
		return this.current;
	}
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

