public interface SaleInterface {
    /**
     * @param buyer
     * @return true or false
     * @param <T>
     */
    <T> boolean transferOwnership(String buyer);
}
