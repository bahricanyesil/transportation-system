
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package passengers;

import interfaces.ownCar;
import interfaces.usePublicTransport;
import locations.Location;
import vehicles.Car;
import vehicles.PublicTransport;

/**
 * 
 * Defines a class to implement passengers with their common features.
 * implements ownCar and usePublicTransport interfaces
 * @author Bahrican Yesil
 * 
 */
public class Passenger implements ownCar, usePublicTransport{
	
	/**
	 * The unique identity of the passengers.
	 */
	private final int ID;
	/**
	 * A boolean determines whether the passenger has the license to drive car.
	 */
	private boolean hasDriversLicense;
	/**
	 * The card balance of the passenger to travel with public transport vehicles.
	 */
	private double cardBalance;
	/**
	 * Represents the passenger's car
	 */
	private Car car;
	/**
	 * Represents the present location of the passenger
	 */
	private Location currentLocation;
	/**
	 * Represents whether the passenger has car or not
	 */
	private boolean hasCar;
	
	/**
	 * Constructs a passenger with his/her unique <code>ID</code>, <code>hasDriversLicense</code> and location <code>l</code>.
	 * Also set the <code>cardBalance</code> to the "0"
	 * Since this type of passengers doesn't have car, set <code>hasCar</code> to false
	 * @param ID				The integer representing unique identity of the passenger, first parameter.
	 * @param hasDriversLicense The boolean representing whether the passenger has license to drive a car, second parameter.
	 * @param l					The location object representing where the passenger will be created in, third parameter.
	 */
	public Passenger(int ID, boolean hasDriversLicense, Location l) {
		this.ID = ID;
		this.hasDriversLicense = hasDriversLicense;
		this.currentLocation = l;
		this.cardBalance = 0;
		this.hasCar = false;
	}
	
	/**
	 * Constructs a passenger with his/her unique <code>ID</code>, location <code>l</code> and <code>fuelConsumption</code> rate of his/her car.
	 * Also set the <code>cardBalance</code> to 0
	 * Since this type of passengers has car, set <code>hasCar</code> to true
	 * @param ID				The integer representing unique identity of the passenger, first parameter.
	 * @param l					The location object representing where the passenger will be created in, second parameter.
	 * @param fuelConsumption   The double representing fuel consumption of the passenger's current car, third parameter.
	 */
	public Passenger(int ID, Location l, double fuelConsumption) {
		this.ID = ID;
		this.currentLocation = l;
		this.hasDriversLicense = true;
		this.cardBalance = 0;
		this.car = new Car(ID, fuelConsumption);
		this.hasCar = true;
	}
	
	/**
	 * 
	 * Firstly, checks that the passenger can travel using the public transport to a specific location.
	 * (checking both the card balance and public transport vehicles' borders)
	 * if s/he can, subtract the price from his/her <code>cardBalance</code>,
	 * adds to the current and history list of the location <code>l</code>
	 * removes from the current list of the <code>currentLocation</code>
	 * change the <code>currentLocation</code> of the passenger to the new location,
	 * @param p The vehicle object that the passenger want to use, first parameter.
	 * @param l	The location object representing where the passenger want to go, second parameter.
	 */
	@Override
	public void ride(PublicTransport p, Location l) {
		//This if statements checks both the suitability of the vehicle to travel and the card balance amount of the passenger
		if(p.canRide(this.currentLocation, l)&&this.cardBalance>=p.getPrice(this.currentLocation.getDistance(l), this)) {
			this.cardBalance = this.cardBalance - p.getPrice(getCurrentLocation().getDistance(l), this);
			l.incomingPassenger(this);
			this.currentLocation.outgoingPassenger(this);
			this.currentLocation = l;
		}
	}
	
	/**
	 * 
	 * Firstly, checks that the passenger can travel using his/her car to a specific location.
	 * (checking the distance and fuel amount relation)
	 * if s/he can, calls the method that subtract the fuel consumed from the total fuel amount.  
	 * adds to the current and history list of the location <code>l</code>
	 * removes from the current list of the <code>currentLocation</code> 
	 * change the <code>currentLocation</code> of the passenger to the new location,
	 * @param l	The location object representing that the passenger want to go with his/her car.
	 */
	@Override
	public void drive(Location l) { 
		//This if statements checks whether the fuel amount in the car is sufficient to travel or not
		if((this.currentLocation.getDistance(l)*this.car.getFuelConsumption())<=this.car.getFuelAmount()) {
			this.car.setFuelAmount(this.currentLocation.getDistance(l));
			l.incomingPassenger(this);
			this.currentLocation.outgoingPassenger(this);
			this.currentLocation = l;
		}
	}
	
	/**
	 * Calls the refuel method in the car class to add some amount of fuel to the total amount.
	 * @param amount A double representing fuel amount that should be added to the total amount.
	 */
	@Override
	public void refuel(double amount) {
		this.car.refuel(amount);
	}
	
	/**
	 * Creates a new car object and set the passengers' current <code>car</code> field 
	 * to this new object with a specific owner ID and fuel consumption rate.
	 * To be sure, also set the <code>hasDriversLicense</code> boolean to true, 
	 * @param fuelConsumption A double representing fuel consumption rate of the new car that passenger purchases.
	 */
	@Override
	public void purchaseCar(double fuelConsumption) {
		this.hasDriversLicense = true;
		this.car = new Car(this.ID, fuelConsumption);
		this.hasCar = true;
	}
	
	/**
	 * Adds some amount to the total <code>cardBalance</code>, fills the card.
	 * @param amount A double representing card amount that should be added to the total card balance in type of double.
	 */
	@Override
	public void refillCard(double amount) {
		this.cardBalance += amount;
	}
	
	/**
	 * Gets the <code>ID</code> of the passenger, the getter method of the ID field.
	 * @return An integer representing the unique <code>ID</code> of the passenger.
	 */
	public int getID() {
		return this.ID;
	}
	
	/**
	 * Gets the <code>cardBalance</code> of the passenger, the getter method of the card balance field.
	 * @return A double representing the <code>cardBalance</code> of the passenger.
	 */
	public double getCardBalance() {
		return this.cardBalance;
	}
	
	/**
	 * Gets the <code>Car</code> object of the passenger, the getter method of the Car field.
	 * @return A car object representing the <code>car</code> of the passenger.
	 */
	public Car getCar() {
		return this.car;
	}
	
	/**
	 * Gets the present location of the passenger not, the getter method of the <code>currentLocation</code> field.
	 * @return A location object representing the <code>currentLocation</code> of the passenger.
	 */
	public Location getCurrentLocation() {
		return this.currentLocation;
	}
	
	/**
	 * Gets the boolean that controls whether the passenger has car, 
	 * the getter method of the <code>hasCar</code> field.
	 * @return A boolean representing whether the passenger has car.
	 */
	public boolean getHasCar() {
		return this.hasCar;
	}
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

