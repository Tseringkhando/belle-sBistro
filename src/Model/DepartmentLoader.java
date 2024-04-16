package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentLoader {

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
