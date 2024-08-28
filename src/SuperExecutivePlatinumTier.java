/**
 * Represents SuperExecutivePlatinumTier class in flight miles program
 */
public class SuperExecutivePlatinumTier extends ExecutivePlatinumTier{
    /**
     * Represents points/miles awarded per cancellation
     */
    private final int points = 2000;

    /**
     * Constructs a new SuperExecutivePlatinumTier object.
     * @param miles The number of miles accumulated by the user in this tier.
     * @param cancelledFlights The number of cancelled flights by the user in this tier.
     * @param totalFlights The number of flights taken by the user in this tier.
     */
    public SuperExecutivePlatinumTier(int miles, int cancelledFlights, int totalFlights){
        super(miles, cancelledFlights, totalFlights);
    }

    /**
     * Updates User's miles in this tier.
     * @see NoTier#updateMiles()
     */
    @Override
    public void updateMiles(){
        this.miles = getCancelledflights()*points;
    }
}
