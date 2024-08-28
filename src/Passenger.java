/**
 * Represents a passenger on a flight.
 *
 */
public class Passenger {
    /**
     * The passenger's tier.
     */
    private Tier tier;
    /**
     * The passenger's ID.
     */
    private final int passengerID;
    /**
     * Whether the passenger's flight was cancelled.
     */
    private boolean isCancelled;
    /**
     * Whether the passenger has complained about the cancelled flight.
     */
    private boolean hasComplained;
    /**
     * Whether it is the end of the year.
     */
    private boolean isEndOfTheYear;
    /**
     * Whether passenger is eligible for a multiplier on their miles.
     */

    private boolean multiplier;
    /**
     * Constructs a new Passenger object.
     *
     * @param passengerID The passenger's ID.
     * @param isCancelled Whether the passenger's flight was cancelled.
     * @param hasComplained Whether the passenger has complained about the cancelled flight.
     * @param isEndOfTheYear Whether it is the end of the year.
     */
    public Passenger(int passengerID, boolean isCancelled, boolean hasComplained, boolean isEndOfTheYearYear) {
        this.tier = new NoTier(isCancelled);
        this.passengerID = passengerID;
        this.isCancelled = isCancelled;
        this.hasComplained = hasComplained;
        this.isEndOfTheYear = isEndOfTheYear;
        this.multiplier = (isCancelled && !hasComplained);
    }
    /**
     * Sets the passenger's tier.
     *
     * @param tier The passenger's tier.
     */

    public void setTier(Tier tier) {
        this.tier = tier;
    }
    /**
     * Gets the passenger's tier.
     *
     * @return The passenger's tier.
     */
    public String getTier(){
        String tierName = tier.toString();
        int index = tierName.indexOf("@");
        tierName =  tierName.substring(0, index);
        return tierName;
    }
    /**
     * Updates the user's tier based on the number of cancelled flights they have had.
     * If the user has had 100 or more cancelled flights, they are upgraded to the Executive Platinum tier.
     * If they have had between 50 and 99 cancelled flights, they are upgraded to the Platinum tier.
     * If they have had between 25 and 49 cancelled flights, they are upgraded to the Gold tier.
     * Otherwise, their tier remains unchanged.
     */
    public void tierUpdate(){
        int miles = getMiles();
        int cancelledFlights = getCancelledFlights();
        int totalFlights = getTotalFlights();

        if (getCancelledFlights() >= 100) {
            setTier(new ExecutivePlatinumTier(miles,cancelledFlights, totalFlights));
            milesUpdate();
        } else if (getCancelledFlights() >= 50 && getCancelledFlights() < 100) {
            setTier(new PlatinumTier(miles, cancelledFlights, totalFlights));
            milesUpdate();
        } else if (getCancelledFlights() >= 25 && getCancelledFlights() < 50) {
            setTier(new GoldTier(miles,cancelledFlights, totalFlights));
            milesUpdate();
        }
    }

    /**
     * Updates user's tier based on their accumulated miles and cancelled flights
     * If cancelled flights exceeds 100 and user has not complained, tier is upgraded to SuoerExecutivePlatinumTier and given a multiplier bonus.
     * f the user has cancelled between 50 and 100 flights and has not complained, they are upgraded to PlatinumProTier and given a multiplier bonus.
     * This method does not return any values, but updates the user's tier and miles.
     */


    public void specialTierUpdate(){
        int miles = getMiles();
        int cancelledFlights = getCancelledFlights();
        int totalFlights = getTotalFlights();

        if(getCancelledFlights() >= 100 && hasComplained==false){
            setTier(new SuperExecutivePlatinumTier(miles, cancelledFlights, totalFlights));
            milesUpdate();
            setMultiplier(true);
        } else if ((getCancelledFlights() >= 50 && getCancelledFlights() < 100) && hasComplained==false){
            setTier(new PlatinumProTier(miles, cancelledFlights, totalFlights));
            milesUpdate();
            setMultiplier(true);
        }
    }
    /**
     * Updates the passenger's miles.
     */
    public void milesUpdate(){
        tier.updateMiles();
    }
    /**
     * Gets the passenger's ID.
     *
     * @return The passenger's ID.
     */
    public int getPassengerID() {
        return passengerID;
    }
    /**
     * Gets whether the passenger's flight was cancelled.
     *
     * @return Whether the passenger's flight was cancelled.
     */
    public boolean getCancelled() {
        return isCancelled;
    }
    /**
     * Sets whether the passenger's flight was cancelled.
     *
     * @param isCancelled Whether the passenger's flight was cancelled.
     */
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
    /**
     * Sets the end of the year status
     * @param endOfYear a boolean value indicating whether it is the end of the year or not
     */

    public void setEndOfTheYear(boolean endOfYear) {
        isEndOfTheYear = endOfYear;
    }
    /**
     * Gets the complaint status of the user.
     * @return a boolean value indicating whether the user has complained or not
     */
    public boolean getHasComplained(){
        return hasComplained;
    }
    /**
     *  Sets the complaint status of the user.
     *   @param hasComplained a boolean value indicating whether the user has complained or not
     */
    public void setHasComplained(boolean hasComplained){
        this.hasComplained = hasComplained;
    }
    /**
     Gets the accumulated miles of the user in the current tier.
     @return an integer value representing the user's miles in the current tier
     */
    public int getMiles(){
        return tier.getMiles();
    }
    /**
     *  Gets the number of cancelled flights of the user in the current tier.
     *  @return an integer value representing the user's cancelled flights in the current tier
     */
    public int getCancelledFlights(){
        return tier.getCancelledflights();
    }
    /**
     * Gets the total number of flights of the user.
     * @return an integer value representing the user's total flights
     */
    public int getTotalFlights(){
        return tier.getFlights();
    }
    /**
     * Checks whether the user has a multiplier or not.
     * @return a boolean value indicating whether the user has a multiplier or not
     */
    public boolean hasMultiplier(){
        return multiplier;
    }

    /**
     * Sets the multiplier status of the user.
     * @param multiplier
     */
    public void setMultiplier(boolean multiplier) {
        this.multiplier = multiplier;
    }

    /**
     * Adds a flight to the user's flight history.
     * @param isCancelled
     */
    public void addFlight(boolean isCancelled){
        tier.addFlight(isCancelled);
    }
}
