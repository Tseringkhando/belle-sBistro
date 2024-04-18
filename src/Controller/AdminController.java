package Controller;
import java.awt.event.*;

import javax.swing.JOptionPane;

import Model.Login;
import View.*;
/**
 * Controls the administrative functionalities provided in the AdminView.
 * Handles interaction between the view and the model for various administrative tasks.
 */
public class AdminController {
	private AdminView view;
	/**
	 * Constructor for AdminController.
	 *
	 * @param v The AdminView associated with this controller.
	 */
	public AdminController(AdminView v)
	{
		view=v;
	}

	/**
	 * Initializes the controller by setting up action listeners for various administrative functions.
	 */
	public void checkbutton() {

		// For viewing departments
		view.addViewDeptListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.listDepartmentView();

			}
		});
		// For adding new department
		view.addDeptListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent e)
			{ 
				view.addDepartmentView();

			}
		});

		//adding new employee button
		view.addEmployeeListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.addEmployeeView();

			}
		});

		// list employees
		view.addListEmployeesListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.listEmployeesView();

			}
		});

		// Set up listener for listing managers
		view.addListManagerListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{view.listManagersView();}

		});



		// Set up listener for logging out
		view.addLogOutListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (confirmLogout()) {
					performLogout();
				}
			}
		});
	}

	/**
	 * Displays a confirmation dialog to confirm logout action.
	 *
	 * @return true if user confirms logout, false otherwise.
	 */
	private boolean confirmLogout() {
		int re = JOptionPane.showConfirmDialog(null, "Confirm Log out?", "Confirm",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		return re == JOptionPane.YES_OPTION;
	}

	/**
	 * Handles the logout process, disposing the current view and opening the login view.
	 */
	private void performLogout() {
		view.dispose();
		LoginView loginView = new LoginView();
		Login loginModel = new Login();
		LoginController loginController = new LoginController(loginView, loginModel);
		loginController.loginData();
		loginView.setVisible(true);
	}
}
