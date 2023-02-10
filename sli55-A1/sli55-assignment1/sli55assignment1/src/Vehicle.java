public abstract class Vehicle implements Comparable<Vehicle>{
    public String name;
    public String brand;
    public String model;
    public boolean isAvailable; //Used to determine if a vehicle can be rented or sold.

    public Vehicle(){

    }

    public Vehicle(String name, String brand, String model, boolean isAvailable){
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.isAvailable = isAvailable;
    }

    public abstract void getQuote(); //Prints out the current availability details of the vehicle.

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    /**
     * Print the vehicle details.
     */
    public void printDetails(){
        System.out.println("The name: " + name);
        System.out.println("The brand: " + brand);
        System.out.println("The model: " + model);
        System.out.println("Is available? " + isAvailable);
    }

    public int compareTo(Vehicle cars){
        if(cars != null){
            if(name.equals(cars.name))
                return brand.compareTo(cars.brand);
            else
                return name.compareTo(cars.name);
        }
        else{
            throw new NullPointerException();
        }

    }
}
