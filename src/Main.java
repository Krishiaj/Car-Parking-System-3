import java.util.Scanner;

// Main class containing the entry point of the application
//Handles user interaction and menu navigation
public class Main {
    // Main method - starting point of the application
    //@param args Command line arguments (not used)
    //@throws InvalidInputException if login credentials are invalid
    public static void main(String[] args) throws InvalidInputException {
        Scanner scanner = new Scanner(System.in);
        //Initialze parking manager with 10 slots
        ParkingManager parkingManager = new ParkingManager(10);

        //Main application loop
while (true) {
        System.out.println("Welcome to the Car Parking Management System");
        System.out.println("1. Register");
        System.out.println("2. Login");

        int choice = scanner.nextInt();
        scanner.nextLine();  //Consume newline


      //Authentication loop
    while (true) {
        if (choice == 1) {
            //Registration process
            System.out.println("Register");
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            User user = new User(username, password);
            if (user.register()) {
                System.out.println("Registration successful.");
                break;
            } else {
                System.out.println("Registration failed.");
                break;
            }
        } else {
            if (choice == 2) {
                //Login process
                System.out.println("Login");
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                User user = new User(username, password);
                if (user.login()) {
                    System.out.println("Login successful.");

                    //Parking operations menu
                   
                    while (true) {
                        System.out.println("1. Park Vehicle");
                        System.out.println("2. Remove Vehicle");
                        System.out.println("3. Check Parking Status");
                        System.out.println("4. Exit");
                        int option = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        switch (option) {
                            case 1:
                                //Park vehicle flow
                                System.out.print("License Plate: ");
                                String licensePlate = scanner.nextLine();
                                System.out.print("Owner Name: ");
                                String ownerName = scanner.nextLine();
                                System.out.print("Contact Number: ");
                                String contactNumber = scanner.nextLine();
                                Car car = new Car(licensePlate, ownerName, contactNumber);
                                if (parkingManager.parkVehicle(car)) {
                                    System.out.println("Vehicle parked successfully.");
                                } else {
                                    System.out.println("Parking is full.");
                                }
                                break;
                            case 2:
                                //Remove vehicle flow
                                System.out.print("License Plate: ");
                                String lp = scanner.nextLine();
                                if (parkingManager.removeVehicle(lp)) {
                                    System.out.println("Vehicle removed successfully.");
                                } else {
                                    System.out.println("Vehicle not found.");
                                }
                                break;
                            case 3:
                                //Check parking status
                                parkingManager.checkParkingStatus();
                                break;
                            case 4:
                                //Exit application
                                System.out.println("Exiting...");
                                return;
                            default:
                                System.out.println("Invalid option.");
                        }
                    }
                } else {
                    System.out.println("Login failed.");
                }
            }
        }
    }
}

    }

}
