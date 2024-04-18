package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;

import Model.*;
import View.*;

/**
 * The ListEmployeesController class is responsible for handling user interactions
 * and updating the view and model for the list of employees in the Human Resource
 * Management System (HRMS) application.
 */
public class ListEmployeesController {

	private ListEmployeesView view;
	private ListEmployeesModel model;
	private AddEmployeeModel addEmpModel;
	private Employees empData;
	private ArrayList<Employees> emps= new ArrayList<Employees>();
	private JTable empTable = new JTable();	

	/**
    * Constructor for the ListEmployeesController class.
    * @param v The ListEmployeesView object associated with this controller.
    */
	public ListEmployeesController(ListEmployeesView v)
	{
		view=v;
	}
    
	/**
    * Method to populate and display the list of employees in the view.
    */
	public void viewLists()
	{
		model = new ListEmployeesModel();
		JScrollPane scrollPane = model.getScrollPane();
		view.setEmpTable(model.getTable());
		view.setScrollPane(scrollPane);

	}

	/**
    * Method to update an employee's information.
    * @param view The ListEmployeesView object associated with this controller.
    */
	public void updateEmployeeData(ListEmployeesView view) {
		view.addUpdateEmpListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 addEmpModel = new AddEmployeeModel();
	                int indexToUpdate = view.getIndex(); // Get the index of the employee being updated
	                try {
	                    if (validateInputs(indexToUpdate)) { // Pass index to validate inputs method
	                        addEmpModel.updateEmployee(view, indexToUpdate);
	                        model.refreshTableModel();
	                        view.getScrollPane().revalidate();
	                        view.getScrollPane().repaint();
	                        System.out.println(indexToUpdate + ", " + (indexToUpdate));
	                    }
	                } catch (FileNotFoundException e1) {
	                    e1.printStackTrace();
	                } catch (IOException e1) {
	                    e1.printStackTrace();
	                }
	            }
		});
	}
	
	/**
     * Method to delete an employee from the list.
     * @param v The ListEmployeesView object associated with this controller.
     */
		public void deleteEmp(ListEmployeesView v)
		{
			v.addDeleteEmpListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addEmpModel = new AddEmployeeModel();
					addEmpModel.deleteEmp(v, v.getIndex());
					model.refreshTableModel(); // Refresh the table model
	                view.getScrollPane().revalidate();
	                view.getScrollPane().repaint();
				}
			});
		}
		/**
	    * Method to initialize the department ComboBox with department names.
	    */
		public void initializeComponents() {
	        List<Departments> departments = DepartmentLoader.loadDepartments("departments.dat");
	        for (Departments department : departments) {
	        	view.getDepartmentComboBox().addItem(department.getDeptName()); // Add department name to JComboBox
	        }
	    }
		
		
		 /**
	     * Validates the input fields for updating employee data.
	     *
	     * @return true if all inputs are valid, otherwise false.
	     */
		 private boolean validateInputs(int currentIndex) {
		        if (!view.getTxtFname().getText().equals("") && !view.getTxtLname().getText().equals("")) {
		            String sin = view.getTxtSin().getText();
		            String email = view.getTxtEmail().getText();
		            double payRate = (Double) view.getPaySpinner().getValue();
		            Date dob = ((SpinnerDateModel) view.getDobSpinner().getModel()).getDate();
		            ArrayList<Employees> employees = addEmpModel.getEmployeeArray();

		            for (int i = 0; i < employees.size(); i++) {
		                if (i == currentIndex) continue; // Skip the current employee
		                
		                Employees emp = employees.get(i);
		                if (emp.getSin().equals(sin)) {
		                    JOptionPane.showMessageDialog(view, "An employee with this SIN already exists.");
		                    return false;
		                }
		                if (emp.getEmail().equals(email)) {
		                    JOptionPane.showMessageDialog(view, "An employee with this email already exists.");
		                    return false;
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
		        } else {
		            JOptionPane.showMessageDialog(view, "Employee's names cannot be empty.");
		            return false;
		        }
		    }
		}