package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a department with a department ID and name.
 */
public class Departments implements Serializable {

	/**
	 * This is the model for Department class
	 */
	private static final long serialVersionUID = 1L;
	
	private String deptID, deptName;
	ArrayList<Departments> d = new ArrayList<Departments>();
	
	// Parameterized constructor
	public Departments(String id, String name)
	{
		setDeptID(id);
		setDeptName(name);
	}
	
	// Default constructor
	public Departments() {}
	
	// Getter for department ID
	public String getDeptID() {
		return deptID;
	}
	
	// Setter for department ID
	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}
	
	 // Getter for department name
	public String getDeptName() {
		return deptName;
	}
	
	 // Setter for department name
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
