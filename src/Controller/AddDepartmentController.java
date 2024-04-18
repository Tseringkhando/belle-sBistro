package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.AddDepartmentModel;
import Model.Departments;
import View.AddDepartmentView;
/**
 * Controls the interaction between the model and the view for adding departments.
 * Handles the input validation and updates the model based on user actions in the view.
 */
public class AddDepartmentController {
	private AddDepartmentView view;
	private AddDepartmentModel model;
  /**
   * Constructor for AddDepartmentController.
   * @param v The AddDepartmentView associated with this controller.
   */
  public AddDepartmentController(AddDepartmentView v ) {
    view =v;
  }
  /**
   * Initializes the action listener for the department check button.
   * Validates the input fields and interacts with the model to add new departments.
   */
  public void deptCheckButton()
  {
    view.addActionSave(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
    	// Validate input
        if(view.getDeptID().getText().isEmpty() ||view.getDeptName().getText().isEmpty()) {
          JOptionPane.showMessageDialog(null, "Incomplete Information");
        }
        else {
        model= new AddDepartmentModel();
        model.addArray(view);
        // Clear the text fields after successful addition
        view.getDeptID().setText("");
        view.getDeptName().setText("");
        }
      }
    });
    
  }

}
