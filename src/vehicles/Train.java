
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;
import passengers.Passenger;
import passengers.DiscountedPassenger;

/**
 * 
 * Defines a class to implement trains (one of the public transports)
 * Their prices are different from the busses (the other public transport)
 * Extends PublicTransport class since it inherits it.
 * @author Bahrican Yesil
 * 
 */
public class Train extends PublicTransport{
	
	/**
	 * Calls the super constructor to create the train object which is a type of public transport vehicles.
	 * @param ID An integer representing the unique identity of the train.
	 * @param x1 A double representing the first x coordinate in the operating range of the train.
	 * @param y1 A double representing the first y coordinate in the operating range of the train.
	 * @param x2 A double representing the second x coordinate in the operating range of the train.
	 * @param y2 A double representing the second y coordinate in the operating range of the train.
	 */
	public Train(int ID, double x1, double y1, double x2, double y2) {
		super(ID, x1, y1, x2, y2);
	}
	
	/**
	 * After controls whether passenger is discounted or not, returns the price of the train according to the distance.
	 * The normal train fee is 5 liras per one stop traveled and 15 kilometers between every stop,
	 * discounted passengers get 20% discount on the train.
	 * @param distance     A double representing the distance from the passenger's current location to the location that s/he want to go, first parameter.
	 * @param p 		   A passenger object representing the passenger who travels, second parameter.
	 * @return 			   A double representing the price of the train for this distance
	 */
	@Override
	public final double getPrice(double distance, Passenger p) {
		int nofStop = 0;
		// Total number of stops since trains charge per stop.
		if(distance%15>=7.5) {
			// if the reminder is more than or equals to 7.5, rounds it up
			nofStop = (int)(distance/15.0) + 1;
		}
		else {
			// if the reminder is less than 7.5, rounds it down
			nofStop = (int)(distance/15.0);
		}
		
		if(p instanceof DiscountedPassenger) {
			// if the passenger is discounted, get %20 discount
			return ((5.0*nofStop)*4.0)/5.0;
		}
		else {
			return 5.0*nofStop;
		}
	}
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

