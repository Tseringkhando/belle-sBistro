package Model;
import View.*;
//import model.AddDepartModel;

import java.io.*;
import java.util.*;
import javax.swing.*;
import Controller.*;


public class AddDepartmentModel {
  AddDepartmentView dv;
  ArrayList <Departments> deptUsers  = new ArrayList<Departments>();
  ListDepartmentsModel deptRecord = new ListDepartmentsModel(); // list of department model
  Departments deptData;
  public void addArray(AddDepartmentView dv)
  {
	  
    deptData = new Departments(dv.getDeptID().getText(), dv.getDeptName().getText());
//    Checking for existing data before adding new departments
    if(deptRecord.getArrays()!=null) {
    	
      deptUsers= deptRecord.getArrays();
      deptUsers.add(deptData);
      addDepartmentData(); 
      JOptionPane.showMessageDialog(null, "Department Added");
    }
    else {

      deptUsers.add(deptData);
      addDepartmentData(); 
      JOptionPane.showMessageDialog(null, "Department Added");
    }

  }
  public void addDepartmentData() 
  {
    try {
      FileOutputStream fout = new FileOutputStream("departments.dat");
      ObjectOutputStream oos = new ObjectOutputStream(fout);
      oos.writeObject(deptUsers);
      oos.close();
      

    }catch (Exception e) {
    	e.getMessage();
    	e.printStackTrace();
    }


  }


  //modify department
  public void updateDepartment(ListDepartmentsView dv, int i) throws FileNotFoundException, IOException {
    deptUsers=  deptRecord.getArrays();
    deptData= new Departments(dv.getID(), dv.getName());
    deptUsers.set(i,deptData);
    addDepartmentData();
    JOptionPane.showMessageDialog(null, "Updated Successfully");
    System.out.println("suscess update");
    
  }

  //delete department
  public void deleteDept(ListDepartmentsView dv,int i) {
    int re = JOptionPane.showConfirmDialog(null, "Confirm Delete?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (re == JOptionPane.YES_OPTION) {
    deptUsers=  deptRecord.getArrays();
    deptUsers.remove(i);
    // updata data
    addDepartmentData();
    JOptionPane.showMessageDialog(null, "Department Deleted Successfully");}
  }

}
