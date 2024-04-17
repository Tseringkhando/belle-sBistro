package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * This class handles the model for displaying a list of departments in a JTable.
 */
public class ListDepartmentsModel {
	ArrayList<Departments> deptScroll = new ArrayList<Departments>();

	DefaultTableModel tblDeptModel = new DefaultTableModel(0, 2);
	private JTable tblDeptData=new JTable(tblDeptModel);
	JScrollPane scrollPaneDept = new JScrollPane(tblDeptData);
    
	/**
     * Constructor for ListDepartmentsModel. Retrieves department data and sends it to the table.
     */
	public ListDepartmentsModel()
	{
		sendDeptData();
	}
	
	 /**
     * Retrieves the list of Departments from the serialized file.
     * @return ArrayList of Departments
     */
	public  static ArrayList<Departments> getArrays()
	{
		ArrayList<Departments> departments = null;
		try{
			FileInputStream fis = new FileInputStream("departments.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object o= ois.readObject();
			departments = (ArrayList<Departments>)o;
			ois.close();


		}
		catch (FileNotFoundException e){

			e.getMessage();
		}
		catch (IOException e){e.getMessage();}
		catch (ClassNotFoundException e){

			e.getMessage();
		}
		return departments;
	}

	/**
	 * method to send data from Departments records to table
 	 */
	public void sendDeptData() {
		if(getArrays()!=null) {
			deptScroll = getArrays();
			Departments obj = new Departments();
			for(int i=0;i<deptScroll.size();i++) {
				obj=deptScroll.get(i);
				Object[] data= {obj.getDeptID(),obj.getDeptName()};
				tblDeptModel.addRow(data);		
			}
			Object col[]= {"Dept Code","Name",};
			tblDeptModel.setColumnIdentifiers(col);
			tblDeptData.setRowHeight(25);

		}
	}
	
	/**
     * Refreshes the table model by clearing all rows and repopulating it with updated data.
     */
	public void refreshTableModel() {
	    tblDeptModel.setRowCount(0); // Clear all rows
	    sendDeptData(); // populated table model with updated data
	}
	
	/**
     * Returns the JScrollPane containing the JTable.
     * @return JScrollPane containing the JTable
     */
	public JScrollPane getScrollPane()
	{
		return scrollPaneDept;
	}
	
	/**
     * Returns the JTable.
     * @return JTable containing department data
     */
	public JTable getTable() {
		return tblDeptData;
	}
	
	/**
     * Helper function to retrieve names of departments.
     * @return List of department names
     */
	public List<String> getDepartmentNames() {
	    ArrayList<Departments> departments = getArrays(); // Reuse existing method to fetch departments
	    List<String> names = new ArrayList<>();
	    if (departments != null) {
	        for (Departments dept : departments) {
	            names.add(dept.getDeptName());
	        }
	    }
	    return names;
	}

}
