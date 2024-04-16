package Controller;

import java.awt.event.*;
import javax.swing.*;
import Model.AddEmployeeModel;
import Model.Employees;
import View.AddEmployeeView;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.regex.Pattern;
/**
 * Controls the process of adding new employees and managing their data validation.
 */
public class AddEmployeeController {
    AddEmployeeView view;
    AddEmployeeModel model;
    /**
     * Constructor for AddEmployeeController.
     *
     * @param v The view associated with this controller.
     */
    public AddEmployeeController(AddEmployeeView v) {
        view = v;
    }

    /**
     * Initializes the controller by setting up action listeners for saving and clearing employee data.
     */
    public void empController() {
    	model = new AddEmployeeModel();
        // Save employee
        view.getBtnSaveEmp().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            		if (validateInputs()) {
                        model.addEmployee(view);
                        resetFields();
                    }
            	    
            
            }
        });

        // Reset fields
        view.getBtnClear().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
    }
    /**
     * Validates the input fields for new employee data.
     *
     * @return true if all inputs are valid, otherwise false.
     */
    private boolean validateInputs() {
        String sin = view.getTxtSin().getText();
        String email = view.getTxtEmail().getText();
        double payRate = (Double) view.getPaySpinner().getValue();
        Date dob = ((SpinnerDateModel) view.getDobSpinner().getModel()).getDate();
        ArrayList<Employees> employees = model.getEmployeeArray();
        
        if(!employees.isEmpty()) {
        	 // Check for existing SIN or email
            for (Employees emp : employees) {
                if (emp.getSin().equals(sin)) {
                    JOptionPane.showMessageDialog(view, "An employee with this SIN already exists.");
                    return false;
                }
                if (emp.getEmail().equals(email)) {
                    JOptionPane.showMessageDialog(view, "An employee with this email already exists.");
                    return false;
                }
            }
        }

        // Validate SIN
        if (!Pattern.matches("\\d{9}", sin)) {
            JOptionPane.showMessageDialog(view, "SIN must be 9 digits only.");
            return false;
        }

        // Validate email using RegEx
        if (!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", email)) {
            JOptionPane.showMessageDialog(view, "Invalid email format.");
            return false;
        }

       

        // Validate age
        Calendar cal = Calendar.getInstance();
        cal.setTime(dob);
        int age = Calendar.getInstance().get(Calendar.YEAR) - cal.get(Calendar.YEAR);
        if (age < 0 || age > 100) {
            JOptionPane.showMessageDialog(view, "Age must be between 0 and 100.");
            return false;
        }

        // Validate pay rate
        if (payRate <= 0.0) {
            JOptionPane.showMessageDialog(view, "Pay rate must be greater than 0.");
            return false;
        }

        return true;
    }
    /**
     * Resets all input fields to their default states.
     */
    private void resetFields() {
        view.getTxtFname().setText("");
        view.getTxtLname().setText("");
        view.getTxtSin().setText("");
        view.getTxtEmail().setText("");
        view.getTxtAddres().setText("");
        view.getCmbRole().setSelectedIndex(0);
        view.getCmbType().setSelectedIndex(0);
        view.getDobSpinner().setValue(new Date());
        view.getHireDateSpinner().setValue(new Date());
        view.getPaySpinner().setValue(16.55);
    }
}
