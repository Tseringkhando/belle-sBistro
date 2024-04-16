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

public class ListManagersController {
	ListManagersView view;
	ListManagersModel model;
	Employees empData;


	ArrayList<Employees> emps= new ArrayList<Employees>();
	JTable empTable = new JTable();	
	public ListManagersController(ListManagersView v)
	{
		view=v;
	}

	public void viewLists()
	{
		model = new ListManagersModel();
		JScrollPane scrollPane = model.getScrollPane();
		view.setEmpTable(model.getTable());
		System.out.println(model.getTable().getRowCount());
		view.setScrollPane(scrollPane);

	}
	
	



}
