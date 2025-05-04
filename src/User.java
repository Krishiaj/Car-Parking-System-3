import java.io.*;
import java.util.Scanner;
import java.util.Formatter;

// Handles user auhentication and registration
public class User {
    private String username; //User's login name
    private String password; //User;s password

    //Constructor to create a User
    //@param username Login name
    //@param password Login password

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Getter for username

    public String getUsername() {
        return username;
    }


    //Authenticates user against stored credentials
    //@return true if login successful
    //@throws InvalidInputException if credentials dont match
    public boolean login() throws InvalidInputException{
        try (Scanner scanner = new Scanner(new File("F:\\ahmed.txt"))) {
            //Check each line in credentials file
            while (scanner.hasNextLine()) {
                String[] credentials = scanner.nextLine().split(",");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    return true;
                }
            }
            
            throw new InvalidInputException();
        }
        catch (InvalidInputException e){
            System.out.println("username or Password is incorrect ");
        }
        
        
        catch (FileNotFoundException e) {
            System.out.println("error in reading");
        }
        return false;
    }

    //Registers a new user by saving credentials to file
    //@return true if registration successful

    public boolean register() {
        try (Formatter out = new Formatter(new FileWriter("F:\\ahmed.txt", true))) {
            //Append new credentials to file
            out.format("%s,%s%n",username,password);
            return true;
        } catch (IOException e) {
            System.out.println("error in writing");
        }
        return false;
    }
}
