package Model;

import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ListEmployeesModel {
    ArrayList<Employees> employeeList = new ArrayList<>();

    DefaultTableModel tblEmployeeModel = new DefaultTableModel(0, 12);
    private JTable tblEmployeeData = new JTable(tblEmployeeModel);
    JScrollPane scrollPaneEmployee = new JScrollPane(tblEmployeeData);

    public ListEmployeesModel() {
        sendEmployeeData();
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Employees> getArrays() {
        ArrayList<Employees> employees = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("employees.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            employees = (ArrayList<Employees>) o;
            ois.close();
        } catch (EOFException e) {
            // Return an empty list if the file is empty or corrupted
            return employees;
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }


    /**
     * Method to send data from Employee records to table
     */
    public void sendEmployeeData() {
        if (getArrays() != null) {
            employeeList = getArrays();
            Employees obj;
            for (int i = 0; i < employeeList.size(); i++) {
                obj = employeeList.get(i);
                Object[] data = {obj.getEmpID(),obj.getFirstName(), obj.getLastName(), obj.getSin(), obj.getAddress(), obj.getEmail(), obj.getRole(), obj.getType(), obj.getDob(), obj.getHireDate(), obj.getHourlyPay(),obj.getDepartmentName()};
                tblEmployeeModel.addRow(data);
            }
            Object col[] = {"Emp ID","First Name", "Last Name", "SIN", "Address", "Email", "Role", "Type", "DOB", "Hire Date", "Hourly Pay","Department"};
            tblEmployeeModel.setColumnIdentifiers(col);
            tblEmployeeData.setRowHeight(25);
        }
    }
    
	public void refreshTableModel() {
		tblEmployeeModel.setRowCount(0); // Clear all rows
	    sendEmployeeData(); // Repopulate table model with updated data
	}
	
    public JScrollPane getScrollPane() {
        return scrollPaneEmployee;
    }

    public JTable getTable() {
        return tblEmployeeData;
    }
}
