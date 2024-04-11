package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.AddDepartmentModel;
import View.AddDepartmentView;

public class AddDepartmentController {
  AddDepartmentView view;
  AddDepartmentModel model;
  
  public AddDepartmentController(AddDepartmentView v ) {
    view =v;
  }
  
  public void deptCheckButton()
  {
    view.addActionSave(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        if(view.getDeptID().getText().isEmpty() ||view.getDeptName().getText().isEmpty()) {
          JOptionPane.showMessageDialog(null, "Incomplete Information");
        }
        else {
        model= new AddDepartmentModel();
        model.addArray(view);
        view.getDeptID().setText("");
        view.getDeptName().setText("");
        }
      }
    });
    
    
  }
}
