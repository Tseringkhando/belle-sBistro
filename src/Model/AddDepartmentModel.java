package Model;
import View.*;
//import model.AddDepartModel;

import java.io.*;
import java.util.*;
import javax.swing.*;
import Controller.*;

/**
 * This class represents the model for adding departments.
 */
public class AddDepartmentModel {
  private AddDepartmentView dv;  // Reference to the view

  private ArrayList <Departments> deptUsers  = new ArrayList<Departments>();
  private ListDepartmentsModel deptRecord = new ListDepartmentsModel(); // list of department model
  private Departments deptData; // Department data

  /**
   * Method to add a department to the system.
   */
  public void addArray(AddDepartmentView dv) {
      if (!deptIdExists(dv.getDeptID().getText())) {
    	// Create a new department object
          Departments deptData = new Departments(dv.getDeptID().getText(), dv.getDeptName().getText());
          deptUsers.add(deptData);  // Add the department to the list
          addDepartmentData();  // Save the updated list to file
          JOptionPane.showMessageDialog(null, "Department Added");
      } else {
          JOptionPane.showMessageDialog(null, "Department code already exists!", "Error", JOptionPane.ERROR_MESSAGE);
      }
  }
  
  /**
   * Method to check if a department ID already exists.
   */
  public boolean deptIdExists(String id) {
      if (deptRecord.getArrays() != null) {
          deptUsers = deptRecord.getArrays();
          for (Departments dept : deptUsers) {
              if (dept.getDeptID().equals(id)) {
                  return true;
              }
          }
      }
      return false;
  }
  
  /**
   * Method to save department data to file.
   */
  public void addDepartmentData() 
  {
    try {
      FileOutputStream fout = new FileOutputStream("departments.dat");
      ObjectOutputStream oos = new ObjectOutputStream(fout);
      oos.writeObject(deptUsers);
      oos.close();
      

    }catch (Exception e) {
    	e.getMessage();
    	e.printStackTrace();
    }


  }


  //modify department
  public void updateDepartment(ListDepartmentsView dv, int i) throws FileNotFoundException, IOException {
    deptUsers=  deptRecord.getArrays();  // Get the list of departments
    deptData= new Departments(dv.getID(), dv.getName());  // Create a new department object
    deptUsers.set(i,deptData); // Update the department at index i
    addDepartmentData(); // Save updated department list to file
    deptRecord.refreshTableModel(); // Refresh the table model to reflect changes
  }
  
  

  //delete department
  public void deleteDept(ListDepartmentsView dv,int i) {
    int re = JOptionPane.showConfirmDialog(null, "Confirm Delete?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (re == JOptionPane.YES_OPTION) {
    deptUsers=  deptRecord.getArrays();  // Get the list of departments
    deptUsers.remove(i);  // Remove the department at index i
    // updata data
    addDepartmentData();
    }
  }

}
