
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

package main;

import java.util.*;
import vehicles.*;
import java.io.*;
import passengers.*;
import locations.*;


/**
 * Defines the <code>main</code> class to analyze the incoming requests 
 * provided as a list of input in the input file, 
 * and carrying out the necessary actions with the help of the other classes. 
 * After, writes to the output file.
 * @author Bahrican Yesil
 */
public class Main {
	
	/**
	 * Reads input file step by step, makes required operations and then prints to the output file.
	 * it takes two inputs as arguments
	 * @param args 					 Command-line arguments
	 * @throws FileNotFoundException Throws in case of files with the specified pathnames do not exist or exist but inaccessible for some reason
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		// Scanner object to parse the input file composed of the sequential traveling operations. 
		Scanner input = new Scanner(new File(args[0]));
		// PrintStream object to print the required outputs to an output file,
		PrintStream output = new PrintStream(new File(args[1]));

		// 3 different array lists that composed of passengers, locations and vehicles.
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		ArrayList<Location> locations = new ArrayList<Location>();
		ArrayList<PublicTransport> vehicles = new ArrayList<PublicTransport>();
		
		// Uncomment the lines below after implementing the Location class
		
		Location l = new Location(0, 0, 0); // The first location is always (0,0).
		locations.add(l);
		
		int operations = input.nextInt(); // operation count
		input.nextLine();
		int id = 0;  //the unique IDs of the passengers
		int id2 = 1; //the unique IDs of the locations, since the first one has almost created, starts from 1
		int id3 = 0; //the unique IDs of the vehicles
		
		// Main for loop to take all of the actions respectively by reading line-by-line
		for(int i=0; i<operations; i++) {
			int action = input.nextInt(); // the action type
			// Action 1 creates a passenger
			if(action == 1) {
				String passengerType = input.next(); // Whether the passenger is discounted or standard
				int driverLicense = input.nextInt(); // Whether the passenger has driver license or not
				boolean driverLicenseb = false; // To convert the integer equivalent of the driver's license into a boolean
				if(driverLicense == 1) {
					driverLicenseb = true;
				}
				int hasCar = input.nextInt(); // Whether s/he has a car or not.
				if(hasCar == 1) {
					double fuelConsume = input.nextDouble(); // if s/he has car, the fuel consumption rate of the car
					if(passengerType.equals("D")) {
						DiscountedPassenger passenger = new DiscountedPassenger(id, l, fuelConsume); // Creates a new discounted passenger with his/her own features
						passengers.add(passenger);
						l.incomingPassenger(passengers.get(id)); // adds the passenger to the his/her location's current and history lists
						id++; //increments the id variable for the next passenger
					}
					else {
						StandardPassenger passenger2 = new StandardPassenger(id, l, fuelConsume); // Creates a new standard passenger with his/her own features
						passengers.add(passenger2);
						l.incomingPassenger(passengers.get(id)); // adds the passenger to the his/her location's current and history lists
						id++; //increments the id variable for the next passenger
					}
				}
				else {
					if(passengerType.equals("D")) {
						DiscountedPassenger passenger3 = new DiscountedPassenger(id, driverLicenseb, l); // Creates a new standard passenger who hasn't car with his/her own features
						passengers.add(passenger3);
						l.incomingPassenger(passengers.get(id)); // adds the passenger to the his/her location's current and history lists
						id++; //increments the id variable for the next passenger
					}
					else {
						StandardPassenger passenger4 = new StandardPassenger(id, driverLicenseb, l); // Creates a new standard passenger who hasn't car with his/her own features
						passengers.add(passenger4);
						l.incomingPassenger(passengers.get(id)); // adds the passenger to the his/her location's current and history lists
						id++; //increments the id variable for the next passenger
					}
				}
			}
			// action 2 creates a location
			else if(action == 2) {
				double x = input.nextDouble(); //x coordinate of the location
				double y = input.nextDouble(); //y coordinate of the location
				Location l2 = new Location (id2, x, y); //creates a new location with its unique id and x-y coordinates
				locations.add(l2);
				id2++; //increments the id2 variable for the next locations
			}
			//action 3 creates a public transport vehicle
			else if(action == 3) {
				int vehicleType = input.nextInt(); //determines the type of the public transport (bus/train)
				double x1 = input.nextDouble(); //first x coordinate of the vehicle
				double y1 = input.nextDouble(); //first y coordinate of the vehicle
				double x2 = input.nextDouble(); //second x coordinate of the vehicle
				double y2 = input.nextDouble(); //second y coordinate of the vehicle
				if(vehicleType == 1) {
					Bus vehicle = new Bus (id3, x1, y1, x2, y2); //creates a new bus with its unique id and x-y coordinates
					vehicles.add(vehicle);
					id3++; //increments the id3 variable for the next vehicles
				}
				else if(vehicleType == 2){
					Train vehicle2 = new Train (id3, x1, y1, x2, y2); //creates a new train with its unique id and x-y coordinates
					vehicles.add(vehicle2);
					id3++; //increments the id3 variable for the next vehicles
				}
			}
			//in the action 4, passenger travels to a location
			else if(action == 4) {
				int passengerId = input.nextInt(); //the id of the passenger
				int locationId = input.nextInt(); //the id of the location
				int transportationType = input.nextInt(); // the type of the transportation (car/bus/train)
				
				/*this condition for the passengers who want to travel with car
				it controls that whether the passenger/location with the given passengerId/locationId has created,
				the passenger has car or not, it also controls whether the passenger's current location is the 
				same with the location that s/he wants to travel*/ 
				if(transportationType == 3&&passengerId<=id&&locationId<=id2&&passengers.get(passengerId).getHasCar()&&(locationId!=passengers.get(passengerId).getCurrentLocation().getID())) {			
					passengers.get(passengerId).drive(locations.get(locationId)); //calls the drive method to travel
				}
				
