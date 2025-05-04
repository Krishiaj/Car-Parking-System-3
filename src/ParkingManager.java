import java.util.*;
//Manages parking operations and maintains parking slot state
public class ParkingManager {
    //List to maintain all parking slots
    private List<ParkingSlot> parkingSlots;
    //Map for quick vehicle loopup by license plate
    private Map<String, ParkingSlot> parkedVehicles;

    //Constructor to initialize parking manager
    //@param number0fSlots Total parking slots to create

    public ParkingManager(int numberOfSlots) {
        parkingSlots = new ArrayList<>();
        //Create specified number of parking slots
        for (int i = 1; i <= numberOfSlots; i++) {
            parkingSlots.add(new ParkingSlot(i));
        }
        parkedVehicles = new HashMap<>();
    }
    //Parks a vehicle in the first available slot
    //@param vehicle The vehicle to park
    //@return true if parking successful, false if no slots available

public boolean parkVehicle(Vehicle vehicle) {
        //Linear search for first available slot
    for (int i = 0; i < parkingSlots.size(); i++) {
        ParkingSlot slot = parkingSlots.get(i);
        if (!slot.isOccupied()) {
            slot.setParkedVehicle(vehicle);
            slot.park();
            //Add to quick lookup map
            parkedVehicles.put(vehicle.getLicensePlate(), slot);
            //Park vehicle logic
            return true;
        }
    }
    return false;
}

    // Removes a vehicle by its license plate
    //@param licensePlate The vehicle to remove
    //@return true if removal successful, false if vehicle not found



    public boolean removeVehicle(String licensePlate) {
        //HashMap lookup (ParkingManager.java)
        if (parkedVehicles.containsKey(licensePlate)) {
            ParkingSlot slot = parkedVehicles.remove(licensePlate);
            //Removal logic
            slot.remove();
            return true;
        }
        return false;
    }

    //Displays current status of all parking slots

public void checkParkingStatus() {
    for (int i = 0; i < parkingSlots.size(); i++) {
        ParkingSlot slot = parkingSlots.get(i);
        if (slot.isOccupied()) {
            Vehicle vehicle = slot.getParkedVehicle();
            System.out.println("Slot " + slot.getSlotNumber() + ": Occupied | License Plate: " + vehicle.getLicensePlate() + " | Owner: " + vehicle.getOwnerName());
        } else {
            System.out.println("Slot " + slot.getSlotNumber() + ": Free");
        }
    }
}

}
