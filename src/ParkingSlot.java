//Represents an individual parking slot that can hold one vehicle
//Implements IParkable interface

public class ParkingSlot implements IParkable {
    private int slotNumber;   //Unique identifier for the slot
    private boolean isOccupied;  // Current occupancy status
    private Vehicle parkedVehicle;  // Reference to parked vehicle

    // Constructor to create a parking slot
    //@param slotNumber The slot identifier
    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.isOccupied = false;  //Slots start unoccupied
    }

    //Getter methods
    public int getSlotNumber() {
        return slotNumber;
    }


    public boolean isOccupied() {
        return isOccupied;
    }

    //Setter methods
    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    //Implements park operation from IParkable
    //Marks slot as occupied and prints status
    @Override
    public void park() {
        this.isOccupied = true;
        System.out.println("Slot " + slotNumber + " is now occupied.");
    }

    //Implements remove operation from IParkable
    //Marks slot as available and clears vehicle reference

    @Override
    public void remove() {
        this.isOccupied = false;
        this.parkedVehicle = null;
        System.out.println("Slot " + slotNumber + " is now free.");
    }
}
