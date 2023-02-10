public class RentCar extends Vehicle implements RentInterface{
    public String renterName;
    private int usageKm;

    public RentCar(){
    }

    public RentCar(String name, String brand, String model, boolean isAvailable, String renterName, int usageKm){
        super(name, brand, model, isAvailable);
        this.renterName = renterName;
        this.usageKm = usageKm;
    }

    /**
     * Print the vehicle details.
     */
    public void printDetails(){
        System.out.println("\nThe rent car details are: ");
        super.printDetails(); //Print instance variables in the abstract Vehicle class
        System.out.println("The name of the renter is "+ renterName + ", and the usageKm is " + usageKm);
    }

    public int getUsageKm() {
        return usageKm;
    }

    public String getRenterName() {
        return renterName;
    }

    @Override
    public <T> boolean hireThis(String renterName){
        // When the car is available to be hired
        if(isAvailable){
            this.renterName = renterName;
            setIsAvailable(false);
            return true;
        }
        return false;
    }

    @Override
    public <T> boolean returnThis(int usageKm){
        // When the car is being hired
        if(!isAvailable){
            this.usageKm = usageKm;
            setIsAvailable(true);
            return true;
        }
        return false;
    }

    @Override
    public void getQuote() {
        if(isAvailable){
            System.out.println("The Vehicle is now available for rent.");
            System.out.println("The name of the previous renter was " + getRenterName() + ", and the usageKm was " + getUsageKm());
        }
        System.out.println("The Vehicle is now in use and cannot be rented.");
        System.out.println("The name of the renter is " + getRenterName() + ", and the usageKm is " + getUsageKm());
    }
}