				/*this condition for the passengers who want to travel with bus
				it controls that whether the passenger/location with the given passengerId/locationId has created,
				it also controls whether the passenger's current location is the same with the location that s/he wants to travel*/ 
				else if (transportationType == 1&&passengerId<=id&&locationId<=id2&&(locationId!=passengers.get(passengerId).getCurrentLocation().getID())){
					int vehicleId = input.nextInt(); //the unique public transport id of the bus
					if(vehicleId<=id3&&vehicles.get(vehicleId) instanceof Bus) { //checks whether the given vehicleId is an instance of bus or not
						passengers.get(passengerId).ride(vehicles.get(vehicleId), locations.get(locationId)); //calls the ride method to travel
					}
				}
				
				/*this condition for the passengers who want to travel with train
				it controls that whether the passenger/location with the given passengerId/locationId has created,
				it also controls whether the passenger's current location is the same with the location that s/he wants to travel*/ 
				else if(transportationType == 2&&passengerId<=id&&locationId<=id2&&(locationId!=passengers.get(passengerId).getCurrentLocation().getID())) {
					int vehicleId = input.nextInt(); //the unique public transport id of the bus
					if(vehicleId<=id3&&vehicles.get(vehicleId) instanceof Train) { //checks whether the given vehicleId is an instance of train or not
						passengers.get(passengerId).ride(vehicles.get(vehicleId), locations.get(locationId)); //calls the ride method to travel
					}
				}
			}
			//in action 5, passenger purchases a car
			else if(action == 5) {
				int passengerId = input.nextInt(); //unique passenger id
				double fuelConsumption = input.nextDouble(); //fuel consumption rate of the new car
				if(passengerId<=id) {
					passengers.get(passengerId).purchaseCar(fuelConsumption); //calls the purchaseCar method to create a new car and assign it to the passenger
				}
			}
			//in action 6, passenger refuels its car
			else if(action == 6) {
				int passengerId = input.nextInt(); //unique passenger id
				double fuelAmount = input.nextDouble(); //fuel amount that is wanted to be added to total amount
				if(passengerId<=id&&passengers.get(passengerId).getHasCar()) {
					passengers.get(passengerId).refuel(fuelAmount); //calls the refuel method to add new fuel
				}
			}
			//in action 7, passenger refills its travel card
			else if(action == 7) {
				int passengerId = input.nextInt(); //unique passenger id
				double addedAmount = input.nextDouble(); //amount that is wanted to be added to card balance
				if(passengerId<=id) {
					passengers.get(passengerId).refillCard(addedAmount); //calls the refillCard method to add new amount to card balance
				}
			}
		}
		
		//this for loop is for outputting the required information to the output file
		for(int i=0; i<locations.size(); i++) {
			output.print("Location " + i + ": (" + withDecimal(locations.get(i).getlocationX())); //x coordinate of the location
			output.print(", " + withDecimal(locations.get(i).getlocationY()) + ")"); //y coordinate of the location
			output.println();
			//this for loop is for traversing the locations' current lists to determine whether this list contains the passenger or not
			for(int k=0; k<passengers.size(); k++) {
				//this if condition controls whether the passenger is in the location now
				if(locations.get(i).getCurrent().contains(passengers.get(k))) {
					double result = 0.0; //to calculate the final value that will be printed
					if(passengers.get(k).getHasCar()) {
						//if the passenger has car, prints the fuel amount
						result =  passengers.get(k).getCar().getFuelAmount();			
					}
					else {
						//if the passenger hasn't car, prints the card balance
						result = passengers.get(k).getCardBalance();	
					}
					output.print("Passenger " + passengers.get(k).getID() + ": " + withDecimal(result));
					output.println();
				}
			}
		}
		input.close();
		output.close();
	}
	
	/**
	 * returns the required double value with 2 decimal points as a string.
	 * @param amount The double representing what we should print with 2 digits after the fraction point.
	 * @return The string with 2 digits after the fraction point.
	 */
	public static String withDecimal(double amount) {
		String result = amount + "000"; //Added "000" in case of there is less than two digit after the "."
		String resultFinal = result.substring(0, result.indexOf('.') + 3);
		return resultFinal;
	}
}


//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

