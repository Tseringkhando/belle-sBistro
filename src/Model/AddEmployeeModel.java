package Model;

import View.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
/**
 * Handles operations related to employee data management including adding, updating,
 * and deleting employee records as well as loading and saving these records to a file.
 */
public class AddEmployeeModel {
  private AddEmployeeView ev;
  private ListEmployeesView lv; 
  private ArrayList<Employees> employeeArray = new ArrayList<>();
  private ListEmployeesModel listEmployeesModel = new ListEmployeesModel(); // list of employees model
  private String filePath = "employees.dat";
  private Employees employeeObj;

  public AddEmployeeModel() {
    loadEmployeeData();
  }
  
  
  /**
   * Adds a new employee to the list and saves the updated list to a file.
   * @param ev The AddEmployeeView containing the input fields for employee data.
   */
  public void addEmployee(AddEmployeeView ev) {
    Employees newEmployee = new Employees(
        getNextEmpID(),
        ev.getTxtFname().getText(),
        ev.getTxtLname().getText(),
        ev.getTxtSin().getText(),
        ev.getTxtAddres().getText(),
        ev.getTxtEmail().getText(),
        ev.getCmbRole().getSelectedItem().toString(),
        ev.getCmbType().getSelectedItem().toString(),
        ((SpinnerDateModel) ev.getDobSpinner().getModel()).getDate().toString(),
        ((SpinnerDateModel) ev.getHireDateSpinner().getModel()).getDate().toString(),
        (Double) ev.getPaySpinner().getValue()
        );

    if (listEmployeesModel.getArrays() != null) {
      employeeArray = listEmployeesModel.getArrays();
    }
    employeeArray.add(newEmployee);
    saveEmployeeData();
    JOptionPane.showMessageDialog(null, "Employee Added");
  }
  
  
  /**
   * Generates the next unique employee ID by finding the highest current ID and incrementing it.
   * @return the next employee ID.
   */
  private int getNextEmpID() {
    int highestId = 0;
    for (Employees emp : employeeArray) {
      if (emp.getEmpID() > highestId) {
        highestId = emp.getEmpID();
      }
    }
    return highestId + 1;
  }
  
  
  /**
   * Saves the current list of employees to the file specified by filePath.
   */
  private void saveEmployeeData() {
    try {
      FileOutputStream fout = new FileOutputStream("employees.dat");
      ObjectOutputStream oos = new ObjectOutputStream(fout);
      oos.writeObject(employeeArray);
      oos.close();


    }catch (Exception e) {
      e.getMessage();
      e.printStackTrace();
    }
  }
  
  
  /**
   * Loads employee data from the file into the employeeArray list.
   */
  private void loadEmployeeData() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
      employeeArray = (ArrayList<Employees>) ois.readObject();
      System.out.println("Loaded employees: " + employeeArray.size());  // Debugging line
    } catch (IOException | ClassNotFoundException e) {
      employeeArray = new ArrayList<>();  // If no data file exists, initialize a new list
    }
  }
  
  
  /**
   * Updates an existing employee's data based on the provided index.
   * @param dv The ListEmployeesView providing updated data.
   * @param i The index of the employee in the list to update.
   * @throws FileNotFoundException, IOException
   */
  public void updateEmployee(ListEmployeesView dv, int i) throws FileNotFoundException, IOException {
    loadEmployeeData();  
    employeeObj = new Employees(dv.getIndex(),dv.getTxtFname().getText(),
        dv.getTxtLname().getText(),
        dv.getTxtSin().getText(),
        dv.getTxtAddres().getText(),
        dv.getTxtEmail().getText(),
        dv.getCmbRole().getSelectedItem().toString(),
        dv.getCmbType().getSelectedItem().toString(),
        ((SpinnerDateModel)dv.getDobSpinner().getModel()).getDate().toString(),
        ((SpinnerDateModel)dv.getHireDateSpinner().getModel()).getDate().toString(),
        (Double)dv.getPaySpinner().getValue());
    if (i >= 0 && i < employeeArray.size()) {
      employeeArray.set(i, employeeObj);
      saveEmployeeData();
      JOptionPane.showMessageDialog(null, "Updated Successfully");
    } else {
      JOptionPane.showMessageDialog(null, "Invalid employee index", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }


   /**
     * Deletes an employee from the list based on the specified index and updates the data file.
     * @param dv The ListEmployeesView related to the employee.
     * @param i The index of the employee to delete.
     */
  public void deleteEmp(ListEmployeesView dv,int i) {
    int re = JOptionPane.showConfirmDialog(null, "Confirm Delete?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (re == JOptionPane.YES_OPTION) {
      employeeArray=  listEmployeesModel.getArrays();
      employeeArray.remove(i);
      // update data
      saveEmployeeData();
      JOptionPane.showMessageDialog(null, "Employee Record Deleted Successfully");}
  }
  
  public ArrayList<Employees> getEmployeeArray() {
      return employeeArray;
  }
}