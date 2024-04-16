package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Login;
import View.*;
/**
 * Handles the login interactions between the login view and the login model.
 * Responsible for initiating and validating user authentication processes.
 */
public class LoginController {
	LoginView view;
	Login model;
	/**
	 * Constructs a LoginController with a specific view and model.
	 *
	 * @param vw The view that provides the user interface for login.
	 * @param mdl The model that handles the business logic of login authentication.
	 */
	public LoginController(LoginView vw, Login mdl)  {   
		view=vw;
		model=mdl;
	}

	/**
	 * Handles login attempts when the login button is pressed. 
	 * It fetches user inputs, validates them, and processes the login based on user type.
	 */
	public void loginData() {
		// Add action listener to the login button in the view
		view.addActionToBtn(new ActionListener () {

			public void actionPerformed(ActionEvent e) {
				// Print username to console (for debugging)
				System.out.println(view.getUsername());
				 // Check if the selected user type is "Admin"
				if(view.getUserType().getSelectedItem().equals("Admin"))
				{
					model.setType("AD"); // Set user type to "AD" (Admin)
					 // Attempt to log in as an admin
					model.loginAdmin();
					 // Verify the username and password
					if(model.verify(view.getUsername(), view.getUserPassword())) {
						// If verification is successful, close the login view
						view.dispose();
						// Open the AdminView
						AdminView adminView = new AdminView();
						adminView.setVisible(true);
						// Initialize the AdminController and check button permissions
						AdminController adminController= new AdminController(adminView);
						adminController.checkbutton();
					}
					else {
						 // If verification fails, show an error message
						JOptionPane.showMessageDialog(null, "Username or Password Incorrect!");
					}
				}
			}
		});
	}
}
