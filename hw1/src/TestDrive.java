import java.util.Scanner;
public class TestDrive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter Car's Fuel Efficiency:");
			double fuelEff = sc.nextDouble();
			if(fuelEff == 0.0) {
				return;
			}
			Car carOne = new Car(fuelEff);
			System.out.println("Enter Car's initial fuel:");
			double fuel = sc.nextDouble();
			carOne.addFuel(fuel);
			
			while(true) {
				System.out.println("Enter distance to travel:");
					double distance = sc.nextDouble();
					if(distance==0.0) {
						System.out.println("Enter fuel to add:");
						fuel = sc.nextDouble();
						if(fuel==0.0) {
							continue;
						}
						carOne.addFuel(fuel);
					}
					else {
						double drivenMiles = carOne.drive(distance);
						System.out.println("Car has travelled "+drivenMiles+" miles");
						System.out.println("Car has "+carOne.getFuelLevel()+" gallons of fuel.");
						System.out.println("Odometer reads "+carOne.getOdometer()+" miles.");
					}
				}
			}
		}
	

	}

