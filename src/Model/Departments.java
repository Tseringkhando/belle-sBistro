package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Departments implements Serializable {

	/**
	 * This is the model for Department class
	 */
	private static final long serialVersionUID = 1L;
	
	private String deptID, deptName;
	ArrayList<Departments> d = new ArrayList<Departments>();
	public Departments(String id, String name)
	{
		setDeptID(id);
		setDeptName(name);
	}
	public Departments() {}
	public String getDeptID() {
		return deptID;
	}
	public void setDeptID(String deptID) {
		this.deptID = deptID;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
