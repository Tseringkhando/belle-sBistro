package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

import Model.*;
import View.*;

/**
 * The ListDepartmentsController class is responsible for handling user interactions
 * and updating the view and model for the list of departments in the Human Resource
 * Management System (HRMS) application.
 */
public class ListDepartmentsController {
	private ListDepartmentsView view;
	private ListDepartmentsModel model;
	private AddDepartmentModel addDeptModel;
	private Departments deptData;
	
	
<<<<<<< HEAD
	private ArrayList<Departments>depts= new ArrayList<Departments>();
	private JTable deptTable = new JTable();	
=======
	ArrayList<Departments>depts= new ArrayList<Departments>();
	JTable deptTable = new JTable();
	
	/**
     * Constructor for the ListDepartmentsController class.
     * @param v The ListDepartmentsView object associated with this controller.
     */
>>>>>>> c7f9151701a3b368e1fcb57de3f1609327ff103d
	public ListDepartmentsController(ListDepartmentsView v)
	{ view=v;
	 
	 }
	
	/**
     * Method to populate and display the list of departments in the view.
     */
	public void viewLists()
	{
		model = new ListDepartmentsModel();
		JScrollPane scrollPane = model.getScrollPane();
		view.setTable(model.getTable());
		view.setScrollPane(scrollPane);
		
		
	}
	/**
     * Method to update a department's information.
     * @param view The ListDepartmentsView object associated with this controller.
     */
	public void updateDepts(ListDepartmentsView view) {
	    view.addActionUpdateDepartment(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            addDeptModel = new AddDepartmentModel();
	            try {
	            	if(!view.getName().equals("")) {
	            		addDeptModel.updateDepartment(view, view.getIndex());
		                model.refreshTableModel(); // Refresh the table model
		                view.getPane().revalidate();
		                view.getPane().repaint();
		                JOptionPane.showMessageDialog(null, "Updated Successfully");
	            	}else {
	            		JOptionPane.showMessageDialog(view, "Department cannot be empty.");
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
     * Method to delete a department from the list.
     * @param v The ListDepartmentsView object associated with this controller.
     */
	public void deleteDept(ListDepartmentsView v)
	{
		v.addActionDeleteDepartment(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDepartmentModel n = new AddDepartmentModel();
				n.deleteDept(v, v.getIndex());
				model.refreshTableModel(); // Refresh the table model
                view.getPane().revalidate();
                view.getPane().repaint();
                JOptionPane.showMessageDialog(null, "Department Deleted Successfully");
			}
		});
	}
	

	
	
}
	

