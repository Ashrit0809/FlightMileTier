/**
 * Represents PlatinumProTier in Flight Miles Program
 */
public class PlatinumProTier extends PlatinumTier{
    /**
     * miles awarded per cancellation in this tier.
     */
    private final int points = 2000;
    /**
     * Constructs a new PlatinumProTier object.
     *
     * @param miles The number of miles accumulated by the user in this tier.
     * @param cancelledFlights The number of cancelled flights by the user in this tier.
     * @param totalFlights The number of flights taken by the user in this tier.
     */
    public PlatinumProTier(int miles, int cancelledFlights, int totalFlights)
    {
        super(miles, cancelledFlights, totalFlights);
    }
    /**
     * Updates the user's miles in this tier.
     *
     * @see PlatinumTier#updateMiles()
     */
    @Override
    public void updateMiles(){
        this.miles = getCancelledflights()*points;
    }
}
