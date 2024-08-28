/**
 * Represents a no-tier membership.
 * A no-tier member does not receive any points for cancelled flights.
 */
public class NoTier extends Tier {
    /**
     * Constructs a new no-tier membership with the given cancelled flight status.
     * @param isCancelled
     */
    public NoTier(boolean isCancelled){
        addFlight(isCancelled);
    }

    /**
     * Constructs a new no-tier membership with the given miles, cancelled flights, and total flights.
     * @param miles
     * @param CancelledFlights
     * @param totalFlights
     */
    public NoTier(int miles, int CancelledFlights, int totalFlights)
    {
        this.miles = miles;
        this.CancelledFlights = CancelledFlights;
        this.flights = totalFlights;
    }
    /**
     * Gets the number of miles accumulated by the user in this tier.
     *
     * @return The number of miles accumulated by the user in this tier.
     */
    @Override
    public int getMiles()
    {
        return this.miles;
    }
    /**
     * Updates the user's miles in this tier.
     */
    @Override
    public void updateMiles(){
        this.miles = getCancelledflights();
    }
    /**
     * Gets the number of cancelled flights by the user in this tier.
     *
     * @return The number of cancelled flights by the user in this tier.
     */
    @Override
    public int getCancelledflights() {
        return this.CancelledFlights;
    }
    /**
     * Gets the number of flights taken by the user in this tier.
     *
     * @return The number of flights taken by the user in this tier.
     */
    @Override
    public int getFlights()
    {
        return this.flights;
    }
    /**
     * Adds a flight to the user's record in this tier.
     *
     * @param isCancelled Whether the flight was cancelled.
     */
    @Override
    public void addFlight(boolean isCancelled){
        if (isCancelled){
            this.CancelledFlights++;
        }
    }
}
