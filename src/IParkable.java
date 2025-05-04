//Interface defining the contract for parkable objects
//Any class that implements this interface must provide these methods

public interface IParkable {

    // Method to handle parking operation
    void park();

    //Method to handle removal operation
    void remove();
}