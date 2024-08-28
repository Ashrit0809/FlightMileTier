/**
 * Represents a Gold tier membership.
 */
public class GoldTier extends NoTier{
    /**
     * A Gold tier member receives 1000 points for each cancelled flight.
     */
    private final int points = 1000;
    /**
     * Constructs a new PlatinumTier object.
     *
     * @param mile The number of miles accumulated by the user in this tier.
     * @param cancelledFlights The number of cancelled flights by the user in this tier.
     * @param totalFlights The number of flights taken by the user in this tier.
     */
    public GoldTier(int mile, int cancelledFlights, int totalFlights){
        super(mile, cancelledFlights, totalFlights);
    }
    /**
     * Updates the user's miles in this tier.
     *
     * @see NoTier#updateMiles()
     */
    @Override
    public void updateMiles(){
        this.miles = getCancelledflights() * points;
    }
}