package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

import Controller.ListEmployeesController;
import Model.Employees;
import Model.ListEmployeesModel;

import javax.swing.JComboBox;

public class ListEmployeesView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tblEmployees;
	private AddEmployeeView addEmployeeView;
	private JScrollPane scrollPaneEmployees;
	private int indexArray;
	private Employees employees;
	private JButton btnUpdateButton;
	/**
	 * Create the panel.
	 */
	public ListEmployeesView() {
		setLayout(null);
//      sending view to controller
      ListEmployeesController controller = new ListEmployeesController(this);
      controller.viewLists();
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 48, 14);
		add(lblNewLabel);
		
		scrollPaneEmployees.setBounds(10, 31, 586, 185);
		add(getScrollPane());
		
		// Initialize and add the AddEmployeeView
        addEmployeeView = new AddEmployeeView();
        addEmployeeView.getLblTitle().setLocation(277, 11);
        addEmployeeView.getBtnClear().setLocation(377, 396);
        addEmployeeView.getBtnSaveEmp().setLocation(203, 396);
        addEmployeeView.setBounds(10, 213, 586, 470);  // Positioning the AddEmployeeView below the table
        addEmployeeView.getLblTitle().setText("Details");;
        
        btnUpdateButton = addEmployeeView.getBtnSaveEmp();
        
     // In ListEmployeesView constructor or after the view is fully initialized
        addUpdateEmpListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Your update logic here
                System.out.println("Update action performed");
                controller.updateEmployee();
            }
        });
        add(addEmployeeView);
     // Listen for row selection in the table
        tblEmployees.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e)
			{
				updateFieldsFromSelectedRow();
				System.out.println("Event triggered");
			}
			});
         
        
        setVisible(true);
	}
	
	public void addUpdateEmpListener(ActionListener a) {
	    if (btnUpdateButton != null) {
	        // Remove existing action listeners to prevent duplicate actions
	        for (ActionListener al : btnUpdateButton.getActionListeners()) {
	            btnUpdateButton.removeActionListener(al);
	        }
	        // Add the new action listener
	        btnUpdateButton.addActionListener(a);
	    } else {
	        System.out.println("Button is not initialized");
	    }
	}
	public JTable getEmpTable() {
		return tblEmployees;
	}
	
	public JScrollPane getScrollPane() {
		return scrollPaneEmployees;
	}
	
	public void setEmpTable(JTable tb) {
		tblEmployees=tb;
	}
	
	public void setScrollPane(JScrollPane s) {
		scrollPaneEmployees = s;
	}
	
	public Employees getEmployees() {
		return employees;
	}
	
	public int getIndex() {
		return indexArray;
	}

	/**
	 * This method lets user to get the full details of employee and update it
	 * 
	 */
	private void updateFieldsFromSelectedRow() {
	    int selectedRow = tblEmployees.getSelectedRow();
	    
	    if (selectedRow >= 0) {
	        // all rows
	    	 int empID = Integer.parseInt(tblEmployees.getValueAt(selectedRow, 0).toString());
	    	 indexArray = empID;
	        String firstName = tblEmployees.getValueAt(selectedRow, 1).toString();
	        String lastName = tblEmployees.getValueAt(selectedRow, 2).toString();
	        String sin = tblEmployees.getValueAt(selectedRow, 3).toString();
	        String address = tblEmployees.getValueAt(selectedRow, 4).toString();
	        String email = tblEmployees.getValueAt(selectedRow, 5).toString();
	        String role = tblEmployees.getValueAt(selectedRow, 6).toString();
	        String type = tblEmployees.getValueAt(selectedRow, 7).toString();
	        String dob = tblEmployees.getValueAt(selectedRow, 8).toString();
	        String hireDate = tblEmployees.getValueAt(selectedRow, 9).toString();
	        String hourlyPay = tblEmployees.getValueAt(selectedRow, 10).toString();
	      
	       
	        // Update AddEmployeeView fields
	        addEmployeeView.getTxtFname().setText(firstName);
	        addEmployeeView.getTxtLname().setText(lastName);
	        addEmployeeView.getTxtSin().setText(sin);
	        addEmployeeView.getTxtEmail().setText(email);
	        addEmployeeView.getTxtAddres().setText(address);
	        addEmployeeView.getCmbRole().setSelectedItem(role);
	        addEmployeeView.getCmbType().setSelectedItem(type);
	     // Setup date format to parse the input date/ format from spinner is  EEE MMM dd HH:mm:ss zzz yyyy
	        SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
	        SimpleDateFormat spinnerFormat = new SimpleDateFormat("MMM dd, yyyy");
	        
	        try {
	            // Parse the dates and set them in the spinners
	            Date dobDate = inputFormat.parse(dob);
	            Date hireDateDate = inputFormat.parse(hireDate);

	            addEmployeeView.getDobSpinner().setValue(spinnerFormat.parse(spinnerFormat.format(dobDate)));
	            addEmployeeView.getHireDateSpinner().setValue(spinnerFormat.parse(spinnerFormat.format(hireDateDate)));
	        } catch (Exception e) {
	            System.err.println("Error parsing dates: " + e.getMessage());
	        }

	        // Parse and set the hourly pay
	        try {
	            Double payDouble = Double.parseDouble(hourlyPay);
	            addEmployeeView.getPaySpinner().setValue(payDouble);
	            employees = new Employees(empID, firstName, lastName, sin, address, email, role, type, dob, hireDate, payDouble);
	        } catch (NumberFormatException e) {
	            System.err.println("Error parsing hourly pay: " + e.getMessage());
	        }
	        
	        
	    }
	}

	
	
	
}
