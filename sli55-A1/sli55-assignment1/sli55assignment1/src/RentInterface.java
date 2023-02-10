public interface RentInterface {
    /**
     * hire the vehicle
     * @param renter
     * @return true or false
     * @param <T>
     */
    <T> boolean hireThis(String renter);

    /**
     * @param mileage
     * @return true or false
     * @param <T>
     */
    <T> boolean returnThis(int mileage);
}
