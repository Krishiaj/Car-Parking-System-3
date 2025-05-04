//Abstract base class representing a vehicle
//Defines common properties and behaviors for all vehicles

abstract class Vehicle {
    protected String licensePlate; //Unique vehicle identifier
    protected String ownerName;  //Name of the vehicle owner

    //Constructor to create a Vehicle
    //@param licensePlate Unique identifier
    //@param ownerName Owner's name

    public Vehicle(String licensePlate, String ownerName) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
    }

    //Getter methods
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    //Abstract methods to be implemented by subclasses

    public abstract void park();

    public abstract void remove();
}