package Model;

import java.io.Serializable;

public class Employees implements Serializable {

	/**
	 * This class represents an employee with various attributes.
	 */
	private static final long serialVersionUID = 1L;
	private int empID;
	private String firstName, lastName, sin, address, email, role, type, dob, hireDate, departmentName;
	private double hourlyPay;

    // Default constructor
    public Employees() {
    }
    
    // Parameterized constructor
    public Employees(int id,String fname, String lname, String newSin, String add, String newEmail, 
    			String newRole, String empType, String newDob, String newHireDate, 
    			double newHourlyPay, String dept) {
        empID = id;
    	firstName = fname;
        lastName = lname;
        sin = newSin;
        address = add;
        email = newEmail;
        role = newRole;
        type = empType;
        dob = newDob;
        hireDate = newHireDate;
        hourlyPay = newHourlyPay;
        departmentName = dept;
    }

    // Getters
    public int getEmpID() {
    	return empID;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSin() {
        return sin;
    }

    public String getAddress() {
        return address;
    }
    
    public String getEmail() {
		return email;
	}

    public String getRole() {
        return role;
    }

    public String getType() {
        return type;
    }

    public String getDob() {
        return dob;
    }

    public String getHireDate() {
        return hireDate;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }



    
 // Setters
    
    public void setEmpID(int id) {
		empID = id;
	}
    
    public void setFirstName(String newName) {
        firstName = newName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    public void setSin(String newSin) {
        sin = newSin;
    }

    public void setAddress(String newAddress) {
        address = newAddress;
    }
    
    public void setEmail(String newEmail) {
		email = newEmail;
	}

    public void setRole(String newRole) {
        role = newRole;
    }

    public void setType(String newType) {
        type = newType;
    }

    public void setDob(String newDob) {
        dob = newDob;
    }

    public void setHireDate(String newHireDate) {
        hireDate = newHireDate;
    }

    public void setHourlyPay(double newHourlyPay) {
        hourlyPay = newHourlyPay;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


}
