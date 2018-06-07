
public class Car {
	private double fuelEfficiency;
	private double fuelLevel;
	private double odometer;
	
	public Car(double fuelEff) {
		fuelEfficiency = fuelEff;
		fuelLevel = 0;
		odometer = 0;
	}
	
	public double getFuelEfficiency() {
		return fuelEfficiency;
	}
	
	public double getFuelLevel() {
		return fuelLevel;
	}
	
	public double getOdometer() {
		return odometer;
	}

	public double addFuel(double gallons) {
		fuelLevel+=gallons;
		return fuelLevel;
	}
	
	public double drive(double miles) {
		double galsNeeded = (miles/fuelEfficiency);
		double trueDis = miles;
		if(galsNeeded > fuelLevel) {
			trueDis = fuelLevel*fuelEfficiency;
			odometer += trueDis;
			fuelLevel = 0;
		}
		else {
			odometer += trueDis;
			fuelLevel-= galsNeeded;
		}
		return trueDis;
	}
}
