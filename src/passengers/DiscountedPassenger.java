
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package passengers;
import locations.Location;

/**
 * 
 * Defines a class to implement passengers who are discounted 
 * (will pay less than the other ones).
 * Extends Passenger class since it inherits it.
 * @author Bahrican Yesil
 * 
 */
public class DiscountedPassenger extends Passenger{

	/**
	 * Calls the super constructor to create the discounted passenger who doesn't have car now with the passenger object's features.
	 * @param ID				The integer representing the unique identity of the passenger, first parameter.
	 * @param hasDriversLicense The boolean representing whether the passenger has license to drive a car, second parameter.
	 * @param l					The location object representing where the passenger will be created, third parameter.
	 */
	public DiscountedPassenger(int ID, boolean hasDriversLicense, Location l) {
		super(ID, hasDriversLicense, l);
	}
	
	/**
	 * Calls the super constructor to create the discounted passenger who has a car now with the passenger object's features.
	 * @param ID				The integer representing unique identity of the passenger, first parameter.
	 * @param l					The location object representing where the passenger will be created, second parameter.
	 * @param fuelConsumption	The double representing fuel consumption of the passenger's current car, third parameter.
	 */
	public DiscountedPassenger(int ID, Location l, double fuelConsumption) {
		super(ID, l, fuelConsumption);
	}
	
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

