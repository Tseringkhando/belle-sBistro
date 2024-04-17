package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.*;
import View.*;

/**
 * The ListEmployeesController class is responsible for handling user interactions
 * and updating the view and model for the list of employees in the Human Resource
 * Management System (HRMS) application.
 */
public class ListEmployeesController {
	ListEmployeesView view;
	ListEmployeesModel model;
	AddEmployeeModel addEmpModel;
	Employees empData;


	ArrayList<Employees> emps= new ArrayList<Employees>();
	JTable empTable = new JTable();	
	
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
				try {
					addEmpModel.updateEmployee(view, view.getIndex());
					model.refreshTableModel(); // Refresh the table model
	                view.getScrollPane().revalidate();
	                view.getScrollPane().repaint();
					System.out.println(view.getIndex()+ ", "+ (view.getIndex()));
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
		
		

	
	



}
