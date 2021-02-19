
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package vehicles;

/**
 * 
 * Defines a class to implement cars (one of the vehicle types which passenger could have)
 * with its ownerID, fuel amount and fuel consumption rate features.
 * @author Bahrican Yesil
 * 
 */
public class Car{
	
	/**
	 * The unique ID of the owner of the car
	 */
	private final int ownerID;
	/**
	 * The total fuel amount of the car in the fuel tank
	 */
	private double fuelAmount;
	/**
	 * The fuel consumption rate of the car
	 */
	private final double fuelConsumption;
	
	/**
	 * Constructs a car with a specified <code>ownerID</code> of its owner and its <code>fuelConsumption</code> rate
	 * Also sets the <code>fuelAmount</code> to zero since a new car should have empty fuel tank.
	 * @param ID				An integer representing the unique identity of its owner.
	 * @param fuelConsumption	A double representing the fuel consumption rate of the car.
	 */
	public Car(int ID, double fuelConsumption) {
		this.ownerID = ID;
		this.fuelConsumption = fuelConsumption;
		this.fuelAmount = 0;
	}
	
	/**
	 * Adds the amount of fuel to the total <code>fuelAmount</code>.
	 * @param amount A double representing the fuel amount that should be added to the total amount in type of double.
	 */
	public void refuel(double amount) {
		this.fuelAmount += amount;
	}
	
	/**
	 * Gets the total <code>fuelAmount</code> in the fuel tank of the car.
	 * @return	A double representing the <code>fuelAmount</code> of the car.
	 */
	public double getFuelAmount() {
		return this.fuelAmount;
	}
	
	/**
	 * Sets the <code>fuelAmount</code> of the car to the new value by subtracting the consumed fuel to travel to a specific location. 
	 * @param distance A double representing the distance from the passenger's current location to the location that s/he want to go.
	 */
	public void setFuelAmount(double distance) {
		this.fuelAmount = this.fuelAmount - (distance*this.fuelConsumption);
	}
	
	/**
	 * Gets the <code>fuelConsumption</code> rate of the car.
	 * @return A double representing the <code>fuelConsumption</code> rate of the car.
	 */
	public double getFuelConsumption() {
		return this.fuelConsumption;
	}
}

//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

