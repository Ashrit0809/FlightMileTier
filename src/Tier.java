/**
 * Represents a Tier in Flight Miles Program
 */
public abstract class Tier{
    /**
     * Represents number of miles earned by customer
     */
    protected int miles;
    /**
     * Represents total number of flights taken by user
     */
    protected int flights;
    /**
     * Represents flights that have been cancelled for the user
     */
    protected int CancelledFlights;
    /**
     * Gets the number of miles accumulated by the user in this tier.
     *
     * @return The number of miles accumulated by the user in this tier.
     */
    abstract int getMiles();
    /**
     * Gets the number of cancelled flights by the user in this tier.
     *
     * @return The number of cancelled flights by the user in this tier.
     */
    abstract int getCancelledflights();
    /**
     * Gets the number of flights taken by the user in this tier.
     *
     * @return The number of flights taken by the user in this tier.
     */

    public abstract int getFlights();
    /**
     * Adds a flight to the user's record in this tier.
     *
     * @param isCancelled Whether the flight was cancelled.
     */

    abstract void addFlight(boolean isCancelled);
    /**
     * Updates the user's miles in this tier.
     */
    abstract void updateMiles();

}
