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
		view.addActionToBtn(new ActionListener () {

			public void actionPerformed(ActionEvent e) {
				System.out.println(view.getUsername());
				if(view.getUserType().getSelectedItem().equals("Admin"))
				{
					model.setType("AD");
					model.loginAdmin();
					if(model.verify(view.getUsername(), view.getUserPassword())) {
						view.dispose();
						AdminView adminView = new AdminView();
						adminView.setVisible(true);
						AdminController adminController= new AdminController(adminView);
						adminController.checkbutton();
					}
					else {
						JOptionPane.showMessageDialog(null, "Username or Password Incorrect!");
					}
				}
			}
		});
	}
}
