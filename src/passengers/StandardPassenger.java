
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package passengers;

import locations.Location;

/**
 * 
 * Defines a class to implement passengers who are not discounted (standard)
 * (will pay the regular fee) extending the 'Passenger'.
 * Extends Passenger class since it inherits it.
 * @author Bahrican Yesil
 * 
 */
public class StandardPassenger extends Passenger{
	
	/**
	 * Calls the super constructor to create the standard passenger object who doesn't have car now with the passenger object's features.
	 * @param ID				An integer representing unique identity of the passenger, first parameter.
	 * @param hasDriversLicense A boolean representing whether the passenger has license to drive a car, second parameter.
	 * @param l					A location object representing where the passenger will be created in, third parameter.
	 */
	public StandardPassenger(int ID, boolean hasDriversLicense, Location l) {
		super(ID, hasDriversLicense, l);
	}
	
	/**
	 * Calls the super constructor to create the standard passenger object who has a car now with the passenger object's features.
	 * @param ID				An integer representing unique identity of the passenger, first parameter.
	 * @param l					A location object representing where the passenger will be created in, third parameter.
	 * @param fuelConsumption	A double representing fuel consumption rate of the passenger's current car, third parameter.
	 */
	public StandardPassenger(int ID, Location l, double fuelConsumption) {
		super(ID, l, fuelConsumption);
	}
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

