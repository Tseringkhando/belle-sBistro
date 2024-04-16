package Model;

import java.io.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class ListDepartmentsModel {
	ArrayList<Departments> deptScroll = new ArrayList<Departments>();

	DefaultTableModel tblDeptModel = new DefaultTableModel(0, 2);
	private JTable tblDeptData=new JTable(tblDeptModel);
	JScrollPane scrollPaneDept = new JScrollPane(tblDeptData);

	public ListDepartmentsModel()
	{
		sendDeptData();
	}
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
	
	public void refreshTableModel() {
	    tblDeptModel.setRowCount(0); // Clear all rows
	    sendDeptData(); // Repopulate table model with updated data
	}
	
	public JScrollPane getScrollPane()
	{
		return scrollPaneDept;
	}
	public JTable getTable() {
		return tblDeptData;
	}

}
