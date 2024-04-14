package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import Model.*;
import View.*;

public class ListEmployeesController {
	ListEmployeesView view;
	ListEmployeesModel model;
	AddEmployeeModel addEmpModel;
	Employees empData;


	ArrayList<Employees> emps= new ArrayList<Employees>();
	JTable empTable = new JTable();	
	public ListEmployeesController(ListEmployeesView v)
	{
		view=v;
	}

	public void viewLists()
	{
		model = new ListEmployeesModel();
		JScrollPane scrollPane = model.getScrollPane();
		view.setEmpTable(model.getTable());
		view.setScrollPane(scrollPane);
	}
	
	// update department
		public void updateEmployee() {
			addEmpModel = new AddEmployeeModel();
			try {
				addEmpModel.updateEmployee(view.getEmployees(), view.getIndex());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	

}
