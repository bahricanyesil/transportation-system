
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;
import passengers.Passenger;
import passengers.DiscountedPassenger;

/**
 * 
 * Defines a class to implement busses (one of the public transports)
 * Their prices are different from the trains (the other public transport)
 * Extends PublicTransport class since it inherits it.
 * @author Bahrican Yesil
 * 
 */
public class Bus extends PublicTransport{
	
	
	/**
	 * Calls the super constructor to create the bus object which is a type of public transport vehicles..
	 * @param ID An integer representing the unique identity of the bus.
	 * @param x1 A double representing the first x coordinate in the operating range of the bus.
	 * @param y1 A double representing the first y coordinate in the operating range of the bus.
	 * @param x2 A double representing the second x coordinate in the operating range of the bus.
	 * @param y2 A double representing the second y coordinate in the operating range of the bus.
	 */
	public Bus(int ID, double x1, double y1, double x2, double y2) {
		super(ID, x1, y1, x2, y2);
	}
	
	/**
	 * After controls whether passenger is discounted or not, returns the price of the bus.
	 * The normal bus fee is 2 liras regardless of the distance traveled,
	 * discounted passengers get 50% discount.
	 * @param distance     A double representing the distance from the passenger's current location to the location that s/he want to go, first parameter.
	 * @param p			   A passenger object representing the passenger who travels, second parameter.
	 * @return 			   A double representing the price of the bus for this distance.
	 */
	@Override
	public final double getPrice(double distance, Passenger p) {
		if(p instanceof DiscountedPassenger) {
			// if the passenger is discounted, get %50 discount
			return 1.0;
		}
		else {
			return 2.0;
		}
	}
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

