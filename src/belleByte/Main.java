package belleByte;
import java.awt.*;

//import Controller.HumanResourceController;
import Controller.LoginController;
import Model.Login;
import View.*;

/**
 * The Main class serves as the entry point for the Human Resource Management System (HRMS) application.
 * It creates an instance of the LoginView class to display the login interface, initializes the Login model,
 * and sets up the LoginController to handle login attempts.
 */
public class Main {
	public static void main(String[] args) {
		// Create a new instance of the LoginView
        LoginView view = new LoginView();
        view.setVisible(true);
        // Initialize the Login model
        Login model= new Login();
        // Create a new LoginController with the LoginView and Login model
		LoginController con = new LoginController(view, model);
		// Call the loginData method in the controller to handle login attempts
		con.loginData();
        
    }
}
