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

public class ListManagersModel {
    private ArrayList<Employees> employeeList = new ArrayList<>();

    private DefaultTableModel tblEmployeeModel = new DefaultTableModel(0, 11);
    private JTable tblManagerData = new JTable(tblEmployeeModel);
    private JScrollPane scrollPaneManagers = new JScrollPane(tblManagerData);

    public ListManagersModel() {
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
                if(obj.getRole().equals("Manager"))
                {                
                Object[] data = {obj.getEmpID(),obj.getFirstName(), obj.getLastName(), obj.getSin(), obj.getAddress(), obj.getEmail(), obj.getRole(), obj.getType(), obj.getDob(), obj.getHireDate(), obj.getHourlyPay()};
                tblEmployeeModel.addRow(data); //
                }
            }
            Object col[] = {"Emp ID","First Name", "Last Name", "SIN", "Address", "Email", "Role", "Type", "DOB", "Hire Date", "Hourly Pay"};
            tblEmployeeModel.setColumnIdentifiers(col);
            tblManagerData.setRowHeight(25);
        }
    }

    public JScrollPane getScrollPane() {
        return scrollPaneManagers;
    }

    public JTable getTable() {
        return tblManagerData;
    }
	
	
}
