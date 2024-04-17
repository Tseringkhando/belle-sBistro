package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

import Model.*;
import View.*;

public class ListDepartmentsController {
	private ListDepartmentsView view;
	private ListDepartmentsModel model;
	private AddDepartmentModel addDeptModel;
	private Departments deptData;
	
	
	private ArrayList<Departments>depts= new ArrayList<Departments>();
	private JTable deptTable = new JTable();	
	public ListDepartmentsController(ListDepartmentsView v)
	{ view=v;
	 
	 }
	
	public void viewLists()
	{
		model = new ListDepartmentsModel();
		JScrollPane scrollPane = model.getScrollPane();
		view.setTable(model.getTable());
		view.setScrollPane(scrollPane);
		
		
	}
	// update department
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

	
	//delete data
	public void deleteDept(ListDepartmentsView v)
	{
		v.addActionDeleteDepartment(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDepartmentModel n = new AddDepartmentModel();
				n.deleteDept(v, v.getIndex());
				model.refreshTableModel(); // Refresh the table model
                view.getPane().revalidate();
                view.getPane().repaint();
                
			}
		});
	}
	

	
	
}
	

