package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a method to load departments from a serialized file.
 */
public class DepartmentLoader {
	
	/**
     * Loads departments from a serialized file.
     * @param fileName The name of the file to load departments from.
     * @return A list of Departments loaded from the file.
     */
	  public static List<Departments> loadDepartments(String fileName) {
	        List<Departments> departments = new ArrayList<>();
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
	            // Assuming the whole ArrayList is serialized in one go
	            departments = (ArrayList<Departments>) ois.readObject();
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return departments;
	    }
}
