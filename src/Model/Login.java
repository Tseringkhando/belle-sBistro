package Model;

import java.io.*;
import java.util.*;

/**
 * Represents the login mechanism for different types of users and manages user credentials.
 */
public class Login {
    private String username;
    private char[] password;
    private String type;
    private String file; // Filename where user data is stored.

    /**
     * Loads administrator credentials from a data file.
     */
    public void loginAdmin() {
        try {
            FileInputStream fis = new FileInputStream("users.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Users obj;
            while ((obj = (Users) ois.readObject()) != null) {
                setUsername(obj.getUsername());
                setPassword(obj.getPassword());
            }
            ois.close();
        } catch (Exception e) {
            e.printStackTrace(); // Log or handle the exception as needed
        }
    }

    /**
     * Verifies if the provided username and password match the stored credentials.
     * 
     * @param username The username to verify.
     * @param password The password to verify.
     * @return true if the credentials match, false otherwise.
     */
    public boolean verify(String username, char[] password) {
        if (this.username.equals(username) && Arrays.equals(this.password, password)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets the file path for storing or retrieving user data.
     * @param file the path to the file.
     */
    public void setUserFile(String file) {
        this.file = file;
    }

    /**
     * Gets the file path used for storing or retrieving user data.
     * @return the path to the file.
     */
    public String getFile() {
        return file;
    }

    /**
     * Sets the username for the user.
     * @param username the username to set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the stored username.
     * @return the username.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the password for the user.
     * 
     * @param password the password to set.
     */
    public void setPassword(char[] password) {
        this.password = password;
    }

    /**
     * Gets the stored password.
     * @return the password.
     */
    public char[] getPassword() {
        return this.password;
    }

    /**
     * Sets the type of the user (e.g., Admin, User).
     * 
     * @param type the type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the type of the user.
     * 
     * @return the type.
     */
    public String getType() {
        return this.type;
    }
}
