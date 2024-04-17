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

	// update employee
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
	
	// delete emp
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
		
		public void initializeComponents() {
	        List<Departments> departments = DepartmentLoader.loadDepartments("departments.dat");
	        for (Departments department : departments) {
	        	view.getDepartmentComboBox().addItem(department.getDeptName()); // Add department name to JComboBox
	        }
	    }
		
		

	
	



}
