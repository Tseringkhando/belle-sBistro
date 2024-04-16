package Model;

import View.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class AddEmployeeModel {
    private AddEmployeeView ev;
    private ListEmployeesView lv; 
    private ArrayList<Employees> employeeUsers = new ArrayList<>();
    private ListEmployeesModel listEmployeesModel = new ListEmployeesModel(); // list of employees model
    private String filePath = "employees.dat";
    private Employees employeeObj;

    public AddEmployeeModel() {
    	loadEmployeeData();
    }
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
            employeeUsers = listEmployeesModel.getArrays();
        }
        employeeUsers.add(newEmployee);
        saveEmployeeData();
        JOptionPane.showMessageDialog(null, "Employee Added");
    }

    private int getNextEmpID() {
        int highestId = 0;
        for (Employees emp : employeeUsers) {
            if (emp.getEmpID() > highestId) {
                highestId = emp.getEmpID();
            }
        }
        return highestId + 1;
    }

    private void saveEmployeeData() {
    	try {
    	      FileOutputStream fout = new FileOutputStream("employees.dat");
    	      ObjectOutputStream oos = new ObjectOutputStream(fout);
    	      oos.writeObject(employeeUsers);
    	      oos.close();
    	      

    	    }catch (Exception e) {
    	    	e.getMessage();
    	    	e.printStackTrace();
    	    }
    }

    private void loadEmployeeData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            employeeUsers = (ArrayList<Employees>) ois.readObject();
            System.out.println("Loaded employees: " + employeeUsers.size());  // Debugging line
        } catch (IOException | ClassNotFoundException e) {
            employeeUsers = new ArrayList<>();  // If no data file exists, initialize a new list
        }
    }
    
//    public void updateEmployee(ListEmployeesView dv, int i) throws FileNotFoundException, IOException {
//    	 employeeUsers=  listEmployeesModel.getArrays();
//    	    employeeObj= dv.getEmployees();
//    	    employeeUsers.set(i,employeeObj);
//    	    saveEmployeeData();
//    	    JOptionPane.showMessageDialog(null, "Updated Successfully");
//      }
    
    public void updateEmployee(ListEmployeesView dv, int i) throws FileNotFoundException, IOException {
        // Reload the latest list from file or ensure that it's synchronized.
        loadEmployeeData();  // Consider this if you suspect data synchronization issues

        // Retrieve the updated employee object from your view
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
        System.out.println(employeeObj.getEmpID()+"   -----"+ employeeObj.getFirstName());
        // Check if the index is within the bounds of the list
        if (i >= 0 && i < employeeUsers.size()) {
            employeeUsers.set(i, employeeObj);
            saveEmployeeData();
            JOptionPane.showMessageDialog(null, "Updated Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid employee index", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    public ArrayList<Employees> getEmployeeUsers() {
        return employeeUsers;
    }
}
