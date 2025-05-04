/* Represents a Car vehicle that can be parked in the system
 * Extends the abstract vehicle class and implements IParkable interface
 */

public class Car extends Vehicle implements IParkable {
    private String contactNumber;  // Contact number of the car owner

    //Constructor to create a Car instance.
    //@param licensePlate Unique identifier for the vehicle
    // @param ownerName Name of the vehicle owner
    // @param contactNumber Contact number of the owner


    public Car(String licensePlate, String ownerName, String contactNumber) {
        super(licensePlate, ownerName);
        this.contactNumber = contactNumber;
    }

    //Getter and setter for contact number
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
 // Implements park operation from IParkable interface
    // Prints confirmation message when car is parked
    @Override
    public void park() {
        System.out.println("Car parked.");
    }
    //Implements remove operation from IParkable interface
    //Prints confirmation message when car is removed

    @Override
    public void remove() {
        System.out.println("Car removed.");
    }
}