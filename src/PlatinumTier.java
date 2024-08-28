/**
 * Class that Represents Platinum Tier in Flight Miles Program
 */
public class PlatinumTier extends NoTier{
    /**
     * Represents the number of points/miles awarded per cancellation
     */
    private final int points = 1000;
    /**
     * Constructs a new PlatinumTier object.
     *
     * @param miles The number of miles accumulated by the user in this tier.
     * @param cancelledFlights The number of cancelled flights by the user in this tier.
     * @param totalFlights The number of flights taken by the user in this tier.
     */
    public PlatinumTier(int miles, int cancelledFlights, int totalFlights){
        super(miles, cancelledFlights, totalFlights);
    }
    /**
     * Updates the user's miles in this tier.
     *
     * @see NoTier#updateMiles()
     */
    @Override
    public void updateMiles(){
        this.miles = getCancelledflights()*points;
    }
}