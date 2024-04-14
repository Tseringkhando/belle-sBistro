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
        } catch (IOException | ClassNotFoundException e) {
            employeeUsers = new ArrayList<>();  // If no data file exists, initialize a new list
        }
    }
    
    public void updateEmployee(Employees e, int i) throws FileNotFoundException, IOException {
    	employeeUsers=  listEmployeesModel.getArrays();
    	System.out.println(i+", ---"+ e.toString());
        employeeUsers.set(i,e);
        saveEmployeeData();
        JOptionPane.showMessageDialog(null, "Updated Successfully");
      }



    public ArrayList<Employees> getEmployeeUsers() {
        return employeeUsers;
    }
}
