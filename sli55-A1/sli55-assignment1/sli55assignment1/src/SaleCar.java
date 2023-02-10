public class SaleCar extends Vehicle implements SaleInterface{
    public String ownerName;

    public SaleCar(){

    }
    public SaleCar(String name, String brand, String model, boolean isAvailable, String ownerName) {
        super(name, brand, model, isAvailable);
        this.ownerName = ownerName;
    }

    public void printDetails(){
        System.out.println("\nThe sale car details are: ");
        super.printDetails(); //Print instance variables in the abstract Vehicle class
        System.out.println("The owner's name is "+ ownerName);
    }

    @Override
    public <T> boolean transferOwnership(String ownerName){
        // When the car is available to be sold
        if(getIsAvailable()){
            this.ownerName = ownerName;
            isAvailable = true;
            return true;
        }
        return false;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public void getQuote(){
        if(getIsAvailable()){
            System.out.println("The Vehicle is now available for sale.");
            System.out.println("The name of the current owner is " + getOwnerName());
        }
        System.out.println("The Vehicle is now unavailable for sale.");
    }

}
