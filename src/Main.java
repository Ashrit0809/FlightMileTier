import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    /**
     * The main method is the entry point of the application.
     * @param args command line arguments passed to the application.
     * @throws FileNotFoundException if the input file is not found.
     * @throws IOException if an IO error occurs while reading the input file.
     */
    public static void main(String args[]) throws FileNotFoundException, IOException {
        /**
         * 1. Get Input from the file.
         * 2. Get the passenger id from the input
         * 3. Get the passenger class for the provided passengerID. If not present, create a new and put that to hashmap
         * 4. After reading all the input, check if we need to upgrade to mileage multiplier.
         * 5. Take passengerID as input from the user, until and unless -1 is entered.
         * 6. For passengerID, print the details that are asked.
         */
        HashMap<Integer, Passenger> passengers = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/ashritk/CS2336Project1/flight-data.txt"))) {
            for (String line; (line = br.readLine()) != null && line.length() != 0;) {
                // process the line.
                String[] inputData = line.split("\\s+");
                int passengerID = Integer.parseInt(inputData[0]);
                Passenger currPassenger = passengers.get(passengerID);
                if (currPassenger == null) {
                    currPassenger = new Passenger(passengerID,false,false,false);
                    passengers.put(passengerID, currPassenger);
                }
                if (inputData[1].equals("Y")) {
                    currPassenger.addFlight(true);
                    if (inputData[2].equals("Y")) {
                        //Check if the passenger has complained or not.
                        currPassenger.setHasComplained(true);
                    }
                } else {
                    currPassenger.addFlight(false);
                }
            }

        }

        for (Integer passengerID : passengers.keySet()) {
            Passenger currPassenger = passengers.get(passengerID);
            currPassenger.tierUpdate();
            currPassenger.specialTierUpdate();
        }
        Scanner scanner = new Scanner(System.in);
        int inputId;
        do {
            System.out.print("Please Enter the passanger Id: ");
            inputId = scanner.nextInt();
            Passenger currPassenger = passengers.get(inputId);
            if (passengers.containsKey(inputId)) {
                System.out.println("Passenger Id: " + inputId);
                System.out.println("Tier: " + currPassenger.getTier());
                System.out.println("Total Miles: " + currPassenger.getMiles());
                System.out.println("Total Cancellations: " + currPassenger.getCancelledFlights());
                System.out.println("Mileage Multiplier: " + currPassenger.hasMultiplier());
            } else {
                System.out.println("Passanger ID is not available");
            }

        } while (inputId != -1);
        {
            System.out.println("Program ended");
        }
        scanner.close();
    }

}