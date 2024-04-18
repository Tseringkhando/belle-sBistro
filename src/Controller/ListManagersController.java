package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.AddEmployeeModel;
import Model.Employees;
import Model.ListEmployeesModel;
import Model.ListManagersModel;
import View.ListEmployeesView;
import View.ListManagersView;

/**
 * The ListManagersController class is responsible for handling user interactions
 * and updating the view and model for the list of managers in the Human Resource
 * Management System (HRMS) application.
 */
public class ListManagersController {
	private ListManagersView view;
	private ListManagersModel model;
	private Employees empData;


	private ArrayList<Employees> emps= new ArrayList<Employees>();
	private JTable empTable = new JTable();	
	
	/**
     * Constructor for the ListManagersController class.
     * @param v The ListManagersView object associated with this controller.
     */
	public ListManagersController(ListManagersView v)
	{
		view=v;
	}
	/**
     * Method to populate and display the list of managers in the view.
     */
	public void viewLists()
	{
		model = new ListManagersModel();
		JScrollPane scrollPane = model.getScrollPane();
		view.setEmpTable(model.getTable());
		System.out.println(model.getTable().getRowCount());
		view.setScrollPane(scrollPane);

	}
	
	



}
