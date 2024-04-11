package Model;

import View.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class AddEmployeeModel {
    private AddEmployeeView ev;
    
    private ArrayList<Employees> employeeUsers = new ArrayList<>();
    private String filePath = "employees.dat";
    ListEmployeesModel listEmployeesModel = new ListEmployeesModel();
    public AddEmployeeModel(AddEmployeeView ev) {
        this.ev = ev;
    }

    public void addEmployee() {
        Employees employeeData = new Employees(
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
        
        if(listEmployeesModel.getArrays()!=null) {
        	
        	employeeUsers= listEmployeesModel.getArrays();
        	employeeUsers.add(employeeData);
        	saveEmployeeData(); 
            JOptionPane.showMessageDialog(null, "Employee Added");
          }
          else {

        	  employeeUsers.add(employeeData);
            saveEmployeeData(); 
            JOptionPane.showMessageDialog(null, "Employee Added");
          }
    }

    private void saveEmployeeData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(employeeUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


	public ArrayList<Employees> getEmployeeUsers() {
		return listEmployeesModel.getArrays();
	}

	

}
