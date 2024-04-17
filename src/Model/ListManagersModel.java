package Model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * This class handles the model for displaying a list of managers in a JTable.
 */
public class ListManagersModel {
    private ArrayList<Employees> employeeList = new ArrayList<>();

    private DefaultTableModel tblEmployeeModel = new DefaultTableModel(0, 11);
    private JTable tblManagerData = new JTable(tblEmployeeModel);
    private JScrollPane scrollPaneManagers = new JScrollPane(tblManagerData);
    
    /**
     * Constructor for ListManagersModel. Retrieves employee data and sends it to the table.
     */
    public ListManagersModel() {
        sendEmployeeData();
    }
    
    /**
     * Retrieves the list of Employees from the serialized file.
     * @return ArrayList of Employees
     */
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
     * Method to send data from Employee records to table for display
     */
    public void sendEmployeeData() {
        if (getArrays() != null) {
            employeeList = getArrays();
            Employees obj;
            for (int i = 0; i < employeeList.size(); i++) {
                obj = employeeList.get(i);
                // Only add managers to the table
                if(obj.getRole().equals("Manager"))
                {                
                Object[] data = {obj.getEmpID(),obj.getFirstName(), obj.getLastName(), obj.getSin(), obj.getAddress(), obj.getEmail(), obj.getRole(), obj.getType(), obj.getDob(), obj.getHireDate(), obj.getHourlyPay()};
                tblEmployeeModel.addRow(data); //
                }
            }
            // Set column names
            Object col[] = {"Emp ID","First Name", "Last Name", "SIN", "Address", "Email", "Role", "Type", "DOB", "Hire Date", "Hourly Pay"};
            tblEmployeeModel.setColumnIdentifiers(col);
            tblManagerData.setRowHeight(25);
        }
    }
    
    /**
     * Returns the JScrollPane containing the JTable.
     * @return JScrollPane containing the JTable
     */
    public JScrollPane getScrollPane() {
        return scrollPaneManagers;
    }

    /**
     * Returns the JTable.
     * @return JTable containing manager data
     */
    public JTable getTable() {
        return tblManagerData;
    }
	
	
}
